<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<body>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":"
            + request.getServerPort() + request.getContextPath() + "/";

    request.setAttribute("basePath", basePath);
%>
</body>
</html>
