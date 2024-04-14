package com.qfedu.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description 读Cookie
 * @Author 千锋涛哥
 * 公众号： Java架构栈
 */
@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 读取cookie: 当客户端再次请求服务器时，通过request将cookie传递到服务器
        // 通过request对象获取浏览器传递的cookie
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie: cookies) {
            String key = cookie.getName();
            String value = cookie.getValue();
            System.out.println(key+"对应的值："+value);
        }
        // SecondServlet暂时不响应浏览器
    }
}
