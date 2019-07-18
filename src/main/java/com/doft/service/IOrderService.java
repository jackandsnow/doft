package com.doft.service;

import com.doft.common.ServerResponse;
import com.doft.vo.OrderDetailVo;
import com.doft.vo.OrderVo;
import com.github.pagehelper.PageInfo;

import java.util.Date;
import java.util.Map;

public interface IOrderService {
    ServerResponse alipay(String orderNo, Long userId, String path);
    ServerResponse normalPay(String orderNo,Long userId);
    ServerResponse aliCallback(Map<String,String > params);
    ServerResponse queryOrderPayStatus(Long userId, String orderNo);


    ServerResponse<Object> createOrder(Long userId,Long deskId,Integer peopleCount);
    ServerResponse<String> cancel(Long userId,String orderNo);
    public ServerResponse<String> delete(Long userId,String orderNo);
    ServerResponse<OrderVo> getOrderDetail(Long userId, String orderNo);
    ServerResponse<PageInfo> getOrderList(Long userId, int pageNum, int pageSize,String orderBy,String order);
    ServerResponse<OrderDetailVo> getLastOrderDetail(Long userId);

    //backend

    ServerResponse<PageInfo> manageList(String orderNo,int pageNum,int pageSize);
    ServerResponse<OrderVo> manageDetail(String orderNo);
    ServerResponse<PageInfo> manageSearch(String orderNo,int pageNum,int pageSize);
    ServerResponse<String> updateOrderStatus(String orderNo, Integer status, Long userId);
    Long addedOrderCount(Date date);
    Long pendingDealOrder(Date date);
}
