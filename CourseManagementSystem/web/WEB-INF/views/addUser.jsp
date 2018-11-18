<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<base href="${basePath}">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>管理员添加</title>
<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
<script type="text/javascript" src="js/addUser_jsp.js"></script>
<script type="text/javascript" src="js/showMsg.js"></script>
</head>
<body>
	<center>
		<h1>添加管理员</h1>
		<hr>
		<form action="addUser" method="post" onsubmit="return validateForm()">
			<table width="300px" cellspacing="0px" cellpadding="0px" border="1px">
				<tr>
					<%--<td>用户名</td>--%>
					<td><label for="username">用户名</label></td>
					<td><input type="text" name="username" id="username" placeholder="用户名为3-12位字母数字或下划线组合" pattern="\w{3,12}" required="required" onblur="validateUserName()"></td>
				</tr>
				<tr>
					<%--<td>密&nbsp;码</td>--%>
					<td><label for="password">密&nbsp;码</label></td>
					<td><input type="password" name="password" id="password" placeholder="密码长度为5-12位字母数字或下划线组合" pattern="\w{5,12}" required="required"></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align:center">
						<input type="submit" value="添加"/>
						<input type="reset" value="取消"/>
						<%--<input value="" name="hidden" hidden/>--%>
					</td>
				</tr>
			</table>
		</form>
		<h3 id="msg" style="color: royalblue">${msg}</h3>
		<span id="validateUsernameMsg" style="font-size: 18px;color: red;font-style: italic"></span>
	</center>
</body>
</html>