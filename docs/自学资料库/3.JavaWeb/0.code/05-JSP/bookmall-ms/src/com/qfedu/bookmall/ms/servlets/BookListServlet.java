package com.qfedu.bookmall.ms.servlets;

import com.qfedu.bookmall.ms.dto.Book;
import com.qfedu.bookmall.ms.service.BookService;
import com.qfedu.bookmall.ms.utils.PageHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Description  分页查询图书信息
 * @Author 千锋涛哥
 * 公众号： Java架构栈
 */
@WebServlet("/BookListServlet")
public class BookListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接收客户端传递的页码
        //  (如果客户端没有传递页码，则默认页码为1，如果传递了则使用客户端传递的页码)
        String num = request.getParameter("pageNum");
        int pageNum = num==null? 1: Integer.parseInt( num );
        //2.定义pageSize
        int pageSize = 10;

        //3.调用BookService查询这一页的图书信息
        BookService bookService = new BookService();
        PageHelper<Book> bookPageHelper = bookService.listBooksByPage(pageNum, pageSize);

        //5.将查询到的bookPageHelper(当前页数据的集合、当前页码、总页数)  转发到book-list.jsp
        request.setAttribute("bookPageHelper",bookPageHelper);
        request.getRequestDispatcher("book-list.jsp").forward(request,response);
    }
}
