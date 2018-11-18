<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>员工表</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="jumbotron">
        <h1>测试pagehelper-插件实现分页!</h1>
        <p>lvjing</p>
        <p><a class="btn btn-primary btn-lg" href="#" role="button">普通的按钮</a></p>
    </div>
    <table class="table table-striped table-bordered table-hover">
        <thead>
        <tr>
            <th>姓名</th>
            <th>邮箱</th>
            <th>性别</th>
            <th>部门</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${LIST}" var="person">
            <tr>
                <td>${person.username}</td>
                <td>${person.email}</td>
                <td>${person.gender}</td>
                <td>${person.deptId}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div>
        <a class="btn btn-default" href="javascript:void(0)" role="button">第&nbsp;${requestScope.PageInfo.pageNum}/${requestScope.PageInfo.pages}&nbsp;页</a>
        <a class="btn btn-default" href="list.do?pageNum=1" role="button">首页</a>
        <a class="btn btn-default" href="list.do?pageNum=${requestScope.PageInfo.prePage}" role="button">上一页</a>
        <a class="btn btn-default" href="list.do?pageNum=${requestScope.PageInfo.nextPage}" role="button">下一页</a>
        <a class="btn btn-default" href="list.do?pageNum=${requestScope.PageInfo.pages}" role="button">尾页</a>

        <a class="btn btn-default" href="javascript:void(0)" role="button">navigatePages：${requestScope.PageInfo.navigatePages}</a>
        <a class="btn btn-default" href="javascript:void(0)" role="button">startRow：${requestScope.PageInfo.startRow}</a>
        <a class="btn btn-default" href="javascript:void(0)" role="button">list：${requestScope.PageInfo.list}</a>
        <a class="btn btn-default" href="javascript:void(0)" role="button">navigateFirstPage：${requestScope.PageInfo.navigateFirstPage}</a>
        <a class="btn btn-default" href="javascript:void(0)" role="button">navigateLastPage：${requestScope.PageInfo.navigateLastPage}</a>
        <c:forEach items="${requestScope.PageInfo.navigatepageNums}" var="page">
            <a class="btn btn-default" href="javascript:void(0)" role="button">navigatepageNums：${page}</a>
        </c:forEach>
    </div>
</div>
</body>
</html>
