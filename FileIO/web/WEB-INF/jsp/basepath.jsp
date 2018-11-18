<%--
  Created by IntelliJ IDEA.
  User: lvjin
  Date: 2018/5/14
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%
    // 获取工程在服务器上的路径
    String basePath = request.getScheme() + "://" + request.getServerName() + ":"
            + request.getServerPort() + request.getContextPath();
//    out.print(basePath);
    request.setAttribute("basePath",basePath);
%>

