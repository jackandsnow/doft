package com.doft.dao;

import com.doft.pojo.OrderDetail;
import com.doft.pojo.OrderDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderDetailMapper {
    int countByExample(OrderDetailExample example);

    int deleteByExample(OrderDetailExample example);

    int deleteByPrimaryKey(Long orderDetailId);

    int insert(OrderDetail record);

    int insertSelective(OrderDetail record);

    List<OrderDetail> selectByExample(OrderDetailExample example);

    OrderDetail selectByPrimaryKey(Long orderDetailId);

    int updateByExampleSelective(@Param("record") OrderDetail record, @Param("example") OrderDetailExample example);

    int updateByExample(@Param("record") OrderDetail record, @Param("example") OrderDetailExample example);

    int updateByPrimaryKeySelective(OrderDetail record);

    int updateByPrimaryKey(OrderDetail record);

    List<OrderDetail> getByOrderNoUserId(@Param("orderNo")String orderNo, @Param("userId")Long userId);

    List<OrderDetail> getByUserId(@Param("userId")Long userId);

    List<OrderDetail> getByOrderNo(@Param("orderNo")String orderNo);

    void batchInsert(@Param("orderDetailList")List<OrderDetail> orderDetailList);


}