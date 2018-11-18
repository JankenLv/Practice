<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <!-- Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <title>员工信息</title>
</head>
<body>
<div class="container">
    <div class="jumbotron">
        <h3>员工信息</h3>
    </div>
    <table class="table table-bordered table-striped">
        <thead>
        <tr>
            <th>员工编号</th>
            <th>员工姓名</th>
            <th>所属部门</th>
            <th>出生日期</th>
            <th>入职日期</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${Employees}" var="employee">
        <tr>
            <td>${employee.id}</td>
            <td>${employee.name}</td>
            <td>${employee.dept}</td>
            <td><fmt:formatDate value="${employee.bornDate}" type="date"/></td>
            <td><fmt:formatDate value="${employee.entryDate}" type="both"/></td>
            <td>
                <form action="toEdit/${employee.id}" method="post">
                    <input type="hidden" name="_method" value="GET">
                    <button class="btn btn-info">修改</button>
                </form>
            </td>
            <td>
                <form action="remove/${employee.id}" method="post">
                    <input type="hidden" name="_method" value="DELETE">
                    <button class="btn btn-warning">删除</button>
                </form>
            </td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
    <nav aria-label="...">
        <ul class="pager">
            <li class="previous"><a href="toAdd"><span aria-hidden="true">&larr;</span>添加课程</a></li>
        </ul>
    </nav>
</div>
</body>
</html>
