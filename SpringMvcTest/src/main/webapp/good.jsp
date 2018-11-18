<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>商品页</title>
</head>
<body>
<form action="good" method="post">
    <label for="name">商品名称</label>
    <input type="text" id="name" name="name" value="${good.price}">
    <p></p>
    <label for="price">价格</label>
    <input type="text" id="price" name="price" value="${good.name}">
    <p></p>
    <button>确认</button>
</form>
</body>
</html>
