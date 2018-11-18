<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <title>创建歌单</title>
    <style type="text/css">
        label{
            font-size: 20px;
        }
        form{
            width: 700px;
        }
        div.panel {
            width: 750px;
            margin: 0 auto;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="jumbotron">
        <h1>创建歌单</h1>
        <p>
            你好，${sessionScope.username}&nbsp;
            <br>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/home">回到首页</a>
        </p>
    </div>
    <div class="panel panel-default">
        <div class="panel-body">
            <form action="${pageContext.request.contextPath}/createSongList" class="form-horizontal">
                <div class="form-group">
                    <label for="songListName" class="col-sm-2 control-label">歌单名称</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="songListName" id="songListName" placeholder="请输入歌单名称" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="songListDesp" class="col-sm-2 control-label">描述</label>
                    <div class="col-sm-10">
                        <textarea rows="3" class="form-control" name="songListDesp" id="songListDesp" placeholder="请输入歌单描述" required></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default btn-lg">创建</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
