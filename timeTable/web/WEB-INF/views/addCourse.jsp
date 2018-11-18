<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <base href="${basePath}">
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>课程添加页</title>
</head>
<body>
<center>
    <h2 style="margin-top: 50px">课程添加</h2>
    <form action="addCourse" method="post">
        <table>
            <tr>
                <td>课程名</td>
                <td><input type="text" name="courseName" pattern="\S(\s|\S)+"/></td>
            </tr>
            <tr>
                <td>所属方向</td>
                <td><input type="text" name="courseType" pattern="\S(\s|\S)+"/></td>
            </tr>
            <tr>
                <td>课程描述</td>
                <td><input type="text" name="description" pattern="\S(\s|\S)+"/></td>
            </tr>
            <tr style="text-align: center;">
                <td colspan="2">
                    <input type="submit" name="submit" value="添加" style="border-radius: 5px;border:none;padding:5px;cursor: pointer;" />
                </td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>
