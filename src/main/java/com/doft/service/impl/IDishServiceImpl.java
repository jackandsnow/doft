package com.doft.service.impl;

import com.doft.common.Const;
import com.doft.common.ServerResponse;
import com.doft.common.constant.EnumDishStatus;
import com.doft.common.constant.EnumResponseCode;
import com.doft.dao.DishMapper;
import com.doft.dao.DishTypeMapper;
import com.doft.pojo.Dish;
import com.doft.pojo.DishType;
import com.doft.pojo.User;
import com.doft.service.IDishService;
import com.doft.util.DateTimeUtil;
import com.doft.util.PropertiesUtil;
import com.doft.vo.DishDetailVo;
import com.doft.vo.DishListVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service("iDishService")
public class IDishServiceImpl implements IDishService {

    @Autowired
    private DishTypeMapper dishTypeMapper;

    @Autowired
    private DishMapper dishMapper;

    private static Logger logger = LoggerFactory.getLogger(IDishServiceImpl.class);

    public ServerResponse saveOrUpdateDish(Dish dish) {
        if (dish != null) {
//            if (StringUtils.isNotBlank(dish.getDishImgUrl())){
//                String[] subImageArray = dish.getDishImgUrl().split(",");
//                if (subImageArray.length > 0){
//
//                }
//            }
            if (dish.getDishId() != null) {
                int rowCount = dishMapper.updateByPrimaryKeySelective(dish);
                if (rowCount > 0) {
                    return ServerResponse.createBySuccessMessage("更新菜品成功");
                }
                return ServerResponse.createBySuccessMessage("更新菜品失败");
            } else {
                dish.setCreatedBy(dish.getLastUpdatedBy());
//                dish.setIsBargainFlag(false);
                dish.setStatus(1);
                int rowCount = dishMapper.insert(dish);
                if (rowCount > 0) {
                    return ServerResponse.createBySuccessMessage("新增菜品成功");
                }
                return ServerResponse.createBySuccessMessage("新增菜品失败");
            }
        } else {
            return ServerResponse.createByErrorMessage("新增或更新菜品参数错误");
        }
    }

    public ServerResponse<String> setSaleStatus(Long dishId, Integer status) {
        if (dishId == null || status == null) {
            return ServerResponse.createByErrorCodeMessage(EnumResponseCode.ILLEGAL_ARGUMENT.getCode(),
                    EnumResponseCode.ILLEGAL_ARGUMENT.getDecs());
        }
        Dish dish = new Dish();
        dish.setDishId(dishId);
        dish.setStatus(status);
        int rowCount = dishMapper.updateByPrimaryKeySelective(dish);
        if (rowCount > 0) {
            return ServerResponse.createBySuccessMessage("修改菜品销售状态成功");
        }
        return ServerResponse.createByErrorMessage("修改菜品销售状态失败");
    }

    public ServerResponse<DishDetailVo> manageDishDetail(Long dishId) {
        if (dishId == null) {
            return ServerResponse.createByErrorCodeMessage(EnumResponseCode.ILLEGAL_ARGUMENT.getCode(),
                    EnumResponseCode.ILLEGAL_ARGUMENT.getDecs());
        }
        Dish dish = dishMapper.selectByPrimaryKey(dishId);
        if (dish == null) {
            return ServerResponse.createByErrorMessage("菜品不存在");
        }
        //vo -- value object
        DishDetailVo dishDetailVo = assembleDishDetailVo(dish);
        return ServerResponse.createBySuccess(dishDetailVo);
    }

    private DishDetailVo assembleDishDetailVo(Dish dish) {
        DishDetailVo dishDetailVo = new DishDetailVo();
        dishDetailVo.setDishId(dish.getDishId());
        dishDetailVo.setDishTypeId(dish.getDishTypeId());
        dishDetailVo.setDishImgUrl(dish.getDishImgUrl());
        dishDetailVo.setDishName(dish.getDishName());
        dishDetailVo.setDescription(dish.getDescription());
        dishDetailVo.setPrice(dish.getPrice());
        dishDetailVo.setStatus(dish.getStatus());
        dishDetailVo.setTotalNumber(dish.getTotalNumber());
        //image host

        dishDetailVo.setImgHost(PropertiesUtil.getProperty(
                "ftp.server.http.prefix", "http://img.doft.com/"));

//        DishType dishType = dishTypeMapper.selectByPrimaryKey(dish.getDishTypeId());
//        if (dishType = null){
//
//        }else {
//            dishDetailVo.setDishTypeId();set
//        }

        //create time
        dishDetailVo.setCreateTime(DateTimeUtil.dateToStr(dish.getCreationTime()));
        //update time
        dishDetailVo.setUpdateTime(DateTimeUtil.dateToStr(dish.getLastUpdatedTime()));
        return dishDetailVo;
    }

    public ServerResponse<PageInfo> getDishList(int pageNum, int pageSize) {
        //startpage
        PageHelper.startPage(pageNum, pageSize);
        //填充自己的sql设置
        List<Dish> dishList = dishMapper.selectList();
        List<DishListVo> dishListVoList = Lists.newArrayList();
        for (Dish dishItem : dishList) {
            DishListVo dishListVo = assembleDishListVo(dishItem);
            dishListVoList.add(dishListVo);
        }
        //pageHelper收尾
        PageInfo pageResult = new PageInfo(dishList);
        pageResult.setList(dishListVoList);
        return ServerResponse.createBySuccess(pageResult);
    }

