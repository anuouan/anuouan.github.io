package com.qfedu.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Description 写Cookie
 * @Author 千锋涛哥
 * 公众号： Java架构栈
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //向浏览器存储一个Cookie
        // 1. 创建Cookie对象  （javax.servlet.http.Cookie）
        Cookie cookie1 = new Cookie("key1", "value1");
        Cookie cookie2 = new Cookie("key2", "value2");

        // 设置cookie生命周期
        // 情况1：如果设置>0的值，表示设置cookie有效时间（单位s）
        // 情况2：如果参数=0，表示浏览器关闭销毁cookie
        // 情况3：如果参数=-1，表示内存存储
        cookie1.setMaxAge(24*60*60);
        cookie2.setMaxAge(24*60*60);

        // 2. 将cookie对象添加到HTTP响应头，写Cookie到客户端
        response.addCookie(cookie1);
        response.addCookie(cookie2);

        //响应浏览器一个界面
        //a.设置响应头
        response.setStatus(200);
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        //b.响应正文
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='utf-8'>");
        out.println("<title></title>");
        out.println("<body>");
        out.println("<a href='SecondServlet'>请求SecondServlet</a>");
        out.println("</body>");
        out.println("</head>");
        out.println("</html>");
        out.flush();
        out.close();
    }
}
