<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <title>登录页面</title>
</head>
<body>
<div class="container" style="width: 400px;margin-top: 100px">
    <div class="panel panel-default">
        <div class="panel-heading"><h3>登录</h3></div>
        <div class="panel-body">
            <form action="${pageContext.request.contextPath}/login">
                <div class="form-group">
                    <label for="exampleInputEmail1">请输入用户名</label>
                    <input type="text" name="username" class="form-control" id="exampleInputEmail1" placeholder="Email">
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">请输入密码</label>
                    <input type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                </div>
                <button type="submit" class="btn btn-default">登录</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
