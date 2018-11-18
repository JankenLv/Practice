<%@ page language="java" pageEncoding="utf-8" import="java.util.*" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>测试验证码</title>
      <meta http-equiv="pragma" content="no-cache">
      <meta http-equiv="cache-control" content="no-cache">
      <meta http-equiv="expires" content="0">
  </head>
  <body>
    <img src="code.jsp" alt="验证码" id="code" />
    <a href="javascript:void(0)" onclick="changeCode()">看不清？点我切换</a>
    <script !src="">
        function changeCode(){
            document.getElementById("code").src="code.jsp?time=" + new Date().getTime();
        }
    </script>
  </body>
</html>
