package com.doft.controller.portal;

import com.doft.common.ServerResponse;
import com.doft.common.exception.BusinessException;
import com.doft.pojo.Requisition;
import com.doft.pojo.User;
import com.doft.service.RequisitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.doft.common.BaseFunc.getCurrentUser;
import static com.doft.common.ctrl.CtrlHelper.dealAjaxRequest;

/**
 * Created by Jack at 16:05 2018/3/15
 * version 1.0
 */
@Controller
@CrossOrigin
@RequestMapping(value = "/doft/requisition")
public class RequisitionController {

    @Autowired
    private RequisitionService requisitionService;

    @ResponseBody
    @RequestMapping(value = "/saveRequisition.aj")
    public ServerResponse saveRequisition(Integer type, String orderNo) {
        return dealAjaxRequest(() -> {
            User user = getCurrentUser();
            if (user == null) {
                throw new BusinessException("please login the system first!");
            }
            return requisitionService.saveRequisition(type, orderNo, user);
        });
    }

}
