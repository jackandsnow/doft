<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/12
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%--%>
<%--List<String> list = new ArrayList<String>();--%>
<%--list.add("简单是可靠的先决条件");--%>
<%--list.add("兴趣是最好的老师");--%>
<%--list.add("知识上的投资总能得到最好的回报");--%>
<%--request.setAttribute("list", list);--%>
<%--%>--%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Delicious on Fingertips | User Requisition</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.7 -->
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="../../bower_components/font-awesome/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="../../bower_components/Ionicons/css/ionicons.min.css">
    <!-- DataTables -->
    <link rel="stylesheet" href="../../bower_components/datatables.net-bs/css/dataTables.bootstrap.min.css">
    <!--bootstrap table-->
    <link rel="stylesheet" href="../../bower_components/bootstrap-table-develop/bootstrap-table.css">
    <link rel="stylesheet" href="../../bower_components/bootstrap-table-develop/bootstrap-table.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="../../back-stage-dist/css/AdminLTE.min.css">
    <link rel="stylesheet" href="../../back-stage-dist/css/ordertable.css">
    <!-- iCheck -->
    <link rel="stylesheet" href="../../plugins/iCheck/flat/blue.css">
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet" href="../../back-stage-dist/css/skins/_all-skins.min.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <!--<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>-->
    <!--<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>-->
    <![endif]-->

    <!-- Google Font -->
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
    <link rel="stylesheet" href="../../back-stage-dist/css/skins/skin-green.css">
    <style>
        .example-modal .modal {
            position: relative;
            top: auto;
            bottom: auto;
            right: auto;
            left: auto;
            display: block;
            z-index: 1;
        }

        .example-modal .modal {
            background: transparent !important;
        }

        .modal-dialog{
            width: 70%;
        }
    </style>
