<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
	<title>首页</title>
	<!-- Custom Theme files -->
	<meta name="viewport" content="width=device-width, initial-scale=1"/>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content=""/>
	
	<!-- //Custom Theme files -->
	<link href="css/bootstrap.css" type="text/css" rel="stylesheet" media="all">
	<link href="css/style.css" type="text/css" rel="stylesheet" media="all">
	<!-- js -->
	<script src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>
	<!-- //js -->
	<!-- cart -->
	<script src="js/simpleCart.min.js"> </script>
	<!-- cart -->
	<script type="text/javascript">
       
	</script>
</head>
<body>
<!--header-->
<div class="header">
	<div class="container">
		<nav class="navbar navbar-default" role="navigation">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<h1 class="navbar-brand"><a  href="">IMOOC</a></h1>
			</div>
			<!--navbar-header-->
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="list.do" class="active">首页</a></li>
					<!-- 此处分类应从数据库中读取 -->
					<c:forEach items="${requestScope.SubList}" var="cat">
						<li class="dropdown">
							<a href="subList.do?catId=${cat.id}">${cat.name}</a>
						</li>
					</c:forEach>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="manage.do" >进入管理系统</a></li>
				</ul>

			</div>
		</nav>
		</div>
		<div class="clearfix"> </div>
</div>
<!--//header-->
<!--banner-->
<div class="banner">
	<div class="container" style="height: 300px">
		<h2 class="hdng">IMOOC <span>图书</span></h2>
		<p>读万卷书，行万里路</p>
		<a href="#">SHOP NOW</a>
		<!--
		<div class="banner-text">
			<img src="../../../images/tushu.jpeg" alt=""/>
		</div>
		-->
	</div>
</div>
<!--//banner-->
<!--gallery-->
<div class="gallery">
	<div class="container">
		<div class="gallery-grids">

			<c:forEach items="${requestScope.List}" var="book">
				<div class="col-md-3 gallery-grid " style="float:left">
					<a href="#">
						<img src="${book.imgPath}" class="img-responsive" alt="此处应有图片~" style="width: 255px;height: 145px;"/>
						<div class="gallery-info">
							<p><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span> view</p>
							<a class="shop" href="javascript:void(0)">SHOP NOW</a>
							<div class="clearfix"> </div>
						</div>
					</a>
					<div class="galy-info">
						<p style="size: 30px">${book.name}</p>
						<div class="galry">
							<div class="prices">
								<h5 class="item_price">
									<fmt:formatNumber value="${book.price}" type="currency"/>
								</h5>
							</div>
							<div class="rating">
								<c:forEach begin="1" end="${book.level}" var="i">
									<span>☆</span>
								</c:forEach>
							</div>
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
			</c:forEach>

		</div>
</div>

<!--分页导航-->
<c:if test="${requestScope.CatId != null}">
	<nav aria-label="...">
		<ul class="pager">
			<c:if test="${requestScope.PageInfo.pageNum == 1}">
				<li class="disabled"><a href="javascript:void(0)">首页</a></li>
				<li class="disabled"><a href="javascript:void(0)">上一页</a></li>
			</c:if>
			<c:if test="${requestScope.PageInfo.pageNum > 1}">
				<li><a href="subList.do?page=1&catId=${requestScope.CatId}">首页</a></li>
				<li><a href="subList.do?page=${requestScope.PageInfo.prePage}&catId=${requestScope.CatId}">上一页</a></li>
			</c:if>
			<li>
				<span aria-hidden="true" style="color: #3c763d;">第&nbsp;${requestScope.PageInfo.pageNum}&nbsp;/&nbsp;${requestScope.PageInfo.pages}&nbsp;页&nbsp;&nbsp;</span>
			</li>
			<c:if test="${requestScope.PageInfo.pageNum == requestScope.PageInfo.pages}">
				<li class="disabled"><a href="javascript:void(0)">下一页</a></li>
				<li class="disabled"><a href="javascript:void(0)">尾页</a></li>
			</c:if>
			<c:if test="${requestScope.PageInfo.pageNum < requestScope.PageInfo.pages}">
				<li><a href="subList.do?page=${requestScope.PageInfo.nextPage}&catId=${requestScope.CatId}">下一页</a></li>
				<li><a href="subList.do?page=${requestScope.PageInfo.pages}&catId=${requestScope.CatId}">尾页</a></li>
			</c:if>
		</ul>
	</nav>
</c:if>
<c:if test="${requestScope.CatId == null}">
	<nav aria-label="...">
		<ul class="pager">
			<c:if test="${requestScope.PageInfo.pageNum == 1}">
				<li class="disabled"><a href="javascript:void(0)">首页</a></li>
				<li class="disabled"><a href="javascript:void(0)">上一页</a></li>
			</c:if>
			<c:if test="${requestScope.PageInfo.pageNum > 1}">
				<li><a href="list.do?page=1">首页</a></li>
				<li><a href="list.do?page=${requestScope.PageInfo.prePage}">上一页</a></li>
			</c:if>
			<li>
				<span aria-hidden="true" style="color: #3c763d;">第&nbsp;${requestScope.PageInfo.pageNum}&nbsp;/&nbsp;${requestScope.PageInfo.pages}&nbsp;页&nbsp;&nbsp;</span>
			</li>
			<c:if test="${requestScope.PageInfo.pageNum == requestScope.PageInfo.pages}">
				<li class="disabled"><a href="javascript:void(0)">下一页</a></li>
				<li class="disabled"><a href="javascript:void(0)">尾页</a></li>
			</c:if>
			<c:if test="${requestScope.PageInfo.pageNum < requestScope.PageInfo.pages}">
				<li><a href="list.do?page=${requestScope.PageInfo.nextPage}">下一页</a></li>
				<li><a href="list.do?page=${requestScope.PageInfo.pages}">尾页</a></li>
			</c:if>
		</ul>
	</nav>
</c:if>

<!--//gallery-->
<!--subscribe-->
<!--//subscribe-->
<!--footer-->
<!--//footer-->
<div class="footer-bottom">
	<div class="container">
		<p>Copyright © 2017 imooc.com All Rights Reserved | 京ICP备 13046642号-2</p>
	</div>
</div>
</div>
</body>
</html>