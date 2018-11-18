<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<%
    request.getRequestDispatcher(request.getContextPath() + "/WEB-INF/views/biz/home.jsp").forward(request,response);
%>
</body>
</html>
