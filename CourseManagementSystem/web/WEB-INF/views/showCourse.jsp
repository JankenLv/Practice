<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<base href="${basePath}">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>课程查询</title>
<!-- 分页查看 -->
<link type="text/css" rel="stylesheet" href="css/showCourse_jsp.css">
<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
<script type="text/javascript" src="js/queryCourse.js"></script>
</head>
<body>
	<center>
		<h1>课程查询</h1>
		<hr>
		<div id="limitRow">
			<span>显示</span>
			<select name="selectRow" id="selectRow" onchange="paging(event)">
			<c:if test="${totalPages!=null}">
				<option value="${totalPages==null?"":1}" id="firstOfTotalRecords" class="valueOfSelect">
						${totalPages==null?"":1}
				</option>
				<c:if test="${totalPages>5}">
					<option value="<fmt:formatNumber value="${totalPages/2>10?10:totalPages/2}" maxFractionDigits="0"/>" id="halfOfTotalRecords" class="valueOfSelect">
						<fmt:formatNumber value="${totalPages/2>10?10:totalPages/2}" maxFractionDigits="0"/>
					</option>
				</c:if>
				<c:if test="${totalPages>=20}">
					<option value="15" class="valueOfSelect" id="bestViewOfRecord">
						15
					</option>
				</c:if>
				<c:if test="${totalPages>0}">
					<option value="${totalPages}" id="totalRecords" class="valueOfSelect totalRecord" selected>
						全部
					</option>
				</c:if>
			</c:if>
			</select>
			<span>条</span>
		</div>
		<div id="search">
			<span>搜索：</span>
			<input id="searchBox" name="searchBox" type="text" value="" placeholder="   -- 输入搜索条件 --" onkeyup="query(event)"/>
		</div>
		<table cellspacing="0px" cellpadding="0px" border="1px" id="example">
			<thead>
				<tr>
					<th>课程ID</th>
					<th>课程名</th>
					<th>方向</th>
					<th>描述</th>
					<th>时长(小时)</th>
					<th>操作人</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${allCourses}" var="course">
					<tr>
						<td>${course.id}</td>
						<td>${course.courseName}</td>
						<td>${course.courseType}</td>
						<td>${course.description}</td>
						<td>${course.courseTime}</td>
						<td>${course.operator}</td>
					</tr>
			</c:forEach>
			</tbody>
			<h3 style="color: royalblue" id="msg"></h3>
		</table>
		<div class="buttom">
			<div class="left">
				<span>从<span class="record firstRecord">${totalPages==null?"":1}</span>到
					<span class="record totalRecord" >${totalPages}</span>条记录&nbsp;&nbsp;
					总记录为<span class="record totalRecord">${totalPages}</span>条</span>
			</div>
			<div class="right">
				<a href="javascript:void(0)" id="firstPage" onclick="firstPage()">第一页</a>
				<a href="javascript:void(0)" onclick="prePage()">上一页</a>
				<button id="currentPage" disabled="disabled">1</button>
				<a href="javascript:void(0)" onclick="nextPage()">下一页</a>
				<a href="javascript:void(0)" id="lastPage" onclick="lastPage()">最后一页</a>
			</div>
		</div>
	</center>
</body>
</html>