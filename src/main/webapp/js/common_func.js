function timestampToTime(timestamp) { //时间戳转为时间
    var date = new Date(timestamp);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
    Y = date.getFullYear() + '/';
    M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '/';
    D = date.getDate() + ' ';
    h = date.getHours() + ':';
    m = date.getMinutes();
//        s = date.getSeconds();
    return Y+M+D+h+m;
}
function timestampToYMD(timestamp) { //时间戳转为时间
    var date = new Date(timestamp);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
    Y = date.getFullYear() + '/';
    M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '/';
    D = date.getDate() + ' ';
//        s = date.getSeconds();
    return Y+M+D;
}
function CheckPhone(phonenum) {
    var str = phonenum;
    if (str == null || str.length != 11){
        return false;
    }
    var reg1 = new RegExp(/^1([23578])\d{9}$/);
    if (!reg1.test(str)){
        return false;
    }
    else {
        return true;
    }
}

function CheckPassWord(password) {//必须为字母加数字且长度不小于8位
    var str = password;
    if (str == null || str.length <8) {
        return false;
    }
    var reg1 = new RegExp(/^[0-9A-Za-z]+$/);
    if (!reg1.test(str)) {
        return false;
    }
    var reg = new RegExp(/[A-Za-z].*[0-9]|[0-9].*[A-Za-z]/);
    if (reg.test(str)) {
        return true;
    } else {
        return false;
    }
}

function initPage(obj,currentPage,pageTotall) {//根据返回的页总数显示页码
    addPageHtml(obj,currentPage,pageTotall);
}

function addPageHtml(obj,current,pageNum) {
    obj.empty();
    /*上一页*/
    obj.append('<li><a id="pre_btn"><<</a></li>');
    if (current == 1){
        $("#pre_btn").attr("disabled",true);
        $("#pre_btn").css("pointer-events","none");
    }
    /* 中间页 */
    if (pageNum < 8){
        for (var i=1;i<= pageNum;i++){
            if(i == current){
                obj.append('<li><a class="active">'+i+'</a></li>');
                continue;
            }
            obj.append('<li><a class="pagenum">'+i+'</a></li>');
        }
    }
    if (pageNum >= 8){
        if (current>4 && pageNum>4){
            obj.append('<li><a class="pagenum">'+1+'</a></li>');
            obj.append('<li><a class="pagenum">'+2+'</a></li>');
            obj.append('<li><a id="dot1"><span>...</span></a></li>');
        }
        /*中间页*/
        if (current >4 && current <= pageNum-3) {
            var start  = current - 1,end = current + 1;
        }else if(current >4 && current > pageNum-3){
            var start  = pageNum - 3,end = pageNum;
        }else{
            var start = 1,end = 7;
        }
        for (;start <= end;start++) {
            if (start <= pageNum && start >=1) {
                if (start == current) {
                    obj.append('<li><a class="active">'+start+'</a></li>');
                } else if(start == current+1){
                    obj.append('<li><a id="pagenum">'+ start +'</a></li>');
                }else{
                    obj.append('<li><a class="pagenum">'+ start +'</a></li>');
                }
            }
        }
        if (end < pageNum) {
            if (end != (pageNum-1)){
                obj.append('<li><a id="dot2"><span>...</span></a></li>');
            }
            obj.append('<li><a class="pagenum">'+pageNum+'</a></li>');
        }
    }
    /*下一页*/
    obj.append('<li><a id="next_btn">>></a></li>');
    if (current == pageNum) {
        $("#next_btn").attr("disabled",true);
        $("#next_btn").css("pointer-events","none");
    }
}

function addNewsPageEvent() {
    $("#pre_btn").click(function () {
        --currentPage; //除去上一页btn
        console.log(currentPage);
        $("#newList").empty();//empty原来的news
        requestNewsPages(); //添加新的news
    });

    $("#next_btn").click(function () {
        ++currentPage; //除去上一页btn
        console.log(currentPage);
        $("#newList").empty();//empty原来的news
        requestNewsPages(); //添加新的news
    });

    $(".pagenum").click(function () {
        // console.log("come on ?？");
        var currentPageString = $(this).text().trim();
        currentPage = Number(currentPageString);
        console.log(currentPage);
        $("#newList").empty();
        requestNewsPages();
    });
    console.log("event finished!");
}

function addOrderPageEvent() {
    $("#pre_btn").click(function () {
        --currentPage; //除去上一页btn
        console.log(currentPage);
        $(".order_history ul").empty();//empty原来的news
        orderSort();
        //newOrderList();
    });

    $("#next_btn").click(function () {
        ++currentPage; //除去上一页btn
        console.log(currentPage);
        $(".order_history ul").empty();
        orderSort();
        //newOrderList();
    });

    $(".pagenum").click(function () {
        var currentPageString = $(this).text().trim();
        currentPage = Number(currentPageString);
        console.log(currentPage);
        $(".order_history ul").empty();
        //newOrderList();
        orderSort();
    });
    console.log("event finished!");
}

function addDishPageEvent() {
    $("#pre_btn").click(function () {
        --currentPage; //除去上一页btn
        console.log(currentPage);
        $(".dish_list ul").empty();//empty原来的news
        if(current_dishID == 0){
            get_dish_list_by_search(search_dish_name,currentPage,pageSize,dish_sort_order_by,dish_sort_up_down);
        }
        else{
            get_dish_list(current_dishID,currentPage,pageSize,dish_sort_order_by,dish_sort_up_down);
        }
    });

    $("#next_btn").click(function () {
        ++currentPage; //除去上一页btn
        console.log(currentPage);
        $(".dish_list ul").empty();
        // newOrderList();
        if(current_dishID == 0){
            get_dish_list_by_search(search_dish_name,currentPage,pageSize,dish_sort_order_by,dish_sort_up_down);
        }
        else{
            get_dish_list(current_dishID,currentPage,pageSize,dish_sort_order_by,dish_sort_up_down);
        }
    });

    $(".pagenum").click(function () {
        // console.log("come on ?？");
        var currentPageString = $(this).text().trim();
        currentPage = Number(currentPageString);
        // console.log(currentPage);
        $(".dish_list ul").empty();
        if(current_dishID == 0){
            get_dish_list_by_search(search_dish_name,currentPage,pageSize,dish_sort_order_by,dish_sort_up_down);
        }
        else{
            get_dish_list(current_dishID,currentPage,pageSize,dish_sort_order_by,dish_sort_up_down);
        }
    });
    // console.log("event finished!");
}