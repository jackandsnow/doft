<%--
  Created by IntelliJ IDEA.
  User: wangxue
  Date: 18/3/12
  Time: 下午4:28
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
    <!--<link rel="stylesheet" href="../css/dishes.css">-->
    <link rel="stylesheet" href="${ctx}/css/pb.css">
    <!--<script type="text/javascript" src="../resource/js/jquery-ui.min.js"></script>-->
    <script type="text/javascript" src="${ctx}/resource/js/jquery-1.12.4.js"></script>
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
<div id="left">
    <a style="text-decoration: none">
        <div id="sideBar" >
            <ul class="nav  nav-stacked">
                <%--<li  value="0" class="bar" ><a href="${ctx}/jsp/dishes/dishes.jsp">日本菜</a></li>--%>
            </ul>
        </div>
    </a>
</div>
<div id="contain">
    <br/>
    <div id="empty_tips" class="hidden">
        <p></p>
    </div>
    <div class="dish_list">
        <ul>
        </ul>
    </div>
    <div class="up_order hidden">
        <div class="set_time" style="text-align: right">
            <div class="set_time_btn" id="clear_car">
                <button class=" mybtn" onclick="clear_car()">清空购物车</button>
            </div>
        </div>
        <div class="total_money">
            <p>合计：<b >￥<input type="text" value="…" id="all_price" readonly="readonly"/></b></p>
            <br>
            <p >已优惠<input value="20" type="text" id="pre_price" readonly="readonly"/>元</p>
        </div>
        <div class="button_up">
                <button class=" btn mybtn">提交订单</button>
        </div>
    </div>
