package com.doft.service;

import com.doft.common.constant.EnumDeskStatus;
import com.doft.common.constant.EnumMsgType;
import com.doft.common.constant.EnumOrderStatus;
import com.doft.dao.MessageEventMapper;
import com.doft.dao.OrderMapper;
import com.doft.dao.OrderDetailMapper;
import com.doft.dao.DishMapper;
import com.doft.dao.DeskMapper;
import com.doft.pojo.MessageEvent;
import com.doft.pojo.Order;
import com.doft.pojo.User;
import com.doft.pojo.Dish;
import com.doft.pojo.Desk;
import com.doft.pojo.OrderDetail;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by Jack at 21:54 2018/3/14
 * version 1.0
 */
@Service
public class MessageService {

    @Autowired
    private MessageEventMapper eventMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderDetailMapper detailMapper;
    @Autowired
    private DishMapper dishMapper;
    @Autowired
    private DeskMapper deskMapper;

    @Transactional
    public void saveMsgEvent(Integer type, String orderNo, Long amount,
                             Boolean approve, Long userId) {
        MessageEvent event = new MessageEvent();
        event.setMessageType(type);
        EnumMsgType msgType = EnumMsgType.ofCode(type);
        event.setTitle(msgType.getCnDesc());
        StringBuilder builder = new StringBuilder();
        if (msgType == EnumMsgType.ORDER_DEALT_NOTIFICATION) {
            event.setOrderNo(orderNo);
            Order order = orderMapper.selectByOrderNo(orderNo);
            userId = order.getUserId();
            // 同意取消订单
            if (approve) {
                builder.append("您的订单" + orderNo + "已取消");
                order.setOrderStatus(EnumOrderStatus.CANCELLED.getCode());
                // 释放订单绑定的菜品
                List<OrderDetail> details = detailMapper.getByOrderNoUserId(orderNo, userId);
                for (OrderDetail detail : details) {
                    Dish dish = dishMapper.selectByPrimaryKey(detail.getDishId());
                    dish.setTotalNumber(dish.getTotalNumber() + detail.getDishCount());
                    dishMapper.updateByPrimaryKey(dish);
                }
                // 释放订单绑定的餐桌
                Desk desk = deskMapper.selectByPrimaryKey(order.getDeskId());
                desk.setDeskStatus(EnumDeskStatus.FREE.getCode());
                deskMapper.updateByPrimaryKey(desk);
            } else {
                builder.append("您的订单" + orderNo + "不能取消，该订单已在准备中");
                order.setOrderStatus(EnumOrderStatus.UNPAID.getCode());
            }
            order.setLastUpdatedDate(new Date());
            order.setLastUpdatedBy(String.valueOf(userId));
            orderMapper.updateByPrimaryKeySelective(order);
        } else if (msgType == EnumMsgType.RECHARGE_MESSAGE) {
            builder.append("充值" + amount + "元已成功");
        } else if (msgType == EnumMsgType.DISH_DISCOUNT_MESSAGE) {
            builder.append("现有菜品正在优惠促销中，点击进去抢购吧");
        }
        event.setContent(builder.toString());
        event.setSendToUserId(String.valueOf(userId));
        event.setSendTime(new Date());
        event.setIsDeletedFlag(Boolean.FALSE);
        eventMapper.insert(event);
    }

    @Transactional
    public void deleteMsgEvent(Long msgId, User user) {
        MessageEvent event = eventMapper.selectByPrimaryKey(msgId);
        event.setIsDeletedFlag(Boolean.TRUE);
        event.setDeletedBy(String.valueOf(user.getUserId()));
        event.setDeletedDate(new Date());
        eventMapper.updateByPrimaryKey(event);
    }

    public PageInfo<MessageEvent> getMessagePagesByUserId(Long userId, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<MessageEvent> messageEvents = eventMapper.selectByUserId(String.valueOf(userId));
        if (CollectionUtils.isNotEmpty(messageEvents)) {
            return new PageInfo<>(messageEvents, pageSize);
        }
        return new PageInfo<>();
    }

}
