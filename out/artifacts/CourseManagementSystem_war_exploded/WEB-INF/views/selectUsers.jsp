<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<base href="${basePath}">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>管理员查询</title>
</head>
<body>
	<center>
		<h1>管理员查询</h1>
		<hr>
		<table cellspacing="0px" cellpadding="0px" border="1px" width="600px" style="text-align: center">
			<thead>
				<tr>
					<th>用户名</th>
					<th>密码</th>
					<th>类型</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="user" items="${allUsers}">
					<tr>
						<td>${user.username}</td>
						<td>${user.password}</td>
						<td>${user.authority}</td>
						<c:choose>
							<c:when test="${user.username=='imooc'}">
								<td></td>
							</c:when>
							<c:otherwise>
								<td><a href="delUser?username=${user.username}">删除</a></td>
							</c:otherwise>
						</c:choose>

					</tr>
			</c:forEach>
			</tbody>
		</table>
	</center>
</body>
</html>