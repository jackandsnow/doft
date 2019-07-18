<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/12
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Delicious on Fingertips | Order List</title>
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
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                订单列表
                <small>订单内容已经更新</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
                <li><a href="../orderManage/order-list-limit.jsp">订单管理</a></li>
                <li class="active">订单列表</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <!--<h3 class="box-title">This is the box header</h3>-->
                            <div class="row">
                                <div class="col-xs-4 width-limit">
                                    <a href="../../index.jsp" type="button" class="btn btn-block btn-default bg-olive">新建订单</a>
                                </div>
                                <div class="col-sm-8 form-group">
                                    <input id="orderNoSearch" type="text" class="col-sm-4 form-control" placeholder="请输入要搜索的订单号" style="width: 200px;">
                                    <div class="col-sm-4">
                                        <button id="search" type="button" class="btn btn-primary">搜索</button>
                                        <button id="reset" type="button" class="btn btn-default">重置</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body mailbox-messages">
                            <%--<div id="toolbar">--%>
                                <%--<div class="col-sm-12 form-horizontal">--%>
                                    <%--<div class="col-sm-8 form-group">--%>
                                        <%--<input id="orderNoSearch" type="text" class="col-sm-4 form-control" placeholder="请输入要搜索的订单号" style="width: 200px;">--%>
                                        <%--<div class="col-sm-4">--%>
                                            <%--<button id="search" type="button" class="btn btn-primary">搜索</button>--%>
                                            <%--<button id="reset" type="button" class="btn btn-default">重置</button>--%>
                                        <%--</div>--%>
                                    <%--</div>--%>
                                <%--</div>--%>
                            <%--</div>--%>
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

    <!-- Control Sidebar -->
    <aside class="control-sidebar control-sidebar-dark">
        <!-- Create the tabs -->
        <ul class="nav nav-tabs nav-justified control-sidebar-tabs">
            <li><a href="#control-sidebar-home-tab" data-toggle="tab"><i class="fa fa-home"></i></a></li>
            <li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i class="fa fa-gears"></i></a></li>
        </ul>
        <!-- Tab panes -->
        <div class="tab-content">
            <!-- Home tab content -->
            <div class="tab-pane" id="control-sidebar-home-tab">
                <h3 class="control-sidebar-heading">Recent Activity</h3>
                <ul class="control-sidebar-menu">
                    <li>
                        <a href="javascript:void(0)">
                            <i class="menu-icon fa fa-birthday-cake bg-red"></i>

                            <div class="menu-info">
                                <h4 class="control-sidebar-subheading">Langdon's Birthday</h4>

                                <p>Will be 23 on April 24th</p>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="javascript:void(0)">
                            <i class="menu-icon fa fa-user bg-yellow"></i>

                            <div class="menu-info">
                                <h4 class="control-sidebar-subheading">Frodo Updated His Profile</h4>

                                <p>New phone +1(800)555-1234</p>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="javascript:void(0)">
                            <i class="menu-icon fa fa-envelope-o bg-light-blue"></i>

                            <div class="menu-info">
                                <h4 class="control-sidebar-subheading">Nora Joined Mailing List</h4>

                                <p>nora@example.com</p>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="javascript:void(0)">
                            <i class="menu-icon fa fa-file-code-o bg-green"></i>

                            <div class="menu-info">
                                <h4 class="control-sidebar-subheading">Cron Job 254 Executed</h4>

                                <p>Execution time 5 seconds</p>
                            </div>
                        </a>
                    </li>
                </ul>
                <!-- /.control-sidebar-menu -->

                <h3 class="control-sidebar-heading">Tasks Progress</h3>
                <ul class="control-sidebar-menu">
                    <li>
                        <a href="javascript:void(0)">
                            <h4 class="control-sidebar-subheading">
                                Custom Template Design
                                <span class="label label-danger pull-right">70%</span>
                            </h4>

                            <div class="progress progress-xxs">
                                <div class="progress-bar progress-bar-danger" style="width: 70%"></div>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="javascript:void(0)">
                            <h4 class="control-sidebar-subheading">
                                Update Resume
                                <span class="label label-success pull-right">95%</span>
                            </h4>

                            <div class="progress progress-xxs">
                                <div class="progress-bar progress-bar-success" style="width: 95%"></div>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="javascript:void(0)">
                            <h4 class="control-sidebar-subheading">
                                Laravel Integration
                                <span class="label label-warning pull-right">50%</span>
                            </h4>

                            <div class="progress progress-xxs">
                                <div class="progress-bar progress-bar-warning" style="width: 50%"></div>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="javascript:void(0)">
                            <h4 class="control-sidebar-subheading">
                                Back End Framework
                                <span class="label label-primary pull-right">68%</span>
                            </h4>

                            <div class="progress progress-xxs">
                                <div class="progress-bar progress-bar-primary" style="width: 68%"></div>
                            </div>
                        </a>
                    </li>
                </ul>
                <!-- /.control-sidebar-menu -->

            </div>
            <!-- /.tab-pane -->
            <!-- Stats tab content -->
            <div class="tab-pane" id="control-sidebar-stats-tab">Stats Tab Content</div>
            <!-- /.tab-pane -->
            <!-- Settings tab content -->
            <div class="tab-pane" id="control-sidebar-settings-tab">
                <form method="post">
                    <h3 class="control-sidebar-heading">General Settings</h3>

                    <div class="form-group">
                        <label class="control-sidebar-subheading">
                            Report panel usage
                            <input type="checkbox" class="pull-right" checked>
                        </label>

                        <p>
                            Some information about this general settings option
                        </p>
                    </div>
                    <!-- /.form-group -->

                    <div class="form-group">
                        <label class="control-sidebar-subheading">
                            Allow mail redirect
                            <input type="checkbox" class="pull-right" checked>
                        </label>

                        <p>
                            Other sets of options are available
                        </p>
                    </div>
                    <!-- /.form-group -->

                    <div class="form-group">
                        <label class="control-sidebar-subheading">
                            Expose author name in posts
                            <input type="checkbox" class="pull-right" checked>
                        </label>

                        <p>
                            Allow the user to show his name in blog posts
                        </p>
                    </div>
                    <!-- /.form-group -->

                    <h3 class="control-sidebar-heading">Chat Settings</h3>

                    <div class="form-group">
                        <label class="control-sidebar-subheading">
                            Show me as online
                            <input type="checkbox" class="pull-right" checked>
                        </label>
                    </div>
                    <!-- /.form-group -->

                    <div class="form-group">
                        <label class="control-sidebar-subheading">
                            Turn off notifications
                            <input type="checkbox" class="pull-right">
                        </label>
                    </div>
                    <!-- /.form-group -->

                    <div class="form-group">
                        <label class="control-sidebar-subheading">
                            Delete chat history
                            <a href="javascript:void(0)" class="text-red pull-right"><i class="fa fa-trash-o"></i></a>
                        </label>
                    </div>
                    <!-- /.form-group -->
                </form>
            </div>
            <!-- /.tab-pane -->
        </div>
    </aside>
    <!-- /.control-sidebar -->
    <!-- Add the sidebar's background. This div must be placed
         immediately after the control sidebar -->
    <div class="control-sidebar-bg"></div>
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
<!-- iCheck -->
<script src="../../plugins/iCheck/icheck.min.js"></script>
<!-- Page Script -->
<script src="../../js/common_func.js"></script>

