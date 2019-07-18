package com.doft.dao;

import com.doft.pojo.Cart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Cart record);

    int insertSelective(Cart record);

    Cart selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKey(Cart record);

    Cart selectCartByUserIdDishId(@Param("userId") Long userId, @Param("dishId")Long dishId);

    List<Cart> selectCartByUserId(Long userId);

    int selectCartDishCheckedStatusByUserId(Long userId);

    int deleteByUserIdDishIds(@Param("userId")Long userId,@Param("dishIds")List<String> dishIds);

    int checkedOrUnCheckedDish(@Param("userId")Long userId,@Param("dishId")Long dishId,@Param("checked")Integer checked);

    int selectCartDishCount(Long userId);

    List<Cart> selectCheckCartByUserId(Long userId);
}