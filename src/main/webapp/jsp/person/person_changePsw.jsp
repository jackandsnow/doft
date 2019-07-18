<%--
  Created by IntelliJ IDEA.
  User: wangxue
  Date: 18/3/10
  Time: 下午3:18
  To change this template use File | Settings | File Templates.
--%>
<html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:ser var = "ctx" value="${pageContext.request.contextPath}"/>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Personal change Password</title>
    <link rel="stylesheet" href="../../css/common.css">
    <link rel="stylesheet" href="../../css/person_changePsw.css" type="text/css">
    <script type="text/javascript" src="../../resource/js/jquery-1.12.4.js"></script>
</head>

<body>
    <div id="left">
        <div id="sideBar">
            <ul class="nav  nav-stacked">
                <%--<li id="01" class="bar active"><a href="http://192.168.1.180:8080/doft/personalCenter.do">账户信息</a></li>--%>
                <li id="01" class="bar active"><a href="${ctx}/jsp/person/person_info_finished.jsp">账户信息</a></li>
                <li id="02" class="bar"><a href="${ctx}/jsp/person/person_news.jsp">我的消息</a></li>
            </ul>
        </div>
    </div>
    <div id="contain">
        <div class="person_wrapper">
            <div class="info">
                <div class="info_row">
                    <div class="info_lable"><lable>原密码</lable></div>
                    <div class="info_input">
                        <input type="password" id="oldPsw" class="form-control" value="" style="border:0px; border-bottom: 1px solid lightgrey; color: #FB9100; background-color: #FEFEFB;box-shadow: none; width: 200px; text-align: center"/>
                    </div>
                </div>
                <div class="info_row">
                    <div class="info_lable"><lable>新密码</lable></div>
                    <div class="info_input">
                        <input type="password" id="newPsw" class="form-control"  value="" style="border:0px; border-bottom: 1px solid lightgrey; color: #FB9100; background-color: #FEFEFB;box-shadow: none; width: 200px; text-align: center"/>
                    </div>
                </div>
                <div class="info_row">
                    <div class="info_lable"><lable>再次输入密码</lable></div>
                    <div class="info_input">
                        <input type="password" id="newPswAgain" class="form-control"  value="" style="border:0px; border-bottom: 1px solid lightgrey; color: #FB9100; background-color: #FEFEFB;box-shadow: none;width: 200px; text-align: center"/>
                    </div>
                </div>
                <div class="info_row">
                    <div id="error_msg"></div>
                </div>
            </div>
            <div class="but_group" id="Buts">
                <button id="change_info" class="but1" type="button">保存</button>
            </div>
        </div>
    </div>

    <script src="${ctx}/js/common_func.js" type="text/javascript"></script>
<script type="text/javascript">
    $("#change_info").click(function () {
        var oldPsw = $("#oldPsw").val().trim();
        var newPsw = $("#newPsw").val().trim();
        var newPswAgain = $("#newPswAgain").val().trim();
        if (oldPsw.length == 0 || newPsw.length == 0 || newPswAgain.length === 0){
            document.getElementById("error_msg").innerHTML = "输入不能为空 ！";
            return;
        }
        if (CheckPassWord(newPsw)!= true) {
            document.getElementById("error_msg").innerHTML = "输入8-20位字符，包含数字和字母的密码";
            return;
        }
        if (newPsw != newPswAgain){
            document.getElementById("error_msg").innerHTML = "密码两次输入不同！";
            return;
        }
        else {
            $.ajax({
                url : "http://192.168.1.180:8080/user/reset_password.do",//url
                xhrFields: {           withCredentials: true       },
                crossDomain: true,
                type : "POST",//方法类型
                dataType: "json",//预期服务器返回的数据类型
                data: {"passwordOld":oldPsw,"passwordNew":newPswAgain},
                error : function(xhr, status, error) {
                    console.info(JSON.stringify(xhr));
                },
                success : function(data) {
//                    console.log(data);
                    if (data.status == '0'){
//                        console.log("change psw ok");
                        console.log(data);
                        window.location.href="${ctx}/jsp/person/person_info_finished.jsp";//js跳转页面
//                        window.location.href="http://192.168.1.180:8080/doft/personalCenter.do";

                    }
                    else{
                        document.getElementById("error_msg").innerHTML = data.msg;//原密码错误的提示
                    }
                }
            });
        }
    });
</script>
</body>
</html>
