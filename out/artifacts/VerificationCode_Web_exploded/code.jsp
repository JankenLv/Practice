<%@ page import="com.verificationcode.Utils.CaptchaCode" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // 1.清空浏览器缓存：
    response.setHeader("pragma","no-cache");
    response.setHeader("cache-control","no-cache");
    response.setHeader("expires","0");

    // 2.调用编写的生成验证码的工具：
    // 2.1 生成图形验证码：
    /*String code = CaptchaCode.drawImage(response);
    session.setAttribute("code",code);*/

    // 2.2 生成算术验证码：
    int result = CaptchaCode.drawArithmeticImage(response);
    session.setAttribute("result",result);

    // 3.解决getOutputStream异常问题：
    out.clear();
    out = pageContext.pushBody();
%>
