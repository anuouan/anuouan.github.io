package com.qfedu.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Description 修改session数据
 * @Author 千锋涛哥
 * 公众号： Java架构栈
 */
@WebServlet("/FourthServlet")
public class FourthServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1.获取session对象
        HttpSession session = request.getSession();

        //2.修改session对象中的数据
        session.removeAttribute("key1");
    }
}
