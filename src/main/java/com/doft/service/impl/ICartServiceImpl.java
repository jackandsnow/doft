package com.doft.service.impl;

import com.doft.common.Const;
import com.doft.common.ServerResponse;
import com.doft.common.constant.EnumResponseCode;
import com.doft.dao.CartMapper;
import com.doft.dao.DishMapper;
import com.doft.pojo.Cart;
import com.doft.pojo.Dish;
import com.doft.service.ICartService;
import com.doft.util.BigDecimalUtil;
import com.doft.util.PropertiesUtil;
import com.doft.vo.CartDishVo;
import com.doft.vo.CartVo;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.BooleanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

@Service("iCartService")
public class ICartServiceImpl implements ICartService {

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private DishMapper dishMapper;

    public ServerResponse<CartVo> add(Long userId,Long dishId,Integer count,String userName){

        if (dishId == null || count == null || userId == null){
            return ServerResponse.createByErrorCodeMessage(EnumResponseCode.ILLEGAL_ARGUMENT.getCode(),EnumResponseCode.ILLEGAL_ARGUMENT.getDecs());
        }
        Dish dish = dishMapper.selectByDishId(dishId);
        if (dish == null){
            return ServerResponse.createByErrorMessage("菜品ID"+dishId.toString()+"找不到该菜品");
        }

        Cart cart = cartMapper.selectCartByUserIdDishId(userId,dishId);
        if (cart == null){
            //不在购物车
            Cart cartItem = new Cart();
            cartItem.setQuantites(count);
            cartItem.setChecked(Const.Cart.CHECKED);
            cartItem.setUserId(userId);
            cartItem.setCreateBy(userName);
            cartItem.setUpdateBy(userName);
            cartItem.setDishId(dishId);
            cartMapper.insert(cartItem);
        }else{
            //
            count = cart.getQuantites() + count;
            cart.setQuantites(count);
            cartMapper.updateByPrimaryKeySelective(cart);
        }
        return this.list(userId);
    }


    public ServerResponse<CartVo> update(Long userId,Long dishId,Integer count,String userName){
        if (dishId == null || count == null || userId == null){
            return ServerResponse.createByErrorCodeMessage(EnumResponseCode.ILLEGAL_ARGUMENT.getCode(),EnumResponseCode.ILLEGAL_ARGUMENT.getDecs());
        }
        Cart cart = cartMapper.selectCartByUserIdDishId(userId,dishId);
        if (cart != null){
            cart.setQuantites(count);
            cart.setUpdateBy(userName);
        }
        cartMapper.updateByPrimaryKeySelective(cart);
        return this.list(userId);
    }

    public ServerResponse<CartVo> deleteDish(String dishIds,Long userId){
        List<String> dishList = Splitter.on(",").splitToList(dishIds);
        if (CollectionUtils.isEmpty(dishList)){
            return ServerResponse.createByErrorCodeMessage(EnumResponseCode.ILLEGAL_ARGUMENT.getCode(),EnumResponseCode.ILLEGAL_ARGUMENT.getDecs());
        }
        cartMapper.deleteByUserIdDishIds(userId,dishList);
        return this.list(userId);
    }

    public ServerResponse<CartVo> cleanCart(Long userId){
        if (userId == null){
            return ServerResponse.createByErrorCodeMessage(EnumResponseCode.NEED_LOGIN.getCode(),EnumResponseCode.NEED_LOGIN.getDecs());
        }
        List<Cart> cartList = cartMapper.selectCartByUserId(userId);
        for (Cart cart:cartList){
            cartMapper.deleteByPrimaryKey(cart.getId());
            Dish dish = dishMapper.selectByDishId(cart.getDishId());
            dish.setTotalNumber(dish.getTotalNumber()+cart.getQuantites());
            dishMapper.updateByPrimaryKeySelective(dish);
        }
        return this.list(userId);
    }

    public ServerResponse<CartVo> list(Long userId){
        CartVo cartVo = this.getCartVoLimit(userId);
        return ServerResponse.createBySuccess(cartVo);
    }


    public ServerResponse<CartVo> selectOrUnSelect(Long userId,Long dishId,Integer checked){
        cartMapper.checkedOrUnCheckedDish(userId,dishId,checked);
        return this.list(userId);
    }

    public ServerResponse<Integer> getCartDishCount(Long userId){
        if (userId == null){
            return ServerResponse.createBySuccess(0);
        }
        return ServerResponse.createBySuccess(cartMapper.selectCartDishCount(userId));
    }


