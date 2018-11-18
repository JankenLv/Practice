<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>保存图片到数据库</title>
</head>
<body>
<center>
    <form action="${pageContext.request.contextPath}/savePicture" method="post" enctype="multipart/form-data">
        <p>上传图片到数据库</p>
        <hr>
        <label for="pic"></label>
        <input type="file" name="picture" id="pic">
        <input type="submit" value="保存">
    </form>
    <a href="${pageContext.request.contextPath}/checkPicture">查看已保存的图片</a>
</center>
</body>
</html>
