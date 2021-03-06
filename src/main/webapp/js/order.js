/*全局变量*/
//订单号
var orderNo = 0 ;
//订单支付状态
var payFlag = false;
//订单取消状态
var cancleFlag = false ;
//显示状态
var showFlag = true;
//支付样式 1:支付宝   0:余额
var payType = 1 ;
//控制ajax执行顺序
var detailAjax ;
var payStatusAjax ;
var changeOrderStatusAjax;
var orderPayAjax;
$(document).ready(function () {
    //用setInterval  3s请求一次后台，更新订单状态
    /*var timer = setInterval(" changeOrderStatusFun() ", 3000);
    if(payFlag == true){
        clearInterval(timer);
    }*/
    /*加载订单详情界面*/
    orderDetailFun();
    payToggle();
});

/*订单详情*/
function  orderDetailFun() {
    detailAjax = $.ajax({
        url:"http://192.168.1.180:8080/doft/order/detail.do" ,
        xhrFields: {           withCredentials: true       },
        crossDomain: true,
        type: "POST" ,
        dataType:"json" ,
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
/*支付订单*/
function orderPayFun() {
    //console.log("订单号12:"+orderNo);
    orderPayAjax =  $.ajax({
        url: "http://192.168.1.180:8080/doft/order/pay.do" ,
        xhrFields: {withCredentials: true},
        crossDomain: true,
        type: "POST",
        dataType: "json",
        data: {"orderNo":orderNo ,"paymentType" : payType},
        error: function (xhr, status, error) {
            console.info(JSON.stringify(xhr));
        },
        success: function (responseObj) {
            if (responseObj.status == '1') {
                console.log("支付异常");
                return;
            }
            var payUrl = responseObj.data.qrUrl ;
            var payImg ='<img src='+ payUrl+' alt="扫码付款" title="扫一扫" />';
            //console.log("付款码地址"+payUrl);
            $("#pay_img").append(payImg);
        }
    })
}
/*去付款按钮*/
function payToggle(){
    $(".function_btn3 ").click(function () {
        payStatusFun();
        changeOrderStatusFun();
        $.when(payStatusAjax).done(function (){
            if($("#pay_box ").is(':hidden')){
                /*当支付未完成时*/
                //console.log("payFlag = " + payFlag);
                if(payFlag == false){
                    /*弹出支付框*/
                    $("#hide_box ,#pay_box ").show();
                    /*当未调用支付接口时*/
                    if($("#pay_img img").length == 0){
                        /*调用支付接口 弹出二维码*/
                        orderPayFun();
                    }
                    $.when(orderPayAjax).done(function (){
                        showFlag = true ;
                    });
                }
                else{   /*当支付完成时*/
                    // /*弹出提示框*/
                    // $(".function_btn3").click(function () {
                    //     myalert("支付已完成，谢谢支持！");
                    //     // console.log("!");
                    //  })
                }
            }
        });

        if (showFlag== true)
        {
            if( payFlag == false )
            {
                $("#hide_box ").click(function (){
                    payStatusFun();
                    $.when(payStatusAjax).done(function () {
                        if (payFlag == true) {
                            changeOrderStatusFun();
                        }
                        $(" #hide_box ,#pay_box ").hide();
                        showFlag = false;
                    });
                    // console.log("?");
                    /* mycomfire("支付未完成，确认取消支付吗？");*/

                    // console.log("showFlag:" + showFlag);
                });
            }
        }
        // console.log('showFlag='+showFlag);
    });
}

//弹出框 单选-确认
function myalert(e){
    $("body").append('<div id="msg"><div id="msg_top">提示<span class="msg_close">×</span></div><div id="msg_cont">'+e+'</div><div class="msg_close msg_clear" id=msg_sure>确定</div></div>');
    $("#msg").remove();
}
//弹出框 双选-确认、取消
function mycomfire(e){
    $("body").append('<div id="msg"><div id="msg_top">提示<span class="msg_close">×</span></div><div id="msg_cont">'+e+'</div><div class="msg_close msg_clear" id=msg_sure>确定</div><div class="msg_close msg_clear" id="msg_cancel">取消</div></div>');
    $(".msg_close").click(function () {
        $("#msg").remove();
    });
    $("#msg_sure").click(function() {
        $("#msg").remove();
        /*  $(" #hide_box ,#pay_box ").hide();
          showFlag =false;*/
    });
    $("#msg_cancel").click(function(){
        $("#msg").remove();
    });
}

//获取支付状态
function payStatusFun() {
    payStatusAjax = $.ajax({
        url: "http://192.168.1.180:8080/doft/order/query_order_pay_status.do" ,
        xhrFields: {withCredentials: true},
        crossDomain: true,
        type: "POST",
        dataType: "json",
        data: {"orderNo":orderNo},
        error: function (xhr, status, error) {
            console.info(JSON.stringify(xhr));
        },
        success: function (responseObj) {
            //console.log("支付成功");
            payFlag = responseObj.data;
            //console.log(payFlag);
        }
    });
}

//更新订单详情界面订单状态
function changeOrderStatusFun() {
    changeOrderStatusAjax = $.ajax({
        url:"http://192.168.1.180:8080/doft/order/detail.do" ,
        // url: "http://192.168.1.180:8080/cart/list.do",
        xhrFields: {           withCredentials: true       },
        crossDomain: true,
        type: "POST" ,
        dataType:"json" ,
        error:function (xhr, status, error) {
            console.info(JSON.stringify(xhr));
        },
        success:function (responseObj) {
            if(responseObj.status == '1'){
                console.log("订单详情异常");
                return ;
            }
            //获取订单状态
            var orderStatus = responseObj.data.orderStatusDesc ;
            //更新订单状态
            if(orderStatus == "已付款"){
                $("#order_status_p").text(orderStatus);
                $(".function_btn2").attr('disabled',true);
                $(".function_btn3").attr('disabled',true);
            }

        }
    });
}

