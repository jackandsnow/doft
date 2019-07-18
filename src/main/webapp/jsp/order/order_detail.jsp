<%--
  Created by IntelliJ IDEA.
  User: wangxue
  Date: 18/3/20
  Time: 上午10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:ser var = "ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>历史订单详情</title>
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
            <li id="01" class="bar"><a href="${ctx}/jsp/order/order.jsp">订单详情</a></li>
            <li id="02" class="bar"><a href="${ctx}/jsp/order/order_history.jsp">历史订单</a></li>
        </ul>
    </div>
</div>
<div id="contain">
    <%--<div id="detail_or_history">--%>
    <%--<div id="order_detail">--%>
    <%--<a href="#">订单详情</a>--%>
    <%--</div>--%>
    <%--<div id="order_history">--%>
    <%--<a href="${ctx}/jsp/order/order_history.jsp">历史订单</a>--%>
    <%--</div>--%>
    <%--</div>--%>
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
    <%--订单为空时显示的信息--%>
    <div class="none_order">

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
</div>
<script type="text/javascript">
    var orderNum = document.cookie;
    $(document).ready(function () {
//        console.log(orderNum+"orderNum啊啊啊");
        orderDetailFun();
    });

    function  orderDetailFun() {
        detailAjax = $.ajax({
            url:"http://192.168.1.180:8080/doft/order/detail.do" ,
            xhrFields: {           withCredentials: true       },
            crossDomain: true,
            type: "POST" ,
            dataType:"json" ,
            data:{"orderNo":orderNum},
            error:function (xhr, status, error) {
                console.info(JSON.stringify(xhr));
            },
            success:function (responseObj) {
                if(responseObj.status == '1'){
                    console.log("订单详情异常");
                    return ;
                }
                /*这种情况是用户未登录时*/
                if(responseObj.data == null){
                    $(".filter").hide();
                    var tip ="亲，您还没有登录，赶快去登录吧！";
                    var showMsg = '<p>'+tip+'</p> ';
                    $(".none_order").append(showMsg);
                    return ;
                }
                /*这种情况是用户未创建订单时*/
                if(responseObj.data.orderNo == null){
                    $(".filter").hide();
                    $(".filter all_function_btn").hide();
                    var tip ="亲，您还没有创建订单哦，赶快去点餐吧！";
                    var showMsg = '<p>'+tip+'</p> ';
                    $(".none_order").append(showMsg);
                    return ;
                }
                $(".none_order").css("height 0 ; width 0; display none;");
                $(".none_order p").css("height 0 ; width 0; display none;");
                $(".none_order").remove(showMsg);
                /*订单标题*/
                var order = responseObj.data ;
                orderNo = order.orderNo ;
                // console.log("订单号:"+orderNo);
                var creationDate = order.creationDate ;
                var orderStatus = order.orderStatusDesc ;
                var orderTitle = '<div class="order_no_time">\n' +
                    '            <p  id="order_no_p">订单号: '+ orderNo +'</p>\n' +
                    '            <p  id="order_time_p">'+creationDate+'</p>\n' +
                    '        </div>\n' +
                    '        <div class="order_status">\n' +
                    '            <p  id="order_status_p">'+orderStatus+'</p>\n' +
                    '        </div>\n' ;
                $('.order_title').append(orderTitle);
                //wangxue
                if (order.orderStatus == 2){
                    $(".function_btn1").attr('disabled',true);//ban the button
                    $(".function_btn2").attr('disabled',true);
                    $(".function_btn3").attr('disabled',true);
                }
                if (order.orderStatus == 3 || order.orderStatus == 5 || order.orderStatus == 6){
                    $(".function_btn1").hide();
                    $(".function_btn2").hide();
                    $(".function_btn3").hide();
                }

                /*菜品列表*/
                var orderDetail = order.orderDetailList;
                var i ;
                /*输出菜品数量*/
                //console.log(orderDetail.length+'菜品数量');
                for(i=0 ; i<orderDetail.length ; i++){
                    var dishName = orderDetail[i].dishName;
                    var price = orderDetail[i].currentUnitPrice ;
                    var count = orderDetail[i].dishCount ;
                    var price_count = orderDetail[i].totalPrice;
                    var imgUrl = orderDetail[i].imgUrl;
                    var discount;
                    if(orderDetail[i].discountble){
                        discount = "8折";
                    }
                    else {
                        discount = "无" ;
                    }
                    var dish_html = '<li>\n' +
                        '                <div class="dish">\n' +
                        '                    <div class="dish_info">\n' +
                        '                        <div class="dish_img">\n' +
                        '                            <img src='+imgUrl+'>\n' +
                        '                        </div>\n' +
                        '                        <div class="dish_inf_name">\n' +
                        '                            <p>'+dishName+'</p>\n' +
                        '                        </div>\n' +
                        '                    </div>\n' +
                        '                    <div class="dish_inf_money">\n' +
                        '                        <p>￥<span>'+price+'</span></p>\n' +
                        '                    </div>\n' +
                        '                    <div class="dish_count">\n' +
                        '                        <p>'+count+'</p>\n' +
                        '                    </div>\n' +
                        '                    <div class="dish_inf_act">\n' +
                        '                        <p>'+discount+'</p>\n' +
                        '                    </div>\n' +
                        '                    <div class="dish_totle_money">\n' +
                        '                        <p>'+price_count +'</p>\n' +
                        '                    </div>\n' +
                        '                </div>\n' +
                        '            </li>';
                    $(".dish_list ul").append(dish_html);
                }

                /*总价*/
                var deskNum = order.deskId ;
                var discount_total = order.discountPrice ;
                var total_price = order.totalPrice - discount_total;
                var total_price_html = '<p class="desk_inf" >餐桌: <span>'+deskNum +'</span></p>\n ' +
                    '<p class="money_inf" >合计: ￥<span>'+total_price +'</span></p>\n' +
                    '        <p class="discount_inf">已优惠 ￥<span>'+discount_total+'</span></p>';
                $(".all_totle_money ").append(total_price_html);
            }
        });
    }
</script>
</body>
</html>