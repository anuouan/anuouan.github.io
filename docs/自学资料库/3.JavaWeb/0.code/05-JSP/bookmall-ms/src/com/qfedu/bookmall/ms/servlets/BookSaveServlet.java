package com.qfedu.bookmall.ms.servlets;

import com.qfedu.bookmall.ms.dto.Book;
import com.qfedu.bookmall.ms.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.UUID;

/**
 * @Description
 * @Author 千锋涛哥
 * 公众号： Java架构栈
 */
@WebServlet("/BookSaveServlet")
@MultipartConfig
public class BookSaveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接收输入的图书信息
        String bookId = request.getParameter("bookId");
        String bookName = request.getParameter("bookName");
        String bookAuthor = request.getParameter("bookAuthor");
        double bookPrice = Double.parseDouble( request.getParameter("bookPrice") );
        String bookDesc = request.getParameter("bookDesc");
        int bookStock = Integer.parseInt(request.getParameter("bookStock") ) ;
        int bookType = Integer.parseInt(request.getParameter("bookType") ) ;
        //2.接收并保存图书的封面图片
        Part bookImg = request.getPart("bookImg");
        String header = bookImg.getHeader("Content-Disposition");
        String ext = header.substring( header.lastIndexOf("."), header.lastIndexOf("\"") );
        String fileName = UUID.randomUUID().toString()+ext;  //aaaa.jpg
        //获取files目录在服务器的路径
        String dir = getServletContext().getRealPath("/files");
        String savePath = dir+"\\"+fileName;
        //保存图片
        bookImg.write(savePath);
        //3.调用BookService将图书信息保存到数据库
        Book book = new Book(bookId, bookName, bookAuthor, bookPrice, "files/" + fileName, bookDesc, bookStock, bookType);
        BookService bookService = new BookService();
        boolean b = bookService.saveBook(book);
        //4.跳转到提示页面，并进行提示
        String tips = b?"<label style='color:green'>添加图书成功！</label>":"<label style='color:red'>添加图书失败！</label>";
        request.setAttribute("tips",tips);
        request.getRequestDispatcher("prompt.jsp").forward(request,response);
    }
}
