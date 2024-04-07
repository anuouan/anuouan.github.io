package com.qfedu.servlets;

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // session对象是 javax.servlet.http.HttpSession接口的对象
        // getSession() : 获取当前用户连接
        //HttpSession session = request.getSession();

        //3.从session对象中取数据
        //String s1 = (String) session.getAttribute("key1");
        //System.out.println("SecondServlet:"+s1);


        String userName = request.getParameter("userName");
        System.out.println("userName:"+userName);

        String password = (String) request.getAttribute("password");
        System.out.println("password:"+password);
    }
}
