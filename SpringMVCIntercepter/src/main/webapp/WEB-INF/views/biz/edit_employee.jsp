<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <!-- Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <title>修改员工信息</title>
</head>
<body>
<div class="container">
    <div class="jumbotron">
        <h3>修改员工信息</h3>
    </div>
    <form class="form-horizontal" action="../edit" method="post">
        <input type="hidden" name="_method" value="PUT">
        <div class="form-group">
            <label class="col-sm-2 control-label">编号</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="id" value="${Employee.id}" readonly>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">姓名</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="name" value="${Employee.name}">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">部门</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="dept" value="${Employee.dept}">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">出生日期</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="bornDate" value="<fmt:formatDate value="${Employee.bornDate}" type="date"/>">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">入职时间</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="entryDate" value="<fmt:formatDate value="${Employee.entryDate}" type="date"/>">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">保存</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