</div>
<script type="text/javascript " src="${ctx}/js/common_dish_pb_order.js"></script>
<script>
    var bar=document.getElementsByClassName("bar");
    var is_addedSeat;
    var can_create_order;
    var num_of_people;
    //弹出框
    function myalert(e){
        $("body").append('<div id="msg"><div id="msg_top">提示<span class="msg_close">×</span></div><div id="msg_cont">'+e+'</div><div class="msg_close msg_clear" id=msg_sure>确定</div></div>');
        $(".msg_close").click(function (){
            $("#msg").remove();
        });
    }

    function mycomfire(e){
        $("body").append('<div id="msg"><div id="msg_top">提示<span class="msg_close">×</span></div><div id="msg_cont">'+e+'</div><div class="msg_close msg_clear" id=msg_sure>确定</div><div class="msg_close msg_clear" id="msg_cancel">取消</div></div>');
        $(".msg_close").click(function (){
            $("#msg").remove();
        });
        $("#msg_sure").click(function(){
            clean_car();
        });
    }

    // 向后台更新对应菜品id 下的 菜品数量
    function change_dish_num(dish_id,dish_num){
        $.ajax({
            url: "http://192.168.1.180:8080/cart/add.do",
            xhrFields: {           withCredentials: true       },
            crossDomain: true,
            type : "POST",
            data :{"dishId":dish_id,"count":dish_num},
            dataType: "json",
            error : function(xhr, status, error) {
                console.info(JSON.stringify(xhr));
            },
            success : function(responsedObj) {
                console.log("该菜品加入购物车成功！");
                get_cartTotalPrice();
            }

        });

    }

    // 计算 菜品单价 * 菜品数量 = 菜品总价
    function UTPrice(){
        var t_price=document.getElementsByClassName("t_price");
        var univalent=document.getElementsByClassName("univalent");
        var num=document.getElementsByClassName("num");
        for(var i=0;i<t_price.length;i++){
            var univalent_v=univalent[i].value;
            var num_v=num[i].value;
            var t_price_new=univalent_v*num_v;
            $(t_price[i]).val(t_price_new);
        }
    }

    // 通过页面元素 计算购物车中的总价
    function UAprice(){
        var t_price=document.getElementsByClassName("t_price");
        var price=0;
        if(t_price.length==0){
            $("#all_price").val(price);
        }
        else{
            for(var i=0;i<t_price.length;i++){
                var price_one=t_price[i].value;
                price = price + parseInt(price_one);
                console.log(price);
            }
            $("#all_price").val(price);
        }
    }

    //在购物车页面中加载 指定的菜品
    function Up_car_list(dish) {
        var  dish_id = dish.dishId;
        var dishImgUrl = dish.dishImgUrl;
        var dishName = dish.dishName;
        var dishPrice = dish.dishPrice;
        var dishTotalPrice = dish.dishTotalPrice;
        var  quantites = dish.quantites;
        var discountble = " ";
        if(dish.discountble){
            discountble = "(8折优惠)";
        }
        var html='<li value='+dish_id+'>\n' +
            '                <div class="dish">\n' +
            '                    <div class="dish_img">\n' +
            '                        <img src='+dishImgUrl+'>\n' +
            '                    </div>\n' +
            '                    <div class="dish_inf">\n' +
            '                        <div class="dish_inf_name">\n' +
            '                            <p> '+dishName+'</p>\n' +
            '                        </div>\n' +
            '                        <div class="dish_inf_money_and_recommand">\n' +
            '                            <div class="dish_inf_money">\n' +
            '                                <p>￥<input type="text" readonly="readonly" value='+dishPrice+'  class="univalent"/> '+discountble +'</p>\n' +
            '                            </div>\n' +
            // '                            <div class="dish_inf_recommand">\n' +
            // '                                <span>显示星星</span>\n' +
            // '                                <span>5</span>\n' +
            '                                <!--<p>这里显示有多少颗星星</p>-->\n' +
            // '                            </div>\n' +
            '                        </div>\n' +
            // '                        <div class="dish_inf_dec">\n' +
            // '                            <p>这里是对菜品的描述</p>\n' +
            // '                        </div>\n' +
            '                    </div>\n' +
            '                    <div class="dish_total_money">\n' +
            '                        <p>￥<input  type="text" readonly="readonly" value='+dishTotalPrice+'  class="t_price"/></p>\n' +
            '                    </div>\n' +
            '                    <div class="dish_add_pb">\n' +
            '                        <div class="pb_num ">\n' +
            '                            <em class="dec">-</em>\n' +
            '                            <input  type="text"  value='+quantites+' class="num" readonly="readonly"/>\n' +
            '                            <em class="add" title='+ dish.dishStock+'>+</em>\n' +
            '                        </div>\n' +
            '                    </div>\n' +
            '                </div>\n' +
            '            </li>';
        $(".dish_list ul").append(html);

    }

    // 获取购物车中所有菜品的总价
    function get_cartTotalPrice(){
        $.ajax({
            url: "http://192.168.1.180:8080/cart/list.do",
            xhrFields: {           withCredentials: true       },
            crossDomain: true,
            type: "POST",
            dataType: "json",
            error: function (xhr, status, error) {
                console.info(JSON.stringify(xhr));
            },
            success: function (car_obj) {
                if (car_obj.status == '1') {
                    console.log("购物车状态异常");
                    return;
                }
                var cartTotalPrice=car_obj.data.cartTotalPrice;
                var cartDiscountPrice = car_obj.data.cartDiscountPrice;
                $("#all_price").val(cartTotalPrice);
                $("#pre_price").val(cartDiscountPrice);
            }
        });
    }

    //删除购物车中的菜品，但菜品数量减到0时执行。
    function delete_dish(dishID){
        $.ajax({
            url: "http://192.168.1.180:8080/cart/delete_dish.do",
            xhrFields: {           withCredentials: true       },
            crossDomain: true,
            type : "POST",
            dataType: "json",
            data:{"dishIds":dishID},
            error : function(xhr, status, error) {
                console.info(JSON.stringify(xhr));
            },
            success : function(car) {
                if (car.status == '1') {
                    console.log("菜系列表状态异常");
                    return;
                }
                console.log("dishid="+dishID+"的菜品，已经删除成功");
                //获取购物车中的信息 ---start
                $.ajax({
                    url: "http://192.168.1.180:8080/cart/list.do",
                    xhrFields: {           withCredentials: true       },
                    crossDomain: true,
                    type : "POST",
                    dataType: "json",
                    error : function(xhr, status, error) {
                        console.info(JSON.stringify(xhr));
                    },
                    success : function(car_obj) {
                        console.log("购物车状态="+car_obj.status);
                        if(car_obj.status!='0'){
                            console.log("购物车状态异常");
                            return;
                        }
                        get_cartTotalPrice();
                        car_dish_list=car_obj.data.cartDishVoList;
                        console.log("car_dish_list.length="+car_dish_list.length);
                        // 更新顶部购物车内的菜品数量
                        var html = car_dish_list.length;
                        console.log("提交订单按钮 ：html = car_dish_list.length="+html);
                        var num = window.parent.document.getElementsByClassName("num_dish_in_car");
                        $(num).html(html);
                        if(html=='0' || html== 0 ){
                            $(".up_order").addClass("hidden");
                            $("#empty_tips").removeClass("hidden");
                            $("#empty_tips p").html("购物车空空如也，赶快去点菜吧！(*^__^*) 嘻嘻……");
                            $(".dish_list ul").empty();
                            // console.log("car_num="+nnum);
                            // $(".num_dish_in_car").css("display",'none');
                            $(".num_dish_in_car").hide();
                        }
                        else{
                            // $(".num_dish_in_car").css("display",'block');
                            $(".num_dish_in_car").show();
                            // $("#num_dish_in_car").innerHTML(car_dish_list.length);
                        }
                    }
                });
                //获取购物车中的信息  ---end

            }
        });

    }

    function clear_car(){
        console.log('yes');
            $.ajax({
                url: "http://192.168.1.180:8080/cart/clean_cart.do",
                xhrFields: {           withCredentials: true       },
                crossDomain: true,
                type : "POST",
                dataType: "json",
                error : function(xhr, status, error) {
                    console.info(JSON.stringify(xhr));
                },
                success : function(car) {
                    if(car.status != '0'){
                        console.log("购物车状态异常！");
                    }
                    else{
                        console.log("清空购物车成功！");
                        car_dish_list=car.data.cartDishVoList;
                        $(".up_order").addClass("hidden");
                        $("#empty_tips").removeClass("hidden");
                        $("#empty_tips p").html("购物车空空如也，赶快去点菜吧！(*^__^*) 嘻嘻……");
                        $(".dish_list ul").empty();
                        var num = window.parent.document.getElementsByClassName("num_dish_in_car");
                        $(num).html('0');
                        // $(".num_dish_in_car").css("display",'none');
                        $(".num_dish_in_car").hide();

                    }


                }
            });
        // $("#clear_car").click(function(){
        //
        // });
    }
    // document.getElementById('clear_car').addEventListener("click",clear_car);
    function get_curren_order_status(){
        $.ajax({
            url: "http://192.168.1.180:8080/doft/order/detail.do",
            xhrFields: {           withCredentials: true       },
            crossDomain: true,
            type: "POST",
            dataType: "json",
            error: function (xhr, status, error) {
                console.info(JSON.stringify(xhr));
            },
            success: function (responseObj) {
                if (responseObj.status != '0') {
                    console.log("菜系列表状态异常");
                }
                else{
                    console.log("获取当前订单详情成功！");
                    var orderStatus=responseObj.data.orderStatus;
                    if(orderStatus == 1 || orderStatus ==2){
                        can_create_order=0;
                    }
                    else{
                        can_create_order=1;
                    }

                }

            }
        });
    }

    function ger_order_detail(order_no){
        $.ajax({
            url: "http://192.168.1.180:8080/doft/order/detail.do",
            xhrFields: {           withCredentials: true       },
            crossDomain: true,
            type: "POST",
            dataType: "json",
            data:{"orderNo":order_no},
            error: function (xhr, status, error) {
                console.info(JSON.stringify(xhr));
            },
            success: function (responseObj) {
                if (responseObj.status != '0') {
                    console.log("菜系列表状态异常");
                }
                else{
                    console.log("获取当前订单详情成功！");
                    var orderStatus=responseObj.data.orderStatus;

                }

            }
        });
    }

    function create_order(){
        $(".button_up").click(function(){
            if(!can_create_order){ //不可以创建订单！
                myalert("大哥，你当前还有未完成的订单哟！");
                return;
            }
            if(!is_addedSeat){
                myalert("提交订单前，请添加餐位信息！");
                return;
            }
            if(car_dish_list.length ==1 && car_dish_list[0].dishId==1){
                myalert("亲，你的购物车里一个菜都没有，你吃桌子么？");
                return;
            }
            console.log("can_create_order="+can_create_order);
            //获取就餐人数
            for(var i=0;i<car_dish_list.length;i++){
                var  dish = car_dish_list[i];
                if(dish.dishId == 1){
                    num_of_people = dish.quantites;
                }
                console.log('就餐人数是 ='+num_of_people);
            }
            // 分配餐桌
            $.ajax({
                url: "http://192.168.1.180:8080/doft/desk/getRandomFreeDeskId.aj",
                xhrFields: {           withCredentials: true       },
                crossDomain: true,
                type: "POST",
                dataType: "json",
                error: function (xhr, status, error) {
                    console.info(JSON.stringify(xhr));
                },
                success: function (responseObj) {
                    if (responseObj.status != '0') {
                        console.log("菜系列表状态异常");
                        return;
                    }
                    if (responseObj.data == 0) {
                        console.log("暂无可分配的餐桌！");
                        return;
                    }
                    var deskID = responseObj.data;
                    console.log("分配到的餐桌号为："+deskID);

                    // 提交订单
                    $.ajax({
                        url: "http://192.168.1.180:8080/doft/order/create.do",
                        xhrFields: {           withCredentials: true       },
                        crossDomain: true,
                        type: "POST",
                        dataType: "json",
                        data:{"deskId": deskID,"peopleCount":num_of_people},
                        error: function (xhr, status, error) {
                            console.info(JSON.stringify(xhr));
                        },
                        success: function (respondeObj) {
                            console.log("订单创建成功！");
                            if(respondeObj.status !='0'){
                                console.log("订单状态错误！");
                                return;
                            }
                            console.log("订单号="+respondeObj.data.orderNo);
                            // 获取购物车中的信息 ---start
                            $.ajax({
                                url: "http://192.168.1.180:8080/cart/list.do",
                                xhrFields: {           withCredentials: true       },
                                crossDomain: true,
                                type : "POST",
                                dataType: "json",
                                error : function(xhr, status, error) {
                                    console.info(JSON.stringify(xhr));
                                },
                                success : function(car_obj) {
                                    console.log("购物车状态="+car_obj.status);
                                    if(car_obj.status!='0'){
                                        console.log("购物车状态异常");
                                        return;
                                    }

                                    car_dish_list=car_obj.data.cartDishVoList;
                                    console.log("car_dish_list.length="+car_dish_list.length);
                                    // 更新顶部购物车内的菜品数量
                                    var html = car_dish_list.length;
                                    console.log("提交订单按钮 ：html = car_dish_list.length="+html);
                                    var num = window.parent.document.getElementsByClassName("num_dish_in_car");
                                    $(num).html(html);
                                    if(html=='0' || html== 0 ){
                                        // console.log("car_num="+nnum);
                                        // $(".num_dish_in_car").css("display",'none');
                                        $(".num_dish_in_car").hide();
                                    }

                                    else{
                                        // $(".num_dish_in_car").css("display",'block');
                                        $(".num_dish_in_car").show();
                                        // $("#num_dish_in_car").innerHTML(car_dish_list.length);
                                    }
                                    window.location.href="../order/order.jsp";


                                }
                            });
                            //获取购物车中的信息  ---end

                        }
                    });
                }
            });
        });
    }
    function initial_btn(){
        //加的效果
        $(".add").click(function(){
            var n=$(this).prev().val();
            if($(this).attr("title")==n ){
                $(this).attr("disabled",true);
                myalert("兄弟，我是有上限滴！");
                return;
            }
            var num=parseInt(n)+1;
            $(this).prev().val(num);
            var dishId=$(this).parent().parent().parent().parent().val();
            console.log("dish id = "+dishId+'  即将加入购物车');
            change_dish_num(dishId,add_dish_num);
            UTPrice();
            // UAprice();

        });
        //减的效果
        $(".dec").click(function(){
            var n=$(this).next().val();
            var num=parseInt(n)-1;
            if($(this).next().next().attr("title")>num){
                $(this).attr("disabled",false);
            }
            $(this).next().val(num); //写
            var dishId=$(this).parent().parent().parent().parent().val();
            console.log("dish id = "+dishId+'  即将加入购物车');
            if(num==0){
                delete_dish(dishId);
                $(this).parent().parent().parent().parent().addClass("hidden");

            }
            else{
                change_dish_num(dishId,dec_dish_num);
                UTPrice();
            }

        });

        $(".bar").click(function(){
            console.log("当前id="+current_dishID);
            current_dishID=$(this).val();
            console.log("跳转之前点击的current_dishID="+current_dishID);
            //获取父亲页面的元素
            var header_main = window.parent.document.getElementsByClassName('header_main');
            $(header_main).attr('id',current_dishID);
            window.location.href="../dishes/dishes.jsp";
        });


    }
    $(document).ready(function(){
        console.log("document.ready开始执行");
        // clean_active();
        //加载侧边栏的菜系列表
        $.ajax({
            url: "http://192.168.1.180:8080/dish/list_type.do",
            xhrFields: {           withCredentials: true       },
            crossDomain: true,
            type : "POST",
            dataType: "json",
            error : function(xhr, status, error) {
                console.info(JSON.stringify(xhr));
            },
            success : function(list_type) {
                if(list_type.status=='1'){
                    console.log("菜系列表状态异常");
                    return;
                }
                console.log("菜系列表可成功访问");
                dishes_length=list_type.data.length;
                dishes_list=list_type.data;
                console.log("菜系列表长度为"+dishes_length);
                for(var i=0;i<dishes_length;i++){
                    var dish=dishes_list[i];
                    // console.log(dish.dishTypeId+';'+dish.typeName);
                    var html='<li class="bar" value='
                        + dish.dishTypeId
                        + '><a>'
                        + dish.typeName
                        + '</a></li>';
                    $("#sideBar ul").append(html);

                }
                initial_btn();
                console.log("is_login="+is_login);
                // if(is_login==0){ //表明未登录
                //
                // }
            }
        });

        get_curren_order_status();//获取当前订单的详情，主要取订单状态
        //获取购物车中的信息 ---start
        $.ajax({
            url: "http://192.168.1.180:8080/cart/list.do",
            xhrFields: {           withCredentials: true       },
            crossDomain: true,
            type: "POST",
            dataType: "json",
            error: function (xhr, status, error) {
                console.info(JSON.stringify(xhr));
            },
            success: function (car_obj) {
                if (car_obj.status == '1') {
                    console.log("购物车状态异常");
                    return;
                }
                car_dish_list = car_obj.data.cartDishVoList;
                console.log("car_dish_list.length=" + car_dish_list.length);
                if(car_dish_list.length==0){
                    $(".up_order").addClass("hidden");
                    $("#empty_tips").removeClass("hidden");
                    $("#empty_tips p").html("购物车空空如也，赶快去点菜吧！(*^__^*) 嘻嘻……");
                }
                else{
                    $(".up_order").removeClass('hidden');
                    create_order();
                    // clear_car();
                    for(var i=0;i<car_dish_list.length;i++){
                        var dish=car_dish_list[i];
                        Up_car_list(dish);
                    }
                    var cartTotalPrice=car_obj.data.cartTotalPrice;
                    $("#all_price").val(cartTotalPrice);
                    var cartDiscountPrice = car_obj.data.cartDiscountPrice;
                    $("#pre_price").val(cartDiscountPrice);

                    //判断是否有餐位信息
                    is_addedSeat=car_obj.data.addedSeat;

                }
                initial_btn();
            }
        });
    });

</script>
<script type="text/javascript" src="${ctx}/js/pb.js"></script>
</body>
</html>
