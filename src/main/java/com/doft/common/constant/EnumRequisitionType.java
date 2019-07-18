package com.doft.common.constant;

import com.doft.common.exception.BusinessException;

/**
 * Created by Jack at 10:08 2018/3/14
 * version 1.0
 */
public enum EnumRequisitionType {

    /**
     * 申请单类型
     * 1. 加菜
     * 2. 取消订单
     */

    ADD_DISH(1, "add dish", "加菜"),
    CANCEL_ORDER(2, "cancel order", "取消订单");

    private final Integer code;
    private final String enDesc;
    private final String cnDesc;

    EnumRequisitionType(Integer code, String enDesc, String cnDesc) {
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

    public static EnumRequisitionType ofCode(Integer type) {
        if (type == null) {
            // Exception
            throw new BusinessException("该申请单类型不存在！");
        }
        for (EnumRequisitionType requisitionType : values()) {
            if (requisitionType.getCode() == type) {
                return requisitionType;
            }
        }
        // Exception
        throw new BusinessException("该申请单类型不存在！");
    }
}