<script>
    $(document).ready(function () {
        $table = $('#table').bootstrapTable({
            contentType: "application/x-www-form-urlencoded",//一种编码。好像在post请求的时候需要用到。这里用的get请求，注释掉这句话也能拿到数据
            url:"http://192.168.1.180:8080/doft/manage/order/list.do",//要请求数据的文件路径
            //queryParamsType: '',              //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
            queryParams: queryParams,           //请求服务器时所传的参数
            dataField: "rows",
            method: "post",
            ajaxOptions:{
                xhrFields:{
                    withCredentials:true
                },
                crossDomain:true
            },
            responseHandler:responseHandler,//请求数据成功后，渲染表格前的方法
            pagination: true,
            sortable: true,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            pageNumber: 1,                      //初始化加载第一页，默认第一页
            pageSize: 15,                       //每页的记录行数（*）
            pageList: [10, 20, 30, 40],
            sidePagination: "server",         //分页方式：client客户端分页，server服务端分页（*）
            striped: true,                    //是否显示行间隔色
            cache: false,
//            uniqueId: "orderNo",               //每一行的唯一标识，一般为主键列
            //height: 800,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            paginationPreText: "上一页",
            paginationNextText: "下一页",
            showToggle: false,                    //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            search:false,
            showRefresh:false,
            showColumns:false,
            filter:true,
            trimOnSearch:true,
            columns: [
                { title: '订单号',field: 'orderNo',
                    formatter: function (value, row, index) {
                        return "<a onclick='viewOrderDetail(this)'>"+value+"</a>";
                    }},
                { title: '下单时间', field: 'creationDate'},
                { title: '就餐人数', field: 'peopleCount' },
//                { title:'优惠金额',field:'discountPrice'},
                { title: '订单总价（元）', field: 'totalPrice',
                    formatter: function (value, row, index) {
                        var html = "<span>"+"¥ "+value+"</span>";
                        return html;
                    }},
                { title: '订单状态', field: 'orderStatusDesc' ,
                    formatter: function (value, row, index) {
                        var labelColor = 'label-warning';
                        if(value == '未付款'){
                            labelColor = 'label-danger';
                        }else if(value == '已付款'){
                            labelColor = 'label-success';
                        }else if(value == '已完成'){
                            labelColor = 'label-primary';
                        }else if(value == '已取消'){
                            labelColor = 'label-default';
                        }else if(value == '已处理'){
                            labelColor = 'label-info';
                        }
                        var html = '<span class=\"label '+labelColor+"\">"+value+"</span>";
                        return html;
                    }
                },
                { title: '餐桌号', field: 'deskId' }

            ]
        });

//请求服务数据时所传参数
        function queryParams(params){
            //console.log("params.limit"+params.limit);
            //console.log("params.offset"+params.offset);
            return {
                pageSize : params.limit, //每一页的数据行数，默认是上面设置的10(pageSize)
                pageNum : params.offset/params.limit+1 ,//当前页面,默认是上面设置的1(pageNumber)
//                param : "Your Param" //这里是其他的参数，根据自己的需求定义，可以是多个
//                orderNo:''
            }
        }

//请求成功方法
        function responseHandler(result){
            var status = result.status;//在此做了错误代码的判断
            if(status == '10'){
                alert(result.msg);
                window.location.href="../login.jsp";
                return;
            }else if(status!='0'){
                alert(result.msg);
                return;
            }
            //如果没有错误则返回数据，渲染表格
            return {
                total : result.data.total, //总页数,前面的key必须为"total" result.data.pages
                rows : result.data.list, //行数据，前面的key要与之前设置的dataField的值一致.
            };
        };

//刷新表格数据,点击你的按钮调用这个方法就可以刷新
        $('#search').click(function () {
            var orderNoSearch = $('#orderNoSearch').val();
            $('#table').bootstrapTable('refresh', { url: 'http://192.168.1.180:8080/doft/manage/order/list.do?orderNo=' + orderNoSearch});
        });
        $('#reset').click(function() {
            $('#orderNoSearch').val('');
            //刷新表格数据,点击重置按钮调用这个方法就可以刷新
            $('#table').bootstrapTable('refresh', { url: 'http://192.168.1.180:8080/doft/manage/order/list.do' });
        });

    });
