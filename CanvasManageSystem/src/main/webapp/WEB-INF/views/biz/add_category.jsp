<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <base href="${requestScope.basePath}">
        <meta charset="UTF-8">
        <title>新建</title>
        <link rel="stylesheet" href="css/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/css/add.css">
        <script type="text/javascript">
            function goback() {
                window.history.back();
            }
        </script>
    </head>
    <body>
        <nav class="navbar navbar-default">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="manageCanvas.do">
                        慕课网油画管理
                    </a>
                </div>
            </div>
        </nav>
        <div class="container">
            <div class="jumbotron">
                <h1>Hello, ${sessionScope.username}!</h1>
                <p>请小心的新增油画分类，要是建了一个错误的就不好了。。。</p>
            </div>
            <div class="page-header">
                <h3><small>新建</small></h3>
            </div>
            <form class="form-horizontal" action="addCategory.do" method="post">
                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">名称 ：</label>
                    <div class="col-sm-8">
                        <input name="name" class="form-control" id="name" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="description" class="col-sm-2 control-label">描述 ：</label>
                    <div class="col-sm-8">
                        <input type="text" name="description" class="form-control" id="description" required />
                        <%--<input type="hidden" id="createname" name="createname" value="#">--%>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-primary">保存</button>&nbsp;&nbsp;&nbsp;
                        <button type="button" class="btn btn-primary" onclick="goback()">返回</button>
                    </div>
                </div>
            </form>
        </div>
        <footer class="text-center" >
            copy@imooc
        </footer>
    </body>
</html>