    private CartVo getCartVoLimit(Long userId){
        CartVo cartVo = new CartVo();
        List<Cart> cartList = cartMapper.selectCartByUserId(userId);
        List<CartDishVo> cartDishVoList = Lists.newArrayList();

        BigDecimal cartTotalPrice = new BigDecimal("0");
        BigDecimal cartDiscountPrice = new BigDecimal("0");
        Dish seat = dishMapper.selectSeat("餐位");
        Boolean addedSeat = false;
        if (CollectionUtils.isNotEmpty(cartList)){
            for (Cart cartItem: cartList){
                if (cartItem.getDishId().equals(seat.getDishId())){
                    addedSeat = true;
                }
                CartDishVo cartDishVo = new CartDishVo();
                cartDishVo.setId(cartItem.getId());
                cartDishVo.setUserId(userId);
                cartDishVo.setDishId(cartItem.getDishId());


                BigDecimal dishPrice = new BigDecimal("0");
                BigDecimal discountPrice = new BigDecimal("0");
                Dish dish = dishMapper.selectByPrimaryKey(cartItem.getDishId());
                if (dish != null){
                    cartDishVo.setDishImgUrl(dish.getDishImgUrl());
                    cartDishVo.setDishName(dish.getDishName());
                    cartDishVo.setDiscountble(dish.getIsBargainFlag());

                    cartDishVo.setDishStatus(dish.getStatus());
                    cartDishVo.setDishStock(dish.getTotalNumber());
                    if (BooleanUtils.isTrue(dish.getIsBargainFlag())){
                        dishPrice = dish.getPrice().multiply(new BigDecimal("0.8"));
                        discountPrice = dish.getPrice().multiply(new BigDecimal("0.2"));
                    }else{
                        dishPrice = dish.getPrice();

                    }

                    cartDishVo.setDishPrice(dishPrice);
                    //判断库存

                    int buyLimitCount = 0;
                    if (dish.getTotalNumber() >= cartItem.getQuantites()){
                        buyLimitCount = cartItem.getQuantites();
                        cartDishVo.setLimitQuantity(Const.Cart.LIMIT_NUM_SUCCESS);
                    }else {
                        buyLimitCount = dish.getTotalNumber();
                        cartDishVo.setLimitQuantity(Const.Cart.LIMIT_NUM_FAIL);
                        //购物车中更新有效库存
                        Cart cartForQuantity = new Cart();
                        cartForQuantity.setId(cartItem.getId());
                        cartForQuantity.setQuantites(buyLimitCount);
                        cartMapper.updateByPrimaryKeySelective(cartForQuantity);

                    }
                    cartDishVo.setQuantites(buyLimitCount);
                    //计算总价

                    cartDishVo.setDishTotalPrice(BigDecimalUtil.mul(dishPrice.doubleValue(),cartDishVo.getQuantites().doubleValue()));
                    cartDishVo.setDishChecked(cartItem.getChecked());
                }

                if (cartItem.getChecked() == Const.Cart.CHECKED){
                    //增加到购物车总价
                    if (BooleanUtils.isTrue(dish.getIsBargainFlag())){
                        cartDiscountPrice = BigDecimalUtil.add(cartDiscountPrice.doubleValue(),BigDecimalUtil.mul(discountPrice.doubleValue(),cartDishVo.getQuantites().doubleValue()).doubleValue());
                    }
                    cartTotalPrice = BigDecimalUtil.add(cartTotalPrice.doubleValue(),cartDishVo.getDishTotalPrice().doubleValue());
                }
                cartDishVoList.add(cartDishVo);
            }
        }
//        cartDiscountPrice = cartDiscountPrice.multiply(new BigDecimal("0.2"));
//        cartTotalPrice = BigDecimalUtil.sub(cartTotalPrice.doubleValue(),cartDiscountPrice.doubleValue());
        cartVo.setCartTotalPrice(cartTotalPrice);
        cartVo.setCartDiscountPrice(cartDiscountPrice);
        cartVo.setCartDishVoList(cartDishVoList);
        cartVo.setAllChecked(this.getAllCheckedStatus(userId));
        cartVo.setImgHost(PropertiesUtil.getProperty("ftp.server.http.prefix"));
        cartVo.setAddedSeat(addedSeat);
        return cartVo;
    }

    private boolean getAllCheckedStatus(Long userId){
        if (userId == null){
            return false;
        }
        return cartMapper.selectCartDishCheckedStatusByUserId(userId) == 0;
    }
}