</head>
<body class="hold-transition skin-black sidebar-mini">
<div class="wrapper">

    <header class="main-header">
        <!-- Logo -->
        <a href="../orderManage/order-list-limit.jsp" class="logo logo-blue">
            <!-- mini logo for sidebar mini 50x50 pixels -->
            <span class="logo-mini"><b>DOFT</b></span>
            <!-- logo for regular state and mobile devices -->
            <span class="logo-lg"><img src="../../back-stage-dist/img/login/doft_logo.png" class="login-doft-logo" alt="User Image">  点餐管理系统</span>
        </a>
        <!-- Header Navbar: style can be found in header.less -->
        <nav class="navbar navbar-static-top">
            <!-- Sidebar toggle button-->
            <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>

            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                    <!-- Messages: style can be found in dropdown.less-->
                    <li class="dropdown messages-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="fa fa-envelope-o"></i>
                            <!--<span class="label label-success">4</span>-->
                        </a>
                        <!--<ul class="dropdown-menu">-->
                        <!--<li class="header">你有4条新信息</li>-->
                        <!--<li>-->
                        <!--&lt;!&ndash; inner menu: contains the actual data &ndash;&gt;-->
                        <!--<ul class="menu">-->
                        <!--<li>&lt;!&ndash; start message &ndash;&gt;-->
                        <!--<a href="#">-->
                        <!--<div class="pull-left">-->
                        <!--<img src="../../back-stage-dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">-->
                        <!--</div>-->
                        <!--<h4>-->
                        <!--Johnny Mac-->
                        <!--<small><i class="fa fa-clock-o"></i> 5 mins</small>-->
                        <!--</h4>-->
                        <!--<p>下了新的订单</p>-->
                        <!--</a>-->
                        <!--</li>-->
                        <!--&lt;!&ndash; end message &ndash;&gt;-->
                        <!--<li>-->
                        <!--<a href="#">-->
                        <!--<div class="pull-left">-->
                        <!--<img src="../../back-stage-dist/img/user3-128x128.jpg" class="img-circle" alt="User Image">-->
                        <!--</div>-->
                        <!--<h4>-->
                        <!--Maven Miller-->
                        <!--<small><i class="fa fa-clock-o"></i> 2 hours</small>-->
                        <!--</h4>-->
                        <!--<p>提出取消订单申请</p>-->
                        <!--</a>-->
                        <!--</li>-->
                        <!--<li>-->
                        <!--<a href="#">-->
                        <!--<div class="pull-left">-->
                        <!--<img src="../../back-stage-dist/img/user4-128x128.jpg" class="img-circle" alt="User Image">-->
                        <!--</div>-->
                        <!--<h4>-->
                        <!--Shelli Cyrus-->
                        <!--<small><i class="fa fa-clock-o"></i> Today</small>-->
                        <!--</h4>-->
                        <!--<p>提出加菜申请</p>-->
                        <!--</a>-->
                        <!--</li>-->
                        <!--<li>-->
                        <!--<a href="#">-->
                        <!--<div class="pull-left">-->
                        <!--<img src="../../back-stage-dist/img/user3-128x128.jpg" class="img-circle" alt="User Image">-->
                        <!--</div>-->
                        <!--<h4>-->
                        <!--Cody Neverland-->
                        <!--<small><i class="fa fa-clock-o"></i> Yesterday</small>-->
                        <!--</h4>-->
                        <!--<p>下了新的订单</p>-->
                        <!--</a>-->
                        <!--</li>-->
                        <!--</ul>-->
                        <!--</li>-->
                        <!--<li class="footer"><a href="#">查看所有新消息</a></li>-->
                        <!--</ul>-->
                    </li>
                    <!-- Notifications: style can be found in dropdown.less -->
                    <li class="dropdown notifications-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="fa fa-bell-o"></i>
                            <span id="new-notice-num-title" class="label label-warning">0</span>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="header">你有<span id="new-notice-num-top">0</span>条新通知</li>
                            <li>
                                <!-- inner menu: contains the actual data -->
                                <ul id="new-notice" class="menu"></ul>
                            </li>
                            <li class="footer"><a href="#">以上为所有新通知</a></li>
                        </ul>
                    </li>
                    <!-- Tasks: style can be found in dropdown.less -->
                    <li class="dropdown tasks-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="fa fa-flag-o"></i>
                            <span id="new-task-num-title" class="label label-danger">0</span>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="header">你有<span id="new-task-num-top">0</span>项任务</li>
                            <li>
                                <!-- inner menu: contains the actual data -->
                                <ul id="new-task" class="menu">
                                </ul>
                            </li>
                            <li class="footer">
                                <a href="#">以上为所有任务</a>
                            </li>
                        </ul>
                    </li>
                    <!-- User Account: style can be found in dropdown.less -->
                    <li class="dropdown user user-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <img src="../../back-stage-dist/img/user2-160x160.jpg" id="userHeadUrl2" class="user-image" alt="User Image">
                            <span class="hidden-xs" id="userName2"></span>
                        </a>
                        <ul class="dropdown-menu">
                            <!-- User image -->
                            <li class="user-header">
                                <img src="../../back-stage-dist/img/user2-160x160.jpg" id="userHeadUrl3" class="img-circle" alt="User Image">

                                <p>
                                    <span id="userName3"></span> - <span id="roleName"></span>
                                    <small>注册自<span id="creationTime"></span></small>
                                </p>
                            </li>
                            <!-- Menu Body -->
                            <!--<li class="user-body">-->
                            <!--<div class="row">-->
                            <!--<div class="col-xs-4 text-center">-->
                            <!--<a href="#">已处理订单</a>-->
                            <!--</div>-->
                            <!--<div class="col-xs-4 text-center">-->
                            <!--<a href="#">已处理申请</a>-->
                            <!--</div>-->
                            <!--<div class="col-xs-4 text-center">-->
                            <!--<a href="#">历史通知</a>-->
                            <!--</div>-->
                            <!--</div>-->
                            <!--&lt;!&ndash; /.row &ndash;&gt;-->
                            <!--</li>-->
                            <!-- Menu Footer-->
                            <li class="user-footer">
                                <div class="pull-left">
                                    <a href="#" class="btn btn-default btn-flat">个人主页</a>
                                </div>
                                <div class="pull-right">
                                    <button type="button" id="log-out-btn" class="btn btn-default btn-flat">退出</button>
                                </div>
                            </li>
                        </ul>
                    </li>
                    <!-- Control Sidebar Toggle Button -->
                </ul>
            </div>
        </nav>
    </header>
    <!-- Left side column. contains the logo and sidebar -->
    <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
            <!-- Sidebar user panel -->
            <div class="user-panel">
                <div class="pull-left image">
                    <img id="userHeadUrl" src="../../back-stage-dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
                </div>
                <div class="pull-left info">
                    <p id="userName"></p>
                    <a href="#" id="is-online"></a>
                </div>
            </div>
            <ul class="sidebar-menu" data-widget="tree">
                <li class="header">MAIN FUNCTIONS</li>
                <li class="treeview active">
                    <a href="#">
                        <i class="fa fa-sticky-note"></i> <span>订单管理</span>
                        <span class="pull-right-container">
                             <i class="fa fa-angle-left pull-right"></i>
                        </span>
                    </a>
                    <ul class="treeview-menu">
                        <li id="orderListSearch"><a href="../orderManage/order-list-limit.jsp"><i class="fa fa-circle-o"></i> 订单列表</a></li>
                        <li><a href="../orderManage/user-apply-list-limit.jsp"><i class="fa fa-circle-o"></i> 用户申请列表</a></li>
                    </ul>
                </li>
                <!--<li><a href="#"><i class="fa fa-circle-o text-yellow"></i> <span>Warning</span></a></li>-->
                <!--<li><a href="#"><i class="fa fa-circle-o text-aqua"></i> <span>Information</span></a></li>-->
            </ul>
        </section>
        <!-- /.sidebar -->
    </aside>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                用户申请列表
                <small>用户申请列表内容已经更新</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
                <li><a href="../orderManage/order-list-limit.jsp">订单管理</a></li>
                <li class="active">用户申请列表</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">

            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <!--<h3 class="box-title">This is the box header</h3>-->
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body mailbox-messages">
                            <table id="table"></table>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
                </div>
                <!-- /.col -->
            </div>
            <!-- /.row -->
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <footer class="main-footer">
        <div class="pull-right hidden-xs">
            <b>Version</b> 1.0.0
        </div>
        <strong>Copyright &copy; 2014-2016 <span>逆袭潮湿地气小组</span>. </strong> All rights
        reserved.
    </footer>

