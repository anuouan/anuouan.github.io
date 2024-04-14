package com.qfedu.servlets;

import javax.servlet.ServletConfig;
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
@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String v = (String) session.getAttribute("skey");

        ServletContext servletContext = getServletContext();
        String v2 = (String) servletContext.getAttribute("ckey");

        ServletConfig servletConfig = getServletConfig();

        String servletName = servletConfig.getServletName();
        System.out.println("SecondServlet:"+servletName);

    }
}
