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
                <li class="active">人员设置</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">管理员列表</h3>
                            <div class="pull-right">
                                <button type="button" class="btn btn-block btn-primary" id="btnAddNewAdmin" data-toggle="modal" data-target="#modal-manager-add">+新增管理员</button>
                            </div>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body mailbox-messages">
                            <table id="manager-table"></table>
                        </div>
                        <!-- /.box-body -->
                        <div class="modal fade" id="modal-manager-edit">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span></button>
                                        <h4 class="modal-title">
                                            编辑管理员信息
                                        </h4>
                                    </div>
                                    <div class="modal-body">
                                        <div class="row">
                                            <div class="col-xs-12">
                                                <form class="form-horizontal">
                                                    <div hidden class="form-group">
                                                        <label class="col-sm-2 control-label">用户Id</label>
                                                        <div class="col-sm-10">
                                                            <input type="text" class="form-control" id="inputUserId" placeholder="请输入用户名">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label">用户名</label>
                                                        <div class="col-sm-10">
                                                            <input type="text" class="form-control" id="inputUsername" placeholder="请输入用户名">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label">手机号</label>
                                                        <div class="col-sm-10">
                                                            <input type="text" class="form-control" id="inputPhoneNumber" placeholder="请输入手机号">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label">账户余额</label>
                                                        <div class="col-sm-10">
                                                            <input disabled type="number" class="form-control" id="inputMoney" placeholder="请输入账户余额">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label">用户类型</label>
                                                        <div class="col-sm-10">
                                                            <select id="selectType" class="form-control">
                                                                <option value="0">普通管理员</option>
                                                                <option value="1">超级管理员</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                    <div hidden class="form-group">
                                                        <form id="ajaxFormEdit" method="post" action="http://192.168.1.180:8080/doft/manage/dish/upload.do" enctype="multipart/form-data">
                                                            <label class="col-sm-2 control-label">用户头像</label>
                                                            <div class="col-sm-10">
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
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default pull-left" name="btn-cancel-edit" id="btn-cancel-edit" data-dismiss="modal">取消修改</button>
                                        <button type="button" class="btn btn-success" name="btn-save-edit" id="btn-save-edit" data-dismiss="modal">确认修改</button>
                                    </div>
                                </div>
                                <!-- /.modal-content -->
                            </div>
                            <!-- /.modal-dialog -->
                        </div>
                        <!-- /.modal -->
                        <div class="modal fade" id="modal-manager-add">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span></button>
                                        <h4 class="modal-title">
                                            新增管理员
                                        </h4>
                                    </div>
                                    <div class="modal-body">
                                        <div class="row">
                                            <div class="col-xs-12">
                                                <div class="form-horizontal">
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label">用户名</label>
                                                        <div class="col-sm-10">
                                                            <input type="text" class="form-control" id="addUsername" placeholder="请输入用户名">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label">手机号</label>
                                                        <div class="col-sm-10">
                                                            <input type="text" class="form-control" id="addPhoneNumber" placeholder="请输入手机号">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label">密码</label>
                                                        <div class="col-sm-10">
                                                            <input type="password" class="form-control" id="addPassword" placeholder="请输入密码">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label">账户余额</label>
                                                        <div class="col-sm-10">
                                                            <input type="number" class="form-control" id="addMoney" placeholder="请输入账户余额">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label">用户类型</label>
                                                        <div class="col-sm-10">
                                                            <select id="addSelectType" class="form-control">
                                                                <option value="0">普通管理员</option>
                                                                <option value="1">超级管理员</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <form id="ajaxFormAdd" method="post" action="http://192.168.1.180:8080/doft/manage/dish/upload.do" enctype="multipart/form-data">
                                                            <label class="col-sm-2 control-label">用户头像</label>
                                                            <div class="col-sm-10">
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

                        <div class="modal fade" id="modal-dish-edit-img">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span></button>
                                        <h4 class="modal-title">
                                            更改用户头像
                                        </h4>
                                    </div>
                                    <div class="modal-body">
                                        <div class="row">
                                            <div class="col-xs-12">
                                                <div class="form-horizontal">
                                                    <div hidden class="form-group">
                                                        <label class="col-sm-2 control-label">用户Id</label>
                                                        <div class="col-sm-10">
                                                            <input type="text" class="form-control" id="inputUserIdImg" placeholder="请输入用户名">
                                                        </div>
                                                    </div>
                                                    <div hidden class="form-group">
                                                        <label class="col-sm-2 control-label">用户名</label>
                                                        <div class="col-sm-10">
                                                            <input type="text" class="form-control" id="inputUsernameImg" placeholder="请输入用户名">
                                                        </div>
                                                    </div>
                                                    <div hidden class="form-group">
                                                        <label class="col-sm-2 control-label">手机号</label>
                                                        <div class="col-sm-10">
                                                            <input type="text" class="form-control" id="inputPhoneNumberImg" placeholder="请输入手机号">
                                                        </div>
                                                    </div>
                                                    <div hidden class="form-group">
                                                        <label class="col-sm-2 control-label">账户余额</label>
                                                        <div class="col-sm-10">
                                                            <input disabled type="number" class="form-control" id="inputMoneyImg" placeholder="请输入账户余额">
                                                        </div>
                                                    </div>
                                                    <div hidden class="form-group">
                                                        <label class="col-sm-2 control-label">用户类型</label>
                                                        <div class="col-sm-10">
                                                            <select id="selectTypeImg" class="form-control">
                                                                <option value="0">普通管理员</option>
                                                                <option value="1">超级管理员</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <form id="ajaxFormImg" method="post" action="http://192.168.1.180:8080/doft/manage/dish/upload.do" enctype="multipart/form-data">
                                                            <label class="col-sm-3 control-label">更改用户头像</label>
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
                    </div>
                </div>
                <!-- /.col -->
            </div>

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
<!-- iCheck -->
<script src="../../plugins/iCheck/icheck.min.js"></script>
<!-- Page Script -->
<script src="../../js/common_func.js"></script>
<script>
    $(document).ready(function () {
        $.ajax({
            type: 'post',
            url: "http://192.168.1.180:8080/doft/manage/user/getAllUsersByType.aj",
            data:{
                'type':1
            },
            dataType: 'json',
            xhrFields:{
                withCredentials:true
            },
            crossDomain:true,
            success: function(data, status){
                if(data.status == '0'){
                    //var dataObj=eval("("+data+")");
                    var obj = [];
                    for(var i=0;i<data.data.length;i++){
                        var d = data.data[i];
                        //console.log('data:'+d.username);
                        obj.push(d);
                    }
                    //console.log('status: '+status);
                    $table = $('#manager-table').bootstrapTable({
                        data:obj,
                        queryParamsType: '',              //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
                        //queryParams: queryParams,
                        method: "post",
                        pagination: true,
                        xhrFields:{
                            withCredentials:true
                        },
                        crossDomain:true,
                        sortable: true,                     //是否启用排序
                        sortOrder: "asc",                   //排序方式
                        pageNumber: 1,                      //初始化加载第一页，默认第一页
                        pageSize: 10,                       //每页的记录行数（*）
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
                            { title: '用户Id', field: 'userId',sortable:true},
                            { title: '用户名',field: 'userName',sortable:true},
                            { title: '手机号', field: 'phoneNumber',sortable:true},
                            { title: '账户余额（元）', field: 'remainingMoney',sortable:true,
                                formatter: function (value, row, index) {
                                    var html = "<span>"+"¥ "+value+"</span>";
                                    return html;
                                }},
                            { title: '注册时间', field: 'creationTime',sortable:true },
                            { title: '用户头像', field: 'headUrl' ,sortable:true,
                                formatter: function(value,row,index){
                                    return "<img  src="+value+"  width=\"40px\" height=\"40px\" >";
                                }},
                            { title: '用户类型', field: 'userType' ,sortable:true},
                            { title: '操作',  formatter: function (value, row, index) {
                                return "<div class='btn-group'><button type='button' class='btn btn-default btn-sm' onclick='onEdit(this)'><i class='fa fa-edit'></i></button>" +
                                    "<button type='button' class='btn btn-default btn-sm' onclick='onEditImg(this)'><i class='fa fa-picture-o'></i></button>" +
                                    "<button type='button' class='btn btn-default btn-sm' onclick='onDelete(this)'><i class='fa fa-trash-o'></i></button></div>";
                            }}
                        ]
                    });
                }else if(data.status == '10'){
                    alert(data.msg);
                    window.location.href="../login.jsp";
                }else{
                    alert(data.msg);
                    window.location.href="../login.jsp";
                }
            },
            error: function(data){
                alert("error!");
            }
        })
    })
