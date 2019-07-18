package com.doft.vo;

import java.io.Serializable;

/**
 * Created by Jack at 20:14 2018/3/20
 * version 1.0
 */
public class SaleManageVo implements Serializable {

    private Long dishId;

    private String dishName;

    private String dishTypeName;

    private Long totalSales;

    private Float recommendIndex;

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

    public Long getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(Long totalSales) {
        this.totalSales = totalSales;
    }

    public Float getRecommendIndex() {
        return recommendIndex;
    }

    public void setRecommendIndex(Float recommendIndex) {
        this.recommendIndex = recommendIndex;
    }

    @Override
    public String toString() {
        return "SaleManageVo{" +
                "dishId=" + dishId +
                ", dishName='" + dishName + '\'' +
                ", dishTypeName='" + dishTypeName + '\'' +
                ", totalSales=" + totalSales +
                ", recommendIndex=" + recommendIndex +
                '}';
    }
}
