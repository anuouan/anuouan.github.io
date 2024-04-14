<%@ page import="java.util.List" %>
<%@ page import="com.qfedu.jsp.dto.Book" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
    <%! int m = 10; %>
        <table width="80%" align="center" border="1" cellspacing="0">
            <caption>图书信息列表</caption>
            <tr>
                <th>图书ID</th>
                <th>图书名称</th>
                <th>作者</th>
                <th>价格</th>
                <th>封面</th>
                <th>描述</th>
                <th>类型</th>
            </tr>
            <%-- 在JSP中可以写Java代码，但是代码必须写在<%%>符号中 --%>
            <%
            //1.通过Java代码，接收BookListServlet转发时传递的 图书信息集合的数据
            List<Book> bookList = (List<Book>) request.getAttribute("bookList");
            for(int i=0; i< bookList.size() ; i++){
                //book是java代码中的变量
                Book book = bookList.get(i);
            %>
                <tr>
                    <%-- 如果需要将JSP中java代码的变量显示在HTML标签中，则需要使用<%=attr%> --%>
                    <td><%=book.getBookId() %></td>
                    <td><%=book.getBookName() %></td>
                    <td><%=book.getBookAuthor() %></td>
                    <td><%=book.getBookPrice() %></td>
                    <td><img src="<%=book.getBookImgPath() %>"/></td>
                    <td><%=book.getBookDesc() %></td>
                    <td><%=book.getBookType() %></td>
                </tr>
            <%
            }
            %>
        </table>
    </body>
</html>
