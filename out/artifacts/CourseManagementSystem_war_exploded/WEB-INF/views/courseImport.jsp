<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<base href="${basePath}">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%--<script type="text/javascript" src="js/jquery-1.4.2.js"></script>--%>
<script type="text/javascript">
    window.onload=function () {
        var msg = '${msg}';
        if (msg!==undefined && msg!=="") {
            alert(msg);
        }
	};
</script>
<title>课程批量导入</title>
</head>
<body>
	<center>
		<h1>课程批量导入</h1>
		<hr>
		<form action="importCourse" method="post" enctype="multipart/form-data">
			<table cellspacing="0px" cellpadding="0px" border="1px" width="400px">
				<tr>
					<td>Excel文件</td>
					<td><input type="file" name="file"></td>
				</tr>			
				<tr>
					<td colspan="2" style="text-align:center">
						<input type="submit" value="导入">
						<input type="reset" value="取消">
					</td>
				</tr>			
			</table>
		</form>
		<%--<h3 id="msg" style="color: royalblue">${msg}</h3>--%>
	</center>
</body>
</html>