</script>
<script>
    function viewOrderDetail(obj) {
        var oid = $(obj).text();
        //console.log("oid=" + oid);

        var otime = $(obj).parent().parent("tr").children('td').eq(1).text();
        //console.log(otime);

        var ostatus = $(obj).parent().parent("tr").children('td').eq(4).text();

        var ostatusId = '0';
        if(ostatus == '已付款'){
            ostatusId = '1';
        }else if(ostatus == '已处理'){
            ostatusId = '2';
        }else if(ostatus == '申请中'){
            ostatusId = '3';
        }else if(ostatus == '已取消'){
            ostatusId = '4';
        }else if(ostatus == '已完成'){
            ostatusId = '5';
        }
        window.location.href = "order-list-detail-limit.jsp?oid="+oid+"&otime="+otime+"&ostatus="+ostatusId;
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
                    window.location.href="../login.jsp";
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
                        window.location.href="order-list.jsp";
                    }else if(user.roleId == 1){
                        $('#roleName').text('普通管理员');
                    }else{
                        alert("非管理员，无权进入");
                        window.location.href="../login.jsp";
                    }
                    var s = "<i class=\"fa fa-circle text-success\"></i>在线";
                    document.getElementById("is-online").innerHTML += s;
                }else{
                    var s = "<i class=\"fa fa-circle text-gray\"></i>下线";
                    document.getElementById("is-online").innerHTML += s;
                    alert("用户尚未登录，正在转到登录界面...");
                    window.location.href="../login.jsp";
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

