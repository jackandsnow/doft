package com.doft.controller.backend;

import com.doft.common.Const;
import com.doft.common.ServerResponse;
import com.doft.common.constant.EnumResponseCode;
import com.doft.common.constant.EnumUserType;
import com.doft.common.exception.BusinessException;
import com.doft.pojo.User;
import com.doft.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

import java.util.Date;

import static com.doft.common.BaseFunc.getCurrentUser;
import static com.doft.common.ctrl.CtrlHelper.dealAjaxRequest;

@Controller
@CrossOrigin
@RequestMapping("/doft/manage/user")
public class UserManageController {

    @Autowired
    private IUserService iUserService;


    @RequestMapping(value = "/logout.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> logout(HttpSession session) {
        session.removeAttribute(Const.CURRENT_USER);
        return ServerResponse.createBySuccess();
    }

    @ResponseBody
    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public ServerResponse<User> login(String username, String password, HttpSession session) {
        ServerResponse<User> response = iUserService.loginBackend(username, password);
        if (response.isSuccess()) {
            User user = response.getData();
            if (user.getRoleId() == EnumUserType.ADMINISTRATOR.getCode()
                    || user.getRoleId() == EnumUserType.SUPER_ADMINISTRATOR.getCode()) {
                session.setAttribute(Const.CURRENT_USER, user);
                return response;
            } else {
                return ServerResponse.createByErrorMessage("不是管理员，无法登录");
            }
        }

        return response;
    }


    @ResponseBody
    @RequestMapping(value = "/recharge.do", method = RequestMethod.POST)
    public ServerResponse<String> recharge(Long userId, Double amount, HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user != null) {
            if (user.getRoleId() == EnumUserType.ADMINISTRATOR.getCode() || user.getRoleId() == EnumUserType.SUPER_ADMINISTRATOR.getCode()) {

                return iUserService.recharge(userId, amount);
            } else {
                return ServerResponse.createByErrorMessage("非管理员用户，无权限操作");
            }
        } else {
            return ServerResponse.createByErrorCodeMessage(EnumResponseCode.NEED_LOGIN.getCode(), EnumResponseCode.NEED_LOGIN.getDecs());
        }
    }

    @ResponseBody
    @RequestMapping(value = "/getAllUsersByType.aj")
    public ServerResponse getAllUsersByType(Integer type) {
        return dealAjaxRequest(() -> {
            return iUserService.getAllUsersByType(type);
        });
    }

    @ResponseBody
    @RequestMapping(value = "/deleteAdminByAdminId.aj")
    public ServerResponse deleteAdminByAdminId(Long adminId) {
        User user = getCurrentUser();
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(
                    EnumResponseCode.NEED_LOGIN.getCode(), EnumResponseCode.NEED_LOGIN.getDecs());
        }
        return iUserService.deleteAdminByAdminId(adminId, user);
    }

    @ResponseBody
    @RequestMapping(value = "/updateAdminInfo.aj")
    public ServerResponse<String> updateAdminInfo(@RequestBody User submit) {
        User user = getCurrentUser();
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(
                    EnumResponseCode.NEED_LOGIN.getCode(), EnumResponseCode.NEED_LOGIN.getDecs());
        }
        return iUserService.updateAdminInfo(submit, user);
    }

    @ResponseBody
    @RequestMapping(value = "/addedUserCount.aj")
    public ServerResponse addedUserCount() {
        return dealAjaxRequest(() -> iUserService.addedUserCount(new Date()));
    }

}
