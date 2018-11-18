<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>信息课程</title>
    <!-- Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="jumbotron">
        <h3>信息课程</h3>
    </div>
    <table class="table table-striped table-bordered">
        <thead>
        <tr>
            <td>编号</td>
            <td>名称</td>
            <td>价格</td>
            <td>时长</td>
            <td>讲师</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${Courses}" var="course">
            <tr>
                <td>${course.id}</td>
                <td>${course.name}</td>
                <td>${course.price}</td>
                <td>${course.length}</td>
                <td>${course.teacher}</td>
                <td>
                    <form action="toEditCourse/${course.id}" method="post">
                        <input type="hidden" name="_method" value="GET">
                        <button class="btn btn-info">修改</button>
                    </form>
                </td>
                <td>
                    <form action="removeCourse/${course.id}" method="post">
                        <input type="hidden" name="_method" value="DELETE">
                        <button class="btn btn-warning">删除</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
