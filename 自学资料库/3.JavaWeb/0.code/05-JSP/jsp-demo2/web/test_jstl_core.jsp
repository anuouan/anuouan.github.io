<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
    <h3>考试结果</h3>

    <%--  获取考试分数，如果分数>=60,在显示显示结果为“通过” --%>
    <%--  如果test属性的el表达式返回的为true，则显示c:if标签包含的HTML  --%>
    <c:if test="${score >= 60}">
        <label style="color: green">通过</label>
    </c:if>
    <c:if test="${score < 60}">
        <label style="color: red">不通过</label>
    </c:if>

    <hr/>
<%--  如果分数>=90显示优秀；如果分数<90但是>=80显示良好；如果分数<80但是>=70显示中等
  如果分数<70但是>=60显示及格；如果分数<60显示不及格--%>
<%--  c:choose为多分支语句，可以包含多个c:when和一个c:otherwise
      寻找并执行第一个条件成立的c:when，如果所有c:when的条件都不成立则执行c:otherwise--%>
    <c:choose>
        <c:when test="${score>=90}">
            <label style="color: green">优秀</label>
        </c:when>
        <c:when test="${score>=80}">
            <label style="color: green">良好</label>
        </c:when>
        <c:when test="${score>=70}">
            <label style="color: green">中等</label>
        </c:when>
        <c:when test="${score>=60}">
            <label style="color: green">及格</label>
        </c:when>
        <c:otherwise>
            <label style="color: red">不及格</label>
        </c:otherwise>
    </c:choose>


    <%--  遍历传递过来的集合中的图书信息，显示在一个表格中  --%>
    <table align="center" border="1" cellspacing="0">
        <tr>
            <th>图书编号</th>
            <th>图书名称</th>
            <th>图书作者</th>
            <th>图书价格</th>
        </tr>
        <%--    获取传递过来的集合，集合中有几个图书信息，table就显示几行
          items 指定要遍历的集合
          var  指定从集合中每次取出的数据的变量
          begin 指定从集合中的哪个元素开始显示，0表示第一个
          end 指定取到哪个索引对应的集合元素
          step 指定元素的间隔个数（默认为1，依次取出所有元素）
        --%>
        <c:forEach items="${bookList}" var="book" begin="1" end="4" step="2">
            <tr>
                <td>${book.bookId}</td>
                <td>${book.bookName}</td>
                <td>${book.bookAuthor}</td>
                <td>${book.bookPrice}</td>
            </tr>
        </c:forEach>
    </table>

    <%--  格式化数字输出 --%>
    <fmt:formatNumber value="${num}" pattern="#.0000"></fmt:formatNumber><br/>
    <fmt:formatNumber value="${num}" type="currency"></fmt:formatNumber><br/>

    <%-- 格式化日期输出 --%>
    <fmt:formatDate value="${date}" pattern="yyyy-MM-dd"></fmt:formatDate><br/>
    <fmt:formatDate value="${date}" pattern="hh:mm:ss"></fmt:formatDate><br/>
    <fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate><br/>

    </body>
</html>
