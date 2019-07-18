package com.doft.common;

import static com.doft.common.constant.EnumResponseCode.SUCCESS;
import static com.doft.common.constant.EnumResponseCode.ERROR;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
//保证序列化json 如果是null，则不显示key
public class ServerResponse<T> implements Serializable {

    /**
     * 是否成功
     */
    private String status;
    /**
     * 返回的提示信息
     */
    private String msg;
    /**
     * 返回的数据
     */
    private T data;

    private ServerResponse(String status) {
        this.status = status;
    }

    private ServerResponse(String status, T data) {
        this.status = status;
        this.data = data;
    }

    private ServerResponse(String status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public ServerResponse(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    @JsonIgnore
    public boolean isSuccess() {
        return SUCCESS.getCode().equals(getStatus());
    }

    public String getStatus() {
        return status;
    }

    public T getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }

    public static <T> ServerResponse<T> createBySuccess() {
        return new ServerResponse<T>(SUCCESS.getCode());
    }

    public static <T> ServerResponse<T> createBySuccessMessage(String msg) {
        return new ServerResponse<T>(SUCCESS.getCode(), msg);

    }

    public static <T> ServerResponse<T> createBySuccess(T data) {
        return new ServerResponse<T>(SUCCESS.getCode(), data);
    }

    public static <T> ServerResponse<T> createBySuccess(String msg, T data) {
        return new ServerResponse<T>(SUCCESS.getCode(), msg, data);
    }

    public static <T> ServerResponse<T> createByError() {
        return new ServerResponse<T>(ERROR.getCode());
    }

    public static <T> ServerResponse<T> createByErrorMessage(String errorMessage) {
        return new ServerResponse<T>(ERROR.getCode(), errorMessage);
    }


    public static <T> ServerResponse<T> createByErrorCodeMessage(String errorCode, String errorMessage) {
        return new ServerResponse<T>(errorCode, errorMessage);
    }
}
