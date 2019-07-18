package com.doft.controller.backend;

import com.doft.common.ServerResponse;
import com.doft.service.DeskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.doft.common.ctrl.CtrlHelper.dealAjaxRequest;

/**
 * Created by Jack at 10:02 2018/3/16
 * version 1.0
 */
@Controller
@CrossOrigin
@RequestMapping(value = "/doft/manage/desk")
public class DeskManageController {

    @Autowired
    private DeskService deskService;

    @ResponseBody
    @RequestMapping(value = "/initDeskByCount.aj")
    public ServerResponse initDeskByCount(Long count) {
        return dealAjaxRequest(() -> {
            deskService.initDeskByCount(count);
            return "success";
        });
    }

    @ResponseBody
    @RequestMapping(value = "/getDeskTotal.aj")
    public ServerResponse getDeskTotal() {
        return dealAjaxRequest(() -> deskService.getDeskTotal());
    }

    @ResponseBody
    @RequestMapping(value = "/getDeskList.aj")
    public ServerResponse getDeskList() {
        return dealAjaxRequest(() -> deskService.getDeskList());
    }



}
