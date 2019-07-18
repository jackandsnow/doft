<%--
  Created by IntelliJ IDEA.
  User: zhaojing
  Date: 2018/3/13
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:ser var = "ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
    <meta charset="UTF-8">
    <title>历史订单</title>
    <link rel="stylesheet" href="${ctx}/resource/css/bootstrap.min.css" >
    <!--<link rel="stylesheet" href="../resource/css/jquery-ui.min.css"-->
    <link rel="stylesheet" href="${ctx}/css/common.css">
    <link rel="stylesheet" href="${ctx}/css/pagination.css">
    <link rel="stylesheet" href="${ctx}/css/order_history.css">

    <!-- 订单中心样式 -->
    <%--<link rel="stylesheet" href="${ctx}/css/order.css">--%>
    <script type="text/javascript" src="${ctx}/resource/js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="${ctx}/js/order_history.js"></script>
</head>
<body>
<div id="left">
    <!-- 侧边栏 -->
    <div id="sideBar">
        <ul class="nav  nav-stacked">
            <li id="01" class="bar"><a href="${ctx}/jsp/order/order.jsp">订单详情</a></li>
            <li id="02" class="bar active"><a href="#">历史订单</a></li>
        </ul>
    </div>
</div>
<div id="contain">
    <!-- 订单筛选器 -->
    <div class="filter">
        <button class="text_btn btn " id="sort_default" >默认</button>
        <button class="text_btn btn " id="sort_time"  >时间</button>
        <button class="text_btn btn " id="sort_price">价格</button>
        <button class="text_btn btn " id="sort_status">状态</button>
    </div>
    <!-- 订单号 -->
    <div class="order_history">
        <ul>

        </ul>
    </div>
    <%--订单为空时显示的信息--%>
    <div class="none_order">

    </div>
    <%--换页--%>
    <div class="page_wrapper">
        <ul class="pagination">
        </ul>
    </div>
</div>
<script src="${ctx}/js/common_func.js"></script>
</body>
</html>
