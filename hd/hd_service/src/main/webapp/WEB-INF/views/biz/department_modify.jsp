<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>修改科室</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/add.css">
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="dept/list.do">
                慕课网科室管理
            </a>
        </div>
    </div>
</nav>
<div class="container">
    <div class="jumbotron">
        <h1>Hello, ${USER.username}!</h1>
        <p>请小心的修改科室记录，要是修改错误就不好了。。。</p>
    </div>
    <div class="page-header">
        <h3><small>修改科室分类</small></h3>
    </div>
    <form class="form-horizontal" action="modify.do" method="post">
        <input type="hidden" value="${DEP.id}" name="id"/>
        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">名称 ：</label>
            <div class="col-sm-8">
                <input name="name" class="form-control" id="name" value="${DEP.name}">
            </div>
        </div>
        <div class="form-group">
            <label for="category" class="col-sm-2 control-label" style="margin-right: 14px;">分类 ：</label>
            <select name="category" id="category" class="form-control" style="width: 80px;">
                <c:forEach items="${SUBLIST}" var="cat">
                    <c:if test="${DEP.category.id == cat.id}">
                        <option value="${cat.id}" selected>${cat.name}</option>
                    </c:if>
                    <c:if test="${DEP.category.id != cat.id}">
                        <option value="${cat.id}">${cat.name}</option>
                    </c:if>
                </c:forEach>
            </select>
            <%--<div class="col-sm-8">
                <input name="name" class="form-control" id="category">
            </div>--%>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-primary">保存</button>&nbsp;&nbsp;&nbsp;
                <button type="button" class="btn btn-primary" onclick="goback()">返回</button>&nbsp;&nbsp;&nbsp;
            </div>
        </div>
    </form>
</div>
<footer class="text-center" >
    copy@imooc
</footer>
</body>
<script type="text/javascript">
    function goback() {
        window.history.back();
    }
</script>
</html>
