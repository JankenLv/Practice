<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<base href="${basePath}"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录页面</title>
<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
<script type="text/javascript" src="js/index_jsp.js"></script>
</head>
<body>
	<center>
		<h1>用户登录</h1>
		<form action="login" method="post" onsubmit="return checkLoginStatus()">
			<table width="300px" cellspacing="0px" cellpadding="0px" border="1px">
				<tr>
					<td>用户名</td>
					<td colspan="2"><input type="text" name="username" placeholder="请输入用户名" pattern="\w{3,12}" required="required"></td>
				</tr>
				<tr>
					<td>密&nbsp;码</td>
					<td  colspan="2"><input type="password" name="password" placeholder="请输入密码" pattern="\w{5,12}" required="required"></td>
				</tr>
				<tr>
					<td>验证码</td>
					<td style="border-right-style:none;">
						<input type="text" name="checkCode" placeholder="请输入验证码" id="inputCode" required>
					</td>
					<td style="border-left-style:none;">
						<img class="code" id="checkCode" src="kaptcha.jpg" style="cursor:pointer;width:90px;height:25px;" onclick="changeKaptcha()">
					</td>
				</tr>
				<tr>
					<td colspan="3" style="text-align:center">
						<input type="submit" value="登录">
						<input type="reset" value="取消">
					</td>
				</tr>
			</table>
		</form>
		<h3 style="color: royalblue" id="msg"></h3>
	</center>
</body>
</html>

