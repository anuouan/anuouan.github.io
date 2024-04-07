<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date"%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <%! int k = 5;%>

    <%-- 静态引入 --%>
    <%@ include file="header.jsp"%>

    <div style="height: 400px; background: orange">index</div>
    <%@ include file="footer.jsp"%>

    <%-- 动态引入 --%>
    <jsp:include page="test1.jsp"/>
  </body>
</html>
