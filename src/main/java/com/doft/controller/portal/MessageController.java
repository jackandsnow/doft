package com.doft.controller.portal;

import com.doft.common.ServerResponse;
import com.doft.common.constant.EnumMsgType;
import com.doft.common.exception.BusinessException;
import com.doft.pojo.User;
import com.doft.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.doft.common.BaseFunc.getCurrentUser;
import static com.doft.common.ctrl.CtrlHelper.dealAjaxRequest;

/**
 * Created by Jack at 10:47 2018/3/15
 * version 1.0
 */
@Controller
@CrossOrigin
@RequestMapping(value = "/doft/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @ResponseBody
    @RequestMapping(value = "/deleteMsgEvent.aj")
    public ServerResponse deleteMsgEvent(Long msgId) {
        return dealAjaxRequest(() -> {
            User user = getCurrentUser();
            if (user == null) {
                throw new BusinessException("Please login system first!");
            }
            messageService.deleteMsgEvent(msgId, user);
            return "success";
        });
    }

    @ResponseBody
    @RequestMapping(value = "/getMessagePages.aj")
    public ServerResponse getMessagePages(
            @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
            @RequestParam(value = "pageSize", defaultValue = "6") Integer pageSize) {
        return dealAjaxRequest(() -> {
            User user = getCurrentUser();
            if (user == null) {
                throw new BusinessException("Please login system first!");
            }
            return messageService.getMessagePagesByUserId(user.getUserId(), currentPage, pageSize);
        });
    }

}
