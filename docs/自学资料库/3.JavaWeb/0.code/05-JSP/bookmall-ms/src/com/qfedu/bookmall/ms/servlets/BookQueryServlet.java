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
 * @Description 根据图书ID查询图书信息
 * @Author 千锋涛哥
 * 公众号： Java架构栈
 */
@WebServlet("/BookQueryServlet")
public class BookQueryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接收点击修改之后传递过来的图书id
        String bookId = request.getParameter("bookId");
        //2.调用BookService查询这个图书信息
        BookService bookService = new BookService();
        Book book = bookService.getBook(bookId);
        //3.将book（要修改的图书的修改之前的信息）传递到book-modify.jsp进行显示
        request.setAttribute("book",book);
        request.getRequestDispatcher("book-modify.jsp").forward(request,response);
    }
}
