<%@ page contentType="text/html; utf-8" language="java" %>
<html>
<%--<head>--%>
    <%--&lt;%&ndash;<meta http-equiv="refresh" content="0;url=<%=request.getContextPath()%>/WEB-INF/views/biz/studentInfo.jsp">&ndash;%&gt;--%>
<%--</head>--%>
<body>
<%
    request.getRequestDispatcher(request.getContextPath() + "/getStudents").forward(request,response);
%>
</body>
</html>
