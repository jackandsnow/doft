package com.doft.pojo;

public class RolePermission {
    private Integer roleId;

    private String roleType;

    private Boolean orderManageFlag;

    private Boolean userManageFlag;

    private Boolean infoManageFlag;

    private Boolean systemManageFlag;

    @Override
    public String toString() {
        return "RolePermission{" +
                "roleId=" + roleId +
                ", roleType='" + roleType + '\'' +
                ", orderManageFlag=" + orderManageFlag +
                ", userManageFlag=" + userManageFlag +
                ", infoManageFlag=" + infoManageFlag +
                ", systemManageFlag=" + systemManageFlag +
                '}';
    }

    public RolePermission(Integer roleId, String roleType, Boolean orderManageFlag, Boolean userManageFlag, Boolean infoManageFlag, Boolean systemManageFlag) {
        this.roleId = roleId;
        this.roleType = roleType;
        this.orderManageFlag = orderManageFlag;
        this.userManageFlag = userManageFlag;
        this.infoManageFlag = infoManageFlag;
        this.systemManageFlag = systemManageFlag;
    }

    public RolePermission() {
        super();
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType == null ? null : roleType.trim();
    }

    public Boolean getOrderManageFlag() {
        return orderManageFlag;
    }

    public void setOrderManageFlag(Boolean orderManageFlag) {
        this.orderManageFlag = orderManageFlag;
    }

    public Boolean getUserManageFlag() {
        return userManageFlag;
    }

    public void setUserManageFlag(Boolean userManageFlag) {
        this.userManageFlag = userManageFlag;
    }

    public Boolean getInfoManageFlag() {
        return infoManageFlag;
    }

    public void setInfoManageFlag(Boolean infoManageFlag) {
        this.infoManageFlag = infoManageFlag;
    }

    public Boolean getSystemManageFlag() {
        return systemManageFlag;
    }

    public void setSystemManageFlag(Boolean systemManageFlag) {
        this.systemManageFlag = systemManageFlag;
    }
}