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
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //1.获取session对象
        // session对象是 javax.servlet.http.HttpSession接口的对象
        // getSession() : 获取当前用户连接
        //HttpSession session = request.getSession();
        // getId() : 获取sessionID
        //String sessionId = session.getId();
        //System.out.println(sessionId);

        //设置session对象的过期时间（单位:s）
        //设置session过期时间10s：当客户端的两次请求时间>10s,session将会被销毁
        //session.setMaxInactiveInterval(10);

        //手动销毁session对象
        //session.invalidate();

        //2.将数据保存到session对象
        //session.setAttribute("key1","Hello QF!");

        String userName = request.getParameter("userName");
        System.out.println("userName:"+userName);

        request.setAttribute("password","123123");
        //转发
        request.getRequestDispatcher("SecondServlet").forward(request,response);

    }
}
