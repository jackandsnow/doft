package com.doft.common.constant;

import com.doft.common.exception.BusinessException;

/**
 * Created by Jack at 18:48 2018/3/6
 * version 1.0
 */
public enum EnumOrderStatus {

    /**
     * 订单状态
     * 1. 未付款
     * 2. 申请中
     * 3. 已付款
     * 4. 已处理
     * 5. 已完成
     * 6. 已取消
     */

    UNPAID(1, "UNPAID", "未付款"),
    APPLYING(2, "APPLYING", "申请中"),
    PAID(3, "PAID", "已付款"),
    DEALT(4, "DEALT", "已处理"),
    FINISHED(5, "FINISHED", "已完成"),
    CANCELLED(6, "CANCELLED", "已取消");

    private final Integer code;
    private final String enDesc;
    private final String cnDesc;

    EnumOrderStatus(Integer code, String enDesc, String cnDesc) {
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

    public static EnumOrderStatus ofCode(Integer status) {
        if (status == null) {
            // Exception
            throw new BusinessException("该订单状态不存在！");
        }
        for (EnumOrderStatus orderStatus : values()) {
            if (orderStatus.getCode() == status) {
                return orderStatus;
            }
        }
        // Exception
        throw new BusinessException("该订单状态不存在！");
    }

}
