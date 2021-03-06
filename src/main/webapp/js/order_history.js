/*引入时间格式化处理js公共接口*/
/*$(document.body).append('<script src="./common_func.js"><\/script>');*/
/**************************************时间格式化处理************************************/

/*function dateFtt(fmt,date) { //author:
    var o = {
        "M+": date.getMonth() + 1,                 //月份
        "d+": date.getDate(),                    //日
        "h+": date.getHours(),                   //小时
        "m+": date.getMinutes(),                 //分
        "s+": date.getSeconds(),                 //秒
        "q+": Math.floor((date.getMonth() + 3) / 3), //季度
        "S": date.getMilliseconds()             //毫秒
    };
    if (/(y+)/.test(fmt))
        fmt = fmt.replace(RegExp.$1, (date.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt))
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}*/
/*历史订单全局数据*/
/*var orderId ;*/
var currentPage = 1; //current page index
/*var newId; // messageId*/
var pageSize = 8; //6 news a page
var pageTotal = 0; //页总数
//排序筛选器：默认（订单号）：“”；时间：CREATION_DATE ；价格:TOTAL_PRICE ； 状态: ORDER_STATUS
var orderBy = "" ;
// desc: 降序 ；asc:升序
var order = "" ;
//升序降序标志
var descFlag = true ;
$(document).ready(function(){
    // console.log("ready(function)开始执行");
    /*新增订单页*/
     //newOrderList();
    //排序
    orderSort();
});

/*新增订单页*/
function  newOrderList() {
    $.ajax({
        url: "http://192.168.1.180:8080/doft/order/list.do",
        xhrFields: {           withCredentials: true       },
        crossDomain: true,
        type : "POST",
        dataType: "json",
        data: {"pageNum":currentPage,"pageSize":pageSize,"orderBy":orderBy ,"order":order },
        error : function(xhr, status, error) {
            console.info(JSON.stringify(xhr));
        },
        success : function(responseObj) {
            if(responseObj.status=='1'){
                console.log("菜系列表状态异常");
                window.alert("暂无订单，请去点菜吧！");
                return;
            }
            /*这种情况是用户未登录时*/
            if(responseObj.data == null){
                $(".filter").hide();
                var tip ="亲，您还没有登录，赶快去登录吧！";
                var showMsg = '<p>'+tip+'</p> ';
                $(".none_order").append(showMsg);
                return ;
            }
            //console.log("菜系列表可成功访问");
            var orderList = responseObj.data.list;
            //console.log(orderList.length + "length");
            console.log("total:"+responseObj.data.total);
            if(orderList.length == 0){
                $(".filter").remove();
                var tip = "亲，您的历史订单空空如也,快去点餐留下您的足迹吧！";
                var showMsg = '<p>'+tip+'</p> ';
                $(".none_order").append(showMsg);
                return ;
            }
            $(".none_order").css("height 0 ; width 0; display none;");
            $(".none_order p").css("height 0 ; width 0; display none;");
            $(".none_order").remove(showMsg);
            if(responseObj.data.total != 0){
                for( var i=0 ; i <orderList.length ; i++ ){
                    var order = orderList[i];
                    var creationDate = order.creationDate;
                    var lastUpdatedDate =order.lastUpdatedDate;
                    var orderNo = order.orderNo;
                   // console.log(orderNo);
                    var orderStatus = order.orderStatusDesc;
                    var discountPrice = order.discountPrice;
                    var totalPrice = order.totalPrice - discountPrice;

                    var html = ' <li id='+orderNo+'>\n' +
                        '                <div class="order_title">\n' +
                        '                    <div class="round">\n' +
                        '                        <p>●</p>\n' +
                        '                    </div>\n' +
                        '                    <div class="order_no_time">\n' +
                        '                        <p  class="order_no">订单号: <span>'+orderNo +'</span></p>\n' +
                        '                        <p  class="order_time">'+ creationDate/*+lastUpdatedDate*/ +'</p>\n' +
                        '                    </div>\n' +
                        '                    <div class="order_status">\n' +
                        '                        <p>'+ orderStatus+'</p>\n' +
                        '                    </div>\n' +
                        '                    <div class="order_price">\n' +
                        '                        <p>￥<span>'+ totalPrice+'</span></p>\n' +
                        '                    </div>\n' +
                        '                    <div class="delete_btn">\n' +
                        '                        <button class="mybtn">删除</button>\n' +
                        '                    </div>\n' +
                        '                </div>\n' +
                        '            </li>';
                    $('.order_history ul').append(html);
                }
            }
            /*删除一条订单记录*/
            deleteOrder();
            /*总页数*/
            pageTotal = responseObj.data.pages;
           // console.log(pageTotal+"总页数");
            initPage($(".pagination ") ,currentPage  ,pageTotal );
           // console.log(currentPage+"当前页");
            addOrderPageEvent();
            // order click event wangxue
            OrderDetailEvent();
        }
    });
}

