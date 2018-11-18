<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <!-- Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <title>登录</title>
</head>
<body>
<div class="container">
    <div class="jumbotron">
        <h3>用户管理</h3>
    </div>
    <div class="panel panel-default" style="width: 300px; margin: auto;">
        <div class="panel-heading">
            <h3 class="panel-title">登录</h3>
        </div>
        <div class="panel-body">
            <form action="login" method="post">
                <div class="form-group">
                    <label >用户名：</label>
                    <input type="text" class="form-control" name="account">
                </div>
                <div class="form-group">
                    <label >密码：</label>
                    <input type="text" class="form-control" name="password">
                </div>
                <div class="form-group">
                    <button class="btn btn-info">登录</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
