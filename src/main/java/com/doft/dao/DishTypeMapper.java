package com.doft.dao;

import com.doft.pojo.DishType;
import com.doft.pojo.DishTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DishTypeMapper {
    int countByExample(DishTypeExample example);

    int deleteByExample(DishTypeExample example);

    int deleteByPrimaryKey(Long dishTypeId);

    int insert(DishType record);

    int insertSelective(DishType record);

    List<DishType> selectByExample(DishTypeExample example);

    DishType selectByPrimaryKey(Long dishTypeId);

    int updateByExampleSelective(@Param("record") DishType record, @Param("example") DishTypeExample example);

    int updateByExample(@Param("record") DishType record, @Param("example") DishTypeExample example);

    int updateByPrimaryKeySelective(DishType record);

    int updateByPrimaryKey(DishType record);

    List<DishType> selectAllDishType();
}