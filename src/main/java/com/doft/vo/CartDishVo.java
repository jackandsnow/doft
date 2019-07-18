package com.doft.vo;

import java.math.BigDecimal;

public class CartDishVo {

    private Long id;

    private Long userId;

    private Long dishId;

    private Integer quantites;

    private String dishName;

    private String dishImgUrl;

    private BigDecimal dishPrice;

    private Integer dishStatus;

    private BigDecimal dishTotalPrice;

    private Integer dishStock;

    private Integer dishChecked;

    private String limitQuantity;

    private Boolean discountble;

    public Boolean getDiscountble() {
        return discountble;
    }

    public void setDiscountble(Boolean discountble) {
        this.discountble = discountble;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getDishId() {
        return dishId;
    }

    public void setDishId(Long dishId) {
        this.dishId = dishId;
    }

    public Integer getQuantites() {
        return quantites;
    }

    public void setQuantites(Integer quantites) {
        this.quantites = quantites;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDishImgUrl() {
        return dishImgUrl;
    }

    public void setDishImgUrl(String dishImgUrl) {
        this.dishImgUrl = dishImgUrl;
    }

    public BigDecimal getDishPrice() {
        return dishPrice;
    }

    public void setDishPrice(BigDecimal dishPrice) {
        this.dishPrice = dishPrice;
    }

    public Integer getDishStatus() {
        return dishStatus;
    }

    public void setDishStatus(Integer dishStatus) {
        this.dishStatus = dishStatus;
    }

    public BigDecimal getDishTotalPrice() {
        return dishTotalPrice;
    }

    public void setDishTotalPrice(BigDecimal dishTotalPrice) {
        this.dishTotalPrice = dishTotalPrice;
    }

    public Integer getDishStock() {
        return dishStock;
    }

    public void setDishStock(Integer dishStock) {
        this.dishStock = dishStock;
    }

    public Integer getDishChecked() {
        return dishChecked;
    }

    public void setDishChecked(Integer dishChecked) {
        this.dishChecked = dishChecked;
    }

    public String getLimitQuantity() {
        return limitQuantity;
    }

    public void setLimitQuantity(String limitQuantity) {
        this.limitQuantity = limitQuantity;
    }
}
