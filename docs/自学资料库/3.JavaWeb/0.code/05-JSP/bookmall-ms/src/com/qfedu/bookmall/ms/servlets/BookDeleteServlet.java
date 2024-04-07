package com.qfedu.bookmall.ms.servlets;

import com.qfedu.bookmall.ms.dto.Book;
import com.qfedu.bookmall.ms.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description 删除图书信息
 * @Author 千锋涛哥
 * 公众号： Java架构栈
 */
@WebServlet("/BookDeleteServlet")
public class BookDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接收点击删除之后传递过来的图书ID
        String bookId = request.getParameter("bookId");
        //2.调用BookService完成删除(我们当前案例是将数据真实的从数据库删除，企业项目开发中都是做的逻辑删除---Java web项目)
        BookService bookService = new BookService();
        boolean b = bookService.deleteBook(bookId);
        //3.根据删除结果跳转到提示页面进行提示
        String tips = b?"<label style='color:green'>图书删除成功！</label>":"<label style='color:red'>图书删除失败！</label>";
        request.setAttribute("tips",tips);
        request.getRequestDispatcher("prompt.jsp").forward(request,response);
    }
}
