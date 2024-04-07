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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author 千锋涛哥
 * 公众号： Java架构栈
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //1.传递数据
        //简单类型
        request.setAttribute("key1",123);
        //字符串
        request.setAttribute("key2","Hello EL!");
        //对象
        request.setAttribute("key3",new Book("1001","Java","亮亮",20.00));
        //数组
        String[] arr = {"aaa","bbb","ccc"};
        request.setAttribute("key4",arr);
        //集合
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("1001","Java","亮亮",20.00));
        bookList.add(new Book("1002","C++","张三",21.00));
        bookList.add(new Book("1003","Python","李四",22.00));
        request.setAttribute("key5",bookList);
        //Map
        Map<String,Book> map = new HashMap<>();
        map.put("a1001",new Book("1001","Java","亮亮",20.00));
        map.put("a1002",new Book("1002","C++","张三",21.00));
        map.put("a1003",new Book("1003","Python","李四",22.00));
        request.setAttribute("key6",map);


        request.setAttribute("key","requestValue");
        
        HttpSession session = request.getSession();
        session.setAttribute("key","sessionValue");

        ServletContext application = getServletContext();
        application.setAttribute("key","applicationValue");

        //2.转发到JSP页面
        request.getRequestDispatcher("test.jsp").forward(request,response);

    }
}
