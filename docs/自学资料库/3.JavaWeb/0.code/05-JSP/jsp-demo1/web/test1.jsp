<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        test1
    <%--  从当前JSP转发到另一个JSP
    <jsp:forward page="test2.jsp">
         转发的同时携带参数
        <jsp:param name="name" value="zhangsan"/>
        <jsp:param name="sex" value="nan"/>

    </jsp:forward>
    --%>


    <%
        //将键值对存储到pageContext对象
        pageContext.setAttribute("key1","value1");
    %>

    <%
        //从pageContext根据key取出value
        String v = (String) pageContext.getAttribute("key1");

    %>
    <%=v %>

        <jsp:forward page="test2.jsp"></jsp:forward>

    </body>
</html>
