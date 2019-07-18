package com.doft.vo;

import java.math.BigDecimal;
import java.util.List;

public class CartVo {
    private List<CartDishVo> cartDishVoList;

    private BigDecimal cartTotalPrice;

    private BigDecimal cartDiscountPrice;

    private Boolean allChecked;
    private String imgHost;

    private Boolean addedSeat;

    public BigDecimal getCartDiscountPrice() {
        return cartDiscountPrice;
    }

    public void setCartDiscountPrice(BigDecimal cartDiscountPrice) {
        this.cartDiscountPrice = cartDiscountPrice;
    }

    public List<CartDishVo> getCartDishVoList() {
        return cartDishVoList;
    }


    public void setCartDishVoList(List<CartDishVo> cartDishVoList) {
        this.cartDishVoList = cartDishVoList;
    }

    public BigDecimal getCartTotalPrice() {
        return cartTotalPrice;
    }

    public void setCartTotalPrice(BigDecimal cartTotalPrice) {
        this.cartTotalPrice = cartTotalPrice;
    }

    public Boolean getAllChecked() {
        return allChecked;
    }

    public void setAllChecked(Boolean allChecked) {
        this.allChecked = allChecked;
    }

    public String getImgHost() {
        return imgHost;
    }

    public void setImgHost(String imgHost) {
        this.imgHost = imgHost;
    }

    public Boolean getAddedSeat() {
        return addedSeat;
    }

    public void setAddedSeat(Boolean addedSeat) {
        this.addedSeat = addedSeat;
    }
}
