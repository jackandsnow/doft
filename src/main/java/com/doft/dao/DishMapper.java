package com.doft.dao;

import com.doft.pojo.Dish;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DishMapper {
    int deleteByPrimaryKey(Long dishId);

    int insert(Dish record);

    int insertSelective(Dish record);

    Dish selectByPrimaryKey(Long dishId);

    int updateByPrimaryKeySelective(Dish record);

    int updateByPrimaryKey(Dish record);

    List<Dish> selectByDishType(Long type);

    List<Dish> selectList();

    List<Dish> selectByNameAndDishId(@Param("dishName")String dishName, @Param("dishId")Long dishId);

    Dish selectByDishId(Long dishId);

    List<Dish> selectByNameAndDishTypeId(@Param("dishName")String dishName, @Param("dishTypeId")Long dishTypeId);

    Long countByCreatedTime(@Param("begin") String begin, @Param("end") String end);


    Dish selectSeat(String seatName);
}