package com.doft.vo;

import com.doft.common.constant.EnumUserType;
import com.doft.pojo.User;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;

/**
 * Created by Jack at 15:07 2018/3/14
 * version 1.0
 */
public class UserManageVo implements Serializable {

    private Long userId;

    private String userName;

    private String phoneNumber;

    private BigDecimal remainingMoney;

    private String creationTime;

    private String headUrl;

    private String userType;

    public UserManageVo(User user) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        this.creationTime = dateFormat.format(user.getCreationTime());
        this.headUrl = user.getHeadUrl() == null ? "" : user.getHeadUrl();
        this.phoneNumber = user.getPhoneNumber();
        this.remainingMoney = user.getRemainingMoney();
        this.userId = user.getUserId();
        this.userName = user.getUserName();
        EnumUserType type = EnumUserType.ofCode(user.getRoleId());
        this.userType = type.getCnDesc();
    }

    @Override
    public String toString() {
        return "UserManageVo{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", remainingMoney=" + remainingMoney +
                ", creationTime='" + creationTime + '\'' +
                ", headUrl='" + headUrl + '\'' +
                ", userType='" + userType + '\'' +
                '}';
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public BigDecimal getRemainingMoney() {
        return remainingMoney;
    }

    public void setRemainingMoney(BigDecimal remainingMoney) {
        this.remainingMoney = remainingMoney;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
