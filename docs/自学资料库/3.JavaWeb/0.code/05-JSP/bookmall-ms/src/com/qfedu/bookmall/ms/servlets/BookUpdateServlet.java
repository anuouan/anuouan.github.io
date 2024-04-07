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
 * @Description
 * @Author 千锋涛哥
 * 公众号： Java架构栈
 */
@WebServlet("/BookUpdateServlet")
public class BookUpdateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接收修改后的图书信息（因为不修改图片，所以就是常规的数据提交）
        String bookId = request.getParameter("bookId");
        String bookName = request.getParameter("bookName");
        String bookAuthor = request.getParameter("bookAuthor");
        double bookPrice = Double.parseDouble( request.getParameter("bookPrice") );
        String bookImgPath = request.getParameter("bookImgPath");
        String bookDesc = request.getParameter("bookDesc");
        int bookStock = Integer.parseInt(request.getParameter("bookStock") ) ;
        int bookType = Integer.parseInt(request.getParameter("bookType") ) ;

        //2.调用BookService执行修改
        Book book = new Book(bookId, bookName, bookAuthor, bookPrice, bookImgPath, bookDesc, bookStock, bookType);
        BookService bookService = new BookService();
        boolean b = bookService.modifyBook(book);

        //3.跳转到提示页面，进行提示
        String tips = b?"<label style='color:green'>图书修改成功！</label>":"<label style='color:red'>图书修改失败！</label>";
        request.setAttribute("tips",tips);
        request.getRequestDispatcher("prompt.jsp").forward(request,response);
    }
}
