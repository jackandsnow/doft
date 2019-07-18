package com.doft.dao;

import com.doft.pojo.Order;
import com.doft.pojo.OrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {
    int countByExample(OrderExample example);

    int deleteByExample(OrderExample example);

    int deleteByPrimaryKey(Long orderId);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByExample(OrderExample example);

    Order selectByPrimaryKey(Long orderId);

    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    Order selectByUserIdAndOrderNo(@Param("userId") Long userId, @Param("orderNo") String orderNo);

    Order selectByOrderNo(String orderNo);

    List<Order> selectByUserId(Long userId);

    List<Order> selectAllOrders();

    List<Order> selectByCreatedBy(String createdBy);

    Long countByCreatedTime(@Param("begin") String begin, @Param("end") String end);

    Long countByCreatedTimeAndStatus(@Param("begin") String begin, @Param("end") String end, @Param("status") Integer status);

}