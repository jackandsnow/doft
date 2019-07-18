package com.doft.vo;

import com.doft.pojo.Dish;
import com.doft.pojo.Order;
import com.doft.pojo.OrderDetail;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Jack at 15:57 2018/3/13
 * version 1.0
 */
public class OrderDetailVo implements Serializable {

    private String orderNo;

    private Long dishId;

    private String dishName;

    private Integer dishCount;

    private Boolean isAddedDishFlag;

    private Boolean discountble;
//
//    private Long userId;

    private BigDecimal currentUnitPrice;

    private BigDecimal totalPrice;

    private String createTime;

    private String ImgUrl;

//    private Date updateTime;


    public Boolean getAddedDishFlag() {
        return isAddedDishFlag;
    }

    public void setAddedDishFlag(Boolean addedDishFlag) {
        isAddedDishFlag = addedDishFlag;
    }

    public Boolean getDiscountble() {
        return discountble;
    }

    public void setDiscountble(Boolean discountble) {
        this.discountble = discountble;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
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
        this.dishName = dishName;
    }

    public Integer getDishCount() {
        return dishCount;
    }

    public void setDishCount(Integer dishCount) {
        this.dishCount = dishCount;
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getImgUrl() {
        return ImgUrl;
    }

    public void setImgUrl(String imgUrl) {
        ImgUrl = imgUrl;
    }
}
