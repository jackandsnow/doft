package com.doft.service.impl;

import com.alipay.api.AlipayResponse;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.demo.trade.config.Configs;
import com.alipay.demo.trade.model.ExtendParams;
import com.alipay.demo.trade.model.GoodsDetail;
import com.alipay.demo.trade.model.builder.AlipayTradePrecreateRequestBuilder;
import com.alipay.demo.trade.model.result.AlipayF2FPrecreateResult;
import com.alipay.demo.trade.service.AlipayTradeService;
import com.alipay.demo.trade.service.impl.AlipayTradeServiceImpl;
import com.alipay.demo.trade.utils.ZxingUtils;
import com.doft.common.Const;
import com.doft.common.ServerResponse;
import com.doft.common.constant.*;
import com.doft.dao.*;
import com.doft.pojo.*;
import com.doft.service.IOrderService;
import com.doft.util.*;
import com.doft.vo.OrderDetailVo;
import com.doft.vo.OrderVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("iOrderService")
public class IOrderServiceImpl implements IOrderService{

    private static final Logger logger = LoggerFactory.getLogger(IOrderServiceImpl.class);

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Autowired
    private PayInfoMapper payInfoMapper;

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private DishMapper dishMapper;

    @Autowired
    private DeskMapper deskMapper;

    @Autowired
    private SaleNumMapper saleNumMapper;

    @Autowired
    private UserMapper userMapper;
    /**
     *
     * saveOrder -> createOrder
     * reuse SerialGenerator
     */
    public ServerResponse<Object> createOrder(Long userId,Long deskId,Integer peopleCount){
        //从购物车获取数据
        List<Cart> cartList = cartMapper.selectCheckCartByUserId(userId);

        //计算订单总价
        ServerResponse serverResponse = getCartOrderItem(userId,cartList);
        if (!serverResponse.isSuccess()){
            return serverResponse;
        }

        List<OrderDetail> orderDetailList = (List<OrderDetail>)serverResponse.getData();
        BigDecimal payment = getOrderTotalPrice(orderDetailList);

        BigDecimal discout_payment = getOrderDiscountPrice(orderDetailList);

        //锁定餐桌

        Desk desk = new Desk();
        desk.setDeskId(deskId);
        desk.setDeskStatus(EnumDeskStatus.BUSY.getCode());
        deskMapper.updateByPrimaryKeySelective(desk);

        //生成订单
        Order order = assembleOrder(userId,payment,discout_payment,deskId,peopleCount);

        if (order == null){
            return ServerResponse.createByErrorMessage("生成订单错误");
        }

        if (CollectionUtils.isEmpty(orderDetailList)){
            return ServerResponse.createByErrorMessage("购物车为空");
        }

        for (OrderDetail orderDetail:orderDetailList){
            orderDetail.setOrderNo(order.getOrderNo());
        }

        //mybatis批量插入
        orderDetailMapper.batchInsert(orderDetailList);

        //生成成功，减少库存
        this.reduceDishStock(orderDetailList);
        //清空购物车
        this.cleanCart(cartList);
        //返回给前端数据
        OrderVo orderVo = assembleOrderVo(order,orderDetailList);

        return ServerResponse.createBySuccess(orderVo);

    }


