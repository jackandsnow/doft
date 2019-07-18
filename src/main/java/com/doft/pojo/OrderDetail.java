package com.doft.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class OrderDetail {
    private Long orderDetailId;

    private String orderNo;

    private Long dishId;

    private String dishName;

    private Integer dishCount;

    private Boolean isAddedDishFlag;

    private Long userId;

    private BigDecimal currentUnitPrice;

    private BigDecimal totalPrice;

    private Date createTime;

    private Date updateTime;

    public OrderDetail(Long orderDetailId, String orderNo, Long dishId, String dishName, Integer dishCount, Boolean isAddedDishFlag, Long userId, BigDecimal currentUnitPrice, BigDecimal totalPrice, Date createTime, Date updateTime) {
        this.orderDetailId = orderDetailId;
        this.orderNo = orderNo;
        this.dishId = dishId;
        this.dishName = dishName;
        this.dishCount = dishCount;
        this.isAddedDishFlag = isAddedDishFlag;
        this.userId = userId;
        this.currentUnitPrice = currentUnitPrice;
        this.totalPrice = totalPrice;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public OrderDetail() {
        super();
    }

    public Long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public Long getDishId() {
        return dishId;
    }

    public void setDishId(Long dishId) {
        this.dishId = dishId;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName == null ? null : dishName.trim();
    }

    public Integer getDishCount() {
        return dishCount;
    }

    public void setDishCount(Integer dishCount) {
        this.dishCount = dishCount;
    }

    public Boolean getIsAddedDishFlag() {
        return isAddedDishFlag;
    }

    public void setIsAddedDishFlag(Boolean isAddedDishFlag) {
        this.isAddedDishFlag = isAddedDishFlag;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BigDecimal getCurrentUnitPrice() {
        return currentUnitPrice;
    }

    public void setCurrentUnitPrice(BigDecimal currentUnitPrice) {
        this.currentUnitPrice = currentUnitPrice;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}