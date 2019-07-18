package com.doft.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Dish {
    private Long dishId;

    private String dishName;

    private Long dishTypeId;

    private String dishImgUrl;

    private BigDecimal price;

    private Integer totalNumber;

    private Integer status;

    private Boolean isBargainFlag;

    private Date creationTime;

    private String createdBy;

    private Date lastUpdatedTime;

    private String lastUpdatedBy;

    private Float recommendIndex;

    private String description;

    public Dish(Long dishId, String dishName, Long dishTypeId, String dishImgUrl, BigDecimal price, Integer totalNumber, Integer status, Boolean isBargainFlag, Date creationTime, String createdBy, Date lastUpdatedTime, String lastUpdatedBy, Float recommendIndex, String description) {
        this.dishId = dishId;
        this.dishName = dishName;
        this.dishTypeId = dishTypeId;
        this.dishImgUrl = dishImgUrl;
        this.price = price;
        this.totalNumber = totalNumber;
        this.status = status;
        this.isBargainFlag = isBargainFlag;
        this.creationTime = creationTime;
        this.createdBy = createdBy;
        this.lastUpdatedTime = lastUpdatedTime;
        this.lastUpdatedBy = lastUpdatedBy;
        this.recommendIndex = recommendIndex;
        this.description = description;
    }

    public Dish() {
        super();
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

    public Long getDishTypeId() {
        return dishTypeId;
    }

    public void setDishTypeId(Long dishTypeId) {
        this.dishTypeId = dishTypeId;
    }

    public String getDishImgUrl() {
        return dishImgUrl;
    }

    public void setDishImgUrl(String dishImgUrl) {
        this.dishImgUrl = dishImgUrl == null ? null : dishImgUrl.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(Integer totalNumber) {
        this.totalNumber = totalNumber;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Boolean getIsBargainFlag() {
        return isBargainFlag;
    }

    public void setIsBargainFlag(Boolean isBargainFlag) {
        this.isBargainFlag = isBargainFlag;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    public Date getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public void setLastUpdatedTime(Date lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy == null ? null : lastUpdatedBy.trim();
    }

    public Float getRecommendIndex() {
        return recommendIndex;
    }

    public void setRecommendIndex(Float recommendIndex) {
        this.recommendIndex = recommendIndex;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}