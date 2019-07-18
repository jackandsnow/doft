package com.doft.pojo;

import java.util.Date;

public class Requisition {
    private Long reqId;

    private String reqNo;

    private Integer reqStatus;

    private Integer reqType;

    private String reqBy;

    private String reqContent;

    private Long orderId;

    private String approver;

    private Date creationDate;

    private String createdBy;

    public Requisition(Long reqId, String reqNo, Integer reqStatus, Integer reqType, String reqBy, String reqContent, Long orderId, String approver, Date creationDate, String createdBy) {
        this.reqId = reqId;
        this.reqNo = reqNo;
        this.reqStatus = reqStatus;
        this.reqType = reqType;
        this.reqBy = reqBy;
        this.reqContent = reqContent;
        this.orderId = orderId;
        this.approver = approver;
        this.creationDate = creationDate;
        this.createdBy = createdBy;
    }

    public Requisition() {
        super();
    }

    public Long getReqId() {
        return reqId;
    }

    public void setReqId(Long reqId) {
        this.reqId = reqId;
    }

    public String getReqNo() {
        return reqNo;
    }

    public void setReqNo(String reqNo) {
        this.reqNo = reqNo == null ? null : reqNo.trim();
    }

    public Integer getReqStatus() {
        return reqStatus;
    }

    public void setReqStatus(Integer reqStatus) {
        this.reqStatus = reqStatus;
    }

    public Integer getReqType() {
        return reqType;
    }

    public void setReqType(Integer reqType) {
        this.reqType = reqType;
    }

    public String getReqBy() {
        return reqBy;
    }

    public void setReqBy(String reqBy) {
        this.reqBy = reqBy == null ? null : reqBy.trim();
    }

    public String getReqContent() {
        return reqContent;
    }

    public void setReqContent(String reqContent) {
        this.reqContent = reqContent == null ? null : reqContent.trim();
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver == null ? null : approver.trim();
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }
}