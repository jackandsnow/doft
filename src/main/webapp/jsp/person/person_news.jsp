<%--
  Created by IntelliJ IDEA.
  User: wangxue
  Date: 18/3/14
  Time: 上午10:00
  To change this template use File | Settings | File Templates.
--%>
<html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:ser var = "ctx" value="${pageContext.request.contextPath}"/>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Person_news</title>
    <!--<link rel="stylesheet" href="../resource/css/jquery-ui.min.css"-->
    <link rel="stylesheet" href="${ctx}/css/common.css" type="text/css">
    <link rel="stylesheet" href="${ctx}/css/pagination.css" type="text/css">
    <link rel="stylesheet" href="${ctx}/css/person_news.css" type="text/css">

    <script type="text/javascript" src="${ctx}/resource/js/jquery-1.12.4.js"></script>
    <!--copyright@wangxue 2018/03/10 person news-->
</head>
<body>
    <div id="left">
        <div id="sideBar">
            <ul class="nav  nav-stacked">
                <%--<li id="01" class="bar active"><a href="http://192.168.1.180:8080/doft/personalCenter.do">账户信息</a></li>--%>
                <li id="01" class="bar"><a href="${ctx}/jsp/person/person_info_finished.jsp">账户信息</a></li>
                <li id="02" class="bar active"><a href="${ctx}/jsp/person/person_news.jsp">我的消息</a></li>
            </ul>
        </div>
    </div>
    <div id="contain">
        <div class="All_news">
            <ul id="newList">
                <%--<li>--%>
                    <%--<p>你的订单<a href="">1234556</a>已取消</p>--%>
                    <%--<div class="put_right">--%>
                        <%--<input class="delete" type="image" src="${ctx}/resource/img/person/delete.png" onclick="">--%>
                    <%--</div>--%>
                    <%--<div class="put_right"><span class="time">2018/3/7 16:00</span></div>--%>
                <%--</li>--%>
                <%----%>
            </ul>
        </div>
        <div class="page_wrapper">
            <ul class="pagination">
            </ul>
        </div>
    </div>

<script type="text/javascript" src="${ctx}/js/common_func.js"></script>
<script type="text/javascript">
    var allNews = new Array(); // get the response news list
    var currentPage = 1; //current page index
    var newId; // messageId
    var pageSize = 6; //6 news a page
    var pageTotall = 0; //页总数

    $(document).ready(function () {
        requestNewsPages();
    });
    
    function requestNewsPages() {
        $.ajax({
            url : "http://192.168.1.180:8080/doft/message/getMessagePages.aj",//url
            xhrFields: {           withCredentials: true       },
            crossDomain: true,
            type : "POST",//方法类型
            dataType: "json",//预期服务器返回的数据类型
            data: {"currentPage":currentPage,"pageSize":pageSize},
            error : function(xhr, status, error) {
                console.info(JSON.stringify(xhr));
                window.alert("服务器忙，稍后！");
            },
            success : function(responseNews) {
                console.log(responseNews);
                if (responseNews.status == '0'){
                    allNews = responseNews.data.list;
                    pageTotall = responseNews.data.pages;//won't change
                    if (allNews == null){
                        var hinthtml = '<p class="hintmsg">暂无消息~</P>';
                        $(".All_news").append(hinthtml);
                        return;
                    }
                    for(var i=0; i<allNews.length; i++){//add new into ul li
                        renderNewContent(allNews[i],i);
                    }
                    addDeleteEvent();
                    initPage($(".pagination"),currentPage,pageTotall);//添加分页html
                    addNewsPageEvent();
                    // init the page part
                    pageTotall = responseNews.data.pages;
                }
                else{
                    window.alert("网络错误！");
//                    console.log("get news wrong");
                }
            }
        });
    }

    function renderNewContent(newItem,no) {//add the new content and time
        addNewHtml(no);
        $("#newContent"+no).text(newItem.content);
        $("#newTime"+no).text(timestampToTime(newItem.sendTime));
    }
    
    function addNewHtml(no) { // add the html li element
        var newhtml =
            '<li id = "'+no+'">'+
            '   <p id="newContent'+no+'"></p>'+
            '   <div class="put_right">'+
            '      <input class="delete" type="image" src="${ctx}/resource/img/person/delete.png">'+
            '   </div>'+
            '   <div class="put_right"><span class="time" id="newTime'+no+'"></span></div>'+
            '</li>';
        $("#newList").append(newhtml);
    }

    //delete function
    function addDeleteEvent() {
        $(".delete").click(function () {
            var newIndex = Number($(this).parent().parent().attr("id"));
            newId = allNews[newIndex].messageId;
            $.ajax({
                //get the input phoneNum;
                url : "http://192.168.1.180:8080/doft/message/deleteMsgEvent.aj",//url
//                url : "/doft/message/deleteMsgEvent.aj",//url
                xhrFields: {           withCredentials: true       },
                crossDomain: true,
                type : "POST",//方法类型
                dataType: "json",//预期服务器返回的数据类型
                data: {"msgId":newId},
                error : function(xhr, status, error) {
                    console.info(JSON.stringify(xhr));
                },
                success : function(responseData) {
//                    console.log(responseData);
                    if (responseData.status == '0'){
                        $(this).parent().parent().remove();
                        window.location.reload();
                    }
                    else{
                        window.alert("服务器忙，稍后！");
                    }
                }
            });
        });
    }
</script>
</body>
</html>