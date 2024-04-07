package com.qfedu.jsp.servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Description
 * @Author 千锋涛哥
 * 公众号： Java架构栈
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.分别通过 request、session、application传值
        request.setAttribute("key1","value1");

        HttpSession session = request.getSession();
        session.setAttribute("key2","value2");

        ServletContext application = getServletContext();
        application.setAttribute("key3","value3");

        //2.转发到test3.jsp
        //request.getRequestDispatcher("test3.jsp").forward(request,response);
        // 重定向到test3.jsp
        response.sendRedirect("test3.jsp");
    }
}
