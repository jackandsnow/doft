package com.doft.pojo;

import java.util.Date;

public class Cart {
    private Long id;

    private Long userId;

    private Long dishId;

    private Integer quantites;

    private Integer checked;

    private Date createTime;

    private String createBy;

    private Date updateTime;

    private String updateBy;

    public Cart(Long id, Long userId, Long dishId, Integer quantites, Integer checked, Date createTime, String createBy, Date updateTime, String updateBy) {
        this.id = id;
        this.userId = userId;
        this.dishId = dishId;
        this.quantites = quantites;
        this.checked = checked;
        this.createTime = createTime;
        this.createBy = createBy;
        this.updateTime = updateTime;
        this.updateBy = updateBy;
    }

    public Cart() {
        super();
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

    public Integer getChecked() {
        return checked;
    }

    public void setChecked(Integer checked) {
        this.checked = checked;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }
}