</div>
<!-- ./wrapper -->

<!-- jQuery 3 -->
<script src="../../bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="http://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="../../bower_components/bootstrap-table-develop/bootstrap-table.js"></script>
<!-- DataTables -->
<script src="../../bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="../../bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<script src="../../bower_components/bootstrap-table-develop/bootstrap-table-zh-CN.js"></script>
<!-- SlimScroll -->
<script src="../../bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="../../bower_components/fastclick/lib/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="../../back-stage-dist/js/adminlte.min.js"></script>
<!-- page script -->
<!-- iCheck -->
<script src="../../plugins/iCheck/icheck.min.js"></script>
<!-- Page Script -->
<script src="../../js/common_func.js"></script>
<script>
    $(document).ready(function () {
        $.ajax({
            type: 'post',
            url: "http://192.168.1.180:8080/doft/manage/requisition/getAllRequisitions.aj",
            dataType: 'json',
            xhrFields:{
                withCredentials:true
            },
            crossDomain:true,
            success: function(data){
                if(data.status == '0'){
                    //var dataObj=eval("("+data+")");
                    var obj = [];
                    for(var i=0;i<data.data.length;i++){
                        var d = data.data[i];
                        //console.log('data:'+d.orderNo);
                        obj.push(d);
                    }
                    $table = $('#table').bootstrapTable({
                        data:obj,
                        queryParamsType: '',              //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
                        //queryParams: queryParams,
                        method: "post",
                        pagination: true,
                        sortable: true,                     //是否启用排序
                        ajaxOptions:{
                            xhrFields:{
                                withCredentials:true
                            },
                            crossDomain:true
                        },
                        sortOrder: "asc",                   //排序方式
                        pageNumber: 1,                      //初始化加载第一页，默认第一页
                        pageSize: 15,                       //每页的记录行数（*）
                        pageList: [10, 20, 50, 100],
                        sidePagination: "client",         //分页方式：client客户端分页，server服务端分页（*）
                        striped: true,                    //是否显示行间隔色
                        cache: false,
                        uniqueId: "orderNo",               //每一行的唯一标识，一般为主键列
//                        height: 800,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
                        paginationPreText: "上一页",
                        paginationNextText: "下一页",
                        showToggle: false,                    //是否显示详细视图和列表视图的切换按钮
                        cardView: false,                    //是否显示详细视图
                        search:true,
                        showRefresh:false,
                        showColumns:true,
                        filter:true,
                        trimOnSearch:true,
                        columns: [
                            { title: '申请单号',field: 'reqNo',sortable:true,
                                formatter: function (value, row, index) {
                                    return "<a onclick='viewOrderDetail(this)'>"+value+"</a>";
                                }},
                            { title: '申请时间', field: 'creationDate',sortable:true},
                            { title: '订单号', field: 'orderNo',sortable:true },
                            { title: '申请人', field: 'reqBy',sortable:true},
//                        { title: '餐桌号', field: 'deskId'},
                            { title: '申请类型', field: 'reqType' ,sortable:true},
                            { title: '申请状态',  field: 'reqStatus',sortable:true, formatter: function (value, row, index) {
                                var labelColor = 'label-default';
                                if(value == '未处理'){
                                    labelColor = 'label-danger';
                                }else if(value == '已同意'){
                                    labelColor = 'label-success';
                                }
                                var html = '<span class=\"label '+labelColor+"\">"+value+"</span>";
                                return html;
                            }},
                            { title: '处理人', field: 'approver',sortable:true }
                        ]
                    });
                }else if(data.status == '10'){
                    alert(data.msg);
                    window.location.href="../login.jsp";
                }else{
                    alert(data.msg);
                }
            },
            error: function(data){
                alert("error!");
            }
        });


    });
