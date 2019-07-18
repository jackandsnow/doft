<%--
  Created by IntelliJ IDEA.
  User: wangxue
  Date: 18/3/13
  Time: 上午9:27
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE HTML>
<html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:ser var = "ctx" value="${pageContext.request.contextPath}"/>
<head>
    <meta charset="UTF-8">
    <title>register</title>
    <%--<script type="text/javascript" src="../../resource/js/jquery-ui.min.js"></script>--%>
    <!-- 引入Jquery js库文件 -->
    <script type="text/javascript" src="${ctx}/resource/js/jquery-1.12.4.js" ></script>
    <link rel="stylesheet" href="${ctx}/css/register.css">
</head>
<body>
<div class="login">
    <!-- 左侧图片 -->
    <div class="login_left" >
        <div class="login_left_img">
            <img src="${ctx}/resource/img/login_left.jpg">
        </div>
    </div>
    <!-- 手机号注册 -->
    <div class="form_wrapper">
        <form id="form_login" action="" method="post">
            <div class="oneform">
                <div class="form_label">
                    <label>手机</label>
                </div>
                <div class="form_input">
                    <input type="text" id="uphone" onkeyup="value=value.replace(/[^\d]/g,'')" placeholder="手机号">
                </div>
            </div>
            <div class="oneform">
                <div class="form_label" id="validation">
                    <label >验证码 </label>
                </div>
                <div class="form_input">
                    <input type="text" id="vali" placeholder="验证码"/>
                    <button id="send-number-button" class="plain-button" type="button">获取动态码</button>
                </div>
            </div>
            <div class="oneform">
                <div class="form_label">
                    <label >设置密码</label>
                </div>
                <div class="form_input">
                    <input type="password" id="pswd1" placeholder="输入8-20位字符，含数字和字母"/>
                </div>
            </div>
            <div class="oneform">
                <div class="form_label">
                    <label >密码重复</label>
                </div>
                <div class="form_input">
                    <input type="password" id="pswd2" placeholder="再次输入密码"/>
                </div>
            </div>
            <div class="oneform">
                <div class="form_label">
                    <label >设置昵称</label>
                </div>
                <div class="form_input">
                    <input type="text" id="uname" placeholder="输入你的昵称"/>
                </div>
            </div>
            <%--错误信息提示--%>
            <div id="hint_msg">
                <p id="error_msg"></p>
            </div>
            <!-- 返回登录 -->
            <div class="oneform">
                <%--<div id="hint_msg" class="form_input">
                    密码请输入8-20位字符，必须包含数字和字母
                </div>--%>
                <div id="login" class="form_label">
                    <a href="${ctx}/jsp/login/login.jsp"><p>登录</p></a>
                </div>
            </div>

            <!-- 注册按钮 -->
            <div class="oneform">
                <div class="login_btn">
                    <input id="register_btn" type="button" value="注册"/>
                </div>
            </div>
        </form>
    </div>
</div>

<script src="${ctx}/js/bmob-min.js"></script>
<script src="${ctx}/js/common_func.js"></script>
<script type="text/javascript">
    Bmob.initialize("253950cf6fe3d5d8682b0f4e0251ef63", "dd6ee8a5569911ae46d062ac15cdb21f");
    var uphone;
    var uvali;
    var upswd1;
    var upswd2;
    var uname;

    $("#send-number-button").click(function () {
        uphone = $("#uphone").val().trim(); // trim 去除字符串两端的空白字符
        if (CheckPhone(uphone) != true) {
            document.getElementById("hint_msg").innerHTML = "请输入11位手机号";
            return false;
        }
//        console.log(uphone);
        Bmob.Sms.requestSmsCode({"mobilePhoneNumber": uphone} ).then(function(obj) {//get code
//            alert("发送成功，smsId:"+obj.smsId);
            console.log("发送成功");
        }, function(err){
//            alert("发送失败:"+err);
            document.getElementById("hint_msg").innerHTML = "验证码发送失败，请再试一次";
        });
    });

    $("#register_btn").click(function () {
        upswd1 = $("#pswd1").val().trim();
        upswd2 = $("#pswd2").val().trim();
        uname = $("#uname").val().trim();
        uvali = $("#vali").val().trim();
        if (uvali.length != 6) {
            document.getElementById("hint_msg").innerHTML = "请输入6位验证码";
            return false;
        }
        if (CheckPassWord(upswd1)!= true) {
            document.getElementById("hint_msg").innerHTML = "密码请输入8-20位字符，必须包含数字和字母";
            return false;
        }
        if (upswd1 != upswd2) {
            document.getElementById("hint_msg").innerHTML = "两次密码输入不同";
            return false;
        }
        if (uname.length > 30 || uname.length < 2) {
            document.getElementById("hint_msg").innerHTML = "昵称请输入2-30位字符";
            return false;
        }
        Bmob.Sms.verifySmsCode(uphone, uvali).then(function(obj) {
//            alert("msg:"+obj.msg);
            if (obj.msg == "ok"){
                console.log("验证成功");
            }
        }, function(err){
//            alert("原因"+err);
            document.getElementById("hint_msg").innerHTML = "验证码错误！";
            return false;
        });
        if(uname!="" && upswd2!="" && uphone!=""){
            $.ajax({
                //get the input phoneNum;
                url : "http://192.168.1.180:8080/user/register.do",//url
                xhrFields: {           withCredentials: true       },
                crossDomain: true,
                type : "POST",//方法类型
                dataType: "json",//预期服务器返回的数据类型
                data: {"userName":uname,"password":upswd2, "phoneNumber":uphone},
                error : function(xhr, status, error) {
                    console.info(JSON.stringify(xhr));
                },
                success : function(data) {
//                    console.log(data);
                    if (data.status == '0'){
//                        console.log("ok");
                        window.location.href="${ctx}/jsp/login/login.jsp";//js跳转页面
                    }
                    else{
                        document.getElementById("hint_msg").innerHTML = data.msg;
                    }
                }
            });
        }
    })
</script>
</body>
</html>