<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">
<head>
    <base href="${requestScope.basePath}">
    <meta charset="UTF-8">
    <title>首页</title>
    <link rel="stylesheet" type="text/css" href="css/style/common.css" />
    <link rel="stylesheet" type="text/css" href="css/style/index.css" />
    <script type="text/javascript" src="js/pagination.js"></script>
</head>
<body>
    <div class="header">
        <div class="logo f1">
            <img src="img/image/logo.png">
        </div>
        <div class="auth fr">
            <c:choose>
                <c:when test="${sessionScope.username != null}">
                    <ul>
                        <li style="margin-right: 10px"><a href="manageCanvas.do" class="header-btn">进入管理系统</a></li>
                        <li style="margin-right: 10px"><a href="logout.do" class="header-btn">安全退出</a></li>
                    </ul>
                </c:when>
                <c:otherwise>
                    <ul>
                        <li style="margin-right: 10px"><a href="loginPrompt.do" class="header-btn">登录</a></li>
                        <li style="margin-right: 10px"><a href="registerPrompt.do" class="header-btn">注册</a></li>
                    </ul>
                </c:otherwise>
            </c:choose>

        </div>
    </div>
    <div class="content">
        <div class="banner">
            <img class="banner-img" src="img/image/welcome.png" width="732px" height="372" alt="图片描述">
        </div>

        <div class="img-content">
            <ul>
            <c:forEach items="${requestScope.canvasList}" var="canvas">
            <li>
                <img class="img-li-fix" src="getSmallImg.do?id=${canvas.id}" alt="油画">
                <div class="info">
                    <h3 class="img_title">${canvas.name}</h3>
                    <p>${canvas.description}</p>
                    <div class="btn">
                        <a href="showCanvasDetail.do?id=${canvas.id}" class="edit">详情</a>
                    </div>
                </div>
            </li>
            </c:forEach>
            </ul>
        </div>

        <div class="page-nav">
            <form action="goHome.do" id="page-nav-form" method="post">
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
    </div>

    <div class="footer">
        <p><span>M-GALLARY</span>©2017 POWERED BY IMOOC.INC</p>
    </div>
</body>
</html>