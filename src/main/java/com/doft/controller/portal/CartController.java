package com.doft.controller.portal;

import com.doft.common.Const;
import com.doft.common.ServerResponse;
import com.doft.common.constant.EnumResponseCode;
import com.doft.pojo.User;
import com.doft.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@CrossOrigin
@RequestMapping("/cart/")
public class CartController {

    @Autowired
    private ICartService iCartService;

    @RequestMapping("list.do")
    @ResponseBody
    public ServerResponse list(HttpSession session){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorCodeMessage(EnumResponseCode.NEED_LOGIN.getCode(),EnumResponseCode.NEED_LOGIN.getDecs());
        }
        //cart core
        return iCartService.list(user.getUserId());
    }


    @RequestMapping("add.do")
    @ResponseBody
    public ServerResponse add(HttpSession session,Integer count, Long dishId){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorCodeMessage(EnumResponseCode.NEED_LOGIN.getCode(),EnumResponseCode.NEED_LOGIN.getDecs());
        }
        //cart core
        return iCartService.add(user.getUserId(),dishId,count,user.getUserName());
    }

    @RequestMapping("update.do")
    @ResponseBody
    public ServerResponse update(HttpSession session,Integer count, Long dishId){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorCodeMessage(EnumResponseCode.NEED_LOGIN.getCode(),EnumResponseCode.NEED_LOGIN.getDecs());
        }
        //cart core
        return iCartService.update(user.getUserId(),dishId,count,user.getUserName());
    }

    @RequestMapping("delete_dish.do")
    @ResponseBody
    public ServerResponse deleteDish(HttpSession session, String dishIds){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorCodeMessage(EnumResponseCode.NEED_LOGIN.getCode(),EnumResponseCode.NEED_LOGIN.getDecs());
        }
        //cart core
        return iCartService.deleteDish(dishIds,user.getUserId());
    }


    @RequestMapping("clean_cart.do")
    @ResponseBody
    public ServerResponse cleanCart(HttpSession session){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorCodeMessage(EnumResponseCode.NEED_LOGIN.getCode(),EnumResponseCode.NEED_LOGIN.getDecs());
        }
        //cart core
        return iCartService.cleanCart(user.getUserId());
    }

    //全选

    @RequestMapping("select_all.do")
    @ResponseBody
    public ServerResponse selectAll(HttpSession session){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorCodeMessage(EnumResponseCode.NEED_LOGIN.getCode(),EnumResponseCode.NEED_LOGIN.getDecs());
        }
        //cart core
        return iCartService.selectOrUnSelect(user.getUserId(),null,Const.Cart.CHECKED);
    }
    //全反选
    @RequestMapping("un_select_all.do")
    @ResponseBody
    public ServerResponse unSelectAll(HttpSession session){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorCodeMessage(EnumResponseCode.NEED_LOGIN.getCode(),EnumResponseCode.NEED_LOGIN.getDecs());
        }
        //cart core
        return iCartService.selectOrUnSelect(user.getUserId(),null,Const.Cart.UN_CHECKED);
    }
    //单独选中
    @RequestMapping("select.do")
    @ResponseBody
    public ServerResponse select(HttpSession session,Long dishId) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(EnumResponseCode.NEED_LOGIN.getCode(), EnumResponseCode.NEED_LOGIN.getDecs());
        }
        //cart core
        return iCartService.selectOrUnSelect(user.getUserId(), dishId, Const.Cart.CHECKED);
        //查询购物车里菜品的数量
    }
    //单独反选
    @RequestMapping("un_select.do")
    @ResponseBody
    public ServerResponse unSelect(HttpSession session,Long dishId) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(EnumResponseCode.NEED_LOGIN.getCode(), EnumResponseCode.NEED_LOGIN.getDecs());
        }
        //cart core
        return iCartService.selectOrUnSelect(user.getUserId(), dishId, Const.Cart.UN_CHECKED);

    }
    //查询购物车里菜品的数量
    @RequestMapping("get_cart_dish_count.do")
    @ResponseBody
    public ServerResponse<Integer> getCartDishCount(HttpSession session){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createBySuccess(0);
        }
        //cart core
        return iCartService.getCartDishCount(user.getUserId());
    }
}
