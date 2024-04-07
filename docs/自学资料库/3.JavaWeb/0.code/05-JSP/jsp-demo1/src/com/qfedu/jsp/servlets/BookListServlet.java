package com.qfedu.jsp.servlets;

import com.qfedu.jsp.dao.BookDAO;
import com.qfedu.jsp.dto.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Description 接收客户端请求场、查询图书信息，将图书信息转发到一个JSP文件进行显示
 * @Author 千锋涛哥
 * 公众号： Java架构栈
 */
@WebServlet("/BookListServlet")
public class BookListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.调用BookDAO查询图书信息
        BookDAO bookDAO = new BookDAO();
        List<Book> bookList = bookDAO.listBooks();

        //2.将数据转发到book-list.jsp进行动态显示
        request.setAttribute("bookList",bookList);
        request.getRequestDispatcher("book-list.jsp").forward(request,response);
    }
}
