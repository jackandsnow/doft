package com.doft.controller.backend;

import com.doft.common.Const;
import com.doft.common.ServerResponse;
import com.doft.common.constant.EnumResponseCode;
import com.doft.pojo.Dish;
import com.doft.pojo.User;
import com.doft.service.IDishService;
import com.doft.service.IFileService;
import com.doft.service.IUserService;
import com.doft.util.PropertiesUtil;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;

import static com.doft.common.ctrl.CtrlHelper.dealAjaxRequest;

@Controller
@CrossOrigin
@RequestMapping("/doft/manage/dish")
public class DishManageController {

    @Autowired
    private IUserService iUserService;
    @Autowired
    private IDishService iDishService;
    @Autowired
    private IFileService iFileService;

    @ResponseBody
    @RequestMapping("/save.do")
    public ServerResponse dishSave(HttpSession session, Dish dish) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(
                    EnumResponseCode.NEED_LOGIN.getCode(), "用户未登录，请登录管理员");

        }
        dish.setLastUpdatedBy(user.getUserName());
        if (iUserService.checkAdminRole(user).isSuccess()) {
            //业务逻辑
            return iDishService.saveOrUpdateDish(dish);
        } else {
            return ServerResponse.createByErrorMessage("非管理员用户，无权限操作");
        }
    }

    @ResponseBody
    @RequestMapping("/set_sale_status.do")
    public ServerResponse setSaleStatus(HttpSession session, Long dishId, Integer status) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(
                    EnumResponseCode.NEED_LOGIN.getCode(), "用户未登录，请登录管理员");
        }
        if (iUserService.checkAdminRole(user).isSuccess()) {
            //业务逻辑
            return iDishService.setSaleStatus(dishId, status);
        } else {
            return ServerResponse.createByErrorMessage("非管理员用户，无权限操作");
        }
    }


    @ResponseBody
    @RequestMapping("/detail.do")
    public ServerResponse getDetail(HttpSession session, Long dishId) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(
                    EnumResponseCode.NEED_LOGIN.getCode(), "用户未登录，请登录管理员");
        }
        if (iUserService.checkAdminRole(user).isSuccess()) {
            //业务逻辑
            return iDishService.manageDishDetail(dishId);
        } else {
            return ServerResponse.createByErrorMessage("非管理员用户，无权限操作");
        }
    }


    @ResponseBody
    @RequestMapping("/list.do")
    public ServerResponse getList(HttpSession session, @RequestParam(value = "pageNum", defaultValue = "1")
            int pageNum, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(
                    EnumResponseCode.NEED_LOGIN.getCode(), "用户未登录，请登录管理员");

        }
        if (iUserService.checkAdminRole(user).isSuccess()) {
            //业务逻辑
            return iDishService.getDishList(pageNum, pageSize);

            //动态分页
//            return ServerResponse.createBySuccess();
        } else {
            return ServerResponse.createByErrorMessage("非管理员用户，无权限操作");
        }
    }


    @ResponseBody
    @RequestMapping("/search.do")
    public ServerResponse dishSearch(HttpSession session, String dishName, Long dishId,@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,@RequestParam(value = "pageSize", defaultValue = "10") int pageSize,@RequestParam(value = "orderBy",defaultValue = "")String orderBy,@RequestParam(value = "order",defaultValue = "")String order) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(
                    EnumResponseCode.NEED_LOGIN.getCode(), "用户未登录，请登录管理员");
        }
        if (iUserService.checkAdminRole(user).isSuccess()) {
            //业务逻辑
            return iDishService.searchDish(dishName, dishId, pageNum, pageSize,orderBy,order);

            //动态分页
//            return ServerResponse.createBySuccess();
        } else {
            return ServerResponse.createByErrorMessage("非管理员用户，无权限操作");
        }
    }


    @ResponseBody
    @RequestMapping("/upload.do")
    public ServerResponse upload(@RequestParam(value = "upload_file", required = false)
                                             MultipartFile file, HttpServletRequest request) {
//        User user = (User)
        String path = request.getSession().getServletContext().getRealPath("upload");
        String targetFileName = iFileService.upload(file, path);
        String url = PropertiesUtil.getProperty("ftp.server.http.prefix") + targetFileName;
        Map fileMap = Maps.newHashMap();
        fileMap.put("uri", targetFileName);
        fileMap.put("url", url);
        return ServerResponse.createBySuccess(fileMap);
    }

    @ResponseBody
    @RequestMapping(value = "/addedDishCount.aj")
    public ServerResponse addedDishCount() {
        return dealAjaxRequest(() -> iDishService.addedDishCount(new Date()));
    }

}
