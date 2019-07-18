package com.doft.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Jack at 14:34 2018/3/21
 * version 1.0
 */
public class SaleAmountVo implements Serializable {

    /* 销售日期 */
    private String date;
    /* 销售金额 */
    private BigDecimal amount = BigDecimal.ZERO;

    @Override
    public String toString() {
        return "SaleAmountVo{" +
                "date='" + date + '\'' +
                ", amount=" + amount +
                '}';
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
