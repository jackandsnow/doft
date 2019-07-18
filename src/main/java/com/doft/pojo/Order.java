package com.doft.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    private Long orderId;

    private Long userId;

    private String orderNo;

    private Integer peopleCount;

    private Long deskId;

    private BigDecimal totalPrice;

    private Integer paymentType;

    private BigDecimal discountAmount;

    private Integer orderStatus;

    private String remark;

    private Boolean isDeletedFlag;

    private Date creationDate;

    private String createdBy;

    private Date lastUpdatedDate;

    private String lastUpdatedBy;

    private Date endTime;

    private Date paymentTime;

    public Order(Long orderId, Long userId, String orderNo, Integer peopleCount, Long deskId, BigDecimal totalPrice, Integer paymentType, BigDecimal discountAmount, Integer orderStatus, String remark, Boolean isDeletedFlag, Date creationDate, String createdBy, Date lastUpdatedDate, String lastUpdatedBy, Date endTime, Date paymentTime) {
        this.orderId = orderId;
        this.userId = userId;
        this.orderNo = orderNo;
        this.peopleCount = peopleCount;
        this.deskId = deskId;
        this.totalPrice = totalPrice;
        this.paymentType = paymentType;
        this.discountAmount = discountAmount;
        this.orderStatus = orderStatus;
        this.remark = remark;
        this.isDeletedFlag = isDeletedFlag;
        this.creationDate = creationDate;
        this.createdBy = createdBy;
        this.lastUpdatedDate = lastUpdatedDate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.endTime = endTime;
        this.paymentTime = paymentTime;
    }

    public Order() {
        super();
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public Integer getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(Integer peopleCount) {
        this.peopleCount = peopleCount;
    }

    public Long getDeskId() {
        return deskId;
    }

    public void setDeskId(Long deskId) {
        this.deskId = deskId;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Boolean getIsDeletedFlag() {
        return isDeletedFlag;
    }

    public void setIsDeletedFlag(Boolean isDeletedFlag) {
        this.isDeletedFlag = isDeletedFlag;
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

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy == null ? null : lastUpdatedBy.trim();
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }
}