</script>
<script>
    function viewOrderDetail(obj){
        var aid = $(obj).text();
        //console.log(aid);

        var oid = $(obj).parent().parent("tr").children('td').eq(2).text();
        //console.log(oid);

        var atype = $(obj).parent().parent("tr").children('td').eq(4).text();
        //console.log(atype);
        var atypeId = '0';
        if(atype == '取消订单'){
            atypeId = '1';
        }

        var astatus = $(obj).parent().parent("tr").children('td').eq(5).text();

        var astatusId = '0';
        if(astatus == '已同意'){
            astatusId = '1';
        }else if(astatus == '已拒绝'){
            astatusId = '2';
        }
        window.location.href = "user-apply-list-detail-limit.jsp?aid="+aid+"&oid="+oid+"&atype="+atypeId+"&astatus="+astatusId;
    }
</script>
<!--今日新增数量-->
<script>
    //    <!--今日新增订单数量-->
    $(function () {
        "use strict";
        $.ajax({
            type: 'post',
            url: "http://192.168.1.180:8080/doft/manage/order/addedOrderCount.aj",
            dataType: 'json',
            xhrFields:{
                withCredentials:true
            },
            crossDomain:true,
            success: function(data){
                if(data.status == '0'){
                    var newOrderNum = data.data;
                    $('#new-order-num').text(newOrderNum);
                    if(parseInt(newOrderNum)!=0){
                        var s = "<li>" + "<a href=\"../orderManage/order-list-limit.jsp\">" + "<i class=\"fa fa-file-text text-primary\"></i> 新添加了"+newOrderNum+"个订单" + "</a>" + "</li>";
                        document.getElementById("new-notice").innerHTML += s;
                        var n = parseInt($('#new-notice-num-title').text());
                        n+=1;
                        $('#new-notice-num-title').text(n);
                        $('#new-notice-num-top').text(n);
                    }

                }else if(data.status == '10'){
                    alert(data.msg);
                    window.location.href="../login.jsp";
                }else{
                    alert(data.msg);
                }
            },
            error: function(data){
                window.location.href="../login.jsp";
            }
        });
    });
    //    <!--今日新增申请数量-->
    $(function () {
        "use strict";
        $.ajax({
            type: 'post',
            url: "http://192.168.1.180:8080/doft/manage/requisition/addedRequisitionCount.aj",
            dataType: 'json',
            xhrFields:{
                withCredentials:true
            },
            crossDomain:true,
            success: function(data){
                if(data.status == '0'){
                    var newReqNum = data.data;
                    $('#new-req-num').text(newReqNum);
                    if(parseInt(newReqNum)!=0){
                        var s = "<li>" + "<a href=\"../orderManage/user-apply-list-limit.jsp\">" + "<i class=\"fa fa-comments text-success\"></i> 新添加了"+newReqNum+"个申请" + "</a>" + "</li>";
                        document.getElementById("new-notice").innerHTML += s;
                        var n = parseInt($('#new-notice-num-title').text());
                        n+=1;
                        $('#new-notice-num-title').text(n);
                        $('#new-notice-num-top').text(n);
                    }

                }else if(data.status == '10'){
                    alert(data.msg);
                    window.location.href="../login.jsp";
                }else{
                    alert(data.msg);
                    window.location.href="../login.jsp";
                }
            },
            error: function(data){
                window.location.href="../login.jsp";
            }
        });
    });
    //    <!--今日待处理申请数量-->
    $(function () {
        $.ajax({
            type: 'post',
            url: "http://192.168.1.180:8080/doft/manage/requisition/pendingRequisition.aj",
            dataType: 'json',
            xhrFields:{
                withCredentials:true
            },
            crossDomain:true,
            success: function(data){
                if(data.status == '0'){
                    var newReqNum = data.data;
                    if(parseInt(newReqNum)!=0){
                        var s = "<li>" + "<a href=\"../systemSettings/basicSettings.jsp\">" + "<i class=\"fa fa-comments text-success\"></i>  您有"+newReqNum+"条待处理申请" + "</a>" + "</li>";
                        document.getElementById("new-task").innerHTML += s;
                        var n = parseInt($('#new-task-num-title').text());
                        n+=parseInt(newReqNum);
                        $('#new-task-num-title').text(n);
                        $('#new-task-num-top').text(n);
                    }

                }else if(data.status == '10'){
                    alert(data.msg);
                    window.location.href="../login.jsp";
                }else{
                    alert(data.msg);
                    window.location.href="../login.jsp";
                }
            },
            error: function(data){
                window.location.href="../login.jsp";
            }
        });
    });
    //    <!--今日待处理订单数量-->
    $(function () {
        $.ajax({
            type: 'post',
            url: "http://192.168.1.180:8080/doft/manage/order/pendingDealOrder.aj",
            dataType: 'json',
            xhrFields:{
                withCredentials:true
            },
            crossDomain:true,
            success: function(data){
                if(data.status == '0'){
                    var newReqNum = data.data;
                    if(parseInt(newReqNum)!=0){
                        var s = "<li>" + "<a href=\"../orderManage/order-list-limit.jsp\">" + "<i class=\"fa fa-file-text text-primary\"></i>  您有"+newReqNum+"条待处理订单" + "</a>" + "</li>";
                        document.getElementById("new-task").innerHTML += s;
                        var n = parseInt($('#new-task-num-title').text());
                        n+=parseInt(newReqNum);
                        $('#new-task-num-title').text(n);
                        $('#new-task-num-top').text(n);
                    }

                }else if(data.status == '10'){
                    alert(data.msg);
                    window.location.href="../login.jsp";
                }else{
                    alert(data.msg);
                    window.location.href="../login.jsp";
                }
            },
            error: function(data){
                window.location.href="../login.jsp";
            }
        });
    });

