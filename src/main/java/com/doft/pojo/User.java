package com.doft.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class User {
    private Long userId;

    private String userName;

    private String password;

    private String headUrl;

    private String phoneNumber;

    private BigDecimal remainingMoney;

    private Integer roleId;

    private Boolean isDeletedFlag;

    private Date creationTime;

    private String createdBy;

    private Date lastUpdatedTime;

    private String lastUpdatedBy;

    private String question;

    private String answer;

    public User(Long userId, String userName, String password, String headUrl, String phoneNumber, BigDecimal remainingMoney, Integer roleId, Boolean isDeletedFlag, Date creationTime, String createdBy, Date lastUpdatedTime, String lastUpdatedBy, String question, String answer) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.headUrl = headUrl;
        this.phoneNumber = phoneNumber;
        this.remainingMoney = remainingMoney;
        this.roleId = roleId;
        this.isDeletedFlag = isDeletedFlag;
        this.creationTime = creationTime;
        this.createdBy = createdBy;
        this.lastUpdatedTime = lastUpdatedTime;
        this.lastUpdatedBy = lastUpdatedBy;
        this.question = question;
        this.answer = answer;
    }

    public User() {
        super();
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
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl == null ? null : headUrl.trim();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    public BigDecimal getRemainingMoney() {
        return remainingMoney;
    }

    public void setRemainingMoney(BigDecimal remainingMoney) {
        this.remainingMoney = remainingMoney;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Boolean getIsDeletedFlag() {
        return isDeletedFlag;
    }

    public void setIsDeletedFlag(Boolean isDeletedFlag) {
        this.isDeletedFlag = isDeletedFlag;
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

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }
}