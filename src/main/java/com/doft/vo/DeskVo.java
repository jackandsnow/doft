package com.doft.vo;

import com.doft.common.constant.EnumDeskStatus;
import com.doft.pojo.Desk;

import java.io.Serializable;

/**
 * Created by Jack at 17:20 2018/3/16
 * version 1.0
 */
public class DeskVo implements Serializable {

    private Long deskId;

    private String deskStatus;

    @Override
    public String toString() {
        return "DeskVo{" +
                "deskId=" + deskId +
                ", deskStatus='" + deskStatus + '\'' +
                '}';
    }

    public DeskVo(Desk desk) {
        this.deskId = desk.getDeskId();
        EnumDeskStatus status = EnumDeskStatus.ofCode(desk.getDeskStatus());
        this.deskStatus = status.getCnDesc();
    }

    public DeskVo(Long deskId, String deskStatus) {
        this.deskId = deskId;
        this.deskStatus = deskStatus;
    }

    public Long getDeskId() {
        return deskId;
    }

    public void setDeskId(Long deskId) {
        this.deskId = deskId;
    }

    public String getDeskStatus() {
        return deskStatus;
    }

    public void setDeskStatus(String deskStatus) {
        this.deskStatus = deskStatus;
    }
}
