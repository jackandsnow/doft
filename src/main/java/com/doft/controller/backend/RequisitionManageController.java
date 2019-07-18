package com.doft.controller.backend;

import com.doft.common.ServerResponse;
import com.doft.common.exception.BusinessException;
import com.doft.pojo.User;
import com.doft.service.RequisitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

import static com.doft.common.BaseFunc.getCurrentUser;
import static com.doft.common.ctrl.CtrlHelper.dealAjaxRequest;

/**
 * Created by Jack at 16:06 2018/3/15
 * version 1.0
 */
@Controller
@CrossOrigin
@RequestMapping(value = "/doft/manage/requisition")
public class RequisitionManageController {

    @Autowired
    private RequisitionService requisitionService;

    @ResponseBody
    @RequestMapping(value = "/getAllRequisitions.aj")
    public ServerResponse getAllRequisitions() {
        return dealAjaxRequest(() -> {
            return requisitionService.getAllRequisitions();
        });
    }

    @ResponseBody
    @RequestMapping(value = "/updateRequisitionStatus.aj")
    public ServerResponse updateRequisitionStatus(String reqNo, Integer status) {
        return dealAjaxRequest(() -> {
            User user = getCurrentUser();
            if (user == null) {
                throw new BusinessException("please login the system first!");
            }
            requisitionService.updateRequisitionStatus(reqNo, status, user);
            return "success";

        });
    }

    @ResponseBody
    @RequestMapping(value = "/addedRequisitionCount.aj")
    public ServerResponse addedRequisitionCount() {
        return dealAjaxRequest(() -> requisitionService.addedRequisitionCount(new Date()));
    }

    @ResponseBody
    @RequestMapping(value = "/pendingRequisition.aj")
    public ServerResponse pendingRequisition() {
        return dealAjaxRequest(() -> requisitionService.pendingRequisition(new Date()));
    }

}
