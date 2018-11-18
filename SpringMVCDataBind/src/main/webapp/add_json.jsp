<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
    <title>测试json类型数据绑定</title>
    <script type="text/javascript" src="js/jquery-1.4.2.js"></script>
    <script type="text/javascript">
        $(function () {
            var json = {
                "id":"8",
                "name":"ssm框架整合",
                "price":"500"
            };
            $.ajax({
                url:"jsonType",
                data:JSON.stringify(json),
                type:"post",
                contentType:"application/json;charset=utf-8",
                dataType:"json",
                success:function(data) {
                    alert(data.name + " === " + data.price)
                }
            });
        })
    </script>
<body>

</body>
</html>
