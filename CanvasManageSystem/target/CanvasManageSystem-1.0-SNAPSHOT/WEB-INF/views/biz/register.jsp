<%@ page contentType="text/html;charset=UTF-8" %>
<html>
	<head>
		<base href="${requestScope.basePath}">
		<title>登录</title>
		<link rel="stylesheet" href="css/css/login.css">
	</head>
	<body>
		<div class="login" style="height:450px;">
			<div class="header">
				<h1>
					<a href="loginPrompt.do" style="color: #000;">登录</a>
					<span id="separate-line">|</span>
					<a href="javascript:void(0)" id="reg" style="color: #2C689B;">注册</a>
				</h1>
				<button onclick="goHome()"></button>
			</div>
			<form action="register.do" method="post" onsubmit="return checkPWD()">
				<div class="name">
					<label for="name">请输入用户名：</label>
					<input type="text" id="name" name="username" placeholder="用户名为5~12位字母数字的组合" pattern="([0-9a-zA-Z]){5,12}" required>
					<p></p>
				</div>
				<div class="pwd">
					<label for="pwd">请输入密码：</label>
					<input type="password" id="pwd" name="password" placeholder="密码为6~12位数字的组合" pattern="([0-9]){6,12}" required>
					<p></p>
				</div>
				<div class="checkPwd">
					<label for="checkPwd">请确认密码：</label>
					<input type="password" id="checkPwd" name="password" placeholder="确认密码" required>
					<p></p>
				</div>
				<div class="btn-red">
					<input type="submit" value="注册" id="login-btn">
					<input type="reset" value="重置" id="login-btn-2">
				</div>
			</form>
		</div>
	</body>
	<script type="text/javascript">
        function goHome() {
            window.location="index.jsp";
        }
        function checkPWD() {
			var pwd = document.getElementById('pwd').value;
			var checkPwd = document.getElementById('checkPwd').value;
			// console.log(pwd + "   " + checkPwd);
            if (pwd == checkPwd) {
                return true;
            } else {
                alert("两次密码不一致");
				return false;
            }
        }
	</script>
</html>