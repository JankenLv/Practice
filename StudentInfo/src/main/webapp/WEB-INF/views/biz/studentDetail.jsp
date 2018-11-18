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
        <h1>学生详细信息</h1>
        <p></p>
        <p><a class="btn btn-primary btn-lg" href="<%=request.getContextPath()%>/getStudents">返回学生信息页</a></p>
    </div>
    <form class="form-horizontal" action="<%=request.getContextPath()%>/modifyStudent">
        <input type="hidden" value="${student.id}" name="id">
        <div class="form-group form-group-lg">
            <label for="reg_no" class="col-sm-2 control-label">学号</label>
            <div class="col-sm-10">
                <input type="text" value="${student.reg_no}" class="form-control" id="reg_no" name="reg_no" placeholder="请输入学号" >
            </div>
        </div>
        <div class="form-group form-group-lg">
            <label for="name" class="col-sm-2 control-label">姓名</label>
            <div class="col-sm-10">
                <input type="text" value="${student.name}" class="form-control" id="name" name="name" placeholder="请输入姓名" >
            </div>
        </div>
        <div class="form-group form-group-lg">
            <label for="sex" class="col-sm-2 control-label">性别</label>
            <div class="col-sm-10">
                <input type="text" value="${student.sex}" class="form-control" id="sex" placeholder="请输入性别" >
            </div>
        </div>
        <div class="form-group form-group-lg">
            <label for="age" class="col-sm-2 control-label">年龄</label>
            <div class="col-sm-10">
                <input type="text" value="${student.age}" class="form-control" id="age" name="age" placeholder="请输入年龄" >
            </div>
        </div>
        <div class="form-group form-group-lg">
            <label for="grade" class="col-sm-2 control-label">年级</label>
            <div class="col-sm-10">
                <input type="text" value="${student.grade}" class="form-control" id="grade" name="grade" placeholder="请输入年级" >
            </div>
        </div>
        <div class="form-group form-group-lg">
            <label for="major" class="col-sm-2 control-label">专业</label>
            <div class="col-sm-10">
                <input type="text" value="${student.major}" class="form-control" id="major" name="major" placeholder="请输入专业" >
            </div>
        </div>
        <div class="form-group form-group-lg">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-info">保存</button>
                <button type="reset" class="btn btn-default">取消</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
