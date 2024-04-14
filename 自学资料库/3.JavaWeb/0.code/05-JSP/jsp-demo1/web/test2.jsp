<%@ page import="com.qfedu.jsp.dto.Book" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
This is Test2
<hr/>
    <%-- 相当于 Book book = new Book(); --%>
    <jsp:useBean id="book" class="com.qfedu.jsp.dto.Book"></jsp:useBean>
    <%-- 相当于 book.setBookId("100001")   --%>
    <jsp:setProperty name="book" property="bookId" value="100001"></jsp:setProperty>
    <jsp:setProperty name="book" property="bookName" value="Java"></jsp:setProperty>
    <%-- 相当于 book.getBookId()，并将获取的值输出到页面   --%>
    <jsp:getProperty name="book" property="bookId"/>

    <%
        Book book1 = new Book();
        book1.setBookId("100002");
        book1.setBookName("C++");
        String bookId = book1.getBookId();
    %>
    <%=bookId %>

<hr/>

<%
    String v = (String) pageContext.getAttribute("key1");
%>
<%=v%>

</body>
</html>
