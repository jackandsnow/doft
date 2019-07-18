<%--
  Created by IntelliJ IDEA.
  User: ubuntu
  Date: 18-3-12
  Time: 下午7:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java"  contentType="text/html; charset=UTF-8" %>

<%--<html>--%>
<%--<body>--%>
<%--<h2>Hello World!</h2>--%>

<%--springmvc上传文件--%>
<%--<form name="form1" action="http://192.168.1.180:8080/doft/manage/dish/upload.do" method="post" enctype="multipart/form-data">--%>
    <%--<input type="file" name="upload_file" />--%>
    <%--<input type="submit" value="springmvc上传文件" />--%>
<%--</form>--%>
<%--<form id="showDataForm"--%>
      <%--action="http://192.168.1.180:8080/doft/manage/dish/upload.do" method="post" enctype="multipart/form-data">--%>
    <%--<input type="file" name="upload_file" />--%>
    <%--<input type="submit" value="springmvc上传文件" />--%>
    <%--<input type="submit" value="提交"/>--%>
<%--</form>--%>
<%--<div id="output1"--%>
     <%--style="width:1000px;height:200px;background-color:#eee;">--%>
<%--</div>--%>

<%--</body>--%>
<%--</html>--%>

<%--<script src="bower_components/jquery/dist/jquery.min.js"></script>--%>
<%--<script src="bower_components/jquery/dist/jquery.js"></script>--%>
<%--<script src="bower_components/jquery.form.js"></script>--%>
<%--<script>--%>
    <%--$(document).ready(function() {--%>
        <%--var options = {--%>
            <%--target: '#output1',--%>
            <%--// 从服务传过来的数据显示在这个div内部--%>
            <%--也就是ajax局部刷新--%>
            <%--beforeSubmit: showRequest,--%>
            <%--// ajax提交之前的处理--%>
            <%--success: showResponse--%>
        <%--// 处理之后的处理--%>
    <%--};--%>
        <%--$('#showDataForm').submit(function() {--%>
            <%--$(this).ajaxSubmit(options);--%>
            <%--return false;--%>
            <%--//非常重要，如果是false，则表明是不跳转--%>
            <%--//在本页上处理，也就是ajax，如果是非false，则传统的form跳转。--%>
        <%--});--%>
    <%--});--%>
    <%--function showResponse(responseText, statusText, xhr, $form) {--%>
        <%--alert(xhr.responseText+"=="+$form.attr("method")+'status: ' +--%>
            <%--statusText + '\n\nresponseText: \n' + responseText);--%>
<%--//xhr：说明你可以用ajax来自己再次发出请求--%>
<%--//$form：是那个form对象，是一个jquery对象--%>
<%--//statusText：状态，成功则为success--%>
<%--//responseText，服务器返回的是字符串（当然包括html，不包括json）--%>
    <%--}--%>
    <%--function showRequest(formData, jqForm, options) {--%>
        <%--//formData是数组，就是各个input的键值map数组--%>
        <%--//通过这个方法来进行处理出来拼凑出来字符串。--%>
        <%--//formData：拼凑出来的form字符串，比如name=hera&password，--%>
        <%--//其实就是各个表单中的input的键值对，--%>
        <%--//如果加上method=XXXX，那也就是相当于ajax内的data。--%>
        <%--var queryString = $.param(formData);--%>
        <%--alert(queryString+"======"+formData.length);--%>
        <%--for (var i=0; i < formData.length; i++) {--%>
            <%--alert(formData[i].value+"==============="+formData[i].name);--%>
        <%--}--%>
        <%--//jqForm，jquery form对象--%>
        <%--var formElement = jqForm[0];--%>
        <%--alert($(formElement).attr("method"));--%>
        <%--alert($(jqForm[0].name).attr("maxlength"));--%>
        <%--//非常重要，返回true则说明在提交ajax之前你验证--%>
        <%--//成功，则提交ajax form--%>
        <%--//如果验证不成功，则返回非true，不提交--%>
        <%--return true;--%>
    <%--}--%>


    <%--var options = {--%>
        <%--target: '#output1',--%>
        <%--data:{param1:"我自己的第一个额外的参数"},--%>
<%--//这个参数是指通过ajax来给服务器提交除了form内部input的参数--%>
<%--//在后台中使用String param1=req.getParameter("param1");获取。--%>
        <%--// dataType: null,--%>
        <%--dataType:'json',--%>
<%--//这个参数值的是服务器返回的数据类型，默认的是null--%>
<%--//也就是服务器可以默认返回字符串，然后将这些字符串放在target内部--%>
<%--//当然还有json、xml，其中最常用的便是null和json--%>
<%--//对于json的使用，我们会稍后讲解到--%>
        <%--beforeSubmit: showRequest,--%>
        <%--success:  successRes，--%>
        <%--type:'POST'--%>
    <%--//提交方式，默认是自己在form标签上指定的method--%>
    <%--//如果没有指定，则使用get。--%>
        <%--url:''--%>
    <%--//重新提交的url，即url可以在form中配置--%>
    <%--//也可以在这里配置。--%>
    <%--};--%>


<%--</script>--%>
<html>
<head>
    <meta name="viewport" content="width=device-width" />
    <title>Index</title>
    <script src="bower_components/jquery/dist/jquery.min.js"></script>
    <script src="bower_components/jquery/dist/jquery.js"></script>
    <script src="bower_components/jquery.form.js"></script>
</head>
<body>
<div>
    <form id="ajaxForm" method="post" action="http://192.168.1.180:8080/doft/manage/dish/upload.do" enctype="multipart/form-data">
        <input type="file" name="upload_file" />
        <input type="submit" value="springmvc上传文件" />
    </form>
</div>
<script type="text/javascript">
    $(function () {
//        $("#ajaxForm").ajaxForm(function () {
//            alert("提交成功1");
//        });
        $("#ajaxForm").submit(function () {
            $(this).ajaxSubmit(function (data) {
                alert(data.data.url);
            });
            return false;
        });
    });
</script>
</body>
</html>