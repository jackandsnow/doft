package com.doft.common.constant;

public enum EnumResponseCode {
    SUCCESS("0","success"),
    ERROR("1","error"),
    NEED_LOGIN("10","need login"),
    ILLEGAL_ARGUMENT("2","illegal argument");

    private final String code;
    private final String decs;

    EnumResponseCode(String code, String decs){
        this.code = code;
        this.decs = decs;
    }

    public String getCode() {
        return code;
    }

    public String getDecs() {
        return decs;
    }
}
