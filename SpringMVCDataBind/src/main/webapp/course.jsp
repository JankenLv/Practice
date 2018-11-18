<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
    <!-- Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1>课程信息</h1>
    <table class="table">
        <thead>
        <tr>
            <td>课程编号</td>
            <td>课程名称</td>
            <td>课程价格</td>
            <td>课程讲师编号</td>
            <td>课程讲师名称</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${courses}" var="course">
        <tr>
            <td>${course.id}</td>
            <td>${course.name}</td>
            <td>${course.price}</td>
            <td>${course.author.id}</td>
            <td>${course.author.name}</td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
