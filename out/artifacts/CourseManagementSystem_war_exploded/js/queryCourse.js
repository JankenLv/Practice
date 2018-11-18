// 根据条件查询课程
function query() {
    var query = $('#searchBox').val();
    if (query !== "" && query.length !== 0) {
        $.get("queryCourse", {query: query}, function (result) {
            // console.log(result);
            setPagingInfo(result.length);
            showCourse(result);
        });
    }else if(query.length == 0){
        query = "getAllCourses";
        $.get("queryCourse", {query: query}, function (result) {
            // console.log(result);
            setPagingInfo(result.length);
            showCourse(result);
        });
    }
}

// 分页查询
function paging() {
    var page = $("#selectRow").val();
    $.get("paging", {page:page,currentPage:"1"}, function (result) {
        // console.log(result);
        showCourse(result);
        $("#currentPage").html(1);
    });
}

// 控制分页按钮的开关
function doPaging() {
    var totalRecords = $("#totalRecords").val(),
        page = $("#selectRow").val();
    return totalRecords > 0 && page !== totalRecords;
}

// 获取第一页
function firstPage() {
    if (doPaging()) {
        var currentPage = $("#currentPage"),
            currentPageValue = currentPage.html(),
            page = $("#selectRow").val();
        if (currentPageValue != 1) {
            doAjax(page,"1");
            currentPage.html(1);
        }
    }
}
// 获取上一页
function prePage() {
    if (doPaging()) {
        var page = $("#selectRow").val(),
            currentPage = $("#currentPage"),
            currentPageValue = currentPage.html();
        if (currentPageValue != 1) {
            currentPageValue--;
            doAjax(page,currentPageValue);
            currentPage.html(currentPageValue);
        }
    }
}
// 获取下一页
function nextPage() {
    if (doPaging()) {
        var totalRecords = $("#totalRecords").val(),
            currentPage = $("#currentPage"),
            currentPageValue = currentPage.html(),
            page = $("#selectRow").val(),
            maxPage = Math.ceil(totalRecords/page);

        if (currentPageValue != maxPage) {
            currentPageValue++;
            doAjax(page,currentPageValue);
            currentPage.html(currentPageValue);
        }
    }
}
// 获取最后一页
function lastPage() {
    if (doPaging()) {
        var totalRecords = $("#totalRecords").val(),
            currentPage = $("#currentPage"),
            page = $("#selectRow").val(),
            maxPage = Math.ceil(totalRecords/page);

        if (currentPage.html() != maxPage) {
            doAjax(page,maxPage);
            currentPage.html(maxPage);
        }
    }
}
// 执行ajax
function doAjax(page,currentPage) {
    $.get(
        "paging",
        {page:page,currentPage:currentPage},
        function (result) {
            showCourse(result);
    });
}

// 显示课程信息
function showCourse(result) {
    // tbody.empty();
    var tbody = $("tbody");
    tbody.empty();
    if (result.length != 0) {
        $("#msg").empty();
        for (var i = 0; i < result.length; i++) {
            tbody.append(
                "<tr>" +
                "<td>" + result[i].id + "</td>" +
                "<td>" + result[i].courseName + "</td>" +
                "<td>" + result[i].courseType + "</td>" +
                "<td>" + result[i].description + "</td>" +
                "<td>" + result[i].courseTime + "</td>" +
                "<td>" + result[i].operator + "</td>" +
                +"</tr>"
            );
        }
    } else {
        // tbody.empty();
        $("#msg").html("搜索结果为空");
    }
}

// 设置分页信息
function setPagingInfo(lengthOfResult) {
    if (lengthOfResult > 0) {
        $(".valueOfSelect").show();
        $(".totalRecord").val(lengthOfResult).html(lengthOfResult);
        $("#firstOfTotalRecords").val("1").html("1");
        $("#totalRecords").html("全部").attr({selected:"selected"});
        $(".firstRecord").html("1");
        $("#currentPage").html("1");
        if (lengthOfResult > 5) {
            // $("#halfOfTotalRecords").val(lengthOfResult / 2 > 10 ? 10 : parseInt(lengthOfResult/2)).html(lengthOfResult / 2 > 10 ? 10 : parseInt(lengthOfResult / 2));
            var result = lengthOfResult / 2 > 10 ? 10 : Math.floor(lengthOfResult / 2);
            $("#halfOfTotalRecords").val(result).html(result);
        } else {
            $("#halfOfTotalRecords").hide();
        }
        if (lengthOfResult <= 20) {
            $("#bestViewOfRecord").hide();
        }
    } else {
        $(".valueOfSelect").hide();
        $(".totalRecord").val("").html("");
        $(".record").html("");
        $("#currentPage").html("1");
    }
}