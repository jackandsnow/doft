package com.doft.service;

import com.doft.common.ServerResponse;
import com.doft.pojo.Dish;
import com.doft.pojo.User;
import com.doft.vo.DishDetailVo;
import com.github.pagehelper.PageInfo;

import java.util.Date;


public interface IDishService {
    ServerResponse saveOrUpdateDish(Dish dish);
    ServerResponse<String> setSaleStatus(Long dishId, Integer status);
    ServerResponse<DishDetailVo> manageDishDetail(Long dishId);
    ServerResponse<PageInfo> getDishList(int pageNum, int pageSize);
    ServerResponse<PageInfo> searchDish(String dishName,Long dishId,int pageNum,int pageSize,String orderBy,String order);
    ServerResponse<DishDetailVo> getDishDetail(Long dishId);
    ServerResponse<PageInfo> getDishByKeywordDishType(String keyword,Long dishTypeId,int pageNum,int pageSize,String orderBy,String order);
    Long addedDishCount(Date date);
}
