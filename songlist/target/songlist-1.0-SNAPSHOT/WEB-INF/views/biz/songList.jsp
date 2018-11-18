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
        <h1>我的歌单</h1>
        <p>
            你好，${sessionScope.username}&nbsp;
            <br>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/home">回到首页</a>
        </p>
    </div>
    <hr>
    <c:choose>
        <c:when test="${requestScope.songLists == null}">
            <center>
                <span style="font-size: 18px">还没有创建任何歌单呢~，</span>
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/createSongListPrompt">创建歌单</a>
            </center>
        </c:when>
        <c:otherwise>
            <table class="table table-striped table-bordered">
                <thead>
                <tr>
                    <th>歌单名称</th>
                    <th>歌曲名</th>
                    <th>创建者</th>
                    <th>描述</th>
                </tr>
                </thead>
                <tbody style="text-align: center">
                <c:forEach var="songList" items="${requestScope.songLists}">
                    <tr>
                        <td>${songList.name}</td>
                        <td>${songList.songName}</td>
                        <td>${songList.creator}</td>
                        <td>${songList.description}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
