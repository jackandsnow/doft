<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/12
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Delicious on Fingertips | Log in</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.7 -->
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="../bower_components/font-awesome/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="../bower_components/Ionicons/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="../back-stage-dist/css/AdminLTE.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="../back-stage-dist/css/login.css">
    <!-- iCheck -->
    <link rel="stylesheet" href="../plugins/iCheck/square/blue.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <!--<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>-->
    <!--<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>-->
    <!--<![endif]&ndash;&gt;-->

    <!--Google Font -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>

<body class="hold-transition login-page">
<div class="login-box">
    <!-- /.login-logo -->
    <div class="login-box-body">
        <div class="login-head-part">
            <img src="../back-stage-dist/img/login/doft_logo.png" class="login-doft-logo" alt="User Image">
            <span class="login-logo">
        <b>指尖上的美味 </b>点餐系统
      </span>
        </div>
        <p class="login-box-msg">  </p>
        <form action="orderManage/order-list.html" method="post">
            <div class="form-group has-feedback">
                <input type="text" id="username" name="username" class="form-control" placeholder="请输入您的用户名或手机号">
                <span class="glyphicon glyphicon-user form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="password" id="password" name="password" class="form-control" placeholder="请输入您的密码">
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>

            <div class="row">
                <div class="col-xs-8">
                    <%--<div class="checkbox icheck">--%>
                        <%--<label>--%>
                            <%--&lt;%&ndash;<input type="checkbox">&nbsp;&nbsp;记住我的用户名&ndash;%&gt;--%>
                        <%--</label>--%>
                    <%--</div>--%>
                </div>
            </div>
        </form>

        <!--<div class="social-auth-links text-center">-->
        <!--<a href="orderManage/order-list.html"><button type="submit" class="btn btn-block btn-tumblr btn-flat">登录</button></a>-->
        <!--</div>-->
        <div class="social-auth-links text-center">
            <button type="submit" class="btn btn-block btn-tumblr btn-flat" onclick="loginindex()">登录</button>
        </div>
        <%--<div class="forget-password-text"><span><a href="#">忘记密码？</a></span></div>--%>

    </div>
    <!-- /.login-box-body -->
</div>
<!-- /.login-box -->

<!-- jQuery 3 -->
<script src="../bower_components/jquery/dist/jquery.min.js"></script>
<%--<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>--%>
<!-- Bootstrap 3.3.7 -->
<%--<script src="../bower_components/bootstrap/dist/js/bootstrap.min.js"></script>--%>
<script src="http://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="../plugins/iCheck/icheck.min.js"></script>
<script>
//    $(function () {
//        $('input').iCheck({
//            checkboxClass: 'icheckbox_square-blue',
//            radioClass: 'iradio_square-blue',
//            increaseArea: '20%' /* optional */
//        });
//    });
</script>
<script>
    function loginindex() {
        if(document.getElementById("username").value==''||document.getElementById("password").value==''){
            alert("用户名和密码不能为空");
        }else{
            var name,pass;
            name= document.getElementById("username").value;
            pass= document.getElementById("password").value;
            console.log('username: '+name);
            console.log('password: '+pass);
            $.ajax({
                //async:false,
                type: "POST",
                xhrFields:{
                    withCredentials:true
                },
                crossDomain:true,
                url: "http://192.168.1.180:8080/doft/manage/user/login.do",//注意路径  (后台登陆验证的方法)
                data:{"username":name,"password":pass},
                dataType: "json",//预期服务器返回的数据类型
                error : function(xhr, status, error) {
                    console.info(JSON.stringify(xhr));
                    console.info("error");
                },
                success:function(data){
                    console.log('success data: '+data);
                    if (data.status == '0'){
                        console.log("登录成功");
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
                                alert("请求失败，请重新登录");
                                location.reload(true);
                            },
                            success : function(Rdata) {
                                console.log(Rdata);
                                if (Rdata.status == '0'){
                                    console.log("ok");
                                    var user = Rdata.data;
                                    if(user.roleId == 2){
                                        $('#roleName').text('超级管理员');
                                        window.location.href="orderManage/order-list.jsp"; //（验证成功后进入的页面）
                                    }else if(user.roleId == 1){
                                        $('#roleName').text('普通管理员');
                                        window.location.href="orderManage/order-list-limit.jsp"; //（验证成功后进入的页面）
                                    }else{
                                        alert("非管理员，无权进入");
                                        location.reload(true);
                                    }
                                }else{
                                    alert("用户请求失败，请重新登录");
                                    location.reload(true);
                                }
                            }
                        });
                    }else if(data.status == '10'){
                        alert(data.msg);
                        location.reload(true);
                    }else{
                        alert(data.msg);
                        location.reload(true);
                    }
                }
            });
        }
    }
</script>
</body>
</html>
