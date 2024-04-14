<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>

    <div>

<%--    使用EL表达式获取数据    --%>

<%--  接收简单类型及字符串 ${key}  --%>
    ${key1}<br/>
    ${key2}<br/>

<%--  接收对象数据  ${key}获取对象的toString方法输出，
      我们可以通过 ${key.attrName}获取对象属性值，通过反射调用类中属性的get方法获取属性值
       因此传递到JSP页面、使用EL表达式获取属性值的对象必须提供get方法 --%>
    ${key3}<br/>
    ${key3.bookId}<br/>
    ${key3.bookName}<br/>
    ${key3.bookAuthor}<br/>
    ${key3.bookPrice}<br/>

<%-- 接收数组数据  ${key[index]} --%>
    ${key4[0]}-${key4[1]}-${key4[2]}<br/>

<%-- 接收集合中的数据：${key[index]}
     如何集合中的元素是对象 ，可以进一步使用 ${key[index].attrName} 获取集合中对象的属性--%>
    ${key5[0].bookName}- ${key5[0].bookAuthor}<br/>
    ${key5[1].bookName}- ${key5[1].bookAuthor}<br/>
    ${key5[2].bookName}- ${key5[2].bookAuthor}<br/>

<%-- 接收Map中的数据: 使用${key}获取整个map
                    使用${key.mapKey} 根据可以获取元素
                    如果map中的key是以数字开头，可以使用${key['mapKey']}
     如果map中的value是对象，我们还可以进一步使用 ${key.mapKey.attrName}获取对象属性值--%>
    ${key6['a1001']}<br/>
    ${key6.a1001}<br/>
    ${key6.a1001.bookName}<br/>

    <jsp:useBean id="key" class="com.qfedu.dto.Book"></jsp:useBean>
    <hr/>
    ${sessionScope.key}
    </div>





    </body>
</html>