    public ServerResponse<String> delete(Long userId,String orderNo){
        Order order= orderMapper.selectByUserIdAndOrderNo(userId,orderNo);
        if (order == null){
            return ServerResponse.createByErrorMessage("该用户无此订单");
        }

        if (order.getOrderStatus() < 3){
            return ServerResponse.createByErrorMessage("中间状态，无法取消订单");
        }

        Order updateOrder = new Order();
        updateOrder.setOrderId(order.getOrderId());
        updateOrder.setIsDeletedFlag(true);

        int row = orderMapper.updateByPrimaryKeySelective(updateOrder);
        if (row > 0 ){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    public ServerResponse<String> cancel(Long userId,String orderNo){
        Order order= orderMapper.selectByUserIdAndOrderNo(userId,orderNo);
        if (order == null){
            return ServerResponse.createByErrorMessage("该用户无此订单");
        }

        if (order.getOrderStatus() != EnumOrderStatus.UNPAID.getCode()){
            return ServerResponse.createByErrorMessage("已付款，无法取消订单");
        }

        Order updateOrder = new Order();
        updateOrder.setOrderId(order.getOrderId());
        updateOrder.setOrderStatus(EnumOrderStatus.CANCELLED.getCode());

        int row = orderMapper.updateByPrimaryKeySelective(updateOrder);
        if (row > 0 ){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }


    public ServerResponse<PageInfo> getOrderList(Long userId,int pageNum,int pageSize,String orderBy,String order){
        PageHelper.startPage(pageNum,pageSize);

        if (org.apache.commons.lang3.StringUtils.isNotBlank(orderBy) && org.apache.commons.lang3.StringUtils.isNotBlank(order)) {
            PageHelper.orderBy(orderBy + " " + order);
        }
        List<Order> orderList = orderMapper.selectByUserId(userId);
        List<OrderVo> orderVoList = assembleOrderVoList(orderList,userId);
        PageInfo pageResult = new PageInfo(orderList);
        pageResult.setList(orderVoList);
        return ServerResponse.createBySuccess(pageResult);
    }

    private  List<OrderVo> assembleOrderVoList(List<Order> orderList,Long userId){
        List<OrderVo> orderVoList = Lists.newArrayList();
        for (Order order:orderList){
            List<OrderDetail> orderDetailList = Lists.newArrayList();
            if (userId == null){
                //管理员查询时不需要用户id
                orderDetailList =  orderDetailMapper.getByOrderNo(order.getOrderNo());
            }else{
                if (order.getOrderStatus() > 2){
                    orderDetailList =  orderDetailMapper.getByOrderNoUserId(order.getOrderNo(),userId);
                }else{
                    continue;
                }

            }
            OrderVo orderVo = assembleOrderVo(order,orderDetailList);
            orderVoList.add(orderVo);
        }
        return orderVoList;
    }



    public ServerResponse<OrderVo> getOrderDetail(Long userId,String orderNo){
        Order order = orderMapper.selectByUserIdAndOrderNo(userId,orderNo);
        if(order != null){
            List<OrderDetail> orderDetailList = orderDetailMapper.getByOrderNoUserId(orderNo,userId);
            OrderVo orderVo = assembleOrderVo(order,orderDetailList);
            return ServerResponse.createBySuccess(orderVo);
        }else{
            List<Order> orderList = orderMapper.selectByUserId(userId);
            if (CollectionUtils.isEmpty(orderList)){
                return ServerResponse.createBySuccess(new OrderVo());
            }
            order = orderList.get(0);
            List<OrderDetail> orderDetailList = orderDetailMapper.getByOrderNoUserId(order.getOrderNo(),userId);
            OrderVo orderVo = assembleOrderVo(order,orderDetailList);
            return ServerResponse.createBySuccess(orderVo);
        }
//        return ServerResponse.createByErrorMessage("没有找到该订单");
    }


    public ServerResponse<OrderDetailVo> getLastOrderDetail(Long userId){
        List<OrderDetail> orderDetailList = orderDetailMapper.getByUserId(userId);
        OrderDetailVo orderDetailVo = assembleOrderDetailVo(orderDetailList.get(0));
        return ServerResponse.createBySuccess(orderDetailVo);
    }


    private OrderVo assembleOrderVo(Order order,List<OrderDetail> orderDetailList){
        OrderVo orderVo = new OrderVo();
        orderVo.setOrderNo(order.getOrderNo());
        orderVo.setTotalPrice(order.getTotalPrice());
        orderVo.setDiscountPrice(order.getDiscountAmount());
        orderVo.setPaymentType(order.getPaymentType());
        orderVo.setPaymentTypeDesc(EnumPaymentType.ofCode(order.getPaymentType()).getCnDesc());

        orderVo.setOrderStatus(order.getOrderStatus());
        orderVo.setOrderStatusDesc(EnumOrderStatus.ofCode(order.getOrderStatus()).getCnDesc());
        orderVo.setDeskId(order.getDeskId());
        orderVo.setPeopleCount(order.getPeopleCount());

        orderVo.setPaymentTime(DateTimeUtil.dateToStr(order.getPaymentTime()));
        orderVo.setCreationDate(DateTimeUtil.dateToStr(order.getCreationDate()));
        orderVo.setEndTime(DateTimeUtil.dateToStr(order.getEndTime()));

        List<OrderDetailVo> orderDetailVoList = Lists.newArrayList();
        for (OrderDetail orderDetail:orderDetailList){
            OrderDetailVo orderDetailVo = assembleOrderDetailVo(orderDetail);
            orderDetailVoList.add(orderDetailVo);
        }

        orderVo.setOrderDetailList(orderDetailVoList);

        return orderVo;
    }

    private OrderDetailVo assembleOrderDetailVo(OrderDetail orderDetail){
        OrderDetailVo orderDetailVo = new OrderDetailVo();
        orderDetailVo.setOrderNo(orderDetail.getOrderNo());
        orderDetailVo.setDishId(orderDetail.getDishId());
        orderDetailVo.setDishName(orderDetail.getDishName());
        orderDetailVo.setCurrentUnitPrice(orderDetail.getCurrentUnitPrice());
        orderDetailVo.setDishCount(orderDetail.getDishCount());
        orderDetailVo.setTotalPrice(orderDetail.getTotalPrice());
        orderDetailVo.setCreateTime(DateTimeUtil.dateToStr(orderDetail.getCreateTime()));
        Dish dish = dishMapper.selectByDishId(orderDetail.getDishId());
        orderDetailVo.setImgUrl(dish.getDishImgUrl());
        orderDetailVo.setDiscountble(dish.getIsBargainFlag());
        orderDetailVo.setAddedDishFlag(orderDetail.getIsAddedDishFlag());
        return orderDetailVo;
    }

    private void cleanCart(List<Cart> cartList){
        for (Cart cart:cartList){
            cartMapper.deleteByPrimaryKey(cart.getId());
        }
    }

    private void reduceDishStock(List<OrderDetail> orderDetailList){
        for (OrderDetail orderDetail:orderDetailList){
            Dish dish = dishMapper.selectByPrimaryKey(orderDetail.getDishId());
            dish.setTotalNumber(dish.getTotalNumber()-orderDetail.getDishCount());
            dishMapper.updateByPrimaryKeySelective(dish);
        }
    }

    private Order assembleOrder(Long userId,BigDecimal payment,BigDecimal discout_payment,Long deskId,Integer peopleCount){

        Order order = new Order();
        String orderNo = SerialGenerator.getOrderNoSerial();

        order.setOrderNo(orderNo);
        order.setOrderStatus(EnumOrderStatus.UNPAID.getCode());
        order.setPaymentType(EnumPaymentType.ONLINE.getCode());
        order.setTotalPrice(payment);
        order.setDiscountAmount(discout_payment);

        order.setUserId(userId);
        //其他参数

        //餐桌 就餐人数
        order.setPeopleCount(peopleCount);
        order.setDeskId(deskId);
        order.setCreatedBy(String.valueOf(userId));
        order.setCreationDate(new Date());
        order.setLastUpdatedBy(String.valueOf(userId));
        order.setLastUpdatedDate(new Date());
        order.setIsDeletedFlag(Boolean.FALSE);

        int rowCount = orderMapper.insert(order);
        if (rowCount > 0 ){
            return order;
        }
        return null;
    }


    private BigDecimal getOrderTotalPrice(List<OrderDetail> orderDetailList){
        BigDecimal payment = new BigDecimal("0");
        for (OrderDetail orderDetail: orderDetailList){
            payment = BigDecimalUtil.add(
                    payment.doubleValue(),orderDetail.getTotalPrice().doubleValue());
        }
        return payment;
    }

    private BigDecimal getOrderDiscountPrice(List<OrderDetail> orderDetailList){
        BigDecimal discount = new BigDecimal("0");
        Dish dish = new Dish();
        for (OrderDetail orderDetail: orderDetailList){
            dish = dishMapper.selectByDishId(orderDetail.getDishId());
            if (BooleanUtils.isTrue(dish.getIsBargainFlag())){
                discount = BigDecimalUtil.add(
                        discount.doubleValue(),orderDetail.getTotalPrice().doubleValue());
            }
        }

        BigDecimal discount_payment = discount.multiply(new BigDecimal("0.2"));
        return discount_payment;

    }

    private ServerResponse getCartOrderItem(Long userId,List<Cart> cartList){

        List<OrderDetail> orderDetailList = Lists.newArrayList();

        if (CollectionUtils.isEmpty(cartList)){
            ServerResponse.createByErrorMessage("购物车为空");
        }
        //校验购物车数据

        for (Cart cartItem: cartList){
            OrderDetail orderDetail = new OrderDetail();
            Dish dish = dishMapper.selectByPrimaryKey(cartItem.getDishId());
            if (EnumDishStatus.ON_SALE.getCode() != dish.getStatus()){
               return ServerResponse.createByErrorMessage("菜品"+dish.getDishName()+"不是在线售卖状态");
            }

            if (cartItem.getQuantites() > dish.getTotalNumber()){
                return ServerResponse.createByErrorMessage("菜品"+dish.getDishName()+"剩余不足");
            }

            orderDetail.setUserId(userId);
            orderDetail.setDishId(dish.getDishId());
            orderDetail.setDishName(dish.getDishName());
            orderDetail.setCurrentUnitPrice(dish.getPrice());
            orderDetail.setDishCount(cartItem.getQuantites());
            orderDetail.setTotalPrice(
                    BigDecimalUtil.mul(dish.getPrice().doubleValue(),cartItem.getQuantites()));
            orderDetail.setIsAddedDishFlag(Boolean.FALSE);

            orderDetailList.add(orderDetail);
        }

        return ServerResponse.createBySuccess(orderDetailList);
    }


    public ServerResponse normalPay(String orderNo,Long userId){
        Order order = orderMapper.selectByOrderNo(orderNo);
        if (order != null){
            order.setPaymentType(EnumPaymentType.ONLINE.getCode());
            int rowCount = orderMapper.updateByPrimaryKeySelective(order);
            if (rowCount > 0){
                User user = userMapper.selectByPrimaryKey(userId);
                BigDecimal total = user.getRemainingMoney();
                BigDecimal amount = BigDecimalUtil.sub(order.getTotalPrice().doubleValue(),order.getDiscountAmount().doubleValue());
                if (total.doubleValue() < amount.doubleValue()){
                    return ServerResponse.createByErrorMessage("余额不足，请使用其他方式支付，或充值");
                }
                user.setRemainingMoney(BigDecimalUtil.sub(total.doubleValue(),amount.doubleValue()));
                userMapper.updateByPrimaryKey(user);
                PayInfo payInfo = new PayInfo();
                payInfo.setUserId(userId);
                payInfo.setOrderNo(orderNo);
                payInfo.setPayPlatform(EnumPayPlatform.NORMAL.getCode());
                payInfo.setPlatformNumber("2018" + orderNo);
                payInfo.setPlatformStatus("TRADE_SUCCESS");
                payInfoMapper.insert(payInfo);

            }
            return ServerResponse.createByErrorMessage("支付失败，请重试");
        }
        return ServerResponse.createByErrorMessage("订单不存在");
    }

    public ServerResponse alipay(String orderNo,Long userId,String path){
        Map<String,String> resultMap = Maps.newHashMap();
        Order order = orderMapper.selectByUserIdAndOrderNo(userId,orderNo);
        if (order == null){
            ServerResponse.createByErrorMessage("用户没有该订单");
        }else if (order.getOrderStatus() != EnumOrderStatus.UNPAID.getCode()){
            ServerResponse.createByErrorMessage("订单不处于未支付状态");
        }
        resultMap.put("orderNo",String.valueOf(order.getOrderNo()));
        // (必填) 商户网站订单系统中唯一订单号，64个字符以内，只能包含字母、数字、下划线，
        // 需保证商户系统端不能重复，建议通过数据库sequence生成，
        String outTradeNo = order.getOrderNo().toString();

        // (必填) 订单标题，粗略描述用户的支付目的。如“xxx品牌xxx门店当面付扫码消费”
        String subject = new StringBuilder().append("扫码支付，订单号：").append(outTradeNo).toString();

        // (必填) 订单总金额，单位为元，不能超过1亿元
        // 如果同时传入了【打折金额】,【不可打折金额】,【订单总金额】三者,则必须满足如下条件:【订单总金额】=【打折金额】+【不可打折金额】
        String totalAmount = (BigDecimalUtil.sub(order.getTotalPrice().doubleValue(),order.getDiscountAmount().doubleValue())).toString();

        // (可选) 订单不可打折金额，可以配合商家平台配置折扣活动，如果酒水不参与打折，则将对应金额填写至此字段
        // 如果该值未传入,但传入了【订单总金额】,【打折金额】,则该值默认为【订单总金额】-【打折金额】
        String discountableAmount = order.getDiscountAmount().toString();

        // 卖家支付宝账号ID，用于支持一个签约账号下支持打款到不同的收款账号，(打款到sellerId对应的支付宝账号)
        // 如果该字段为空，则默认为与支付宝签约的商户的PID，也就是appid对应的PID
        String sellerId = "";

        // 订单描述，可以对交易或商品进行一个详细地描述，比如填写"购买商品2件共15.00元"
        String body = new StringBuilder().append("订单").append(outTradeNo).append("共消费").append(totalAmount).append("元").append("优惠").append(discountableAmount).append("元").toString();

        // 商户操作员编号，添加此参数可以为商户操作员做销售统计
        String operatorId = "test_operator_id";

        // (必填) 商户门店编号，通过门店号和商家后台可以配置精准到门店的折扣信息，详询支付宝技术支持
        String storeId = "test_store_id";

        // 业务扩展参数，目前可添加由支付宝分配的系统商编号(通过setSysServiceProviderId方法)，详情请咨询支付宝技术支持
        ExtendParams extendParams = new ExtendParams();
        extendParams.setSysServiceProviderId("2088100200300400500");


        // 支付超时，定义为120分钟
        String timeoutExpress = "120m";

        // 商品明细列表，需填写购买商品详细信息，
        List<GoodsDetail> goodsDetailList = new ArrayList<GoodsDetail>();

        List<OrderDetail> orderDetailList = orderDetailMapper.getByOrderNoUserId(orderNo,userId);

        for (OrderDetail orderDetail : orderDetailList ){
            GoodsDetail goods = GoodsDetail.newInstance(orderDetail.getDishId().toString(),orderDetail.getDishName(), BigDecimalUtil.mul(orderDetail.getCurrentUnitPrice().doubleValue(),new Double(100).doubleValue()).longValue(),orderDetail.getDishCount());

            goodsDetailList.add(goods);
        }

        // 创建扫码支付请求builder，设置请求参数
        AlipayTradePrecreateRequestBuilder builder = new AlipayTradePrecreateRequestBuilder()
                .setSubject(subject).setTotalAmount(totalAmount).setOutTradeNo(outTradeNo)
                .setDiscountableAmount(discountableAmount).setSellerId(sellerId).setBody(body)
                .setOperatorId(operatorId).setStoreId(storeId).setExtendParams(extendParams)
                .setTimeoutExpress(timeoutExpress)
                                .setNotifyUrl(PropertiesUtil.getProperty("alipay.callback.url"))//支付宝服务器主动通知商户服务器里指定的页面http路径,根据需要设置
                .setGoodsDetailList(goodsDetailList);

        Configs.init("zfbinfo.properties");

        /** 使用Configs提供的默认参数
         *  AlipayTradeService可以使用单例或者为静态成员对象，不需要反复new
         */
        AlipayTradeService tradeService = new AlipayTradeServiceImpl.ClientBuilder().build();

        AlipayF2FPrecreateResult result = tradeService.tradePrecreate(builder);
        switch (result.getTradeStatus()) {
            case SUCCESS:
                logger.info("支付宝预下单成功: )");

                AlipayTradePrecreateResponse response = result.getResponse();
                dumpResponse(response);

                File folder = new File(path);
                if (!folder.exists()){
                    folder.setWritable(true);
                    folder.mkdirs();
                }

                // 需要修改为运行机器上的路径
                String qrPath = String.format(path+"/qr-%s.png",
                        response.getOutTradeNo());
                String qrFileName = String.format("qr-%s.png",
                        response.getOutTradeNo());

                ZxingUtils.getQRCodeImge(response.getQrCode(), 256, qrPath);

                File targetFile = new File(path,qrFileName);
                try {
                    FTPUtil.uploadFile(Lists.newArrayList(targetFile));
                } catch (IOException e) {
                    logger.error("上传二维码异常",e);
                }

                logger.info("filePath:" + qrPath);
                String qrUrl = PropertiesUtil.getProperty("ftp.server.http.prefix")+targetFile.getName();

                resultMap.put("qrUrl",qrUrl);
                return ServerResponse.createBySuccess(resultMap);

            case FAILED:
                logger.error("支付宝预下单失败!!!");
                return ServerResponse.createByErrorMessage("支付宝预下单失败!!!");

            case UNKNOWN:
                logger.error("系统异常，预下单状态未知!!!");
                return ServerResponse.createByErrorMessage("系统异常，预下单状态未知!!!");

            default:
                logger.error("不支持的交易状态，交易返回异常!!!");
                return ServerResponse.createByErrorMessage("不支持的交易状态，交易返回异常!!!");
        }
    }

    // 简单打印应答
    private void dumpResponse(AlipayResponse response) {
        if (response != null) {
            logger.info(String.format("code:%s, msg:%s", response.getCode(), response.getMsg()));
            if (StringUtils.isNotEmpty(response.getSubCode())) {
                logger.info(String.format("subCode:%s, subMsg:%s", response.getSubCode(),
                        response.getSubMsg()));
            }
            logger.info("body:" + response.getBody());
        }
    }

    public ServerResponse aliCallback(Map<String,String > params){
        String orderNo = params.get("out_trade_no");
        String tradeNo = params.get("trade_no");
        String tradeStatus = params.get("trade_status");

        Order order = orderMapper.selectByOrderNo(orderNo);
        if (order == null){
            return ServerResponse.createByErrorMessage("非法订单，回调忽略");
        }
        if (order.getOrderStatus() >= EnumOrderStatus.PAID.getCode()){
            return ServerResponse.createBySuccess("支付宝重复调用");
        }

        if (Const.AlipayCallback.TRADE_STATUS_SUCCESS.equals(tradeStatus)){
            order.setOrderStatus(EnumOrderStatus.PAID.getCode());
            order.setPaymentTime(DateTimeUtil.strToDate(params.get("gmt_payment")));
            orderMapper.updateByPrimaryKeySelective(order);

        }

        PayInfo payInfo = new PayInfo();
        payInfo.setUserId(order.getUserId());
        payInfo.setOrderNo(order.getOrderNo());
        payInfo.setPayPlatform(EnumPayPlatform.ALIPAY.getCode());
        payInfo.setPlatformNumber(tradeNo);
        payInfo.setPlatformStatus(tradeStatus);

        payInfoMapper.insert(payInfo);
        return ServerResponse.createBySuccess();
    }

    public ServerResponse queryOrderPayStatus(Long userId, String orderNo){
        Order order = orderMapper.selectByUserIdAndOrderNo(userId,orderNo);
        if (order == null){
            return ServerResponse.createByErrorMessage("用户没有该订单");

        }

        if (order.getOrderStatus() >= EnumOrderStatus.PAID.getCode()){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    //backend order

    public ServerResponse<PageInfo> manageList(String orderNo,int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);

        if (StringUtils.isNotEmpty(orderNo)){
            Order order = orderMapper.selectByOrderNo(orderNo);
            if (order != null){
                List<OrderDetail> orderDetailList = orderDetailMapper.getByOrderNo(orderNo);
                OrderVo orderVo = assembleOrderVo(order,orderDetailList);
                PageInfo pageInfo = new PageInfo(Lists.newArrayList(order));
                pageInfo.setList(Lists.newArrayList(orderVo));
                return ServerResponse.createBySuccess(pageInfo);
            }
            return ServerResponse.createByErrorMessage("订单不存在");

        }

        List<Order> orderList = orderMapper.selectAllOrders();
        List<OrderVo> orderVoList = this.assembleOrderVoList(orderList,null);
        PageInfo pageResult = new PageInfo(orderList);
        pageResult.setList(orderVoList);
        return ServerResponse.createBySuccess(pageResult);
    }

    public ServerResponse<OrderVo> manageDetail(String orderNo){
        Order order = orderMapper.selectByOrderNo(orderNo);

        if (order != null){
            List<OrderDetail> orderDetailList = orderDetailMapper.getByOrderNo(orderNo);
            OrderVo orderVo = assembleOrderVo(order,orderDetailList);
            return ServerResponse.createBySuccess(orderVo);
        }
        return ServerResponse.createByErrorMessage("订单不存在");
    }


    public ServerResponse<PageInfo> manageSearch(String orderNo,int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        Order order = orderMapper.selectByOrderNo(orderNo);

        if (order != null){
            List<OrderDetail> orderDetailList = orderDetailMapper.getByOrderNo(orderNo);
            OrderVo orderVo = assembleOrderVo(order,orderDetailList);

            PageInfo pageInfo = new PageInfo(Lists.newArrayList(order));
            pageInfo.setList(Lists.newArrayList(orderVo));

            return ServerResponse.createBySuccess(pageInfo);
        }
        return ServerResponse.createByErrorMessage("订单不存在");
    }


    public ServerResponse<String> updateOrderStatus(String orderNo, Integer status, Long userId) {
        Order order = orderMapper.selectByOrderNo(orderNo);
        if (order == null) {
            ServerResponse.createByErrorMessage("订单不存在");
        }

        Order updateOrder = new Order();
        if (status == EnumOrderStatus.FINISHED.getCode()){
            // 设置订单完成时间
            updateOrder.setEndTime(new Date());
            // 释放餐桌
            freeDesk(order);
            // 记录菜品销量
            List<OrderDetail> orderDetails = orderDetailMapper.getByOrderNoUserId(orderNo, order.getUserId());
            for (OrderDetail detail : orderDetails) {
                SaleNum saleNum = new SaleNum();
                saleNum.setDishId(detail.getDishId());
                saleNum.setDaySaleNumber(Long.valueOf(detail.getDishCount()));
                saleNum.setSaleDate(new Date());
                saleNumMapper.insert(saleNum);
            }
        } else if (status == EnumOrderStatus.CANCELLED.getCode()) {
            // 释放餐桌
            freeDesk(order);
            // 释放库存
            List<OrderDetail> orderDetails = orderDetailMapper.getByOrderNoUserId(orderNo, order.getUserId());
            for (OrderDetail detail : orderDetails) {
                Dish dish = dishMapper.selectByPrimaryKey(detail.getDishId());
                dish.setTotalNumber(dish.getTotalNumber() + detail.getDishCount());
                dishMapper.updateByPrimaryKeySelective(dish);
            }
        } /*else if (status == EnumOrderStatus.PAID.getCode()) {
            updateOrder.setPaymentType(EnumPaymentType.OFFLINE.getCode());
            updateOrder.setPaymentTime(new Date());
            // 保存支付记录
            PayInfo payInfo = new PayInfo();
            payInfo.setOrderNo(orderNo);
            payInfo.setPayPlatform(EnumPayPlatform.CASH.getCode());
            payInfo.setPlatformNumber(orderNo);
            payInfo.setUserId(order.getUserId());
            payInfo.setPlatformStatus("TRADE_SUCCESS");
            payInfoMapper.insert(payInfo);
        }*/

        updateOrder.setOrderStatus(status);
        updateOrder.setOrderId(order.getOrderId());
        updateOrder.setLastUpdatedBy(String.valueOf(userId));
        int rowCount = orderMapper.updateByPrimaryKeySelective(updateOrder);
        if (rowCount > 0 ){
            return ServerResponse.createBySuccess("更新订单状态成功");

        }
        return ServerResponse.createByErrorMessage("更新订单状态失败");
    }

    /* 释放餐桌 */
    private void freeDesk(Order order) {
        Desk desk = deskMapper.selectByPrimaryKey(order.getDeskId());
        desk.setDeskStatus(EnumDeskStatus.FREE.getCode());
        deskMapper.updateByPrimaryKeySelective(desk);
    }

    public Long addedOrderCount(Date date) {
        DateTime begin = new DateTime(DateTimeUtil.getZeroTime(date));
        DateTime end = new DateTime(date);
        return orderMapper.countByCreatedTime(begin.toString(), end.toString());
    }

    public Long pendingDealOrder(Date date) {
        DateTime begin = new DateTime(DateTimeUtil.getZeroTime(date));
        DateTime end = new DateTime(date);
        return orderMapper.countByCreatedTimeAndStatus(begin.toString(),
                end.toString(), EnumOrderStatus.DEALT.getCode());
    }

}
