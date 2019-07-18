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
    </style>
</head>
<body class="hold-transition skin-black sidebar-mini">
<div class="wrapper">

    <header class="main-header">
        <!-- Logo -->
        <a href="../orderManage/order-list.jsp" class="logo logo-blue">
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
            <!-- search form -->
            <!--<form action="#" method="get" class="sidebar-form">-->
            <!--<div class="input-group">-->
            <!--<input type="text" name="q" class="form-control" placeholder="搜索...">-->
            <!--<span class="input-group-btn">-->
            <!--<button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>-->
            <!--</button>-->
            <!--</span>-->
            <!--</div>-->
            <!--</form>-->
            <!-- /.search form -->
            <!-- sidebar menu: : style can be found in sidebar.less -->
            <ul class="sidebar-menu" data-widget="tree">
                <li class="header">MAIN FUNCTIONS</li>
                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-sticky-note"></i> <span>订单管理</span>
                        <span class="pull-right-container">
                             <i class="fa fa-angle-left pull-right"></i>
                        </span>
                    </a>
                    <ul class="treeview-menu">
                        <li id="orderListSearch"><a href="../orderManage/order-list.jsp"><i class="fa fa-circle-o"></i> 订单列表</a></li>
                        <li><a href="../orderManage/user-apply-list.jsp"><i class="fa fa-circle-o"></i> 用户申请列表</a></li>
                    </ul>
                </li>
                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-user"></i>
                        <span>用户管理</span>
                        <span id="new-user-label" class="pull-right-container">
                            <!--<span  class="label label-primary pull-right">4</span>-->
                            <i class="fa fa-angle-left pull-right"></i>
                            <!--<span class="pull-right-container">-->
                            <!--<small class="label pull-right bg-yellow">12</small>-->
                            <!--<small class="label pull-right bg-green">16</small>-->
                            <!--<small class="label pull-right bg-red">5</small>-->
                            <!--`                </span>-->
                        </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="../userManage/user-manage.jsp"><i class="fa fa-circle-o"></i> 用户列表</a></li>
                        <!--<li><a href="../layout/boxed.html"><i class="fa fa-circle-o"></i> Boxed</a></li>-->
                        <!--<li><a href="../layout/fixed.html"><i class="fa fa-circle-o"></i> Fixed</a></li>-->
                        <!--<li><a href="../layout/collapsed-sidebar.html"><i class="fa fa-circle-o"></i> Collapsed Sidebar</a></li>-->
                    </ul>
                </li>
                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-pie-chart"></i>
                        <span>数据统计</span>
                        <span class="pull-right-container">
                  <i class="fa fa-angle-left pull-right"></i>
                </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="../dataCount/data-count.html"><i class="fa fa-circle-o"></i> 餐桌余量及销售额统计</a></li>
                        <li><a href="../dataCount/dish-sale-count.jsp"><i class="fa fa-circle-o"></i> 菜品销量统计</a></li>
                    </ul>
                </li>

                <li class="header">ADVANCED SETTINGS</li>

                <li class="treeview active">
                    <a href="#">
                        <i class="fa fa-cog"></i>
                        <span>系统设置</span>
                        <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="../systemSettings/basicSettings.jsp"><i class="fa fa-circle-o"></i>基本设置</a></li>
                        <li><a href="../systemSettings/adminSettings.jsp"><i class="fa fa-circle-o"></i>人员设置</a></li>
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
                系统设置
                <small>请在这里对系统设置进行修改</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
                <li><a href="../systemSettings/basicSettings.jsp">系统设置</a></li>
                <li class="active">基本设置</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="nav-tabs-custom">
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#tab-dish-type" data-toggle="tab">菜系设置</a></li>
                            <li><a href="#tab-dish" data-toggle="tab">菜品设置</a></li>
                        </ul>
                        <div class="tab-content">
                            <div class="tab-pane active" id="tab-dish-type">
                                <div class="box-header">
                                    <h3 class="box-title">菜系列表</h3>
                                    <div class="pull-right">
                                        <button type="button" class="btn btn-warning" id="btnAddNewDishType" data-toggle="modal" data-target="#modal-dish-type-add">添加菜系</button>
                                        <button type="button" class="btn btn-danger" id="btnDeleteDishType">删除菜系</button>
                                    </div>
                                </div>
                                <!-- /.box-header -->
                                <div class="box-body mailbox-messages">
                                    <table id="dish-type-table"></table>
                                </div>
                                <div class="modal fade" id="modal-dish-type-add">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                    <span aria-hidden="true">&times;</span></button>
                                                <h4 class="modal-title">
                                                    添加新菜系
                                                </h4>
                                            </div>
                                            <div class="modal-body">
                                                <div class="row">
                                                    <div class="col-xs-12">
                                                        <form class="form-horizontal">
                                                            <div class="form-group">
                                                                <label class="col-sm-2 control-label">菜系名称</label>
                                                                <div class="col-sm-10">
                                                                    <input type="text" class="form-control" id="createDishType" placeholder="请输入菜系名称">
                                                                </div>
                                                            </div>
                                                        </form>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-default pull-left" name="btn-cancel-order" data-dismiss="modal">取消</button>
                                                <button type="button" class="btn btn-success" name="btn-save-edit" id="btn-save-dish-type" data-dismiss="modal">确认</button>
                                            </div>
                                        </div>
                                        <!-- /.modal-content -->
                                    </div>
                                    <!-- /.modal-dialog -->
                                </div>
                                <!-- /.modal -->
                                <div class="modal fade" id="modal-dish-type-delete">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                    <span aria-hidden="true">&times;</span></button>
                                                <h4 class="modal-title">
                                                    删除菜系
                                                </h4>
                                            </div>
                                            <div class="modal-body">
                                                <div class="row">
                                                    <div class="col-xs-12">
                                                        <form class="form-horizontal">
                                                            <div class="form-group">
                                                                <label class="col-sm-4 control-label">请选择要删除的菜系</label>
                                                                <div class="col-sm-8">
                                                                    <select id="selectdishTypeDelete" class="form-control">
                                                                    </select>
                                                                </div>
                                                            </div>
                                                        </form>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-default pull-left" name="btn-cancel-dish-delete" data-dismiss="modal">取消删除</button>
                                                <button type="button" class="btn btn-success" name="btn-save-dish-type-delete" id="btn-save-dish-type-delete" data-dismiss="modal">确认删除</button>
                                            </div>
                                        </div>
                                        <!-- /.modal-content -->
                                    </div>
                                    <!-- /.modal-dialog -->
                                </div>
                                <!-- /.modal -->
                            </div>
                            <div class="tab-pane" id="tab-dish">
                                <%--<div class="box">--%>
                                    <div class="box-header">
                                        <h3 class="box-title">菜品列表</h3>
                                        <div class="pull-right">
                                            <button type="button" class="btn btn-success " id="btnSetDeskNum">餐桌总量设置</button>
                                            <button type="button" class="btn btn-primary" id="btnSetDish">添加菜品</button>
                                        </div>
                                        <%--<div class="form-group">--%>
                                        <%--<form id="ajaxForm" method="post" action="http://192.168.1.180:8080/doft/manage/dish/upload.do" enctype="multipart/form-data">--%>
                                        <%--<input type="file" name="upload_file" />--%>
                                        <%--<input type="submit" value="springmvc上传文件" />--%>
                                        <%--</form>--%>
                                        <%--</div>--%>
                                    </div>
                                    <!-- /.box-header -->
                                    <div class="box-body mailbox-messages">
                                        <table id="dish-table"></table>
                                    </div>
                                    <!-- /.box-body -->
                                    <div class="modal fade" id="modal-desk-set">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                        <span aria-hidden="true">&times;</span></button>
                                                    <h4 class="modal-title">
                                                        设置餐桌总量
                                                    </h4>
                                                </div>
                                                <div class="modal-body">
                                                    <div class="row">
                                                        <div class="col-xs-12">
                                                            <form class="form-horizontal">
                                                                <div class="form-group">
                                                                    <label class="col-sm-3 control-label">现有餐桌数</label>
                                                                    <div class="col-sm-9">
                                                                        <input disabled type="number" class="form-control" id="desk-all-num" placeholder="现有餐桌总数目">
                                                                    </div>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label class="col-sm-3 control-label">已占用餐桌数</label>
                                                                    <div class="col-sm-9">
                                                                        <input disabled type="number" class="form-control" id="desk-used-num" placeholder="已占用餐桌总数目">
                                                                    </div>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label class="col-sm-3 control-label">空闲餐桌数</label>
                                                                    <div class="col-sm-9">
                                                                        <input disabled type="number" class="form-control" id="desk-free-num" placeholder="空闲餐桌总数目">
                                                                    </div>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label class="col-sm-3 control-label">设置新餐桌数</label>
                                                                    <div class="col-sm-9">
                                                                        <input type="number" class="form-control" id="createDeskNum" placeholder="请输入新餐桌总数目">
                                                                    </div>
                                                                </div>
                                                            </form>
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-default pull-left" name="btn-cancel-order" data-dismiss="modal">取消</button>
                                                    <button type="button" class="btn btn-success" name="btn-save-edit" id="btn-save-desknum" data-dismiss="modal">确认</button>
                                                </div>
                                            </div>
                                            <!-- /.modal-content -->
                                        </div>
                                        <!-- /.modal-dialog -->
                                    </div>
                                    <!-- /.modal -->
                                    <div class="modal fade" id="modal-dish-add">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                        <span aria-hidden="true">&times;</span></button>
                                                    <h4 class="modal-title">
                                                        新建菜品信息
                                                    </h4>
                                                </div>
                                                <div class="modal-body">
                                                    <div class="row">
                                                        <div class="col-xs-12">
                                                            <div class="form-horizontal">
                                                                <div class="form-group">
                                                                    <label class="col-sm-3 control-label">所属菜系</label>
                                                                    <div class="col-sm-9">
                                                                        <select id="selectdishType" class="form-control">
                                                                        </select>
                                                                    </div>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label class="col-sm-3 control-label">菜品名称</label>
                                                                    <div class="col-sm-9">
                                                                        <input type="text" class="form-control" id="addDishName" placeholder="请输入菜品名称">
                                                                    </div>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label class="col-sm-3 control-label">菜品单价（元）</label>
                                                                    <div class="col-sm-9">
                                                                        <input type="number" class="form-control" id="addDishPrice" placeholder="请输入菜品单价">
                                                                    </div>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label class="col-sm-3 control-label">总数量</label>
                                                                    <div class="col-sm-9">
                                                                        <input type="number" class="form-control" id="addDishNum" placeholder="请输入菜品总数量">
                                                                    </div>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label class="col-sm-3 control-label">菜品描述</label>
                                                                    <div class="col-sm-9">
                                                                        <input type="text" class="form-control" id="addDishDesc" placeholder="请输入菜品描述">
                                                                    </div>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label class="col-sm-3 control-label">推荐指数</label>
                                                                    <div class="col-sm-9">
                                                                        <input type="number" class="form-control" id="addDishRec" placeholder="请输入菜品推荐指数">
                                                                    </div>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label class="col-sm-3 control-label">是否参与满减</label>
                                                                    <div class="col-sm-9">
                                                                        <select id="selectDishBarginAdd" class="form-control">
                                                                            <option value="0">不参与</option>
                                                                            <option value="1">参与</option>
                                                                        </select>
                                                                    </div>
                                                                </div>
                                                                <div class="form-group">
                                                                    <form id="ajaxForm" method="post" action="http://192.168.1.180:8080/doft/manage/dish/upload.do" enctype="multipart/form-data">
                                                                        <label class="col-sm-3 control-label">菜品图片</label>
                                                                        <div class="col-sm-9">
                                                                            <%--<input type="file" name="upload_file" />--%>
                                                                            <%--<input type="submit" class="btn btn-success" name="btn-save-edit" data-dismiss="modal"></button>--%>
                                                                            <input type="file" name="upload_file" />
                                                                        </div>
                                                                        <div class="modal-footer">
                                                                            <div div-box>
                                                                                <input type="submit" value="" style="width:81.6px;height:33.6px;border:none;background-image: url('../../back-stage-dist/img/btn/create-btn-icon.PNG');background-repeat:no-repeat; background-size:100% 100%;"/>
                                                                                <%--<button type="button" class="btn btn-default" name="btn-cancel-edit" id="btn-cancel-dish-create" data-dismiss="modal">取消创建</button>--%>
                                                                            </div>
                                                                        </div>
                                                                    </form>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>


                                            </div>
                                            <!-- /.modal-content -->
                                        </div>
                                        <!-- /.modal-dialog -->
                                    </div>
                                    <!-- /.modal -->
                                    <div class="modal fade" id="modal-dish-edit">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                        <span aria-hidden="true">&times;</span></button>
                                                    <h4 class="modal-title">
                                                        编辑菜品信息
                                                    </h4>
                                                </div>
                                                <div class="modal-body">
                                                    <div class="row">
                                                        <div class="col-xs-12">
                                                            <div class="form-horizontal">
                                                                <div class="form-group">
                                                                    <label class="col-sm-3 control-label">所属菜系</label>
                                                                    <div class="col-sm-9">
                                                                        <select id="selectdishTypeEdit" class="form-control">
                                                                        </select>
                                                                    </div>
                                                                </div>
                                                                <div hidden class="form-group">
                                                                    <label class="col-sm-2 control-label">菜品Id</label>
                                                                    <div class="col-sm-10">
                                                                        <input type="text" class="form-control" id="editDishId" placeholder="请输入菜品Id">
                                                                    </div>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label class="col-sm-3 control-label">菜品名称</label>
                                                                    <div class="col-sm-9">
                                                                        <input type="text" class="form-control" id="editDishName" placeholder="请输入菜品名称">
                                                                    </div>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label class="col-sm-3 control-label">菜品单价（元）</label>
                                                                    <div class="col-sm-9">
                                                                        <input type="number" class="form-control" id="editDishPrice" placeholder="请输入菜品单价">
                                                                    </div>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label class="col-sm-3 control-label">总数量</label>
                                                                    <div class="col-sm-9">
                                                                        <input type="number" class="form-control" id="editDishNum" placeholder="请输入菜品总数量">
                                                                    </div>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label class="col-sm-3 control-label">菜品描述</label>
                                                                    <div class="col-sm-9">
                                                                        <input type="text" class="form-control" id="editDishDesc" placeholder="请输入菜品描述">
                                                                    </div>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label class="col-sm-3 control-label">推荐指数</label>
                                                                    <div class="col-sm-9">
                                                                        <input type="number" class="form-control" id="editDishRec" placeholder="请输入菜品推荐指数">
                                                                    </div>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label class="col-sm-3 control-label">是否参与满减</label>
                                                                    <div class="col-sm-9">
                                                                        <select id="selectDishBarginEdit" class="form-control">
                                                                            <option value="0">不参与</option>
                                                                            <option value="1">参与</option>
                                                                        </select>
                                                                    </div>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label class="col-sm-3 control-label">菜品状态</label>
                                                                    <div class="col-sm-9">
                                                                        <select id="selectDishStautsEdit" class="form-control">
                                                                            <option value="1">在售</option>
                                                                            <option value="2">已下架</option>
                                                                        </select>
                                                                    </div>
                                                                </div>
                                                                <div hidden class="form-group">
                                                                    <label class="col-sm-3 control-label">菜品图片</label>
                                                                    <div class="col-sm-9">
                                                                        <%--<input type="file" name="upload_file" />--%>
                                                                        <%--<input type="submit" class="btn btn-success" name="btn-save-edit" data-dismiss="modal"></button>--%>
                                                                        <img id="dish-img" src="" width="40px" height="40px" />
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-default pull-left" name="btn-cancel-dish-edit" id="btn-cancel-dish-edit" data-dismiss="modal">取消修改</button>
                                                    <button type="button" class="btn btn-success" name="btn-save-dish-edit" id="btn-save-dish-edit" data-dismiss="modal">确认修改</button>
                                                </div>
                                            </div>
                                            <!-- /.modal-content -->
                                        </div>
                                        <!-- /.modal-dialog -->
                                    </div>
                                    <!-- /.modal -->
                                    <div class="modal fade" id="modal-dish-edit-img">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                        <span aria-hidden="true">&times;</span></button>
                                                    <h4 class="modal-title">
                                                        更改菜品图片
                                                    </h4>
                                                </div>
                                                <div class="modal-body">
                                                    <div class="row">
                                                        <div class="col-xs-12">
                                                            <div class="form-horizontal">
                                                                <div hidden class="form-group">
                                                                    <label class="col-sm-3 control-label">所属菜系</label>
                                                                    <div class="col-sm-9">
                                                                        <select id="selectdishTypeEditImg" class="form-control">
                                                                        </select>
                                                                    </div>
                                                                </div>
                                                                <div hidden class="form-group">
                                                                    <label class="col-sm-2 control-label">菜品Id</label>
                                                                    <div class="col-sm-10">
                                                                        <input type="text" class="form-control" id="editDishIdImg" placeholder="请输入菜品Id">
                                                                    </div>
                                                                </div>
                                                                <div hidden class="form-group">
                                                                    <label class="col-sm-3 control-label">菜品名称</label>
                                                                    <div class="col-sm-9">
                                                                        <input type="text" class="form-control" id="editDishNameImg" placeholder="请输入菜品名称">
                                                                    </div>
                                                                </div>
                                                                <div hidden class="form-group">
                                                                    <label class="col-sm-3 control-label">菜品单价（元）</label>
                                                                    <div class="col-sm-9">
                                                                        <input type="number" class="form-control" id="editDishPriceImg" placeholder="请输入菜品单价">
                                                                    </div>
                                                                </div>
                                                                <div hidden class="form-group">
                                                                    <label class="col-sm-3 control-label">总数量</label>
                                                                    <div class="col-sm-9">
                                                                        <input type="number" class="form-control" id="editDishNumImg" placeholder="请输入菜品总数量">
                                                                    </div>
                                                                </div>
                                                                <div hidden class="form-group">
                                                                    <label class="col-sm-3 control-label">菜品描述</label>
                                                                    <div class="col-sm-9">
                                                                        <input type="text" class="form-control" id="editDishDescImg" placeholder="请输入菜品描述">
                                                                    </div>
                                                                </div>
                                                                <div hidden class="form-group">
                                                                    <label class="col-sm-3 control-label">推荐指数</label>
                                                                    <div class="col-sm-9">
                                                                        <input type="number" class="form-control" id="editDishRecImg" placeholder="请输入菜品推荐指数">
                                                                    </div>
                                                                </div>
                                                                <div hidden class="form-group">
                                                                    <label class="col-sm-3 control-label">菜品状态</label>
                                                                    <div class="col-sm-9">
                                                                        <select id="selectDishStautsEditImg" class="form-control">
                                                                            <option value="1">在售</option>
                                                                            <option value="2">已下架</option>
                                                                        </select>
                                                                    </div>
                                                                </div>
                                                                <div hidden class="form-group">
                                                                    <label class="col-sm-3 control-label">是否参与满减</label>
                                                                    <div class="col-sm-9">
                                                                        <select id="selectDishBarginImg" class="form-control">
                                                                            <option value="0">不参与</option>
                                                                            <option value="1">参与</option>
                                                                        </select>
                                                                    </div>
                                                                </div>
                                                                <div class="form-group">
                                                                    <form id="ajaxForm2" method="post" action="http://192.168.1.180:8080/doft/manage/dish/upload.do" enctype="multipart/form-data">
                                                                        <label class="col-sm-3 control-label">更改菜品图片</label>
                                                                        <div class="col-sm-9">
                                                                            <input type="file" name="upload_file" />
                                                                        </div>
                                                                        <div class="modal-footer">
                                                                            <div div-box>
                                                                                <input type="submit" value="" style="width:81.6px;height:33.6px;border:none;background-image: url('../../back-stage-dist/img/btn/edit-btn-icon.PNG');background-repeat:no-repeat; background-size:100% 100%;"/>
                                                                                <%--<button type="button" class="btn btn-default" name="btn-cancel-edit" id="btn-cancel-dish-create" data-dismiss="modal">取消创建</button>--%>
                                                                            </div>
                                                                        </div>
                                                                    </form>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <!-- /.modal-content -->
                                        </div>
                                        <!-- /.modal-dialog -->
                                    </div>
                                    <!-- /.modal -->
                                <%--</div>--%>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
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
<script src="../../bower_components/jquery/dist/jquery.js"></script>
<script src="../../bower_components/jquery.form.js"></script>
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
//    获取菜品列表
    $(document).ready(function () {
        $table = $('#dish-table').bootstrapTable({
            contentType: "application/x-www-form-urlencoded",//一种编码。好像在post请求的时候需要用到。这里用的get请求，注释掉这句话也能拿到数据
            url:"http://192.168.1.180:8080/doft/manage/dish/list.do",//要请求数据的文件路径
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
            pageSize: 10,                       //每页的记录行数（*）
            pageList: [10, 20, 30, 40],
            sidePagination: "server",         //分页方式：client客户端分页，server服务端分页（*）
            striped: true,                    //是否显示行间隔色
            cache: false,
            uniqueId: "orderNo",               //每一行的唯一标识，一般为主键列
//                        height: 800,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            paginationPreText: "上一页",
            paginationNextText: "下一页",
            showToggle: false,                    //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            search:false,
            showRefresh:false,
            showColumns:true,
            filter:true,
            trimOnSearch:true,
            columns: [
                {title: '#',formatter: function (value, row, index) {
                    return index+1;
                }},
                { title: '菜系名称', field: 'dishTypeName'},
                { title: '菜品编号',field: 'dishId'},
                { title: '菜品名称', field: 'dishName'},
                { title: '图片', field: 'dishImgUrl',
                    formatter: function(value,row,index){
                        return "<img id='dish-img-table"+row+"' src="+value+"  width=\"40px\" height=\"40px\" >";
                    }},
                { title: '单价（元）', field: 'price',
                    formatter: function (value, row, index) {
                        var html = "<span>"+"¥ "+value+"</span>";
                        return html;
                    }},
                { title: '总数量', field: 'totalNumber'},
                { title: '菜品描述', field: 'description'},
                { title: '推荐指数', field: 'recommendIndex' ,
                    formatter: function (value, row, index) {
                        var html = "<span>"+value+" / ";
                        var Rindex = parseInt(value);
                        for(var i=0;i<Rindex;i++){
                            html+="<i class=\"fa fa-star text-yellow\"></i>"
                        }
                        if(Rindex != parseFloat(value)){
                            html+="<i class=\"fa fa-star-half-empty text-yellow\"></i>"
                        }
                        html += "</span>";
                        return html;
                    }},
                { title: '是否参与满减', field: 'discountble' ,sortable:true,
                    formatter: function (value, row, index) {
                        var barginText = '参与';
                        if(value == false){
                            barginText = '不参与';
                        }
                        var html = '<span>'+barginText+'</span>';
                        return html;
                    }},
                { title: '菜品状态', field: 'status' ,sortable:true,
                    formatter: function (value, row, index) {
                        var labelColor = 'label-default';
                        if(value == '在售'){
                            labelColor = 'label-success';
                        }
                        var html = '<span class=\"label '+labelColor+"\">"+value+"</span>";
                        return html;
                    }},
                { title: '操作',  formatter: function (value, row, index) {
                    return "<div class='btn-group'><button type='button' class='btn btn-default btn-sm' onclick='onEdit(this)'><i class='fa fa-edit'></i></button>" +
                        "<button type='button' class='btn btn-default btn-sm' onclick='onEditImg(this)'><i class='fa fa-picture-o'></i></button>"+
                        "<button type='button' class='btn btn-default btn-sm' onclick='onDelete(this)'><i class='fa fa-trash-o'></i></button></div>";
                }}
            ]
        });

//请求服务数据时所传参数
        function queryParams(params){
            //console.log("params.limit"+params.limit);
            //console.log("params.offset"+params.offset);
            return {
                pageSize : params.limit, //每一页的数据行数，默认是上面设置的10(pageSize)
                pageNum : params.offset/params.limit+1 //当前页面,默认是上面设置的1(pageNumber)
//                param : "Your Param" //这里是其他的参数，根据自己的需求定义，可以是多个
            }
        }

//请求成功方法
        function responseHandler(result){
            var status = result.status;//在此做了错误代码的判断
            if(status == '10'){
                alert(data.msg);
                window.location.href="../login.jsp";
                return;
            }else if(status!='0'){
                alert(result.msg);
                return;
            }
            //如果没有错误则返回数据，渲染表格
            return {
                total : result.data.total, //总页数,前面的key必须为"total" result.data.pages
                rows : result.data.list //行数据，前面的key要与之前设置的dataField的值一致.
            };
        };

//刷新表格数据,点击你的按钮调用这个方法就可以刷新
        function refresh() {
            $('#table').bootstrapTable('refresh', {url: "http://192.168.1.180:8080/doft/manage/dish/list.do"});
        }
    });
//     获取菜系列表
    $(document).ready(function () {
        $.ajax({
            type: 'post',
            url: "http://192.168.1.180:8080/manage/dish_type/get_all_dish_type.do",
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
                        obj.push(d);
                    }
                    $table = $('#dish-type-table').bootstrapTable({
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
                            {title: '#',formatter: function (value, row, index) {
                                return index+1;
                            }},
                            { title: '菜系编号',field: 'dishTypeId',sortable:true},
                            { title: '菜系名称', field: 'typeName',sortable:true }
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
                alert("获取菜系列表失败!");
            }
        });


    });
</script>
<script>
    $('#btnSetDish').click(function () {
        $.ajax({
            type: 'post',
            url: "http://192.168.1.180:8080/manage/dish_type/get_all_dish_type.do",
            dataType: 'json',
            xhrFields:{
                withCredentials:true
            },
            crossDomain:true,
            success: function(data){
                if(data.status == '0'){
                    var dataList = [];
                    var dishTypeIdList = [];
                    for(var i=0;i<data.data.length;i++){
                        var d = data.data[i];
                        dataList.push(d.typeName);
                        dishTypeIdList.push(d.dishTypeId);
                    }
                    document.getElementById("selectdishType").innerHTML = "";
                    for (var i = 0; i < dataList.length; i++) {
                        //先创建好select里面的option元素
                        var option = document.createElement("option");
                        //转换DOM对象为JQ对象,好用JQ里面提供的方法 给option的value赋值
                        $(option).val(dishTypeIdList[i]);
                        //给option的text赋值,这就是你点开下拉框能够看到的东西
                        $(option).text(dataList[i]);
                        //获取select 下拉框对象,并将option添加进select
                        $('#selectdishType').append(option);
                    }
                }else if(data.status == '10'){
                    alert(data.msg);
                    window.location.href="../login.jsp";
                }else{
                    alert(data.msg);
                }
            },
            error: function(data){
                alert("get dish type error!");
            }
        });

        $('#modal-dish-add').modal('show');
    })
    $('#btnDeleteDishType').click(function () {
        $.ajax({
            type: 'post',
            url: "http://192.168.1.180:8080/manage/dish_type/get_all_dish_type.do",
            dataType: 'json',
            xhrFields:{
                withCredentials:true
            },
            crossDomain:true,
            success: function(data){
                if(data.status == '0'){
                    var dataList = [];
                    var dishTypeIdList = [];
                    for(var i=0;i<data.data.length;i++){
                        var d = data.data[i];
                        dataList.push(d.typeName);
                        dishTypeIdList.push(d.dishTypeId);
                    }
                    document.getElementById("selectdishTypeDelete").innerHTML = "";
                    for (var i = 0; i < dataList.length; i++) {
                        //先创建好select里面的option元素
                        var option = document.createElement("option");
                        //转换DOM对象为JQ对象,好用JQ里面提供的方法 给option的value赋值
                        $(option).val(dishTypeIdList[i]);
                        //给option的text赋值,这就是你点开下拉框能够看到的东西
                        $(option).text(dataList[i]);
                        //获取select 下拉框对象,并将option添加进select
                        $('#selectdishTypeDelete').append(option);
                    }
                }else if(data.status == '10'){
                    alert(data.msg);
                    window.location.href="../login.jsp";
                }else{
                    alert(data.msg);
                }
            },
            error: function(data){
                alert("get dish type error!");
            }
        });

        $('#modal-dish-type-delete').modal('show');
    })
    $('#btnSetDeskNum').click(function () {
        $.ajax({
            type: 'post',
            url: "http://192.168.1.180:8080/doft/manage/desk/getDeskTotal.aj",
            dataType: 'json',
            xhrFields:{
                withCredentials:true
            },
            crossDomain:true,
            success: function(data){
                if(data.status == '0'){
                    var splited = data.data.split(",");
                    $('#desk-all-num').val(parseInt((splited[0].split("/"))[0]));
                    $('#desk-used-num').val(parseInt((splited[1].split("/"))[0]));
                    $('#desk-free-num').val(parseInt((splited[2].split("/"))[0]));
                }else if(data.status == '10'){
                    alert(data.msg);
                    window.location.href="../login.jsp";
                }else{
                    alert(data.msg);
                }
            },
            error: function(data){
                alert("请重试，或重新登录!");
            }
        });

        $('#modal-desk-set').modal('show');
    })
</script>
<script>
    $(function () {
        $("#ajaxForm2").submit(function () {
            $(this).ajaxSubmit(function (data) {

                var dishImgFileUrl = data.data.url;
                //console.log('dishImgFileUrl'+dishImgFileUrl);
                var mToSaveDishName = $('#editDishNameImg').val();
                var mToSaveDishPrice = $('#editDishPriceImg').val();
                var mToSaveDishNum = $('#editDishNumImg').val();
                var mToSaveDishDesc = $('#editDishDescImg').val();
                var mToSaveDishRec = $('#editDishRecImg').val();
                var mToSaveDishStatus = $('#selectDishStautsEditImg option:selected').val();
                var mToSaveDishTypeId = $('#selectdishTypeEditImg option:selected').val();
                var  mToSaveDishBargin = $('#selectDishBarginImg option:selected').val();
                $.ajax({
                    type: 'post',
                    url: "http://192.168.1.180:8080/doft/manage/dish/save.do",
                    data: {
                        'dishId':$('#editDishIdImg').val(),
                        'dishTypeId' : mToSaveDishTypeId,
                        'dishName' : mToSaveDishName,
                        'status': parseInt(mToSaveDishStatus),
                        'price' : parseInt(mToSaveDishPrice),
                        'totalNumber' : parseInt(mToSaveDishNum),
                        'description' : mToSaveDishDesc,
                        'recommendIndex' : parseFloat(mToSaveDishRec),
                        'dishImgUrl' : dishImgFileUrl,
                        'isBargainFlag': parseInt(mToSaveDishBargin)
                    },
                    //contentType : 'application/json; charset=utf-8',
                    dataType: 'json',
                    xhrFields:{
                        withCredentials:true
                    },
                    crossDomain:true,
                    success: function(data){
                        if(data.status == '0'){
                            //console.log("edit successfully!");
                            //window.location.href="../systemSettings/basicSettings.jsp";
                            location.reload(true);
                        }else if(data.status == '10'){
                            alert(data.msg);
                            window.location.href="../login.jsp";
                        }else{
                            alert(data.msg);
                        }
                    },
                    error: function(data){
                        alert(" create error!");
                    }
                });

            });
            return false;
        });
    });
    $('#btn-save-dish-edit').click(function () {
            //console.log("in save edit");

            var mToSaveDishName = $('#editDishName').val();
            if(mToSaveDishName == ""){
                alert("菜品名称不能为空");
                return false;
            }
            var mToSaveDishPrice = $('#editDishPrice').val();
            if(mToSaveDishPrice == ""){
                alert("菜品单价不能为空");
                return false;
            }else if(parseFloat(mToSaveDishPrice)<0 || parseFloat(mToSaveDishPrice)==0){
                alert("菜品单价需大于0");
                return false;
            }
            var mToSaveDishNum = $('#editDishNum').val();
            if(mToSaveDishNum == ""){
                alert("菜品总数量不能为空");
                return false;
            }else if(parseFloat(mToSaveDishNum)<0){
                alert("菜品总数量不能为负");
                return false;
            }
            var mToSaveDishDesc = $('#editDishDesc').val();
            if(mToSaveDishDesc == ""){
                alert("菜品描述不能为空");
                return false;
            }
            var mToSaveDishRec = $('#editDishRec').val();
            if(mToSaveDishRec == ""){
                alert("推荐指数不能为空");
                return false;
            }else if(parseFloat(mToSaveDishRec)>5 || parseFloat(mToSaveDishRec)<0){
                alert("推荐指数范围需在0~5之间");
                return false;
            }
            var mToSaveDishStatus = $('#selectDishStautsEdit option:selected').val();
            //console.log("mToSaveDishStatus: "+mToSaveDishStatus);
            var mToSaveDishTypeId = $('#selectdishTypeEdit option:selected').val();
            //console.log("mToSaveDishTypeId: "+mToSaveDishTypeId);
            var  mToSaveDishBargin = $('#selectDishBarginEdit option:selected').val();
            $.ajax({
                type: 'post',
                url: "http://192.168.1.180:8080/doft/manage/dish/save.do",
                data: {
                    'dishId':$('#editDishId').val(),
                    'dishTypeId' : mToSaveDishTypeId,
                    'dishName' : mToSaveDishName,
                    'price' : parseInt(mToSaveDishPrice),
                    'status': parseInt(mToSaveDishStatus),
                    'totalNumber' : parseInt(mToSaveDishNum),
                    'description' : mToSaveDishDesc,
                    'recommendIndex' : parseFloat(mToSaveDishRec),
                    'isBargainFlag': parseInt(mToSaveDishBargin)
                },
                dataType: 'json',
                xhrFields:{
                    withCredentials:true
                },
                crossDomain:true,
                success: function(data){
                    if(data.status == '0'){
                        //console.log("edit successfully!");
                        //window.location.href="../systemSettings/basicSettings.jsp";
                        location.reload(true);
                    }else if(data.status == '10'){
                        alert(data.msg);
                        window.location.href="../login.jsp";
                    }else{
                        alert(data.msg);
                    }
                },
                error: function(data){
                    alert(" create error!");
                }
            });
        }
    );
    $('#btn-save-dish-type-delete').click(function () {
            var mToDeleteDishTypeId = $('#selectdishTypeDelete option:selected').val();
            //console.log("mToDeleteDishTypeId: "+mToDeleteDishTypeId);
            $.ajax({
                type: 'post',
                url: "http://192.168.1.180:8080/manage/dish_type/delete_dish_type.do",
                data: {
                    'dishTypeId' : mToDeleteDishTypeId
                },
                dataType: 'json',
                xhrFields:{
                    withCredentials:true
                },
                crossDomain:true,
                success: function(data){
                    if(data.status == '0'){
                        alert("成功删除菜系!");
                        //window.location.href="../systemSettings/basicSettings.jsp";
                        location.reload(true);
                    }else if(data.status == '10'){
                        alert(data.msg);
                        window.location.href="../login.jsp";
                    }else{
                        alert(data.msg);
                    }
                },
                error: function(data){
                    alert(" create error!");
                }
            });
        }
    );
</script>
<script>
    function onEdit(obj){
        $('#editDishId').val($(obj).parent().parent().parent("tr").children('td').eq(2).text());

        $('#editDishName').val($(obj).parent().parent().parent("tr").children('td').eq(3).text());

        $('#editDishNum').val($(obj).parent().parent().parent("tr").children('td').eq(6).text());

        $('#editDishPrice').val($(obj).parent().parent().parent("tr").children('td').eq(5).text().split(' ')[1]);

        $('#editDishDesc').val($(obj).parent().parent().parent("tr").children('td').eq(7).text());

        var recIndex = $(obj).parent().parent().parent("tr").children('td').eq(8).text().split(' / ')[0];

        $('#editDishRec').val(recIndex);

        var isBargin = $(obj).parent().parent().parent("tr").children('td').eq(9).text();
        if(isBargin == '参与'){
            $('#selectDishBarginEdit').val(1);
        }else{
            $('#selectDishBarginEdit').val(0);
        }

        var mtype = $(obj).parent().parent().parent("tr").children('td').eq(10).text();
        var mtypeint = 1;
        if(mtype == '已下架'){
            mtypeint = 2;
        }
        $('#selectDishStautsEdit').val(mtypeint);

        var meditDishTypeName = $(obj).parent().parent().parent("tr").children('td').eq(1).text();
        var meditDishId = 0;

        $.ajax({
            type: 'post',
            url: "http://192.168.1.180:8080/manage/dish_type/get_all_dish_type.do",
            dataType: 'json',
            xhrFields:{
                withCredentials:true
            },
            crossDomain:true,
            success: function(data){
                if(data.status == '0'){
                    var dataList = [];
                    var dishTypeIdList = [];
                    for(var i=0;i<data.data.length;i++){
                        var d = data.data[i];
                        dataList.push(d.typeName);
                        dishTypeIdList.push(d.dishTypeId);
                    }
                    document.getElementById("selectdishTypeEdit").innerHTML = "";
                    for (var i = 0; i < dataList.length; i++) {
                        //先创建好select里面的option元素
                        var option = document.createElement("option");
                        //转换DOM对象为JQ对象,好用JQ里面提供的方法 给option的value赋值
                        $(option).val(dishTypeIdList[i]);
                        //console.log( $(option).val());
                        //给option的text赋值,这就是你点开下拉框能够看到的东西
                        $(option).text(dataList[i]);
                        //console.log( $(option).text());
                        //获取select 下拉框对象,并将option添加进select
                        $('#selectdishTypeEdit').append(option);
                        if(dataList[i] == meditDishTypeName){
                            meditDishId = dishTypeIdList[i];
                            $('#selectdishTypeEdit').val(meditDishId);
                        }
                    }
                }else if(data.status == '10'){
                    alert(data.msg);
                    window.location.href="../login.jsp";
                }else{
                    alert(data.msg);
                }
            },
            error: function(data){
                alert("get dish type error!");
            }
        });

        $('#modal-dish-edit').modal('show');
    }

    function onDelete(obj) {
        var dishid = parseInt($(obj).parent().parent().parent("tr").children('td').eq(2).text());
        //console.log("to delete: "+ dishid);
        $.ajax({
            type: 'post',
            url: "http://192.168.1.180:8080/doft/manage/dish/set_sale_status.do",
            data:{
                'dishId':dishid,
                'status':3
            },
            dataType: 'json',
            xhrFields:{
                withCredentials:true
            },
            crossDomain:true,
            success: function(data){
                if(data.status == '0'){
                    alert("菜品删除成功!");
                    location.reload(true);
                }else{
                    if(data.status == '10'){
                        window.location.href="../login.jsp";
                    }else{
                        alert(data.msg);
                    }

                }
            },
            error: function(data){
                alert("菜品删除失败!");
            }
        });
    }

    function onEditImg(obj){
        $('#editDishIdImg').val($(obj).parent().parent().parent("tr").children('td').eq(2).text());

        $('#editDishNameImg').val($(obj).parent().parent().parent("tr").children('td').eq(3).text());

        $('#editDishNumImg').val($(obj).parent().parent().parent("tr").children('td').eq(6).text());

        $('#editDishPriceImg').val($(obj).parent().parent().parent("tr").children('td').eq(5).text().split(' ')[1]);

        $('#editDishDescImg').val($(obj).parent().parent().parent("tr").children('td').eq(7).text());

        var recIndex = $(obj).parent().parent().parent("tr").children('td').eq(8).text().split(' / ')[0];

        $('#editDishRecImg').val(recIndex);

//        document.getElementById('dish-img-edit').src = document.getElementById('dish-img-table').getAttribute('src');
//        //console.log("img text"+document.getElementById('dish-img-table').getAttribute('src'));

        var isBargin = $(obj).parent().parent().parent("tr").children('td').eq(9).text();
        if(isBargin == '参与'){
            $('#selectDishBarginImg').val(1);
        }else{
            $('#selectDishBarginImg').val(0);
        }

        var mtype = $(obj).parent().parent().parent("tr").children('td').eq(10).text();
        var mtypeint = 1;
        if(mtype == '已下架'){
            mtypeint = 2;
        }
        $('#selectDishStautsEditImg').val(mtypeint);

        var meditDishTypeName = $(obj).parent().parent().parent("tr").children('td').eq(1).text();
        var meditDishId = 0;

        $.ajax({
            type: 'post',
            url: "http://192.168.1.180:8080/manage/dish_type/get_all_dish_type.do",
            dataType: 'json',
            xhrFields:{
                withCredentials:true
            },
            crossDomain:true,
            success: function(data){
                if(data.status == '0'){
                    var dataList = [];
                    var dishTypeIdList = [];
                    for(var i=0;i<data.data.length;i++){
                        var d = data.data[i];
                        dataList.push(d.typeName);
                        dishTypeIdList.push(d.dishTypeId);
                    }
                    document.getElementById("selectdishTypeEditImg").innerHTML = "";
                    for (var i = 0; i < dataList.length; i++) {
                        //先创建好select里面的option元素
                        var option = document.createElement("option");
                        //转换DOM对象为JQ对象,好用JQ里面提供的方法 给option的value赋值
                        $(option).val(dishTypeIdList[i]);
                        //console.log( $(option).val());
                        //给option的text赋值,这就是你点开下拉框能够看到的东西
                        $(option).text(dataList[i]);
                        //console.log( $(option).text());
                        //获取select 下拉框对象,并将option添加进select
                        $('#selectdishTypeEditImg').append(option);
                        if(dataList[i] == meditDishTypeName){
                            meditDishId = dishTypeIdList[i];
                            $('#selectdishTypeEditImg').val(meditDishId);
                        }
                    }
                }else if(data.status == '10'){
                    alert(data.msg);
                    window.location.href="../login.jsp";
                }else{
                    alert(data.msg);
                }
            },
            error: function(data){
                alert("get dish type error!");
            }
        });
//        document.getElementById('dish-img-edit').src = document.getElementById('dish-img-table').getAttribute('src');
//        //console.log("img text"+document.getElementById('dish-img-table').getAttribute('src'));

        $('#modal-dish-edit-img').modal('show');
    }

</script>
<script>
    $('#btn-save-dish-type').click(function () {
            //console.log("in save dish type");

            var typeName = $('#createDishType').val();
            if(typeName == ""){
                alert("菜系名称不能为空");
                return false;
            }

            $.ajax({
                type: 'post',
                url: "http://192.168.1.180:8080/manage/dish_type/add_dish_type.do",
                data: {'typeName':typeName},
                dataType: 'json',
                xhrFields:{
                    withCredentials:true
                },
                crossDomain:true,
                success: function(data){
                    if(data.status == '0'){
                        alert("添加新菜系成功!");
                        //window.location.href="../systemSettings/basicSettings.jsp";
                        location.reload(true);
                    }else if(data.status == '10'){
                        alert(data.msg);
                        window.location.href="../login.jsp";
                    }else{
                        alert(data.msg);
                    }
                },
                error: function(data){
                    alert("add error!");
                }
            });
        }
    );
</script>
<script>
    $('#btn-save-desknum').click(function () {
            //console.log("in save desk num");

            var mNeweskNum = $('#createDeskNum').val();
            var mUsedNum = parseInt($('#desk-used-num').val());
            if(mNeweskNum == ""){
                alert("餐桌数量不能为空");
                return false;
            }else if(mNeweskNum <0){
                alert("餐桌数量不能为负");
                return false;
            }else if(mNeweskNum <mUsedNum){
                alert('新设置餐桌数量不能少于已占用餐桌数');
                return false;
            }
            var count = parseInt(mNeweskNum);
            //console.log("count: ",count);
            $.ajax({
                type: 'post',
                url: "http://192.168.1.180:8080/doft/manage/desk/initDeskByCount.aj",
                data: {'count':count},
                dataType: 'json',
                xhrFields:{
                    withCredentials:true
                },
                crossDomain:true,
                success: function(data){
                    if(data.status == '0'){
                        alert("更新餐桌数量成功!");
                        //window.location.href="../systemSettings/basicSettings.jsp";
                        location.reload(true);
                    }else if(data.status == '10'){
                        alert(data.msg);
                        window.location.href="../login.jsp";
                    }else{
                        alert(data.msg);
                    }
                },
                error: function(data){
                    alert("create desk num error!");
                }
            });
        }
    );
</script>
<script>
    $(function () {
        $("#ajaxForm").submit(function () {
            $(this).ajaxSubmit(function (data) {
                var dishImgFileUrl = data.data.url;

                var mToSaveDishName = $('#addDishName').val();
                if(mToSaveDishName == ""){
                    alert("菜品名称不能为空");
                    return false;
                }
                var mToSaveDishPrice = $('#addDishPrice').val();
                if(mToSaveDishPrice == ""){
                    alert("菜品单价不能为空");
                    return false;
                }else if(parseFloat(mToSaveDishPrice)<0 || parseFloat(mToSaveDishPrice)==0){
                    alert("菜品单价需大于0");
                    return false;
                }
                var mToSaveDishNum = $('#addDishNum').val();
                if(mToSaveDishNum == ""){
                    alert("菜品总数量不能为空");
                    return false;
                }else if(parseFloat(mToSaveDishNum)<0){
                    alert("菜品总数量不能为负");
                    return false;
                }
                var mToSaveDishDesc = $('#addDishDesc').val();
                if(mToSaveDishDesc == ""){
                    alert("菜品描述不能为空");
                    return false;
                }
                var mToSaveDishRec = $('#addDishRec').val();
                if(mToSaveDishRec == ""){
                    alert("推荐指数不能为空");
                    return false;
                }else if(parseFloat(mToSaveDishRec)>5 || parseFloat(mToSaveDishRec)<0){
                    alert("推荐指数范围需在0~5之间");
                    return false;
                }
                var mToSaveDishTypeId = $('#selectdishType option:selected').val();
                //console.log("mToSaveDishTypeId: "+mToSaveDishTypeId);
                var mToSaveDishBargin = $('#selectDishBarginAdd option:selected').val();


                $.ajax({
                    type: 'post',
                    url: "http://192.168.1.180:8080/doft/manage/dish/save.do",
                    data: {
                        'dishTypeId' : mToSaveDishTypeId,
                        'dishName' : mToSaveDishName,
                        'price' : parseInt(mToSaveDishPrice),
                        'totalNumber' : parseInt(mToSaveDishNum),
                        'description' : mToSaveDishDesc,
                        'recommendIndex' : parseFloat(mToSaveDishRec),
                        'dishImgUrl' : dishImgFileUrl,
                        'isBargainFlag':parseInt(mToSaveDishBargin)
                    },
                    //contentType : 'application/json; charset=utf-8',
                    dataType: 'json',
                    xhrFields:{
                        withCredentials:true
                    },
                    crossDomain:true,
                    success: function(data){
                        if(data.status == '0'){
                            //console.log("create successfully!");
                            //window.location.href="../systemSettings/basicSettings.jsp";
                            location.reload(true);
                        }else if(data.status == '10'){
                            alert(data.msg);
                            window.location.href="../login.jsp";
                        }else{
                            alert(data.msg);
                        }
                    },
                    error: function(data){
                        alert(" create error!");
                    }
                });

            });
            return false;
        });
    });
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
                        var s = "<li>" + "<a href=\"../orderManage/order-list.jsp\">" + "<i class=\"fa fa-file-text text-primary\"></i> 新添加了"+newOrderNum+"个订单" + "</a>" + "</li>";
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
                        var s = "<li>" + "<a href=\"../orderManage/user-apply-list.jsp\">" + "<i class=\"fa fa-comments text-success\"></i> 新添加了"+newReqNum+"个申请" + "</a>" + "</li>";
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
    //    <!--今日新增用户数量-->
    $(function () {
        "use strict";
        $.ajax({
            type: 'post',
            url: "http://192.168.1.180:8080/doft/manage/user/addedUserCount.aj",
            dataType: 'json',
            xhrFields:{
                withCredentials:true
            },
            crossDomain:true,
            success: function(data){
                if(data.status == '0'){
                    var newUserNum = data.data;
                    $('#new-user-num').text(newUserNum);
                    if(parseInt(newUserNum)!=0){
                        var s = "<li>" + "<a href=\"../userManage/user-manage.jsp\">" + "<i class=\"fa fa-users text-maroon\"></i> 新添加了"+newUserNum+"个用户" + "</a>" + "</li>";
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
    //    <!--今日新增菜品数量-->
    $(function () {
        "use strict";
        $.ajax({
            type: 'post',
            url: "http://192.168.1.180:8080/doft/manage/dish/addedDishCount.aj",
            dataType: 'json',
            xhrFields:{
                withCredentials:true
            },
            crossDomain:true,
            success: function(data){
                if(data.status == '0'){
                    var newDishNum = data.data;
                    $('#new-dish-num').text(newDishNum);
                    if(parseInt(newDishNum)!=0){
                        var s = "<li>" + "<a href=\"../systemSettings/basicSettings.jsp\">" + "<i class=\"fa fa-cutlery text-orange\"></i> 新添加了"+newDishNum+"个菜品" + "</a>" + "</li>";
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
                        var s = "<li>" + "<a href=\"../orderManage/order-list.jsp\">" + "<i class=\"fa fa-file-text text-primary\"></i>  您有"+newReqNum+"条待处理订单" + "</a>" + "</li>";
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
                    }else if(user.roleId == 1){
                        $('#roleName').text('普通管理员');
                        var t = setTimeout("window.location.href=\"../orderManage/order-list-limit.jsp\"",500);
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