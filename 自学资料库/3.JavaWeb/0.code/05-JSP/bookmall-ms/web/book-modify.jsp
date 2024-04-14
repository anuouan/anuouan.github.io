<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title></title>
</head>
<body>
<h3>修改图书信息</h3>
    <form action="BookUpdateServlet" method="post">
    <%--  图书ID不能修改，因此不显示在输入框中，提交修改又需要图书ID，所以使用隐藏域传递图书ID    --%>
      <p>图书ID：${book.bookId}<input type="hidden" name="bookId" value="${book.bookId}"/></p>
      <p>图书名称：<input type="text" name="bookName" value="${book.bookName}"/></p>
      <p>图书作者：<input type="text" name="bookAuthor" value="${book.bookAuthor}"/></p>
      <p>图书价格：<input type="text" name="bookPrice" value="${book.bookPrice}"/></p>
      <%--   图书封面暂不支持修改   --%>
      <p>图书封面：
        <img src="${book.bookImgPath}" height="100"/>
        <input type="hidden" name="bookImgPath" value="${book.bookImgPath}"/>
        <%-- <input type="file" name="" /> --%>
      </p>
      <p>图书描述：<input type="text" name="bookDesc" value="${book.bookDesc}"/></p>
      <p>图书库存：<input type="text" name="bookStock" value="${book.bookStock}"/></p>
      <p>图书类型：
        <c:if test="${book.bookType ==1}">
          <input type="radio" name="bookType" value="1" checked/>原创
          <input type="radio" name="bookType" value="2"/>翻译
        </c:if>
        <c:if test="${book.bookType ==2}">
          <input type="radio" name="bookType" value="1" />原创
          <input type="radio" name="bookType" value="2" checked/>翻译
        </c:if>
      </p>
      <p><input type="submit" value="提交"/></p>
  </form>
</body>
</html>
