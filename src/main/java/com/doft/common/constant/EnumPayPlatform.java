package com.doft.common.constant;

/**
 * Created by Jack at 15:46 2018/3/16
 * version 1.0
 */
public enum EnumPayPlatform {

    NORMAL(0,"余额支付"),
    ALIPAY(1,"支付宝"),
    CASH(2,"现金支付");

    EnumPayPlatform(int code,String value){
        this.code = code;
        this.value = value;
    }
    private String value;
    private int code;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
