<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<c:ser var = "ctx" value="${pageContext.request.contextPath}"/>
<head>
    <meta charset="UTF-8">
    <meta name="viewpoint" content="width=device-width,initial-scale=1">
    <title>指尖上的美味</title>
    <%--<link rel="stylesheet" href="${ctx}/resource/css/bootstrap.min.css">--%>
    <!--<link rel="stylesheet" href="../resource/css/jquery-ui.min.css" type="text/css">-->
    <link rel="stylesheet" href="${ctx}/css/index.css">
    <!--<link rel="stylesheet" href="../resource/zui/css/zui.css">-->
    <script type="text/javascript" src="${ctx}/resource/js/jquery-1.12.4.js" ></script>
    <script type="text/javascript" src="${ctx}/resource/js/bootstrap.js" ></script>
    <!-- 引入Jquery js库文件 -->

    <!--<script type="text/javascript" src="../js/index.js"></script>-->
    <style>
        /*弹出框样式 ——start*/
        #msg{
            width:300px;
            position: fixed;
            z-index:999;
            top: 49%;
            margin-top:-80px;
            left:50%;
            margin-left:-133px;
            background:#fff;
            box-shadow:5px 5px 8px #999;
            font-size:17px;
            color:#666;
            border:1px solid #f8f8f8;
            text-align: center;
            line-height: 2rem;
            display:inline-block;
            padding-bottom:20px;
            border-radius:2px;
        }
        #msg_top{
            background:#f8f8f8;
            padding:5px 15px 5px 20px;
            text-align:left;
        }
        #msg_top span{
            font-size:18px;
            float:right;
            cursor:pointer;
        }
        #msg_cont{
            padding:15px 20px 20px;
            text-align:left;
        }
        .msg_clear{
            display:inline-block;
            color:#fff;
            padding:1px 15px;
            background:#fb9100;
            border-radius:2px;
            float:right;
            margin-right:15px;
            cursor:pointer;
        }
        @media screen and (max-device-width: 640px){
            #msg {
                width: 600px;
                position: fixed;
                z-index: 999;
                top: 41%;
                margin-top: -80px;
                left: 34%;
                margin-left: -133px;
                background: #fff;
                box-shadow: 5px 5px 8px #999;
                font-size: 35px;
                color: #666;
                border: 1px solid #f8f8f8;
                text-align: center;
                line-height: 5rem;
                display: inline-block;
                padding-bottom: 20px;
                border-radius: 17px;
                height: 400px;}
            #msg_top span{
                font-size: 40px;
            }
        }
        /*弹出框样式 ——end*/
    </style>
</head>
<body>
<div id="header">
    <div class="header_main" id="1">
        <div class="logo">
            <div class="logo_img">
                <a><img src="${ctx}/resource/img/logo.png"/></a>
            </div>
            <p>指尖上的美味</p>
        </div>
        <div class="search">
            <input  id="search_input" type="text" placeholder="输入你想要的菜品" value="">
            <button class="btn" id="search-btn"><img src="${ctx}/resource/img/search1.png" alt=""></button>
            <%--<span class="search-btn">--%>
                <%--<a>--%>
                     <%--<button class="btn"><img src="${ctx}/resource/img/search.png" alt=""></button>--%>
                <%--</a>--%>
                <%--</span>--%>
        </div>
        <div class="headBar" id="">
            <div class="bar_list pb">
                <div class="num_dish_in_car">
                   0
                </div>
                <div class=" pb_img">
                    <a><img src="${ctx}/resource/img/PB.png"/></a>
                </div>

                <p>购物车</p>
            </div>
            <div class="bar_list order">
                <div class=" order_img">
                    <a><img src="${ctx}/resource/img/Order.png"/></a>
                </div>
                <p>订单中心</p>
            </div>
            <div class="bar_list person">
                <div class=" person_img">
                    <%--<a href="${ctx}/jsp/person/person_info_finished.jsp" target="mainFrame"><img src="${ctx}/resource/img/Person.png"/></a>--%>
                    <a ><img src="${ctx}/resource/img/Person.png"/></a>
                </div>
                <p>个人中心</p>
            </div>
        </div>
    </div>
</div>
<div id="main">
    <!--内联框架，网页中嵌套另外一个网页-->
    <iframe id="mainFrame" name="mainFrame" src="${ctx}/jsp/dishes/dishes.jsp" width="100%" height="100%" frameborder="0"></iframe>
