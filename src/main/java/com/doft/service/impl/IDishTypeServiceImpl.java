package com.doft.service.impl;

import com.doft.common.ServerResponse;
import com.doft.dao.DishMapper;
import com.doft.dao.DishTypeMapper;
import com.doft.pojo.Dish;
import com.doft.pojo.DishType;
import com.doft.service.IDishTypeService;
import com.mchange.lang.LongUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("iDishTypeService")
public class IDishTypeServiceImpl implements IDishTypeService {

    private Logger logger = LoggerFactory.getLogger(IDishTypeServiceImpl.class);

    @Autowired
    private DishMapper dishMapper;

    @Autowired
    private DishTypeMapper dishTypeMapper;

    public ServerResponse addDishType(String typeName, String createBy){
        if (StringUtils.isBlank(typeName)){
            return ServerResponse.createByErrorMessage("添加菜系参数错误");
        }
        DishType dishType = new DishType();
        dishType.setTypeName(typeName);
        dishType.setStatus(true);//可用状态
        dishType.setCreatedBy(createBy);
        dishType.setLastUpdatedBy(createBy);
        int rowCount = dishTypeMapper.insert(dishType);
        if (rowCount > 0){
            return ServerResponse.createBySuccessMessage("添加菜系成功");
        }

        return ServerResponse.createByErrorMessage("添加菜系失败");
    }


    public ServerResponse deleteDishType(Long dishTypeId){
        if (dishTypeId == null){
            return ServerResponse.createByErrorMessage("删除菜系参数错误");
        }

        DishType dishType = dishTypeMapper.selectByPrimaryKey(dishTypeId);
        dishType.setStatus(false);
        int rowCount = dishTypeMapper.updateByPrimaryKeySelective(dishType);
//        int rowCount = dishTypeMapper.deleteByPrimaryKey(dishTypeId);
        if (rowCount > 0){
            List<Dish> dishList = dishMapper.selectByDishType(dishTypeId);
            for (Dish dish:dishList){
                dish.setStatus(3);
                dishMapper.updateByPrimaryKeySelective(dish);
            }
            return ServerResponse.createBySuccessMessage("删除菜系成功");
        }

        return ServerResponse.createByErrorMessage("删除菜系失败");
    }

    public ServerResponse updateDishTypeName(Long dishTypeId, String typeName,String updatedBy){
        if (dishTypeId == null || StringUtils.isBlank(typeName)){
            ServerResponse.createByErrorMessage("更新菜系参数错误");

        }

        DishType dishType = new DishType();
        dishType.setDishTypeId(dishTypeId);
        dishType.setTypeName(typeName);
        dishType.setLastUpdatedBy(updatedBy);

        int rowCount = dishTypeMapper.updateByPrimaryKeySelective(dishType);
        if (rowCount > 0){
            return ServerResponse.createBySuccessMessage("更新菜系成功");
        }
        return ServerResponse.createByErrorMessage("更新菜系失败");
    }

    public ServerResponse selectAllDishType(){
        List<DishType> DishTypeList = dishTypeMapper.selectAllDishType();
        if (CollectionUtils.isEmpty(DishTypeList)){
            logger.info("未找到菜系");

        }
        return ServerResponse.createBySuccess(DishTypeList);
    }
}
