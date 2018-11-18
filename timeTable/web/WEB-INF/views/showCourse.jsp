<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <base href="${basePath}">
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>课程信息页</title>
</head>
<body>
<div style="width: 100%;height: 500px;margin-top: 50px">
    <form style="text-align: center;margin:0 auto 0 30%">
        <h2 style="text-align: left;">添加成功</h2>
        <table border="1px" cellpadding="5px" cellspacing="1px" >
            <tr>
                <th>课程信息</th>
                <th>所属方向</th>
                <th>课程描述</th>
                <th>创建时间</th>
            </tr>
            <c:forEach var="course" items="${courses}">
                <tr>
                    <td>${course.courseName}</td>
                    <td>${course.courseType}</td>
                    <td>${course.description}</td>
                    <td>${course.date}</td>
                </tr>
            </c:forEach>
        </table>
    </form>
</div>
</body>
</html>
