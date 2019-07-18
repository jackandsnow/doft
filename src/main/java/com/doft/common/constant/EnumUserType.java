package com.doft.common.constant;

import com.doft.common.exception.BusinessException;

/**
 * Created by Jack at 15:18 2018/3/14
 * version 1.0
 */
public enum EnumUserType {
    COMMON_USER(0, "common user", "普通用户"),
    ADMINISTRATOR(1, "administrator", "普通管理员"),
    SUPER_ADMINISTRATOR(2, "super administrator", "超级管理员");

    private final Integer code;
    private final String enDesc;
    private final String cnDesc;

    EnumUserType(Integer code, String enDesc, String cnDesc) {
        this.code = code;
        this.enDesc = enDesc;
        this.cnDesc = cnDesc;
    }

    public Integer getCode() {
        return code;
    }

    public String getEnDesc() {
        return enDesc;
    }

    public String getCnDesc() {
        return cnDesc;
    }

    public static EnumUserType ofCode(Integer type) {
        if (type == null) {
            throw new BusinessException("该用户类型不存在！");
        }
        for (EnumUserType userType : values()) {
            if (type == userType.getCode()) {
                return userType;
            }
        }
        throw new BusinessException("该用户类型不存在！");
    }
}
