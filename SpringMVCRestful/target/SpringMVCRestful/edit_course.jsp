<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>修改课程</title>
    <!-- Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="jumbotron">
        <h3>修改课程</h3>
    </div>
    <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/editCourse">
        <input type="hidden" name="_method" value="PUT"/>
        <div class="form-group">
            <label for="inputEmail3" class="col-sm-2 control-label">编号</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputEmail3" name="id" value="${Course.id}" readonly>
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword4" class="col-sm-2 control-label">名称</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputPassword4" name="name" value="${Course.name}">
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword5" class="col-sm-2 control-label">价格</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputPassword5" name="price" value="${Course.price}">
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword6" class="col-sm-2 control-label">时长</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputPassword6" name="length" value="${Course.length}">
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword3" class="col-sm-2 control-label">讲师</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputPassword3" name="teacher" value="${Course.teacher}">
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
