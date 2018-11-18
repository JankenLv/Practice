<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <head>
        <meta charset="UTF-8">
        <title>图书列表</title>
        <link rel="stylesheet" href="../css/index.css">
        <link rel="stylesheet" href="../css/bootstrap.min.css">
    </head>

    <body>
       <header>
            <div class="container">
               <c:forEach items="${requestScope.SubList}" var="cat">
                   <nav>
                       <a href="subList.do?catId=${cat.id}" >${cat.name}</a>
                   </nav>
               </c:forEach>
                <c:if test="${requestScope.CatId < 0}">
                    <nav>
                        <a href="../category/list.do" >分类</a>
                    </nav>
                    <nav>
                        <a href="../portal.do" >回到首页</a>
                    </nav>
                </c:if>
                <c:if test="${requestScope.CatId > 0}">
                    <nav>
                        <a href="list.do" >全部图书</a>
                    </nav>
                    <nav>
                        <a href="../portal.do" >回到首页</a>
                    </nav>
                </c:if>
            </div>
        </header>
        <section class="banner">
            <div class="container">
                <div>
                    <h1>图书</h1>
                    <p>图书分类列表</p>
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
                    </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${requestScope.PageInfo.list}" var="book">
                            <tr>
                                <td>${book.name}</td>
                                <td>${book.category.name}</td>
                                <td><fmt:formatNumber value="${book.price}" type="currency"/> </td>
                                <td><fmt:formatDate value="${book.createTime}" type="both"/> </td>
                                <td><fmt:formatDate value="${book.updateTime}" type="both"/> </td>
                                <td>
                                    <a class="btn btn-info" href="toModify.do?id=${book.id}">修改</a>&nbsp;&nbsp;
                                    <a class="btn btn-warning" href="remove.do?id=${book.id}">删除</a>&nbsp;&nbsp;
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <c:if test="${requestScope.CatId > 0}">
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
                <c:if test="${requestScope.CatId < 0}">
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