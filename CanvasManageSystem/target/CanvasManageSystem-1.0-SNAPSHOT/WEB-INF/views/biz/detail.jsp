<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <base href="${requestScope.basePath}">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>详情</title>
    <link rel="stylesheet" type="text/css" href="css/style/common.css" />
    <link rel="stylesheet" type="text/css" href="css/style/detail.css" />
<!--<link rel="stylesheet" type="text/css" href="style/reset.css" />
    <link rel="stylesheet" type="text/css" href="style/style.css" />-->
</head>
<body class="bgf8">
    <div class="header">
        <div class="logo f1">
            <img src="img/image/logo.png">
        </div>
        <div class="auth fr">
            <c:choose>
                <c:when test="${sessionScope.username != null}">
                    <ul>
                        <li style="margin-right: 10px"><a href="goHome.do" id="home-btn" class="header-btn">回到首页</a></li>
                        <li><a href="manageCanvas.do" id="sys-btn" class="header-btn">进入管理系统</a></li>
                    </ul>
                </c:when>
                <c:otherwise>
                    <ul>
                        <li style="margin-right: 10px"><a href="goHome.do" class="header-btn">回到首页</a></li>
                        <li style="margin-right: 10px"><a href="loginPrompt.do" class="header-btn">登录</a></li>
                        <li style="margin-right: 10px"><a href="registerPrompt.do" class="header-btn">注册</a></li>
                    </ul>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
    <div class="content">
        <div class="section" style="margin-top:20px;">
            <div class="width1200">
                <div class="fl" style="width: 720px;height: 432px"><img src="getSmallImg.do?id=${requestScope.canvas.id}" style="width: 720px;height: 432px" /></div>
                <div class="fl sec_intru_bg">
                    <dl>
                        <dt>${requestScope.canvas.name}</dt>
                        <dd>
                            <p>发布人：<span>${requestScope.canvas.creator}</span></p>
                            <p>发布时间：<span><fmt:formatDate value="${requestScope.canvas.createTime}" pattern="yyyy年 MM月 dd日"/> </span></p>
                            <p>修改时间：<span><fmt:formatDate value="${requestScope.canvas.updateTime}" pattern="yyyy年 MM月 dd日"/> </span></p>
                        </dd>
                    </dl>
                    <ul>
                        <li>售价：<br/><span class="price"><fmt:formatNumber value="${requestScope.canvas.price}" type="number" maxFractionDigits="0"/></span> 元</li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="secion_words">
            <div class="width1200">
                <div class="secion_wordsCon">
                    <p>${requestScope.canvas.details}</p>
                </div>
            </div>
        </div>
        </div>
        <div class="footer">
            <p><span>M-GALLARY</span>©2017 POWERED BY IMOOC.INC</p>
        </div>
    </body>
    </html>