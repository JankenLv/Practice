<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
    <!-- Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1>添加数组</h1>
    <form action="setType">
        <div class="form-group">
            <label>课程编号</label>
            <input type="text" name="courses[0].id" class="form-control" >
        </div>
        <div class="form-group">
            <label>课程名称</label>
            <input type="text" name="courses[0].name" class="form-control" >
        </div>
        <div class="form-group">
            <label>课程价格</label>
            <input type="text" name="courses[0].price" class="form-control" >
        </div>
        <div class="form-group">
            <label>课程讲师编号</label>
            <input type="text" name="courses[0].author.id" class="form-control" >
        </div>
        <div class="form-group">
            <label>课程讲师名称</label>
            <input type="text" name="courses[0].author.name" class="form-control" >
        </div>
        <div class="form-group">
            <label>课程编号</label>
            <input type="text" name="courses[1].id" class="form-control" >
        </div>
        <div class="form-group">
            <label>课程名称</label>
            <input type="text" name="courses[1].name" class="form-control" >
        </div>
        <div class="form-group">
            <label>课程价格</label>
            <input type="text" name="courses[1].price" class="form-control" >
        </div>
        <div class="form-group">
            <label>课程讲师编号</label>
            <input type="text" name="courses[1].author.id" class="form-control" >
        </div>
        <div class="form-group">
            <label>课程讲师名称</label>
            <input type="text" name="courses[1].author.name" class="form-control" >
        </div>

        <button type="submit" class="btn btn-default">保存</button>
    </form>
</div>
</body>
</html>
