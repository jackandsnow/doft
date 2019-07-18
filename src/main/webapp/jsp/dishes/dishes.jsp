<%--
  Created by IntelliJ IDEA.
  User: wangxue
  Date: 18/3/12
  Time: 下午4:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:ser var = "ctx" value="${pageContext.request.contextPath}"/>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>指尖上的美味</title>
    <link rel="stylesheet" href="${ctx}/resource/css/bootstrap.min.css" >
    <!--<link rel="stylesheet" href="../resource/css/jquery-ui.min.css"-->
    <link rel="stylesheet" href="${ctx}/css/common.css">
    <link rel="stylesheet" href="${ctx}/css/dishes/dishes.css">
    <link rel="stylesheet" href="${ctx}/css/pagination.css">
    <script type="text/javascript" src="${ctx}/resource/js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="${ctx}/resource/js/bootstrap.js"></script>
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
            color:#fb9100;
            border:1px solid #f8f8f8;
            text-align: center;
            line-height: 2rem;
            display:inline-block;
            padding-bottom:20px;
            border-radius:10px;
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
    <div id="sideBar">
        <ul class="nav  nav-stacked">
            <%--<li  value="0" class="bar" ><a href="#">日本菜</a></li>--%>
        </ul>
    </div>
</div>
<div id="contain">
    <div class="filter hidden">
        <button class="btn text_btn" id="dish_sort_null">默认</button>
        <button class="text_btn btn" id="dish_sort_rec">推荐</button>
        <button class="text_btn btn" id="dish_sort_price">价格</button>
        <button class="text_btn btn" id="dish_sort_pre">优惠</button>
    </div>
    <div id="empty_tips" class="hidden">
        <p></p>
    </div>
    <div class="dish_list">
        <ul>
        </ul>
    </div>
    <div class="page_wrapper">
        <ul class="pagination">
        </ul>
    </div>
    <script type="text/javascript" src="${ctx}/js/common_func.js"></script>
    <script type="text/javascript " src="${ctx}/js/common_dish_pb_order.js"></script>

    <script>
        var dish_list; //菜品列表
        var dish_length;  //    菜品长度
        /*全局数据*/
        var currentPage; //current page index
        var newId; // messageId
        var pageSize = 6; //6 news a page
        var pageTotal; //页总数
        var dishTotal;
        var search_dish_name;
        var dish_sort_order_by;
        var dish_sort_up_down;
        function initial_num(){
            currentPage=1;
            pageTotal=1;
            dish_sort_order_by='';
            dish_sort_up_down = '';
        }

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
                return;
            });
            $("#msg_cancel").click(function(){
                return false;
            });
            $("#msg_sure").click(function(){
                return true;
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
                    if(responsedObj.status!='0'){
                        console.log("购物车状态异常");
                        return;
                    }
                    // console.log("该菜品加入购物车成功！");
                    change_car_num();
                    $(".addtoPB_e").click(function(){
                        $(this).prev().removeClass("hidden");
                        $(this).addClass("hidden");
                    });
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
                    if (car.status != '0') {
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
                            car_dish_list=car_obj.data.cartDishVoList;
                            // console.log("car_dish_list.length="+car_dish_list.length);
                            // 更新顶部购物车内的菜品数量
                            var html = car_dish_list.length;
                            // console.log("提交订单按钮 ：html = car_dish_list.length="+html);
                            var num = window.parent.document.getElementsByClassName("num_dish_in_car");
                            $(num).html(html);
                            if(html==0){
                                console.log(" html ===0 !!!!");
                                // console.log("car_num="+nnum);
                                // $(".num_dish_in_car").css("display",'none');
                                $(".num_dish_in_car").hide();
                            }
                            else{
                                // $(".num_dish_in_car").css("display",'block');
                                $(".num_dish_in_car").show();
                                // $("#num_dish_in_car").innerHTML(car_dish_list.length);
                            }

                            // //判断是否有餐位信息
                            // is_addedSeat=car_obj.data.addedSeat;
                            // if(is_addedSeat){
                            //     console.log("购物车中有餐位信息");
                            //     $('.button_up').attr("disabled",false);
                            // }
                            // else{
                            //     $(".set_time").append("提交订单前，请选择餐位信息！");
                            //     $('.button_up').attr("disabled",true);
                            // }
                        }
                    });
                    //获取购物车中的信息  ---end

                }
            });

        }

        function change_car_num(){
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
                    // console.log("购物车状态="+car_obj.status);
                    if(car_obj.status!='0'){
                        console.log("购物车状态异常");
                        return;
                    }
                    car_dish_list=car_obj.data.cartDishVoList;
                    // console.log("car_dish_list.length="+car_dish_list.length);
                    var html = car_dish_list.length;
                    // console.log("var html = car_dish_list.length"+html);
                    var num = window.parent.document.getElementsByClassName("num_dish_in_car");
                    $(num).html(html);
                    if(html=='0' || html== 0 ){
                        // console.log("数量==0");
                        // $(".num_dish_in_car").css("display",'none');
                        $(".num_dish_in_car").hide();
                    }
                    else{
                        // $(".num_dish_in_car").css("display",'block');
                        $(".num_dish_in_car").show();
                    }



                }
            });
            //获取购物车中的信息  ---end


        }

        //初始化加入购物车按钮
        function pb_btn(){
            // console.log("pb_btn开始执行");
            var nArry = document.getElementsByClassName("num");
            var pbArry = document.getElementsByClassName("pb_num");
            // console.log(nArry.length);
            // console.log(pbArry.length);
            // console.log(nArry[i].value, typeof nArry[i].value);
            for(var i=0;i<nArry.length;i++){
                // console.log("开始执行【加入购物车】的隐藏或显示");
                // console.log("num="+nArry[i].value);
                if(nArry[i].value == 0){

                    $(pbArry[i]).addClass("hidden");
                    $(pbArry[i]).next().removeClass("hidden");
                }
                else{
                    $(pbArry[i]).next().addClass("hidden");
                    $(pbArry[i]).removeClass("hidden");

                }
            }
        }
        // 清楚所有bar的active-class
        function clean_active(){
            for(var i=0;i<bar.length;i++){
                if($(bar[i]).hasClass('active')){
                    $(bar[i]).removeClass('active');
                }
            }
            // console.log("加载工作已经执行完成");
            // $(bar[current_bar]).addClass("active");
        }

        // 在页面中加载指定的菜品
        function Upadd_dish(dish){
            var dish_num_in_car=0;
            // console.log("upadd car_dish_list.length="+car_dish_list.length);
            for(var i=0;i<car_dish_list.length;i++){
                // console.log("DB id = " + car_dish_list[i].dishId + "   dish id = " + dish.dishId);
                if(car_dish_list[i].dishId==dish.dishId){
                    dish_num_in_car+=car_dish_list[i].quantites;
                }
            }
            var discountble='';
            if(dish.discountble){
                discountble="8折优惠";
            }
            var recommend_num = parseFloat(dish.recommendIndex).toFixed(1);
            // console.log("dish_num_in_car="+dish_num_in_car);
            var html1 = '<li value='+dish.dishId+'>\n' +
                '                <div class="dish">\n' +
                '                    <div class="dish_img">\n' +
                '                        <img src='+ dish.dishImgUrl+'>\n' +
                '                    </div>\n' +
                '                    <div class="dish_inf">\n' +
                '                        <div class="dish_inf_name">\n' +
                '                            <p>'+ dish.dishName+'</p>\n' +
                '                        </div>\n' +
                 '                         <div class="dish_inf_money_and_recommand">\n' +
                '                            <div class="dish_inf_money">\n' +
                '                                <p>￥<span>'+ dish.price+'</span></p>\n' +
                '                            </div>\n' +
                '                            <div class="dish_inf_recommand">\n' +
                '                                <p>'+ discountble +'</p>\n' +

                '                            </div>\n' +
                '                        </div>\n' +
                '                        <div class=" dish_inf_dec">\n' +
                '                            <p>推荐指数：'+ recommend_num+'</p>\n' +

                '                            <!--<p>这里显示有多少颗星星</p>-->\n' +
                '                        </div>'+
                    '</div>'+
                ' <div class="dish_add_pb">\n' +
                '                        <div class="pb_num ">\n' +
                '                            <em class="dec">-</em>\n' +
                '                            <input type="text" value='
                + dish_num_in_car
                +' class="num" readonly="readonly"/>\n' +
                '                            <em class="add" title='+dish.totalNumber+'>+</em>\n' +
                '                        </div>\n' +
                '                        <button class="com_btn addtoPB addtoPB_e">加入购物车</button>\n' +
                '                    </div></div>\n' +
                '            </li>';
            $(".dish_list ul").append(html1);
        }
        // 初始化button效果以及button点击效果
        function initial_btn_center(){
            $(".addtoPB").click(function(){
                var headBar = window.parent.document.getElementsByClassName('headBar');
                is_login = $(headBar).attr('id');
                console.log("is_login="+is_login);
                if(is_login==1){
                    var n=$(this).prev().children()[1];
                    // console.log(n.value);
                    n.value++;
                    // console.log(n.value);
                    $(n).val(n.value);
                    $(this).prev().removeClass("hidden");
                    $(this).addClass("hidden");
                    var dishId=$(this).parent().parent().parent().val();
                    // console.log("dish id = "+dishId+'  即将加入购物车');
                    change_dish_num(dishId,add_dish_num);
                }
                else{
                    window.open("${ctx}/jsp/login/login.jsp","mainFrame");
                    // myalert("加入购物车前，请登录！");
                }


            });
            //加的效果
            $(".add").click(function(){
                var n=$(this).prev().val(); //获取当前窗口显示的数据
                if($(this).attr("title")==n){
                    $(this).attr("disabled",true);
                    myalert("兄弟，我是有上限滴！");
                    return;
                }
                var num=parseInt(n)+1;
                $(this).prev().val(num);
                // if(num==0){ return;}
                var dishId=$(this).parent().parent().parent().parent().val();
                // console.log("dish id = "+dishId+';数量='+dish_num);
                // console.log("dish id = "+dishId+'  即将加入购物车');
                change_dish_num(dishId,add_dish_num);

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
                // console.log("dish id = "+dishId+';数量='+dish_num);
                // console.log("dish id = "+dishId+'  即将减出购物车');
                if(num==0){
                    delete_dish(dishId);
                    $(this).parent().addClass("hidden");
                    $(this).parent().next().removeClass("hidden");
                }
                else{
                    change_dish_num(dishId,dec_dish_num);
                }

            });
        }
        function initial_btn_sort(){
            console.log("initial_btn_sort 开始执行！");
            $("#dish_sort_null").click(function(){
                 if(dish_sort_order_by == ''){ //当前已经是默认排序
                     myalert("亲，已经是默认排序了！");
                 }
                 else{
                     dish_sort_order_by = '';
                     dish_sort_up_down='desc'; //默认一定是 desc排序
                     // console.log("排序信息如下："+dish_sort_order_by+'，'+dish_sort_up_down);
                     $(".dish_list ul").empty();  //调用之前，先清空列表
                     currentPage = 1;
                     if(current_dishID == 0) { //需加载搜索列表
                         get_dish_list_by_search(search_dish_name,currentPage,pageSize,dish_sort_order_by,dish_sort_up_down);
                     }
                     else{
                         get_dish_list(current_dishID,currentPage,pageSize,dish_sort_order_by,dish_sort_up_down);
                     }
                 }
            });
            $("#dish_sort_rec").click(function(){  //按推荐指数排序
                if(dish_sort_order_by == "RECOMMEND_INDEX"){
                    if(dish_sort_up_down == 'desc'){
                        dish_sort_up_down = 'asc';
                    }
                    else if(dish_sort_up_down == 'asc'){
                        dish_sort_up_down ='desc';
                    }
                }
                else{ // 现在不是 按 推荐指数排序的
                    dish_sort_order_by = "RECOMMEND_INDEX";
                    dish_sort_up_down = 'desc'; //默认用降序

                }
                // console.log("排序信息如下："+dish_sort_order_by+'，'+dish_sort_up_down);
                $(".dish_list ul").empty();  //调用之前，先清空列表
                currentPage = 1;
                if(current_dishID == 0){
                    get_dish_list_by_search(search_dish_name,currentPage,pageSize,dish_sort_order_by,dish_sort_up_down);
                }
                else{
                    get_dish_list(current_dishID,currentPage,pageSize,dish_sort_order_by,dish_sort_up_down);
                }
            });

            $("#dish_sort_price").click(function(){  //按价格排序
                if(dish_sort_order_by == 'PRICE'){
                    if(dish_sort_up_down == 'desc'){
                        dish_sort_up_down = 'asc';
                    }
                    else if(dish_sort_up_down == 'asc'){
                        dish_sort_up_down ='desc';
                    }
                }
                else{
                    dish_sort_order_by = "PRICE";
                    dish_sort_up_down = 'asc';
                }
                // console.log("排序信息如下："+dish_sort_order_by+'，'+dish_sort_up_down);
                $(".dish_list ul").empty();  //调用之前，先清空列表
                currentPage = 1;
                if(current_dishID==0){
                    get_dish_list_by_search(search_dish_name,currentPage,pageSize,dish_sort_order_by,dish_sort_up_down);
                }
                else{
                    get_dish_list(current_dishID,currentPage,pageSize,dish_sort_order_by,dish_sort_up_down);
                }
            });
            $("#dish_sort_pre").click(function(){
                if(dish_sort_order_by == 'IS_BARGAIN_FLAG'){
                    myalert("亲，已经是优惠排序了！");
                }
                else{
                    dish_sort_order_by = "IS_BARGAIN_FLAG";
                    dish_sort_up_down = 'desc';
                    // console.log("排序信息如下："+dish_sort_order_by+'，'+dish_sort_up_down);
                    $(".dish_list ul").empty();  //调用之前，先清空列表
                    currentPage = 1;
                    if(current_dishID == 0){
                        get_dish_list_by_search(search_dish_name,currentPage,pageSize,dish_sort_order_by,dish_sort_up_down);
                    }
                    else{
                        get_dish_list(current_dishID,currentPage,pageSize,dish_sort_order_by,dish_sort_up_down);
                    }
                }
            });

        }
        function initial_btn_bar(){
            // console.log("initial_btn 开始执行！");
            $(".bar").click(function(){
                if(!$(this).hasClass('active')){
                    // console.log("本来没有class");
                    clean_active();
                    $(this).addClass('active');
                    if($(this).hasClass('active')){
                        // console.log("现在有class了");
                    }
                    initial_num();
                    $(".dish_list ul").empty();
                    current_dishID=$(this).val();
                    // 请求button菜系对应的菜品
                    // console.log("排序信息如下："+dish_sort_order_by+'，'+dish_sort_up_down);
                    get_dish_list(current_dishID,currentPage,pageSize,dish_sort_order_by,dish_sort_up_down);

                }
            });
        }
        function get_dish_list_by_search(search_dish_name,currentPage,pagesize,order_by,up_down){
            // 根据输入值 进行搜索
            $.ajax({
                url: "http://192.168.1.180:8080/dish/search.do?",
                xhrFields: {           withCredentials: true       },
                crossDomain: true,
                type : "POST",
                dataType: "json",
                data:{"dishName":search_dish_name,"pageNum":currentPage,"pageSize":pagesize,"orderBy":order_by,"order":up_down},
                error : function(xhr, status, error) {
                    console.info(JSON.stringify(xhr));
                },
                success : function(responesObj) {
                    if (responesObj.status != '0') {
                        console.log("搜索结果异常！");
                    }
                    else {
                        // console.log("搜索成功！");
                        initial_btn_bar();
                        // console.log(respondeObj);
                        dish_length = responesObj.data.size;
                        dish_list = responesObj.data.list;
                        // console.log("currentPage=" + currentPage);
                        if (dish_length == 0) {
                            $("#empty_tips").removeClass("hidden");
                            $("#empty_tips p").html("暂无相关菜品，看看别的吧！");
                            console.log("dish 列表为空！");
                        }
                        else {
                            $(".filter").removeClass('hidden');
                            for (var i = 0; i < dish_length; i++) {
                                Upadd_dish(dish_list[i]);

                            }
                            pb_btn();
                            initial_btn_center();
                            pageTotal = responesObj.data.pages;
                            currentPage = responesObj.data.pageNum;
                            initPage($(".pagination "), currentPage, pageTotal);
                            addDishPageEvent();
                            // dishTotal=respondeObj.data.size;
                            // dish_length=dishes.data.size;

                        }
                    }
                }

            });
        }
        function get_dish_list(typeid,curPage,paSize,order_by,up_down) {
            $.ajax({
                url: "http://192.168.1.180:8080/dish/list.do",
                xhrFields: {           withCredentials: true       },
                crossDomain: true,
                type : "POST",
                data :{"dishTypeId":typeid,"pageNum":curPage,"pageSize":pageSize,"orderBy":order_by,"order":up_down},
                dataType: "json",
                error : function(xhr, status, error) {
                    console.info(JSON.stringify(xhr));
                },
                success : function(respondeObj) {
                    if(respondeObj.status==1){
                        console.log("菜系状态异常");
                        return;
                    }

                    initial_btn_bar();
                    // console.log(respondeObj);
                    dish_length=respondeObj.data.size;
                    dish_list=respondeObj.data.list;
                    // console.log("currentPage="+currentPage);
                    if(dish_length==0){
                        console.log("dish 列表为空！");
                        $("#empty_tips").removeClass("hidden");
                        $("#empty_tips p").html("暂无相关菜品，看看别的吧！");
                    }
                    else{
                        $("#empty_tips").addClass('hidden');
                        $(".filter").removeClass('hidden');
                        for(var i=0;i<dish_length;i++){
                            Upadd_dish(dish_list[i]);

                        }
                        pb_btn();
                        initial_btn_center();
                        pageTotal = respondeObj.data.pages;
                        currentPage = respondeObj.data.pageNum;
                        initPage($(".pagination ") ,currentPage  ,pageTotal );
                        addDishPageEvent();
                        // dishTotal=respondeObj.data.size;
                        // dish_length=dishes.data.size;

                    }


                    // if(!(dishTotal>pageSize)){
                    //     $(".pagination ").addClass('hidden');
                    //     return;
                    // }
                    // else{
                    //     $(".pagination ").removeClass('hidden');
                    // }
                    /*当前页*/


                }
            });
        }

        function load_dishType(typeid){
            $.ajax({
                url: "http://192.168.1.180:8080/dish/list_type.do",
                // url: "http://192.168.1.180:8080/dish/list_type.do",
                xhrFields: {           withCredentials: true       },
                crossDomain: true,
                type : "POST",
                dataType: "json",
                // jsonp:"jsonpCallback",
                error : function(xhr, status, error) {
                    console.info(JSON.stringify(xhr));
                },
                success : function(list_type) {
                    if(list_type.status=='1'){
                        console.log("菜系列表状态异常");
                        return;
                    }
                    initial_btn_bar();
                    initial_btn_sort();
                    // console.log("菜系列表可成功访问");
                    dishes_length=list_type.data.length;
                    dishes_list=list_type.data;
                    // console.log("菜系列表长度为"+dishes_length);
                    for(var i=0;i<dishes_length;i++){
                        var dish=dishes_list[i];
                        // console.log(dish.dishTypeId+';'+dish.typeName);
                        var html='<li class="bar" value='
                            + dish.dishTypeId
                            + '><a href="#">'
                            + dish.typeName
                            + '</a></li>';
                        // if(typeid=='undefined')typeid=1;
                        $("#sideBar ul").append(html);
                        if(dish.dishTypeId==typeid){
                            // console.log("当前选择的bar是："+i);
                            $(bar[i]).addClass('active');
                        }
                    }
                    // console.log("即将加载id为"+current_dishID+"的菜系");
                    // console.log("！！！在加载dishTP列表时，current_dishID = "+current_dishID);
                    if(current_dishID == 0 ){ //显示搜索结果
                        initial_btn_bar(); //可能不需要
                        // 获取输入窗口的值
                        var search_input = window.parent.document.getElementById('search_input');
                        var input_value = $(search_input).val();
                        search_dish_name = input_value;
                        // console.log("input_value="+input_value);
                        $(search_input).val("");//清空输入栏中的文字
                        // 根据输入值 进行搜索
                        get_dish_list_by_search(search_dish_name,currentPage,pageSize,dish_sort_order_by,dish_sort_up_down);
                    }
                    else{
                        // console.log("排序信息如下："+dish_sort_order_by+'，'+dish_sort_up_down);
                        get_dish_list(current_dishID,currentPage,pageSize,dish_sort_order_by,dish_sort_up_down);
                    }

                    // // 默认选择第二项菜系
                    // current_bar=document.getElementsByClassName('bar')[1];
                    // $(current_bar).addClass('active');
                }
            });
        }


        $(document).ready(function(){
            // console.log("ready(function)开始执行,curren_dishID="+current_dishID);
            initial_num();
            var num = window.parent.document.getElementsByClassName("num_dish_in_car");
            var num_dish_in_car= $(num).html();
            console.log('num_dish_in_car='+num_dish_in_car);
            if(num_dish_in_car == '0' || num_dish_in_car == 0){
                // $(".num_dish_in_car").css("display",'none');
                $(".num_dish_in_car").hide();
            }
            var header_main = window.parent.document.getElementsByClassName('header_main');
            current_dishID=$(header_main).attr('id');
            // console.log("加载列表前,curren_dishID="+current_dishID);
            load_dishType(current_dishID);
            change_car_num();


        });
    </script>
</div>
</body>
</html>