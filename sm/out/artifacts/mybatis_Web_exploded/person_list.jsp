<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>员工表</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="jumbotron">
        <h1>Hello, world!</h1>
        <p>...</p>
        <p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a></p>
    </div>
    <table class="table table-striped table-bordered table-hover">
        <thead>
        <tr>
            <th>姓名</th>
            <th>邮箱</th>
            <th>性别</th>
            <th>部门</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>小明</td>
            <td>1</td>
            <td>f</td>
            <td>2</td>
        </tr>
        <tr>
            <td>小红</td>
            <td>1</td>
            <td>f</td>
            <td>2</td>
        </tr>
        <tr>
            <td>小李</td>
            <td>1</td>
            <td>f</td>
            <td>2</td>
        </tr>
        </tbody>
    </table>
    <div>
        <a class="btn btn-default" href="javascript:void(0)" role="button">共&nbsp;${requestScope.PageInfo.total}&nbsp;页</a>
        <a class="btn btn-default" href="list.do?pageNum=${requestScope.PageInfo.navigateFirstPage}" role="button">首页</a>
        <a class="btn btn-default" href="list.do?pageNum=${requestScope.PageInfo.prePage}" role="button">上一页</a>
        <a class="btn btn-default" href="list.do?pageNum=${requestScope.PageInfo.nextPage}" role="button">下一页</a>
        <a class="btn btn-default" href="list.do?pageNum=${requestScope.PageInfo.navigateLastPage}" role="button">尾页</a>
    </div>
</div>
</body>
</html>
