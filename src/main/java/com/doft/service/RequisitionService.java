package com.doft.service;

import com.doft.common.constant.EnumOrderStatus;
import com.doft.common.constant.EnumRequisitionStatus;
import com.doft.common.constant.EnumRequisitionType;
import com.doft.common.exception.BusinessException;
import com.doft.dao.OrderMapper;
import com.doft.dao.RequisitionMapper;
import com.doft.dao.UserMapper;
import com.doft.pojo.Order;
import com.doft.pojo.Requisition;
import com.doft.pojo.User;
import com.doft.util.DateTimeUtil;
import com.doft.util.SerialGenerator;
import com.doft.vo.RequisitionManageVo;
import org.apache.commons.collections.CollectionUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.collect.Lists.newArrayList;

/**
 * Created by Jack at 16:14 2018/3/15
 * version 1.0
 */
@Service
public class RequisitionService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RequisitionMapper requisitionMapper;

    public List<RequisitionManageVo> getAllRequisitions() {
        List<Requisition> requisitions = requisitionMapper.selectAllRequisitions();
        if (CollectionUtils.isNotEmpty(requisitions)) {
            return requisitions.stream().map(r -> {
                RequisitionManageVo manageVo = new RequisitionManageVo();
                manageVo.setReqNo(r.getReqNo());
                SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
                manageVo.setCreationDate(dateFormat.format(r.getCreationDate()));
                User user = userMapper.selectByPrimaryKey(Long.valueOf(r.getReqBy()));
                manageVo.setReqBy(user == null ? "" : user.getUserName());
                manageVo.setReqStatus(EnumRequisitionStatus.ofCode(r.getReqStatus()).getCnDesc());
                manageVo.setApprover(r.getApprover() == null ? "" : r.getApprover());
                manageVo.setReqType(EnumRequisitionType.ofCode(r.getReqType()).getCnDesc());
                Order order = orderMapper.selectByPrimaryKey(r.getOrderId());
                manageVo.setOrderNo(order == null ? "" : order.getOrderNo());
                return manageVo;
            }).collect(Collectors.toList());
        }
        return newArrayList();
    }

    @Transactional
    public String saveRequisition(Integer type, String orderNo, User user) {
        Order order = orderMapper.selectByOrderNo(orderNo);
        Requisition requisition = new Requisition();
        String requisitionNo = SerialGenerator.getRequisitionNoSerial();
        requisition.setReqNo(requisitionNo);
        EnumRequisitionType requisitionType = EnumRequisitionType.ofCode(type);
        requisition.setReqType(requisitionType.getCode());
        requisition.setReqContent(requisitionType.getCnDesc());
        requisition.setOrderId(order.getOrderId());
        requisition.setReqStatus(EnumRequisitionStatus.UNDEALT.getCode());
        requisition.setReqBy(String.valueOf(user.getUserId()));
        requisition.setCreatedBy(String.valueOf(user.getUserId()));
        requisition.setCreationDate(new Date());
        saveOrUpdateRequisition(requisition);
        order.setOrderStatus(EnumOrderStatus.APPLYING.getCode());
        orderMapper.updateByPrimaryKeySelective(order);
        return requisition.getReqNo();
    }

    @Transactional
    public void updateRequisitionStatus(String reqNo, Integer status, User user) {
        List<Requisition> requisitionList = requisitionMapper.selectByRequisitionNo(reqNo);
        if (CollectionUtils.isNotEmpty(requisitionList)) {
            Requisition requisition = requisitionList.get(0);
            requisition.setReqStatus(status);
            requisition.setApprover(user.getUserName());
            saveOrUpdateRequisition(requisition);
        } else {
            throw new BusinessException("该申请单不存在！");
        }
    }

    @Transactional
    public void saveOrUpdateRequisition(Requisition requisition) {
        if (requisition.getReqId() == null) {
            requisitionMapper.insert(requisition);
        } else {
            requisitionMapper.updateByPrimaryKey(requisition);
        }
    }

    public Long addedRequisitionCount(Date date) {
        DateTime begin = new DateTime(DateTimeUtil.getZeroTime(date));
        DateTime end = new DateTime(date);
        return requisitionMapper.countByCreatedTime(begin.toString(), end.toString());
    }

    public Long pendingRequisition(Date date) {
        DateTime begin = new DateTime(DateTimeUtil.getZeroTime(date));
        DateTime end = new DateTime(date);
        return requisitionMapper.countByCreatedTimeAndStatus(begin.toString(),
                end.toString(), EnumRequisitionStatus.UNDEALT.getCode());
    }

}
