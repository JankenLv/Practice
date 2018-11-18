<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <base href="${requestScope.basePath}">
    <meta charset="UTF-8">
    <title>编辑</title>
    <link rel="stylesheet" href="css/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/css/add.css">
    <script type="text/javascript">
        function goback() {
            window.history.back();
        }
    </script>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="manageCanvas.do">
                慕课网油画管理
            </a>
        </div>
    </div>
</nav>
<div class="container">
    <div class="jumbotron">
        <h1>Hello, ${sessionScope.username}!</h1>
        <p>请小心的编辑油画记录</p>
    </div>
    <div class="page-header">
        <h3><small>编辑</small></h3>
    </div>
    <form class="form-horizontal" action="updateCanvas.do" method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">名称 ：</label>
            <div class="col-sm-8">
                <input name="name" class="form-control" id="name" value="${requestScope.canvas.name}" required>
                <input type="hidden" name="id" class="form-control" id="id" value="${requestScope.canvas.id}">
            </div>
        </div>
        <div class="form-group">
            <label for="categoryId" class="col-sm-2 control-label">分类 ：</label>
            <select id="categoryId" name="categoryId" class="col-sm-2 form-control" style="width: auto;margin-left: 15px;" >
                <c:forEach var="category" items="${requestScope.categories}">
                    <c:choose>
                        <c:when test="${requestScope.canvas.categoryId == category.id}">
                            <option id="${category.id}" value="${category.id}" selected>${category.name}</option>
                        </c:when>
                        <c:otherwise>
                            <option id="${category.id}" value="${category.id}">${category.name}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="price" class="col-sm-2 control-label">价格 ：</label>
            <div class="col-sm-8">
                <input name="price" type="number" class="form-control" id="price" pattern="([0-9]*)|([0-9]+\.([0-9])+)" value="${requestScope.canvas.price}" />
            </div>
        </div>
        <div class="form-group">
            <label for="smallImg" class="col-sm-2 control-label">图片 ：</label>
            <div class="col-sm-8">
                <input id="smallImg" name="smallImg" class="file-loading"
                       type="file" multiple accept=".jpg,.jpeg,.png" data-min-file-count="1"
                       data-show-preview="true" value="" />
            </div>
        </div>
        <div class="form-group">
            <label for="description" class="col-sm-2 control-label">描述 ：</label>
            <div class="col-sm-8">
                <input name="description" type="text" class="form-control" id="description" value="${requestScope.canvas.description}" />
            </div>
        </div>
        <div class="form-group">
            <label for="details" class="col-sm-2 control-label">简介 ：</label>
            <div class="col-sm-8">
                <textarea name="details" class="form-control" id="details">${requestScope.canvas.details}</textarea>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-primary">保存</button>&nbsp;&nbsp;&nbsp;
                <button type="button" class="btn btn-primary" onclick="goback()">返回</button>
            </div>
        </div>
    </form>
</div>
<footer class="text-center" >
    copy@imooc
</footer>
</body>
</html>
