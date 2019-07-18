package com.doft.controller.backend;

import com.doft.common.Const;
import com.doft.common.constant.EnumResponseCode;
import com.doft.common.ServerResponse;
import com.doft.pojo.User;
import com.doft.service.IDishTypeService;
import com.doft.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


@Controller
@CrossOrigin
@RequestMapping("/manage/dish_type/")
public class DishTypeManageController {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private IDishTypeService iDishTypeService;

    @RequestMapping("add_dish_type.do")
    @ResponseBody
    public ServerResponse addDishType(HttpSession session, String typeName){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorCodeMessage(EnumResponseCode.NEED_LOGIN.getCode(),"用户未登录，请登录");
        }
        //校验是否为管理员
        if (iUserService.checkAdminRole(user).isSuccess()){
            //是管理员
            return iDishTypeService.addDishType(typeName,user.getUserName());
        }else{
            return ServerResponse.createByErrorMessage("无权限操作，需要管理员权限");
        }

    }


    @RequestMapping("delete_dish_type.do")
    @ResponseBody
    public ServerResponse deleteDishType(HttpSession session, Long dishTypeId){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorCodeMessage(EnumResponseCode.NEED_LOGIN.getCode(),"用户未登录，请登录");
        }
        //校验是否为管理员
        if (iUserService.checkAdminRole(user).isSuccess()){
            //是管理员
            return iDishTypeService.deleteDishType(dishTypeId);
        }else{
            return ServerResponse.createByErrorMessage("无权限操作，需要管理员权限");
        }

    }

    @RequestMapping("set_dish_type_name.do")
    @ResponseBody
    public ServerResponse setDishTypeName(HttpSession session,Long dishTypeId, String typeName){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorCodeMessage(EnumResponseCode.NEED_LOGIN.getCode(),"用户未登录，请登录");
        }
        //校验是否为管理员
        if (iUserService.checkAdminRole(user).isSuccess()){
            //更新菜品名称
            return iDishTypeService.updateDishTypeName(dishTypeId,typeName,user.getUserName());
        }else{
            return ServerResponse.createByErrorMessage("无权限操作，需要管理员权限");
        }
    }

    @RequestMapping("get_all_dish_type.do")
    @ResponseBody
    public ServerResponse getAllDishType(HttpSession session){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorCodeMessage(EnumResponseCode.NEED_LOGIN.getCode(),"用户未登录，请登录");
        }
        //校验是否为管理员
        if (iUserService.checkAdminRole(user).isSuccess()){
            //更新菜品名称
            return iDishTypeService.selectAllDishType();
        }else{
            return ServerResponse.createByErrorMessage("无权限操作，需要管理员权限");
        }
    }


}
