<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String basePath = request.getContextPath();%>
<html>
  <head>
    <title>Kaptcha实现验证码</title>
    <style>
      #inputKaptcha{
        height: 30px;
      }
      button{
        padding: 5px 5px;
      }
    </style>
  </head>
  <body>
  <center>
  <form action="submit.action">
    <table>
      <tr>
        <td>
          <img src="kaptcha.jpg" id="kaptcha"/>
        </td>
        <td>
          <button type="button" id="changeImage">看不清？点击更换</button>
        </td>
      </tr>
      <tr>
        <td colspan="2">
          <input type="text" id="inputKaptcha" value="" placeholder="请输入图片上的验证码" maxlength="4"/>
          <button type="button" id="login">登录</button>
        </td>
        <td>

        </td>
      </tr>
    </table>
  </form>
    <h3 id="h3"></h3>
  </center>
  <script src="<%=basePath%>/js/jquery-1.4.2.js"></script>
  <script>
      $("#changeImage").click(function(){
          $("#kaptcha").attr({src:"kaptcha.jpg?"+ new Date().getTime()});
      });
      $("#login").click(function() {
         var url = "<%=basePath%>/LoginServlet";
         var inputKaptcha = $("#inputKaptcha").val();
         var data = {"inputKaptcha":inputKaptcha};
         console.log("url: " + url);
         console.log("data: " + inputKaptcha);
         $.post("<%=basePath%>/LoginServlet",data,function(result) {
             $("#h3").stop(true);
             console.log("login: " + result[0] + " msg: " + result[1]);
             if("1"==result[0]){
                $("#h3").html(result[1]).fadeIn("slow").delay(2000).fadeOut("slow");
             }else if("0"==result[0]){
                 $("#h3").html(result[1]).fadeIn("slow").delay(2000).fadeOut("slow");
             }
         },"json");
      });
  </script>
  </body>
</html>
