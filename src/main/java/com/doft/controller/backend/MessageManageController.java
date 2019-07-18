package com.doft.controller.backend;

import com.doft.common.ServerResponse;
import com.doft.common.constant.EnumMsgType;
import com.doft.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.doft.common.ctrl.CtrlHelper.dealAjaxRequest;

/**
 * Created by Jack at 18:39 2018/3/19
 * version 1.0
 */
@Controller
@CrossOrigin
@RequestMapping(value = "/doft/manage/message")
public class MessageManageController {

    @Autowired
    private MessageService messageService;

    @ResponseBody
    @RequestMapping(value = "/saveOrderMsg.aj")
    public ServerResponse saveOrderMsg(String orderNo, Boolean approve, Long userId) {
        return dealAjaxRequest(() -> {
            messageService.saveMsgEvent(EnumMsgType.ORDER_DEALT_NOTIFICATION.getCode(),
                    orderNo, null, approve, userId);
            return "success";
        });
    }

    @ResponseBody
    @RequestMapping(value = "/saveRechargeMsg.aj")
    public ServerResponse saveRechargeMsg(Long amount, Long userId) {
        return dealAjaxRequest(() -> {
            messageService.saveMsgEvent(EnumMsgType.RECHARGE_MESSAGE.getCode(),
                    null, amount, null, userId);
            return "success";
        });
    }

    @ResponseBody
    @RequestMapping(value = "/saveDiscountMsg.aj")
    public ServerResponse saveDiscountMsg(Long userId) {
        return dealAjaxRequest(() -> {
            messageService.saveMsgEvent(EnumMsgType.DISH_DISCOUNT_MESSAGE.getCode(),
                    null, null, null, userId);
            return "success";
        });
    }


}
