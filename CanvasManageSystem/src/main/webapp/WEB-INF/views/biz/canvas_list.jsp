<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <head>
        <base href="${requestScope.basePath}">
        <meta charset="UTF-8">
        <title>油画列表</title>
        <link rel="stylesheet" href="css/css/index.css">
        <link rel="stylesheet" href="css/css/bootstrap.min.css">
        <script type="text/javascript" src="js/pagination.js"></script>
    </head>
    <body>
        <header>
            <div class="container">
                <nav>
                    <a href="goHome.do" >回到首页</a>
                </nav>
                <nav>
                    <a href="showAllCategories.do" >管理分类</a>
                </nav>
                <c:forEach var="category" items="${requestScope.categories}">
                    <nav>
                        <a href="manageCanvasOfCategory.do?categoryId=${category.id}">${category.name}</a>
                    </nav>
                </c:forEach>
            </div>
        </header>
        <section class="banner">
            <div class="container">
                <div>
                    <h1>油画</h1>
                    <p>油画列表</p>
                </div>
            </div>
        </section>
        <section class="main">
            <div class="container">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>名称</th>
                        <th>分类</th>
                        <th>价格</th>
                        <th>创建时间</th>
                        <th>最后修改时间</th>
                        <th>描述</th>
                        <th>编辑</th>
                        <th>删除</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${requestScope.canvasList}" var="canvas">
                        <tr>
                            <td>${canvas.name}</td>
                            <td>
                            <c:forEach var="category" items="${requestScope.categories}">
                                <c:if test="${canvas.categoryId == category.id}">
                                    ${category.name}
                                </c:if>
                            </c:forEach>
                            </td>
                            <td><fmt:formatNumber type="currency" value="${canvas.price}"/></td>
                            <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${canvas.createTime}"/></td>
                            <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${canvas.updateTime}"/></td>
                            <td>${canvas.description}</td>
                            <td><a href="updateCanvasPrompt.do?id=${canvas.id}">编辑</a></td>
                            <td><a href="delCanvas.do?id=${canvas.id}">删除</a>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </section>
        <section class="page">
            <div class="container">
                <div id="fatie">
                    <a href="addCanvasPrompt.do"><button>新建</button></a>
                </div>
            </div>
        </section>
        <div class="page-nav">
            <form action="manageCanvas.do" id="page-nav-form" method="post">
                <input type="hidden" id="currentPage" name="currentPage" value="${requestScope.currentPage}"/>
                <input type="hidden" id="totalPage" name="totalPage" value="${requestScope.totalPage}"/>
                <ul>
                    <li><a href="javascript:void(0)" onclick="getCanvas('first')">首页</a></li>
                    <li><a href="javascript:void(0)" onclick="getCanvas('pre')">上一页</a></li>
                    <li><span class="current-page" id="current-page">${requestScope.currentPage}</span></li>
                    <li><a href="javascript:void(0)" onclick="getCanvas('next')">下一页</a></li>
                    <li style="margin-right: 0"><a href="javascript:void(0)" onclick="getCanvas('last')">共${requestScope.totalPage}页</a></li>
                </ul>
            </form>
        </div>
        <footer>
            copy@慕课网
        </footer>
    </body>
</html>