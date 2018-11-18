<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <title>网站首页</title>
    <style type="text/css">
        table, th{
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="jumbotron">
        <h1>欢迎来到纯音乐之家</h1>
        <p>
            你好，
            <c:choose>
                <c:when test="${sessionScope.username != null}">
                    ${sessionScope.username}&nbsp;
                    <br>
                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/mySongList">我的歌单</a>
                </c:when>
                <c:otherwise>
                    请&nbsp;<a class="btn btn-primary" href="${pageContext.request.contextPath}/loginPrompt">登录</a>
                </c:otherwise>
            </c:choose>
        </p>
    </div>
    <table class="table table-striped table-bordered">
        <thead>
        <tr>
            <th>项目名称</th>
            <th>演唱者</th>
            <th>类别</th>
            <th>作词</th>
            <th>语言</th>
            <th>发行日期</th>
        </tr>
        </thead>
        <tbody style="text-align: center">
        <c:forEach var="song" items="${songs}">
            <tr>
                <td>${song.name}</td>
                <td>${song.singer}</td>
                <td>${song.category}</td>
                <td>${song.writer}</td>
                <td>${song.language}</td>
                <td><fmt:formatDate value="${song.issudate}" pattern="yyyy年MM月dd日"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
