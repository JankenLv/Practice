<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE"/>
		<title></title>
		<link rel="stylesheet" type="text/css" href="css/all.css"/>
		<link rel="stylesheet" type="text/css" href="css/pop.css"/>
		<link rel="stylesheet" type="text/css" href="css/main.css"/>
	</head>
	<script type="text/javascript">
        function showMsg() {
            var msg = '${resultDto.exceptionMsg}';
            if (msg == "") {
                //
            } else {
                alert(msg);
            }
        }
	</script>
	<body style="background: #e1e9eb;" onload="showMsg()">
		<form id="mainForm" method="post" enctype="multipart/form-data" action="${basePath}/ImportExcel">
			<div class="right">
				<div class="current">当前位置：<a href="###">导入/导出</a> &gt; 导入Excel</div>
				<div class="rightCont">
					<p class="g_title fix">导入</p>
					<table class="tab1" width="100%">
						<tbody>
							<tr>
							<td align="right" width="10%">标题<font color="red">*</font>：</td>
							<td width="30%">
								<input id="title" name="title" class="allInput" style="width:100%;" type="text" />
							</td>
							<td align="right" width="10%">选择文件<font color="red">*</font>：</td>
							<td width="30%">
								<input type="file" name="excel" style="width:100%;" required="required"/>
							</td>
						</tr>
					</tbody>
					</table>
					<div style="text-align: center; margin-top: 30px;">
						<input class="tabSub" value="导     入" type="submit"/>
					</div>
				</div>
			</div>
		</form>
	</body>
</html>