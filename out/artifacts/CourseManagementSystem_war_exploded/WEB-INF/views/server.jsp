<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<base href="${basePath}">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>课程后台管理系统</title>
</head>
	<frameset rows="15%,*">
		<frame src="goTo?page=top"/>
		<frameset cols="15%,*">
			<%--<frame src="goTo?page=left&flag=${flag}"></frame>--%>
			<frame src="goTo?page=left"/>
			<frame name="main"/>
		</frameset>
	</frameset>
</html>