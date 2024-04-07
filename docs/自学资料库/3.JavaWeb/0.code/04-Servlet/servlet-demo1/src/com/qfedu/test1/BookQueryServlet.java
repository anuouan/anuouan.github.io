package com.qfedu.test1;

import com.qfedu.test1.dto.Book;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description 根据图书ID查询一个图书信息
 * @Author 千锋涛哥
 * 公众号： Java架构栈
 */
@WebServlet("/book-query")
public class BookQueryServlet extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        // 将ServletRequest转换成HttpServletRequest
        // 将ServletResponse转换成HttpServletResponse
        // 调用 service(HttpServletRequest req, HttpServletResponse resp)
        super.service(req, res);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取客户端请求方式
        // 根据不同的请求方式，调用doGet/doPost
        super.service(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("BookQueryServlet--------doPost");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("BookQueryServlet--------doGet");
        //动态生成HTML
        // 1.接收到浏览器请求时传递的图书ID (bookId)
        String bid = request.getParameter("bookId");

        // 2.根据bid查询数据库图书表(伪代码)
        Map<String, Book> bookMap = new HashMap<>();
        bookMap.put("1001",new Book("1001","Java","张三",55.66,""));
        bookMap.put("1002",new Book("1002","C++","李四",33.44,""));
        bookMap.put("1003",new Book("1003","Python","王五",44.55,""));
        // book就是根据用户请求查询到的动态数据
        Book book = bookMap.get(bid);

        // 3.将查询到图书信息生成网页，将网页响应给浏览器：通过IO流（输出流）向浏览器响应一个网页数据
        // 这个out对象，就是用于响应浏览器的输出流，通过这个输出流写出什么数据，浏览器就可以接受到什么数据
        // a.设置响应头
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        // b.通过输出流响应网页数据
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><meta charset='utf-8'><title>这是Servlet响应的网页</title></head>");
        out.println("<body>");
        out.println("<table style='border:1px deepskublue solid; width:1000px;' align='center' border='1' cellspacing='0'>");
        out.println("<tr><th>图书编号</th><th>图书名称</th><th>图书作者</th><th>图书价格</th><th>图书封面</th></tr>");
        out.println("<tr>");
        out.println("<td>"+book.getBookId()+"</td>");
        out.println("<td>"+book.getBookName()+"</td>");
        out.println("<td>"+book.getBookAuthor()+"</td>");
        out.println("<td>"+book.getBookPrice()+"</td>");
        out.println("<td>"+book.getBookImgPath()+"</td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
        out.flush();
        out.close();
    }


}
