<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>学生信息</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="jumbotron">
        <h1>学生信息</h1>
        <p></p>
        <%--<p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a></p>--%>
        <a class="btn btn-info" href="<%=request.getContextPath()%>/addStudentPrompt" role="button">添加学生</a>
    </div>
    <table class="table table-striped table-bordered table-hover">
        <thead>
        <tr>
            <th>学号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>年级</th>
            <th>专业</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${students}" var="student">
            <tr>
                <td>${student.reg_no}</td>
                <td>${student.name}</td>
                <td>${student.sex}</td>
                <td>${student.age}</td>
                <td>${student.grade}</td>
                <td>${student.major}</td>
                <%--<td><a class="btn btn-info" href="<%=request.getContextPath()%>/addStudentPrompt" role="button">添加学生</a></td>--%>
                <td>
                    <a class="btn btn-info" href="${pageContext.request.contextPath}/delStudent?id=${student.id}">删除</a>
                    <a class="btn btn-info" href="${pageContext.request.contextPath}/showStudentDetail?id=${student.id}">修改</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