/**
 *  written by wangxue
 * @constructor
 */
function OrderDetailEvent() {
    $(".order_no span").click(function () {
        var orderNum = $(this).text();
        //console.log(orderNum);
        document.cookie = orderNum;
        window.open("order_detail.jsp","mainFrame");
    });
}

/*删除订单*/
function  deleteOrder() {
    $('.delete_btn').click(function () {
        /*var orderNo = $(this).siblings(".order_no_time").children(".order_no").children("span").text() ;*/
        var orderNo = $(this).parent().parent().attr("id");
        //console.log(orderNo+"订单号");
        // $(this).parent().parent().addClass("hidden");
        $.ajax({
            url: "http://192.168.1.180:8080/doft/order/delete.do",
            xhrFields: {           withCredentials: true       },
            crossDomain: true,
            type : "POST",
            dataType: "json",
            data:{"orderNo":orderNo},
            error : function(xhr, status, error) {
                console.info(JSON.stringify(xhr));
            },
            success : function (responseData) {
                //console.log("删除成功");
                if (responseData.status == '0') {
                    $(this).parent().parent().remove();
                    window.location.reload();
                    return ;
                }
                else{
                    window.alert("服务器忙，稍后！");
                }
            }
        });
    });
}


/*将数字转换为订单状态*/
/*
function  NumToStatusFun(num) {
    switch (num){
        case 1:
            return  "未付款" ;
        case 2:
            return  "已付款" ;
        case 3:
            return  "申请中" ;
        case 4:
            return  "已处理" ;
        case 5:
            return  "已完成" ;
        case 6:
            return  "已取消" ;
        default:
            return  "已完成" ;
    }
}*/
//排序函数
function orderSort() {
    $("#sort_default").click(function () {
        orderBy = "" ;
        //console.log("orderBy="+orderBy );
        //进行排序
        if($(".order_history ul").length > 0){
            $(".order_history ul ").empty();
        }
        newOrderList() ;
    });
    $("#sort_time").click(function () {
        orderBy = "CREATION_DATE" ;
        //console.log("orderBy="+orderBy );
        if(descFlag == true){
            order = "desc" ;
            descFlag = false ;
            //console.log("order="+order);
        }
        else {
            order = "asc" ;
            descFlag = true ;
            //console.log("order="+order);
        }
        //进行排序
        if($(".order_history ul").length > 0){
            $(".order_history ul ").empty();
        }
        newOrderList() ;
    });
    $("#sort_price").click(function () {
        orderBy = "TOTAL_PRICE" ;
        //console.log("orderBy="+orderBy );
        if(descFlag == true){
            order = "desc" ;
            descFlag = false ;
            //console.log("order="+order);
        }
        else{
            order = "asc" ;
            descFlag = true ;
            //console.log("order="+order);
        }
        //进行排序
        if($(".order_history ul").length > 0){
            $(".order_history ul ").empty();
        }
        newOrderList() ;
    });
    $("#sort_status").click(function () {
        orderBy = "ORDER_STATUS" ;
        //console.log("orderBy="+orderBy );
        if(descFlag == true){
            order = "desc" ;
            descFlag = false ;
            //console.log("order="+order);
        }
        else{
            order = "asc" ;
            descFlag = true ;
            //console.log("order="+order);
        }
        //进行排序
        if($(".order_history ul").length > 0){
            $(".order_history ul ").empty();
        }
        newOrderList() ;
    });
    //进行排序
    if($(".order_history ul").length > 0){
        $(".order_history ul ").empty();
    }
    newOrderList() ;
}