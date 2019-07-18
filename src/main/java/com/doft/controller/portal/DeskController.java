package com.doft.controller.portal;

import com.doft.common.ServerResponse;
import com.doft.service.DeskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.doft.common.ctrl.CtrlHelper.dealAjaxRequest;

/**
 * Created by Jack at 16:17 2018/3/16
 * version 1.0
 */
@Controller
@CrossOrigin
@RequestMapping(value = "/doft/desk")
public class DeskController {

    @Autowired
    private DeskService deskService;

    @ResponseBody
    @RequestMapping(value = "/getRandomFreeDeskId.aj")
    public ServerResponse getRandomFreeDeskId() {
        return dealAjaxRequest(() -> {
            return deskService.getRandomFreeDeskId();
        });
    }

}
