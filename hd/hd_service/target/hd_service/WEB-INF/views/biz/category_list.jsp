<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>科室分类列表</title>
    <link rel="stylesheet" href="../css/index.css">
    <link rel="stylesheet" href="../css/bootstrap.min.css">
</head>
<body>
<header>
    <div class="container">
        <c:forEach items="${LIST}" var="cat">
            <nav>
                <a href="javascript:void(0)">${cat.name}</a>
            </nav>
        </c:forEach>
        <nav>
            <a href="../dept/list.do" >科室管理</a>
        </nav>
    </div>
</header>
<section class="banner">
    <div class="container">
        <div>
            <h1>科室分类</h1>
            <p>科室分类列表</p>
        </div>
    </div>
</section>
<section class="main">
    <div class="container">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>名称</th>
                <th>创建时间</th>
                <th>最后修改时间</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${LIST}" var="cat">
                <tr>
                    <td>${cat.name}</td>
                    <td><fmt:formatDate value="${cat.createTime}" type="both"/></td>
                    <td><fmt:formatDate value="${cat.updateTime}" type="both"/></td>
                    <td>
                        <a href="toModify.do?id=${cat.id}">修改</a>&nbsp;&nbsp;
                        <a href="remove.do?id=${cat.id}">删除</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</section>
<section class="page">
    <div class="container">
        <div id="fatie">
            <a href="toAdd.do"><button>新建</button></a>
        </div>
    </div>
</section>
<footer>
    copy@慕课网
</footer>
</body>
</html>
