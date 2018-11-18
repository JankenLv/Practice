<%@ page contentType="text/html;charset=UTF-8" %>
<html>
	<head>
		<base href="${requestScope.basePath}">
		<title>登录</title>
		<link rel="stylesheet" href="css/css/login.css">
	</head>
	<body>
		<div class="login">
			<div class="header">
				<h1>
					<a href="javascript:void(0)">登录</a>
					<span id="separate-line">|</span>
					<a href="registerPrompt.do" id="reg">注册</a>
				</h1>
				<button onclick="goHome()"></button>
			</div>
			<form action="login.do" method="post">
				<div class="name">
					<label for="name">请输入用户名：</label>
					<input type="text" id="name" name="username" placeholder="请输入用户名" pattern="([0-9a-zA-Z]){5,12}" required>
					<p></p>
				</div>
				<div class="pwd">
					<label for="pwd">请输入密码：</label>
					<input type="password" id="pwd" name="password" placeholder="请输入密码" pattern="([0-9]){6,12}" required>
					<p></p>
				</div>
				<div class="btn-red">
					<input type="submit" value="登录" id="login-btn">
					<input type="reset" value="重置" id="login-btn-2">
				</div>
			</form>
		</div>
	</body>
	<script type="text/javascript">
        function goHome() {
            window.location="index.jsp";
        }
	</script>
</html>