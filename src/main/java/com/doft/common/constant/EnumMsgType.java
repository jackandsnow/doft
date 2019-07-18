package com.doft.common.constant;

import com.doft.common.exception.BusinessException;

/**
 * Created by Jack at 16:33 2018/3/14
 * version 1.0
 */
public enum EnumMsgType {

    ORDER_DEALT_NOTIFICATION(1, "order dealt notification", "订单处理通知"),
    RECHARGE_MESSAGE(2, "recharge message", "充值消息"),
    DISH_DISCOUNT_MESSAGE(3, "dish discount message", "菜品优惠消息");

    private final Integer code;
    private final String enDesc;
    private final String cnDesc;

    EnumMsgType(Integer code, String enDesc, String cnDesc) {
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

    public static EnumMsgType ofCode(Integer type) {
        if (type == null) {
            throw new BusinessException("该消息类型不存在！");
        }
        for (EnumMsgType msgType : values()) {
            if (type == msgType.getCode()) {
                return msgType;
            }
        }
        throw new BusinessException("该消息类型不存在！");
    }
}
