package com.doft.vo;

import com.doft.pojo.Requisition;

import java.io.Serializable;

/**
 * Created by Jack at 9:40 2018/3/14
 * version 1.0
 */
public class RequisitionManageVo implements Serializable {

    private String reqNo;

    private String creationDate;

    private String orderNo;

    private String reqBy;

    private String reqType;

    private String reqStatus;

    private String approver;

    public RequisitionManageVo() {
    }

    @Override
    public String toString() {
        return "RequisitionManageVo{" +
                "reqNo='" + reqNo + '\'' +
                ", creationDate=" + creationDate +
                ", orderNo='" + orderNo + '\'' +
                ", reqBy='" + reqBy + '\'' +
                ", reqType='" + reqType + '\'' +
                ", reqStatus='" + reqStatus + '\'' +
                ", approver='" + approver + '\'' +
                '}';
    }

    public String getReqNo() {
        return reqNo;
    }

    public void setReqNo(String reqNo) {
        this.reqNo = reqNo;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getReqBy() {
        return reqBy;
    }

    public void setReqBy(String reqBy) {
        this.reqBy = reqBy;
    }

    public String getReqType() {
        return reqType;
    }

    public void setReqType(String reqType) {
        this.reqType = reqType;
    }

    public String getReqStatus() {
        return reqStatus;
    }

    public void setReqStatus(String reqStatus) {
        this.reqStatus = reqStatus;
    }

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }
}
