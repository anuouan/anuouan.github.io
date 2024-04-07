package com.qfedu.servlets;

import com.qfedu.dto.Book;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

/**
 * @Description
 * @Author 千锋涛哥
 * 公众号： Java架构栈
 */
@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //1.传递数据
        //分数
        request.setAttribute("score",99);
        // 集合
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("1001","Java","亮亮",20.00));
        bookList.add(new Book("1002","C++","张三",21.00));
        bookList.add(new Book("1003","Python","李四",22.00));
        bookList.add(new Book("1004","PHP","王五",22.00));
        bookList.add(new Book("1005","HTML","赵柳",22.00));
        bookList.add(new Book("1006","平凡的世界","路遥",22.00));
        request.setAttribute("bookList",bookList);

        //传递日期和数字
        request.setAttribute("num",3.141592653);
        request.setAttribute("date",new Date());

        //2.转发到JSP页面
        request.getRequestDispatcher("test_jstl_core.jsp").forward(request,response);

    }
}
