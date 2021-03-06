<%--
  Created by IntelliJ IDEA.
  User: wangxue
  Date: 18/3/12
  Time: 下午4:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:ser var = "ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>指尖上的美味</title>
    <link rel="stylesheet" href="${ctx}/resource/css/bootstrap.min.css" >
    <!--<link rel="stylesheet" href="../resource/css/jquery-ui.min.css"-->
    <link rel="stylesheet" href="${ctx}/css/common.css">
    <link rel="stylesheet" href="${ctx}/css/order.css">
    <script type="text/javascript" src="${ctx}/resource/js/jquery-1.12.4.js"></script>


</head>
<body>
<div id="left">
    <!-- 侧边栏 -->
    <div id="sideBar">
        <ul class="nav  nav-stacked">
            <li id="01" class="bar active"><a href="#">订单详情</a></li>
            <li id="02" class="bar"><a href="${ctx}/jsp/order/order_history.jsp">历史订单</a></li>
        </ul>
    </div>
</div>

<%--订单为空时显示的信息--%>
<div class="none_order">

</div>

<div id="contain">
    <!-- 订单号 -->
    <div class="order_title">
        <%--<div class="order_no_time">
            <p  id="order_no_p">订单号: 000001</p>
            <p  id="order_time_p">2018.03.10 12:04--2018.03.10 12:34</p>
        </div>
        <div class="order_status">
            <p  id="order_status_p">已结账</p>
        </div>--%>
    </div>
    <!-- 菜品排序筛选器 -->
    <div class="filter">
        <div id="dish_btn">
            <button class="text_btn btn"  >菜品</button>
        </div>
        <div id="price_btn">
            <button class="text_btn btn">单价</button>
        </div>
        <div id="count_btn">
            <button class="text_btn btn" >数量</button>
        </div>
        <div id="act_btn">
            <button class="text_btn btn" >优惠活动</button>
        </div>
        <div id="totle_btn">
            <button class="text_btn btn " >总价</button>
        </div>
    </div>

    <!--菜单列表 -->
    <div class="dish_list">
        <ul>
            <%--菜品--%>

            <!-- 餐桌信息 -->

        </ul>
    </div>
    <!-- 总额 -->
    <div class="all_totle_money">

    </div>
    <!-- 取消订单/加菜/去付款btn -->
    <div class="filter all_function_btn">
      <%--  <button class="btn function_btn1 mybtn " >加菜</button>--%>
        <button class="btn function_btn2 mybtn " style="cursor: pointer">取消订单</button>
        <button class="btn function_btn3 mybtn" style="cursor: pointer">去付款</button>
    </div>
        <%--支付时背景界面--%>
        <div id="hide_box"></div>
        <div id="pay_box">
            <%--<span class="radiobox" id="alipay_check">支付宝</span>--%>
            <%--<span class="radiobox" id="balancePay_check">余额</span>--%>
            <%--<div class="pay_img" href="javascript:void(0)">--%>
            <div id="pay_img">
                <%--付款码--%>
                <%--<img src="${ctx}/resource/img/alipayimg.jpg" alt="扫码付款" title="扫一扫" />--%>
            </div>
            <%--<div id="pay_balance">--%>
                <%--&lt;%&ndash;余额支付&ndash;%&gt;--%>
            <%--</div>--%>
        </div>
</div>
<script type="text/javascript" src="${ctx}/js/order.js"></script>
<script type="text/javascript">
    /*取消订单*/
    $(".function_btn2").click(function () {
        console.log("取消订单btn");
        $.ajax({
            url : "http://192.168.1.180:8080/doft/requisition/saveRequisition.aj",//url
            xhrFields: {           withCredentials: true       },
            crossDomain: true,
            type : "POST",//方法类型
            dataType: "json",//预期服务器返回的数据类型
            data: {"type":2,"orderNo":orderNo},
            error : function(xhr, status, error) {
                console.info(JSON.stringify(xhr));
                window.alert("网络错误！无法取消订单");
            },
            success : function(Responsedata) {
                console.log(Responsedata);
                if (Responsedata.status == '0'){
                    console.log("cancel ok");
//                    window.location.reload();
                    $("#order_status_p").text("申请中");
                    $(".function_btn1").attr('disabled',true);//ban the button
                    $(".function_btn2").attr('disabled',true);
                    $(".function_btn3").attr('disabled',true);
                }
                else{
                    window.alert("sorry系统开小差了！");
                }
            }
        });
    });
</script>
</body>
</html>