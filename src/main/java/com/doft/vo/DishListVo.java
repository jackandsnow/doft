package com.doft.vo;

import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class DishListVo {
    private Long dishId;

    private String dishName;

    private String dishTypeName;

    private String dishImgUrl;

    private BigDecimal price;

    private String description;

    private Integer totalNumber;

    private Float recommendIndex;

    private String status;

    private String imageHost;

    private Boolean isDiscountble;

    public Boolean getDiscountble() {
        return isDiscountble;
    }

    public void setDiscountble(Boolean discountble) {
        isDiscountble = discountble;
    }

    @Override
    public String toString() {
        return "DishListVo{" +
                "dishId=" + dishId +
                ", dishName='" + dishName + '\'' +
                ", dishTypeName='" + dishTypeName + '\'' +
                ", dishImgUrl='" + dishImgUrl + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", totalNumber=" + totalNumber +
                ", recommendIndex=" + recommendIndex +
                ", status=" + status +
                ", imageHost='" + imageHost + '\'' +
                '}';
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

    public String getDishTypeName() {
        return dishTypeName;
    }

    public void setDishTypeName(String dishTypeName) {
        this.dishTypeName = dishTypeName;
    }

    public String getDishImgUrl() {
        return dishImgUrl;
    }

    public void setDishImgUrl(String dishImgUrl) {
        this.dishImgUrl = dishImgUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(Integer totalNumber) {
        this.totalNumber = totalNumber;
    }

    public Float getRecommendIndex() {
        return recommendIndex;
    }

    public void setRecommendIndex(Float recommendIndex) {
        this.recommendIndex = recommendIndex;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImageHost() {
        return imageHost;
    }

    public void setImageHost(String imageHost) {
        this.imageHost = imageHost;
    }
}
