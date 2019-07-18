package com.doft.pojo;

public class Desk {
    private Long deskId;

    private Integer deskStatus;

    private Boolean isValidFlag;

    public Desk(Long deskId, Integer deskStatus, Boolean isValidFlag) {
        this.deskId = deskId;
        this.deskStatus = deskStatus;
        this.isValidFlag = isValidFlag;
    }

    public Desk() {
        super();
    }

    public Long getDeskId() {
        return deskId;
    }

    public void setDeskId(Long deskId) {
        this.deskId = deskId;
    }

    public Integer getDeskStatus() {
        return deskStatus;
    }

    public void setDeskStatus(Integer deskStatus) {
        this.deskStatus = deskStatus;
    }

    public Boolean getIsValidFlag() {
        return isValidFlag;
    }

    public void setIsValidFlag(Boolean isValidFlag) {
        this.isValidFlag = isValidFlag;
    }
}