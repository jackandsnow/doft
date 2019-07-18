package com.doft.controller.portal;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.demo.trade.config.Configs;
import com.doft.common.Const;
import com.doft.common.ServerResponse;
import com.doft.common.constant.EnumPaymentType;
import com.doft.common.constant.EnumResponseCode;
import com.doft.pojo.User;
import com.doft.service.IOrderService;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.doft.common.ServerResponse;
import com.doft.common.exception.BusinessException;
import com.doft.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Iterator;
import java.util.Map;
import static com.doft.common.BaseFunc.getCurrentUser;
import static com.doft.common.ctrl.CtrlHelper.dealAjaxRequest;

@Controller
@CrossOrigin
@RequestMapping("/doft/order/")
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private IOrderService iOrderService;



    /**
     * save order  -> create order and clear cart
     */
//    @ResponseBody
//    @RequestMapping(value = "/saveOrder.aj")
//    public ServerResponse saveOrder(@RequestBody OrderDto orderDto, HttpServletRequest request) {
//        return dealAjaxRequest(() -> {
//            User user = getCurrentUser();
//            if (user == null) {
//                throw new BusinessException("please login the system first!");
//            }
//            return orderService.saveOrder(orderDto, user);
//        });
//    }

    @RequestMapping("create.do")
    @ResponseBody
    public ServerResponse create(HttpSession session,Long deskId,Integer peopleCount){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorCodeMessage(EnumResponseCode.NEED_LOGIN.getCode(),EnumResponseCode.NEED_LOGIN.getDecs());
        }

        return iOrderService.createOrder(user.getUserId(),deskId,peopleCount);
    }



    /**
     * delete order -> cancel.do
     */

    @RequestMapping("delete.do")
    @ResponseBody
    public ServerResponse delete(HttpSession session, String orderNo){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorCodeMessage(EnumResponseCode.NEED_LOGIN.getCode(),EnumResponseCode.NEED_LOGIN.getDecs());
        }

        return iOrderService.delete(user.getUserId(),orderNo);
    }


    @RequestMapping("cancel.do")
    @ResponseBody
    public ServerResponse cancel(HttpSession session, String orderNo){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorCodeMessage(EnumResponseCode.NEED_LOGIN.getCode(),EnumResponseCode.NEED_LOGIN.getDecs());
        }

        return iOrderService.cancel(user.getUserId(),orderNo);
    }

    /**
     * get order detail list b orderNo
     */
    @RequestMapping("detail.do")
    @ResponseBody
    public ServerResponse detail(HttpSession session, @RequestParam(value = "orderNo",required = false) String orderNo){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorCodeMessage(EnumResponseCode.NEED_LOGIN.getCode(),EnumResponseCode.NEED_LOGIN.getDecs());
        }

        return iOrderService.getOrderDetail(user.getUserId(),orderNo);
    }

    /**
     * get orders by user id
     */
    @RequestMapping("list.do")
    @ResponseBody
    public ServerResponse list(HttpSession session, @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,@RequestParam(value = "pageSize",defaultValue = "10") int pageSize,@RequestParam(value = "orderBy",defaultValue = "")String orderBy,@RequestParam(value = "order",defaultValue = "")String order){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorCodeMessage(EnumResponseCode.NEED_LOGIN.getCode(),EnumResponseCode.NEED_LOGIN.getDecs());
        }

        return iOrderService.getOrderList(user.getUserId(),pageNum,pageSize,orderBy,order);
    }


    /**
     *
     *  Alipay
     */
    @RequestMapping("pay.do")
    @ResponseBody
    public ServerResponse pay(HttpSession session, String orderNo,int paymentType, HttpServletRequest request){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorCodeMessage(EnumResponseCode.NEED_LOGIN.getCode(),EnumResponseCode.NEED_LOGIN.getDecs());
        }

        String path = request.getSession().getServletContext().getRealPath("upload");
        if (paymentType == EnumPaymentType.ONLINE.getCode()){
            return iOrderService.alipay(orderNo,user.getUserId(),path);
        } else if (paymentType == EnumPaymentType.OFFLINE.getCode()){
            return iOrderService.normalPay(orderNo,user.getUserId());
        }else{
            return ServerResponse.createByErrorCodeMessage(EnumResponseCode.ILLEGAL_ARGUMENT.getCode(),EnumResponseCode.ILLEGAL_ARGUMENT.getDecs());
        }

    }


    //alipay callback

    @RequestMapping("alipay_callback.do")
    @ResponseBody
    public Object alipayCallback(HttpServletRequest request){

        Map<String,String> params = Maps.newHashMap();

        Map requestParams = request.getParameterMap();
        for (Iterator iterator = requestParams.keySet().iterator();iterator.hasNext();){
            String name = (String)iterator.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0;i < values.length;i++){

                valueStr = (i == values.length -1 )? valueStr + values[i] : valueStr+values[i]+",";

            }
            params.put(name,valueStr);
        }
        logger.info("支付宝回调，sign:{},trade_status:{},参数:{} ",params.get("sign"),params.get("trade_status"),params.toString());

        //验证回调正确性,避免重复通知
        params.remove("sign_type");
        try {
            boolean alipayRSACheckedV2 = AlipaySignature.rsaCheckV2(params, Configs.getAlipayPublicKey(),"utf-8",Configs.getSignType());
            if (!alipayRSACheckedV2){
                return ServerResponse.createByErrorMessage("非法请求，验证不通过");
            }
        } catch (AlipayApiException e) {
            logger.error("支付宝验证回调异常",e);
        }

        //验证各种数据

        //
        ServerResponse serverResponse = iOrderService.aliCallback(params);

        if (serverResponse.isSuccess()){
            return Const.AlipayCallback.RESPONSE_SUCCESS;

        }
        return Const.AlipayCallback.RESPONSE_FAILED;

    }


    @RequestMapping("query_order_pay_status.do")
    @ResponseBody
    public ServerResponse<Boolean> queryOrderPayStatus(HttpSession session, String orderNo){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorCodeMessage(EnumResponseCode.NEED_LOGIN.getCode(),EnumResponseCode.NEED_LOGIN.getDecs());
        }

        ServerResponse serverResponse = iOrderService.queryOrderPayStatus(user.getUserId(),orderNo);
        if (serverResponse.isSuccess()){
            return ServerResponse.createBySuccess(true);
        }
        return ServerResponse.createBySuccess(false);

    }
}