</script>
<script>
    //展示用户信息
    $(document).ready(function(){
        $.ajax({
            //get the input phoneNum;
            url : "http://192.168.1.180:8080/user/get_information.do",//url
            xhrFields: {
                withCredentials: true
            },
            crossDomain: true,
            type : "POST",//方法类型
            dataType: "json",//预期服务器返回的数据类型
            //            data: {"phoneNumber":Uname,"password":Upass},
            error : function(xhr, status, error) {
                var s = "<i class=\"fa fa-circle text-gray\"></i>下线";
                document.getElementById("is-online").innerHTML += s;
                alert("请求失败，请重试");
            },
            success : function(Rdata) {
                //console.log(Rdata);
                if (Rdata.status == '0'){
                    //console.log("ok");
                    var user = Rdata.data;
                    $("#userName").text(user.userName);
                    $("#userHeadUrl").attr('src',user.headUrl);
                    $("#userName2").text(user.userName);
                    $("#userHeadUrl2").attr('src',user.headUrl);
                    $("#userName3").text(user.userName);
                    $("#userHeadUrl3").attr('src',user.headUrl);
                    $('#creationTime').text(timestampToYMD(user.creationTime));
                    if(user.roleId == 2){
                        $('#roleName').text('超级管理员');
                        window.location.href="user-apply-list.jsp";
                    }else if(user.roleId == 1){
                        $('#roleName').text('普通管理员');
                        //
                    }else{
                        alert("非管理员，无权进入");
                        var t = setTimeout("window.location.href=\"../login.jsp\"",500);
                    }
                    var s = "<i class=\"fa fa-circle text-success\"></i>在线";
                    document.getElementById("is-online").innerHTML += s;
                }else{
                    var s = "<i class=\"fa fa-circle text-gray\"></i>下线";
                    document.getElementById("is-online").innerHTML += s;
                    var t = setTimeout("window.location.href=\"../login.jsp\"",500);
//                    alert("用户尚未登录，点击确定转到登录界面...");
//                    window.location.href="../login.jsp";
                }
            }
        });
    });
</script>
<script>
    $('#log-out-btn').click(function () {
        $.ajax({
            type: 'post',
            url: "http://192.168.1.180:8080/doft/manage/user/logout.do",
            xhrFields:{
                withCredentials:true
            },
            crossDomain:true,
            dataType: 'json',
            success: function (data) {
                if(data.status == '0'){
                    window.location.href="../login.jsp";
                }else{
                    alert("请求失败，请重试");
                    window.location.href="../login.jsp";
                }

            },
            error: function (data) {
                alert("请求失败，请重试")
            }
        });
    });
</script>
</body>
</html>

