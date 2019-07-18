<%@ page import="com.doft.pojo.User" %>
<%--
  Created by IntelliJ IDEA.
  User: wangxue
  Date: 18/3/10
  Time: 上午9:34
  To change this template use File | Settings | File Templates.
--%>
<%--<%@include file="/page/index.jsp"%>--%>
<%--<%@ taglib prefix="c" uri="http://localhost:8088/" %>--%>
<!DOCTYPE HTML>
<html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:ser var = "ctx" value="${pageContext.request.contextPath}"/>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Personal Information(finished)</title>
    <script type="text/javascript" src="${ctx}/resource/js/jquery-1.12.4.js"></script>
    <%--<link rel="stylesheet" href="${ctx}/resource/css/bootstrap.min.css" >--%>
    <!--<link rel="stylesheet" href="../resource/css/jquery-ui.min.css"-->
    <link rel="stylesheet" href="${ctx}/css/common.css">
    <link rel="stylesheet" href="${ctx}/css/person_info.css" type="text/css">
</head>
<body>
    <div id="left">
        <div id="sideBar">
            <ul class="nav  nav-stacked">
                <%--<li id="01" class="bar active"><a href="/doft/personalCenter.do">账户信息</a></li>--%>
                <%--<li id="01" class="bar active"><a href="http://192.168.1.180:8080/doft/personalCenter.do">账户信息</a></li>--%>
                <li id="01" class="bar active"><a href="${ctx}/jsp/person/person_info_finished.jsp">账户信息</a></li>
                <li id="02" class="bar"><a href="${ctx}/jsp/person/person_news.jsp">我的消息</a></li>
            </ul>
        </div>
    </div>
    <div id="contain">
            <div class="person_wrapper">
                <div class="pic_text">
                    <div class="pic">
                        <a class="avatar">
                            <img src="${ctx}/resource/img/person/flower.jpg" alt="">
                        </a>
                    </div>
                    <div class="info">
                        <div class="info_row">
                            <div class="info_lable"><lable>账户名</lable></div>
                            <div class="info_input">
                                <input type="text" id="userName" class="form-control"  readonly="readonly" value="" >
                            </div>
                        </div>
                        <div class="info_row">
                            <div class="info_lable"><lable>手机号</lable></div>
                            <div class="info_input">
                                <input type="text" id="phoneNumber" class="form-control"  readonly="readonly" value="" >
                            </div>
                        </div>
                        <div class="info_row">
                            <div class="info_lable"><lable>余  额</lable></div>
                            <div class="info_input">
                                <input type="text" id="remainingMoney" class="form-control"  readonly="readonly" value="" >
                            </div>
                        </div>
                        <div class="info_row" id="error_msg"></div>
                    </div>
                </div>
            </div>
            <div class="but_group" id="Buts">
                <button id="change_info" class="but1 mybtn" type="button">修改信息</button>
                <button id="change_pwd" class="but1 mybtn" type="button" onclick="javascript:gotoNewPsw()">修改密码</button>
                <%--<a href="${ctx}/jsp/person/person_changePsw.jsp">修改密码</a>--%>
                <button id="exit" class="but1 mybtn" type="button">退出账户</button>
            </div>
    </div>

<script type="text/javascript">
    <%--var userName = ${sessionScope.currentUser.userName};--%>
    <%--var userPhone = ${sessionScope.currentUser.phoneNumber};--%>
    <%--var userMoney = ${sessionScope.currentUser.remainingMoney};--%>
    <%--var userName = ${userName};--%>
    <%--var userPhone = ${phoneNumber};--%>
    <%--var userMoney = ${remainingMoney};--%>

    $(document).ready(function(){//展示用户信息
        $.ajax({
            //get the input phoneNum;
            url : "http://192.168.1.180:8080/user/get_information.do",//url
            xhrFields: {           withCredentials: true       },
            crossDomain: true,
            type : "POST",//方法类型
            dataType: "json",//预期服务器返回的数据类型
//            data: {"phoneNumber":Uname,"password":Upass},
            error : function(xhr, status, error) {
                console.info(JSON.stringify(xhr));
            },
            success : function(Rdata) {
                console.log(Rdata);
                if (Rdata.status == '0'){
                    console.log("ok");
                    var user = Rdata.data;
                    $("#userName").val(user.userName);
                    $("#phoneNumber").val(user.phoneNumber);
                    $("#remainingMoney").val(user.remainingMoney+' RMB');
                }
                else{
                    window.location.href="${ctx}/jsp/login/login.jsp";//should delete
                }
            }
        });
    });

    $("#change_info").click(function () {
        hideButs();
        $("#userName").focus();//光标位置
        $("#save").click(function () {
            var newUserName = $("#userName").val().trim();
            if (newUserName.length < 1 || newUserName.length >30){
//                document.getElementById("error_msg").innerHTML = "昵称请输入2-30位字符！";
                window.alert("昵称请输入2-30位字符");
                return;
            }
            console.log("save new info");
            $.ajax({
                url : "http://192.168.1.180:8080/user/update_information.do",//url
                xhrFields: {           withCredentials: true       },
                crossDomain: true,
                type : "POST",//方法类型
                dataType: "json",//预期服务器返回的数据类型
                data: {"userName":newUserName},
                error : function(xhr, status, error) {
                    console.info(JSON.stringify(xhr));
                    window.alert("网络异常");
                },
                success : function(data) {
//                    console.log(data);
                    if (data.status == '0'){
//                        console.log("change person info ok");
                        updateInfo();
                        <%--window.location.href="${ctx}/jsp/login/login.jsp";--%>
                    }
                    else{
                        window.alert("用户名未更改！");
                    }
                }
            });
        });
    });

    function hideButs() {
        $("#userName").removeAttr("readOnly");
        $(".but1").toggle();
        var saveBtn = $("<button id='save' class='but1' type='button'>保存</button>");
        $("#Buts").append(saveBtn);
    }
    function updateInfo() {// remove save button and add old buttons
        $("#userName").attr("readOnly");
        $("#save").remove();
        $(".but1").toggle();
    }
    
    function gotoNewPsw() {
        window.location.href= "${ctx}/jsp/person/person_changePsw.jsp";
    }

    $("#exit").click(function (){
        $.ajax({
            url : "http://192.168.1.180:8080/user/logout.do",//url
            xhrFields: {           withCredentials: true       },
            crossDomain: true,
            type : "POST",//方法类型
            dataType: "json",//预期服务器返回的数据类型
            error : function(xhr, status, error) {
                console.info(JSON.stringify(xhr));
            },
            success : function(data) {
//                console.log(data);
                if (data.status == '0'){
//                    console.log("exit ok");
                    is_login = 0;
                    var num = window.parent.document.getElementsByClassName('num_dish_in_car');
                    $(num).hide();
                    var headBar = window.parent.document.getElementsByClassName('headBar');
                    $(headBar).attr('id',is_login);
                    window.location.href="${ctx}/jsp/login/login.jsp";//js跳转页面
                }
                else{
                    window.alert("服务器忙，请稍候再试！");
                }
            }
        });
    })
</script>
</body>
</html>