    private DishListVo assembleDishListVo(Dish dish) {
        DishListVo dishListVo = new DishListVo();
        dishListVo.setDishId(dish.getDishId());
        dishListVo.setDishName(dish.getDishName());
        dishListVo.setDishImgUrl(dish.getDishImgUrl());
        DishType type = dishTypeMapper.selectByPrimaryKey(dish.getDishTypeId());
        dishListVo.setDishTypeName(type.getTypeName());
        dishListVo.setPrice(dish.getPrice());
        EnumDishStatus status = EnumDishStatus.ofCode(dish.getStatus());
        dishListVo.setStatus(status.getCnDesc());
        dishListVo.setRecommendIndex(dish.getRecommendIndex());
        dishListVo.setTotalNumber(dish.getTotalNumber());
        dishListVo.setDescription(dish.getDescription());
        dishListVo.setImageHost(PropertiesUtil.getProperty(
                "ftp.server.http.prefix", "http://img.doft.com/"));
        dishListVo.setDishImgUrl(dish.getDishImgUrl());
        dishListVo.setDiscountble(dish.getIsBargainFlag());
        return dishListVo;
    }


    public ServerResponse<PageInfo> searchDish(String dishName, Long dishId, int pageNum, int pageSize,String orderBy,String order) {
        PageHelper.startPage(pageNum, pageSize);
        if (StringUtils.isNotBlank(orderBy) && StringUtils.isNotBlank(order)) {
            PageHelper.orderBy(orderBy + " " + order);
        }
        if (StringUtils.isNotBlank(dishName)) {
            dishName = new StringBuilder().append("%").append(dishName).append("%").toString();
        }
        List<Dish> dishList = new ArrayList<>();
        try {
            dishList = dishMapper.selectByNameAndDishId(dishName, dishId);

        } catch (Exception ex) {
            logger.info("", ex);
        }
        List<DishListVo> dishListVoList = Lists.newArrayList();
        for (Dish dishItem : dishList) {
            DishListVo dishListVo = assembleDishListVo(dishItem);
            dishListVoList.add(dishListVo);
        }


        //pageHelper收尾
        PageInfo pageResult = new PageInfo(dishList);
        pageResult.setList(dishListVoList);
        return ServerResponse.createBySuccess(pageResult);
    }

    public ServerResponse<DishDetailVo> getDishDetail(Long dishId) {
        if (dishId == null) {
            return ServerResponse.createByErrorCodeMessage(EnumResponseCode.ILLEGAL_ARGUMENT.getCode(), EnumResponseCode.ILLEGAL_ARGUMENT.getDecs());

        }
        Dish dish = dishMapper.selectByPrimaryKey(dishId);
        if (dish == null) {
            return ServerResponse.createByErrorMessage("菜品不存在");
        }
        if (dish.getStatus() != EnumDishStatus.ON_SALE.getCode()) {
            return ServerResponse.createByErrorMessage("菜品已下架或删除");
        }
        //vo -- value object
        DishDetailVo dishDetailVo = assembleDishDetailVo(dish);
        return ServerResponse.createBySuccess(dishDetailVo);
    }

    public ServerResponse<PageInfo> getDishByKeywordDishType(String keyword, Long dishTypeId, int pageNum, int pageSize, String orderBy, String order) {
        if (StringUtils.isBlank(keyword) && dishTypeId == null) {
            return ServerResponse.createByErrorCodeMessage(EnumResponseCode.ILLEGAL_ARGUMENT.getCode(), EnumResponseCode.ILLEGAL_ARGUMENT.getDecs());
        }

        if (dishTypeId != null) {
            DishType dishType = dishTypeMapper.selectByPrimaryKey(dishTypeId);
            if (dishType == null && StringUtils.isBlank(keyword)) {
                //return empty set ,not error
                PageHelper.startPage(pageNum, pageSize);
                List<DishListVo> dishListVoList = Lists.newArrayList();
                PageInfo pageInfo = new PageInfo(dishListVoList);
                return ServerResponse.createBySuccess(pageInfo);
            }
        }

        if (StringUtils.isNotBlank(keyword)) {
            keyword = new StringBuilder().append("%").append(keyword).append("%").toString();

        }

        PageHelper.startPage(pageNum, pageSize);
        if (StringUtils.isNotBlank(orderBy) && StringUtils.isNotBlank(order)) {
            PageHelper.orderBy(orderBy + " " + order);
        }

        List<Dish> dishList = dishMapper.selectByNameAndDishTypeId(StringUtils.isBlank(keyword) ? null : keyword, (dishTypeId == null) ? null : dishTypeId);
        List<DishListVo> dishListVoList = Lists.newArrayList();
        for (Dish dish : dishList) {
            DishListVo dishListVo = assembleDishListVo(dish);
            dishListVoList.add(dishListVo);
        }

        PageInfo pageInfo = new PageInfo(dishList);
        pageInfo.setList(dishListVoList);
        return ServerResponse.createBySuccess(pageInfo);
    }

    public Long addedDishCount(Date date) {
        DateTime begin = new DateTime(DateTimeUtil.getZeroTime(date));
        DateTime end = new DateTime(date);
        return dishMapper.countByCreatedTime(begin.toString(), end.toString());
    }


}
