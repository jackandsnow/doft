package com.doft.pojo;

import java.util.Date;

public class DishType {
    private Long dishTypeId;

    private String typeName;

    private Date creationDate;

    private String createdBy;

    private Date lastUpdatedDate;

    private String lastUpdatedBy;

    private Boolean status;

    private Integer sortOrder;

    @Override
    public String toString() {
        return "DishType{" +
                "dishTypeId=" + dishTypeId +
                ", typeName='" + typeName + '\'' +
                ", creationDate=" + creationDate +
                ", createdBy='" + createdBy + '\'' +
                ", lastUpdatedDate=" + lastUpdatedDate +
                ", lastUpdatedBy='" + lastUpdatedBy + '\'' +
                ", status=" + status +
                ", sortOrder=" + sortOrder +
                '}';
    }

    public DishType(Long dishTypeId, String typeName, Date creationDate, String createdBy, Date lastUpdatedDate, String lastUpdatedBy, Boolean status, Integer sortOrder) {
        this.dishTypeId = dishTypeId;
        this.typeName = typeName;
        this.creationDate = creationDate;
        this.createdBy = createdBy;
        this.lastUpdatedDate = lastUpdatedDate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.status = status;
        this.sortOrder = sortOrder;
    }

    public DishType() {
        super();
    }

    public Long getDishTypeId() {
        return dishTypeId;
    }

    public void setDishTypeId(Long dishTypeId) {
        this.dishTypeId = dishTypeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }
}