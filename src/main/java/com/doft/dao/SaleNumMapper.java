package com.doft.dao;

import com.doft.pojo.SaleNum;
import com.doft.pojo.SaleNumExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SaleNumMapper {
    int countByExample(SaleNumExample example);

    int deleteByExample(SaleNumExample example);

    int deleteByPrimaryKey(Long saleId);

    int insert(SaleNum record);

    int insertSelective(SaleNum record);

    List<SaleNum> selectByExample(SaleNumExample example);

    SaleNum selectByPrimaryKey(Long saleId);

    int updateByExampleSelective(@Param("record") SaleNum record, @Param("example") SaleNumExample example);

    int updateByExample(@Param("record") SaleNum record, @Param("example") SaleNumExample example);

    int updateByPrimaryKeySelective(SaleNum record);

    int updateByPrimaryKey(SaleNum record);

    List<Long> selectDistinctDishId();

    List<Long> selectByDishId(Long dishId);

    List<SaleNum> selectByBeginAndEndTime(@Param("begin") String begin, @Param("end") String end);

}