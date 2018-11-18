<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta charset="UTF-8">
        <title>新增图书</title>
        <link rel="stylesheet" href="../css/bootstrap.min.css">
        <link rel="stylesheet" href="../css/add.css">
        <script type="text/javascript" src="../js/jquery-1.4.2.js"></script>
        <script type="text/javascript" src="../js/addBook.js"></script>
    </head>
    <body>
        <nav class="navbar navbar-default">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="list.do">
                        慕课网图书管理
                    </a>
                </div>
            </div>
        </nav>
        <div class="container">
            <div class="jumbotron">
                <h1>新增图书</h1>
                <p>请小心的新增图书记录，要是建了一个错误的就不好了。。。</p>
            </div>
            <div class="page-header">
                <h3><small>新增图书</small></h3>
            </div>
            <form class="form-horizontal" action="add.do" method="post" enctype="multipart/form-data">
                <div id="content">
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">名称 ：</label>
                        <div class="col-sm-8">
                            <input name="name" class="form-control" id="name" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="category" class="col-sm-2 control-label">分类 ：</label>
                        <select id="category" name="categoryId" class="col-sm-2 form-control" style="width: auto;margin-left: 15px;">
                            <c:forEach var="cat" items="${requestScope.SubList}">
                                <option  value="${cat.id}">${cat.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="level" class="col-sm-2 control-label">星级 ：</label>
                        <select id="level" name="level" class="col-sm-2 form-control" style="width: auto;margin-left: 15px;">
                            <option id="1" value="1">1星</option>
                            <option id="2" value="2">2星</option>
                            <option id="3" value="3">3星</option>
                            <option id="4" value="4">4星</option>
                            <option id="5" value="5">5星</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="price" class="col-sm-2 control-label">价格 ：</label>
                        <div class="col-sm-8">
                            <input id="price" name="price" type="number" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="file" class="col-sm-2 control-label">图片 ：</label>
                        <div class="col-sm-8">
                            <input id="file" name="smallImg" class="file-loading"
                                   type="file" multiple accept=".jpg,.jpeg,.png" data-min-file-count="1"
                                   data-show-preview="true" onchange="previewPic()">
                            <div class="row" style="display: none;" id="preview">
                                <div class="col-xs-6 col-md-3" >
                                        <span>图片预览：</span>
                                        <a href="javascript:void(0)" class="thumbnail">
                                        <img src="" alt="此处应有图片~" id="img"/>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
                <div align="right">
                    <button type="button" onclick="addContent()" class="btn btn-primary">增加</button>&nbsp;&nbsp;&nbsp;
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-primary">保存</button>&nbsp;&nbsp;&nbsp;
                        <button type="button" class="btn btn-warning" onclick="goback()">返回</button>&nbsp;&nbsp;&nbsp;
                    </div>
                </div>
            </form>
        </div>
        <footer class="text-center" >
            copy@imooc
        </footer>
    <script type="text/javascript">
        var index = 1;
        function addContent() {
            var html =
                '           <h5 class="page-header"></h5>\n' +
                '           <div id="_div_' + index + '">\n' +
                '               <div class="form-group">\n' +
                '                    <label for="name" class="col-sm-2 control-label">名称 ：</label>\n' +
                '                    <div class="col-sm-8">\n' +
                '                        <input name="name" class="form-control" id="name">\n' +
                '                    </div>\n' +
                '                </div>\n' +
                '                <div class="form-group">\n' +
                '                    <label class="col-sm-2 control-label">分类 ：</label>\n' +
                '                    <select name="categoryId" class="col-sm-2 form-control" style="width: auto;margin-left: 15px;">\n' +
                '                        <c:forEach var="cat" items="${requestScope.SubList}">\n' +
                '                            <option value="${cat.id}">${cat.name}</option>\n' +
                '                        </c:forEach>\n' +
                '                    </select>\n' +
                '                </div>\n' +
                '                <div class="form-group">\n' +
                '                    <label class="col-sm-2 control-label">星级 ：</label>\n' +
                '                    <select name="level" class="col-sm-2 form-control" style="width: auto;margin-left: 15px;">\n' +
                '                        <option id="1" value="1">1星</option>\n' +
                '                        <option id="2" value="2">2星</option>\n' +
                '                        <option id="3" value="3">3星</option>\n' +
                '                        <option id="4" value="4">4星</option>\n' +
                '                        <option id="5" value="5">5星</option>\n' +
                '                    </select>\n' +
                '                </div>\n' +
                '                <div class="form-group">\n' +
                '                    <label class="col-sm-2 control-label">价格 ：</label>\n' +
                '                    <div class="col-sm-8">\n' +
                '                        <input name="price" type="number" class="form-control" id="price">\n' +
                '                    </div>\n' +
                '                </div>\n' +
                '                <div class="form-group">\n' +
                '                    <label for="file_' + index + '" class="col-sm-2 control-label">图片 ：</label>\n' +
                '                    <div class="col-sm-8">\n' +
                '                        <input id="file_'+ index +'" name="smallImg" onchange="previewPic(' + index + ')"  class="file-loading"\n' +
                '                               type="file" multiple accept=".jpg,.jpeg,.png" data-min-file-count="1"\n' +
                '                               data-show-preview="true">\n' +
                '                               <div class="row" style="display: none;" id="preview_'+ index +'">\n' +
                '                                <div class="col-xs-6 col-md-3" >\n' +
                '                                        <span>图片预览：</span>\n' +
                '                                        <a href="javascript:void(0)" class="thumbnail">\n' +
                '                                        <img src="" alt="此处应有图片~" id="img_' + index + '" >\n' +
                '                                    </a>\n' +
                '                                </div>\n' +
                '                            </div>\n'+
                '                    </div>\n' +
                '                </div>\n' +
                '             </div>\n';

            var newDiv = document.createElement('div');
            newDiv.id = '_' + index++;
            newDiv.innerHTML = html;
            document.getElementById('content').appendChild(newDiv);
        }
    </script>
    </body>
</html>