</script>
<script>
    $('#btn-save-edit').click(function () {
        var submit = new Object();

        var mToSaveUsername = $('#inputUsername').val();
        if(mToSaveUsername == ""){
            alert("用户名不能为空");
            return false;
        }
        var mToSavePhonenum = $('#inputPhoneNumber').val();
        if(mToSavePhonenum == ""){
            alert("手机号不能为空");
            return false;
        }else if(mToSavePhonenum.length!=11 || !(/^((\d{3}-\d{8}|\d{4}-\d{7,8})|(1[3|5|7|8][0-9]{9}))$/.test(mToSavePhonenum))){
            alert("手机号填写的格式不对，请正确填写");
            return false;
        }

        var mToSaveRoleId = $('#selectType option:selected').val();
        //console.log("mToSaveRoleId: "+mToSaveRoleId);
        if(mToSaveRoleId == '0'){
            submit.roleId = 1;
        }else{
            submit.roleId = 2;
        }
        submit.userName = mToSaveUsername;
        submit.phoneNumber = mToSavePhonenum;
        submit.userId =  parseInt($('#inputUserId').val());

        //console.log("to save: "+$('#inputUserId').val());
        //console.log("to save: "+mToSaveUsername);
        //console.log("to save: "+mToSavePhonenum);

        $.ajax({
            type: 'post',
            url: "http://192.168.1.180:8080/doft/manage/user/updateAdminInfo.aj",
            data: JSON.stringify(submit),
            contentType : 'application/json; charset=utf-8',
            dataType: 'json',
            xhrFields:{
                withCredentials:true
            },
            crossDomain:true,
            success: function(data){
                if(data.status == '0'){
                    alert("修改管理员信息成功！");
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
                alert(mToSaveUsername+" edit error!");
            }
        });
    }
    );
</script>
<script>
    function onEdit(obj){
        $('#inputUserId').val($(obj).parent().parent().parent("tr").children('td').eq(1).text());

        var musername = $(obj).parent().parent().parent("tr").children('td').eq(2).text();
        $('#inputUsername').val(musername);
        //console.log("in edit modal username: "+musername);

        var mphonenumber = $(obj).parent().parent().parent("tr").children('td').eq(3).text();
        $('#inputPhoneNumber').val(mphonenumber);
        //console.log(mphonenumber);

        var mmoney = $(obj).parent().parent().parent("tr").children('td').eq(4).text().split(' ')[1];
        $('#inputMoney').val(mmoney);

        var mtype = $(obj).parent().parent().parent("tr").children('td').eq(7).text();
        var mtypeint = 0;
        if(mtype == '超级管理员'){
            mtypeint = 1;
        }
        $('#selectType').val(mtypeint);

        $('#modal-manager-edit').modal('show');
    }

    function onDelete(obj) {
        var muserid = $(obj).parent().parent().parent("tr").children('td').eq(1).text();
        //console.log("to delete: "+ muserid);
        $.ajax({
            type: 'post',
            url: "http://192.168.1.180:8080/doft/manage/user/deleteAdminByAdminId.aj",
            data:{
                'adminId':muserid
            },
            dataType: 'json',
            xhrFields:{
                withCredentials:true
            },
            crossDomain:true,
            success: function(data){
                if(data.status == '0'){
                    alert("删除管理员成功！");
                    location.reload(true);
                }else if(data.status == '10'){
                    alert(data.msg);
                    window.location.href="../login.jsp";
                }else{
                    alert(data.msg);
                }
            },
            error: function(data){
                alert(mphonenumToDelete +" delete error!");
            }
        });
    }

    function onEditImg(obj){
        $('#inputUserIdImg').val($(obj).parent().parent().parent("tr").children('td').eq(1).text());

        var musername = $(obj).parent().parent().parent("tr").children('td').eq(2).text();
        $('#inputUsernameImg').val(musername);
        //console.log("in edit modal username: "+musername);

        var mphonenumber = $(obj).parent().parent().parent("tr").children('td').eq(3).text();
        $('#inputPhoneNumberImg').val(mphonenumber);
        //console.log(mphonenumber);

        var mmoney = $(obj).parent().parent().parent("tr").children('td').eq(4).text().split(' ')[1];
        $('#inputMoneyImg').val(mmoney);

        var mtype = $(obj).parent().parent().parent("tr").children('td').eq(7).text();
        var mtypeint = 0;
        if(mtype == '超级管理员'){
            mtypeint = 1;
        }
        $('#selectTypeImg').val(mtypeint);

        $('#modal-dish-edit-img').modal('show');
    }
</script>
<script>
    $(function () {
        $("#ajaxFormAdd").submit(function () {
            $(this).ajaxSubmit(function (data) {
                var submit = new Object();
                var userImgFileUrl = data.data.url;
                //console.log("userImgFileUrl"+userImgFileUrl);

                var mToSaveUsername = $('#addUsername').val();
                if(mToSaveUsername == ""){
                    alert("用户名不能为空");
                    return false;
                }
                var mToSavePhonenum = $('#addPhoneNumber').val();
                if(mToSavePhonenum == ""){
                    alert("手机号不能为空");
                    return false;
                }else if(mToSavePhonenum.length!=11 || !(/^((\d{3}-\d{8}|\d{4}-\d{7,8})|(1[3|5|7|8][0-9]{9}))$/.test(mToSavePhonenum))){
                    alert("手机号填写的格式不对，请正确填写");
                    return false;
                }

                var mToSavePassword = $('#addPassword').val();
                if(mToSavePassword == ""){
                    alert("密码不能为空");
                    return false;
                }else if(mToSavePassword.length<8 || mToSavePassword.length>20){
                    alert("密码长度需为8~20位");
                    return false
                }else if(!(/^(?=.*[a-zA-Z]+)(?=.*[0-9]+)[a-zA-Z0-9]+$/.test(mToSavePassword))){
                    alert("密码必须为数字和字母的组合，不能包含特殊字符");
                    return false;
                }

                var mToSaveMoney = $('#addMoney').val();
                if(mToSaveMoney == ""){
                    alert("账户余额不能为空");
                    return false;
                }else if(parseFloat(mToSaveMoney)<0){
                    alert("账户余额不能为负");
                    return false;
                }
                var mToSaveRoleId = $('#addSelectType option:selected').val();
                //console.log("mToSaveRoleId: "+mToSaveRoleId);
                if(mToSaveRoleId == '0'){
                    submit.roleId = 1;
                }else{
                    submit.roleId = 2;
                }
                submit.userName = mToSaveUsername;
                submit.phoneNumber = mToSavePhonenum;
                submit.password = mToSavePassword;
                submit.remainingMoney = mToSaveMoney;
                submit.headUrl = userImgFileUrl;
                $.ajax({
                    type: 'post',
                    url: "http://192.168.1.180:8080/doft/manage/user/updateAdminInfo.aj",
                    data: JSON.stringify(submit),
                    contentType : 'application/json; charset=utf-8',
                    dataType: 'json',
                    xhrFields:{
                        withCredentials:true
                    },
                    crossDomain:true,
                    success: function(data){
                        if(data.status == '0'){
                            alert("新增管理员成功！");
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
    $(function () {
        $("#ajaxFormImg").submit(function () {
            $(this).ajaxSubmit(function (data) {
                var dishImgFileUrl = data.data.url;
                //console.log("dishImgFileUrl"+dishImgFileUrl);
                var submit = new Object();

                var mToSaveUsername = $('#inputUsernameImg').val();
                var mToSavePhonenum = $('#inputPhoneNumberImg').val();
                var mToSaveRoleId = $('#selectTypeImg option:selected').val();
                if(mToSaveRoleId == '0'){
                    submit.roleId = 1;
                }else{
                    submit.roleId = 2;
                }
                submit.userName = mToSaveUsername;
                submit.phoneNumber = mToSavePhonenum;
                submit.userId =  parseInt($('#inputUserIdImg').val());
                submit.headUrl = dishImgFileUrl;
                $.ajax({
                    type: 'post',
                    url: "http://192.168.1.180:8080/doft/manage/user/updateAdminInfo.aj",
                    data: JSON.stringify(submit),
                    contentType : 'application/json; charset=utf-8',
                    dataType: 'json',
                    xhrFields:{
                        withCredentials:true
                    },
                    crossDomain:true,
                    success: function(data){
                        if(data.status == '0'){
                            alert("修改用户头像成功！");
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
                        alert(mToSaveUsername+" edit error!");
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