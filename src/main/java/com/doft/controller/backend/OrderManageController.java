package com.doft.controller.backend;

import com.doft.common.Const;
import com.doft.common.ServerResponse;
import com.doft.common.constant.EnumResponseCode;
import com.doft.common.exception.BusinessException;
import com.doft.pojo.User;
import com.doft.service.IOrderService;
import com.doft.service.IUserService;
import com.doft.vo.OrderVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

import java.util.Date;

import static com.doft.common.BaseFunc.getCurrentUser;
import static com.doft.common.ctrl.CtrlHelper.dealAjaxRequest;

/**
 * Created by Jack at 16:01 2018/3/15
 * version 1.0
 */
@Controller
@CrossOrigin
@RequestMapping(value = "/doft/manage/order/")
public class OrderManageController {

    @Autowired
    private IOrderService iOrderService;

    @Autowired
    private IUserService iUserService;
    /**
     * get all orders
     *
     * /getAllOrders.aj -> list.do
     */
    @ResponseBody
        @RequestMapping(value = "list.do")
    public ServerResponse<PageInfo> getAllOrders(HttpSession session,@RequestParam(value = "orderNo",required = false ,defaultValue = "")String orderNo, @RequestParam(value = "pageNum",defaultValue = "1") int pageNum, @RequestParam(value = "pageSize",defaultValue = "10") int pageSize) {

        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorCodeMessage(EnumResponseCode.NEED_LOGIN.getCode(),"用户未登录，请登录管理员");

        }
        if (iUserService.checkAdminRole(user).isSuccess()){
            //业务逻辑
            return iOrderService.manageList(orderNo,pageNum,pageSize);
        }else{
            return ServerResponse.createByErrorMessage("非管理员用户，无权限操作");
        }

//        return dealAjaxRequest(() -> orderService.getAllOrders());
    }

    /**
     * get order detail list b orderNo
     *
     * getOrderDetailsByOrderNo.aj -> detail.do
     */

    @ResponseBody
    @RequestMapping(value = "detail.do")
    public ServerResponse<OrderVo> getOrderDetailsByOrderNo(HttpSession session, String orderNo){

        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorCodeMessage(EnumResponseCode.NEED_LOGIN.getCode(),"用户未登录，请登录管理员");

        }
        if (iUserService.checkAdminRole(user).isSuccess()){
            //业务逻辑
            return iOrderService.manageDetail(orderNo);
        }else{
            return ServerResponse.createByErrorMessage("非管理员用户，无权限操作");
        }

//        return dealAjaxRequest(() -> orderService.getAllOrders());
    }


    /**
     * Order Search
     */

    @ResponseBody
    @RequestMapping(value = "search.do")
    public ServerResponse<PageInfo> orderSearch(HttpSession session, String orderNo,@RequestParam(value = "pageNum",defaultValue = "1") int pageNum, @RequestParam(value = "pageSize",defaultValue = "10") int pageSize){

        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorCodeMessage(EnumResponseCode.NEED_LOGIN.getCode(),"用户未登录，请登录管理员");

        }
        if (iUserService.checkAdminRole(user).isSuccess()){
            //业务逻辑
            return iOrderService.manageSearch(orderNo,pageNum,pageSize);
        }else{
            return ServerResponse.createByErrorMessage("非管理员用户，无权限操作");
        }

//        return dealAjaxRequest(() -> orderService.getAllOrders());
    }

    /**
     * update order status
     *
     *
     * pdateOrderStatus.aj -> update_order_status.do
     */
    @ResponseBody
    @RequestMapping(value = "update_order_status.do")
    public ServerResponse updateOrderStatus(HttpSession session,String orderNo, Integer status) {
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorCodeMessage(EnumResponseCode.NEED_LOGIN.getCode(),"用户未登录，请登录管理员");

        }
        if (iUserService.checkAdminRole(user).isSuccess()){
            //业务逻辑
            return iOrderService.updateOrderStatus(orderNo,status,user.getUserId());
        }else{
            return ServerResponse.createByErrorMessage("非管理员用户，无权限操作");
        }
    }

    @ResponseBody
    @RequestMapping(value = "addedOrderCount.aj")
    public ServerResponse addedOrderCount() {
        return dealAjaxRequest(() -> iOrderService.addedOrderCount(new Date()));
    }

    /**
     * 获取当天待处理的订单数量
     */
    @ResponseBody
    @RequestMapping(value = "pendingDealOrder.aj")
    public ServerResponse pendingDealOrder() {
        return dealAjaxRequest(() -> iOrderService.pendingDealOrder(new Date()));
    }

}
