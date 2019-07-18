package com.doft.pojo;

import java.util.Date;

public class SaleNum {
    private Long saleId;

    private Long dishId;

    private Long daySaleNumber;

    private Date saleDate;

    public SaleNum(Long saleId, Long dishId, Long daySaleNumber, Date saleDate) {
        this.saleId = saleId;
        this.dishId = dishId;
        this.daySaleNumber = daySaleNumber;
        this.saleDate = saleDate;
    }

    public SaleNum() {
        super();
    }

    public Long getSaleId() {
        return saleId;
    }

    public void setSaleId(Long saleId) {
        this.saleId = saleId;
    }

    public Long getDishId() {
        return dishId;
    }

    public void setDishId(Long dishId) {
        this.dishId = dishId;
    }

    public Long getDaySaleNumber() {
        return daySaleNumber;
    }

    public void setDaySaleNumber(Long daySaleNumber) {
        this.daySaleNumber = daySaleNumber;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }
}