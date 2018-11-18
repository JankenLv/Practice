<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <link rel="stylesheet" href="css/login.css">
</head>
<body>
<div class="login">
    <div class="header">
        <h1>
            <a href="toLogin.do" style="color: #000">登录</a>
            &nbsp;|&nbsp;
            <a href="javascript:void(0)" style="color: #2C689B">注册</a>
        </h1>
        <button onclick="gotoPortal()"></button>
    </div>
    <form action="register.do" method="post">
        <div class="name">
            <input type="text" id="name" name="username" required>
            <p></p>
        </div>
        <div class="pwd">
            <input type="password" id="pwd" name="password" required>
            <p></p>
        </div>
        <div class="btn-red">
            <input type="submit" value="注册" id="login-btn">
        </div>
    </form>
</div>
</body>
<script type="text/javascript">
    function gotoPortal() {
        window.location.href = 'gotoPortal.do';
    }
</script>
</html>
