<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<base href="${basePath}">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>课程添加</title>
<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
<script type="text/javascript" src="js/showMsg.js"></script>
</head>
<body>
	<center>
		<h1>课程添加</h1>
		<hr>
		<form action="addCourse" method="post">
			<table width="400px" cellspacing="0px" cellpadding="0px" border="1px">
				<tr>
					<%--<td>课程ID</td>--%>
					<td><label for="courseId">课程ID</label></td>
					<td><input type="text" name="courseId" id="courseId" pattern="[1-9]\d{0,2}" required></td>
				</tr>
				<tr>
					<%--<td>课程名</td>--%>
					<td><label for="courseName">课程名</label></td>
					<td><input type="text" name="courseName" id="courseName" required></td>
				</tr>
				<tr>
					<%--<td>方向</td>--%>
					<td><label for="courseType">方向</label></td>
					<td>
						<select name="courseType" id="courseType">
							<option value="Java">Java</option>
							<option value="前端">前端</option>
							<option value="Linux">Linux</option>
						</select>
					</td>
				</tr>
				<tr>
					<%--<td>描述</td>--%>
					<td><label for="description">描述</label></td>
					<td>
						<textarea name="description" id="description" required></textarea>
					</td>
				</tr>
				<tr>
					<%--<td>时长</td>--%>
					<td><label for="courseTime">时长</label></td>
					<td>
						<input id="courseTime" name="courseTime" type="text" pattern="[1-9]\d{0,2}(\.\d)?" required>
					</td>
				</tr>
				<tr>
					<%--<td>操作人</td>--%>
					<td><label for="operator">操作人</label></td>
					<td>
						<input name="operator" id="operator" type="text" value="${username}" readonly="readonly" />
					</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align:center">
						<input type="submit" value="添加">
						<input type="reset" value="取消">
					</td>
				</tr>
			</table>
		</form>
		<h3 id="msg" style="color: royalblue">${msg}</h3>
	</center>
</body>
</html>