</div>
<div id="footer">
    <div class="footBtn" id="dish_btn">
        <a>
            <button>点菜</button>
        </a>
    </div>
    <div class="footBtn" id="pb_btn">
        <a>
            <button>购物车</button>
        </a>
    </div>
    <div class="footBtn" id="order_btn">
        <a >
            <button>订单中心</button>
        </a>
    </div>
    <div class="footBtn" id="person_btn">
        <%--<a href="${ctx}/jsp/person/person_info_finished.jsp" target="mainFrame">--%>
        <a >
            <button>个人中心</button>
        </a>
    </div>
</div>
</div>
<script type="text/javascript " src="${ctx}/js/common_dish_pb_order.js"></script>
<script>
    //弹出框
    function myalert(e){
        $("body").append('<div id="msg"><div id="msg_top">提示<span class="msg_close">×</span></div><div id="msg_cont">'+e+'</div><div class="msg_close msg_clear" id=msg_sure>确定</div></div>');
        $(".msg_close").click(function (){
            $("#msg").remove();
        });
    }
    function is_login_fun(){
        // 判断用户是否登录
        $.ajax({
            url: "http://192.168.1.180:8080/user/check_login.do",
            xhrFields: {           withCredentials: true       },
            crossDomain: true,
            type: "POST",
            dataType: "json",
            error: function (xhr, status, error) {
                console.info(JSON.stringify(xhr));
            },
            success: function (Rdata) {
                console.log("Rdata.status="+Rdata.status);
                if(Rdata.status == '0'){
                    is_login = 1;
                }
                else{
                    is_login = 0;
                }
                $(".headBar").attr('id',is_login);
                console.log("is_login="+is_login);
                // 购物车小红点控制
                if(is_login==1){
                    // $(".num_dish_in_car").css("display",'block');
                    $(".num_dish_in_car").show();
                }
                else{ //未登录
                    // $(".num_dish_in_car").css("display",'none');
                    $(".num_dish_in_car").hide();
                }
            }

        });
    }

    function initail_header_btn(){
        $(".pb").click(function () {
            // console.log("开始初始化 pb-button");
            // is_login_fun();
            is_login =  $(".headBar").attr('id');
            if(is_login == 1){
                window.open("${ctx}/jsp/pb/pb.jsp","mainFrame");
            }
            else{
                window.open("${ctx}/jsp/login/login.jsp","mainFrame");
            }

        });
        $("#pb_btn").click(function(){
            is_login =  $(".headBar").attr('id');
            if(is_login == 1){
                window.open("${ctx}/jsp/pb/pb.jsp","mainFrame");
            }
            else{
                window.open("${ctx}/jsp/login/login.jsp","mainFrame");
            }
        });
        $(".logo").click(function(){

            //不管等不等了都跳
            $(".header_main").attr('id',1); //把id改为1
            window.open("${ctx}/jsp/dishes/dishes.jsp","mainFrame");

        });
        $("#dish_btn").click(function(){
            //不管等不等了都跳
            $(".header_main").attr('id',1); //把id改为1
            window.open("${ctx}/jsp/dishes/dishes.jsp","mainFrame");
        });
        $(".order").click(function(){
            // is_login_fun();
            is_login =  $(".headBar").attr('id');
            console.log("is_login="+is_login);
            if(is_login == 1){
                window.open("${ctx}/jsp/order/order.jsp","mainFrame");
            }
            else{
                window.open("${ctx}/jsp/login/login.jsp","mainFrame");
            }
        });
        $("#order_btn").click(function(){
            is_login =  $(".headBar").attr('id');
            console.log("is_login="+is_login);
            if(is_login == 1){
                window.open("${ctx}/jsp/order/order.jsp","mainFrame");
            }
            else{
                window.open("${ctx}/jsp/login/login.jsp","mainFrame");
            }
        });
        $(".person").click(function(){
            // is_login_fun();
            is_login =  $(".headBar").attr('id');
            if(is_login == 1){
                window.open("${ctx}/jsp/person/person_info_finished.jsp","mainFrame");
            }
            else{
                window.open("${ctx}/jsp/login/login.jsp","mainFrame");
            }
        });
        $("#person_btn").click(function(){
            is_login =  $(".headBar").attr('id');
            if(is_login == 1){
                window.open("${ctx}/jsp/person/person_info_finished.jsp","mainFrame");
            }
            else{
                window.open("${ctx}/jsp/login/login.jsp","mainFrame");
            }
        });

        $("#search-btn").click(function(){
            current_dishID = 0 ;
            var header_main = window.parent.document.getElementsByClassName('header_main');
            $(header_main).attr('id',current_dishID);
            if($("#search_input").val() == ''){
                myalert("搜索信息不能为空！");
                return;
            }
            window.open("${ctx}/jsp/dishes/dishes.jsp","mainFrame");
        });
    }
    $(document).ready(function(){
        // console.log("document).ready已经执行");
        is_login_fun();
        initail_header_btn();


    });
</script>
</body>
</html>