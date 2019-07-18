package com.doft.pojo;

import java.util.Date;

public class MessageEvent {
    private Long messageId;

    private Integer messageType;

    private String title;

    private String content;

    private String sendToUserId;

    private Date sendTime;

    private String orderNo;

    private Boolean isDeletedFlag;

    private String deletedBy;

    private Date deletedDate;

    public MessageEvent(Long messageId, Integer messageType, String title, String content, String sendToUserId, Date sendTime, String orderNo, Boolean isDeletedFlag, String deletedBy, Date deletedDate) {
        this.messageId = messageId;
        this.messageType = messageType;
        this.title = title;
        this.content = content;
        this.sendToUserId = sendToUserId;
        this.sendTime = sendTime;
        this.orderNo = orderNo;
        this.isDeletedFlag = isDeletedFlag;
        this.deletedBy = deletedBy;
        this.deletedDate = deletedDate;
    }

    public MessageEvent() {
        super();
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public Integer getMessageType() {
        return messageType;
    }

    public void setMessageType(Integer messageType) {
        this.messageType = messageType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getSendToUserId() {
        return sendToUserId;
    }

    public void setSendToUserId(String sendToUserId) {
        this.sendToUserId = sendToUserId == null ? null : sendToUserId.trim();
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public Boolean getIsDeletedFlag() {
        return isDeletedFlag;
    }

    public void setIsDeletedFlag(Boolean isDeletedFlag) {
        this.isDeletedFlag = isDeletedFlag;
    }

    public String getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(String deletedBy) {
        this.deletedBy = deletedBy == null ? null : deletedBy.trim();
    }

    public Date getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(Date deletedDate) {
        this.deletedDate = deletedDate;
    }
}