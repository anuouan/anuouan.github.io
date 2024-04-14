package com.qfedu.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Description 验证用户名是否可用
 * @Author 千锋涛哥
 * 公众号： Java架构栈
 */
@WebServlet("/CheckUserNameServlet")
public class CheckUserNameServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //1.接收用户名
        String name = request.getParameter("userName");

        //2.判断是否可用
        boolean b = !name.startsWith("admin");

        //3.响应ajax请求
        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        String jsonStr = b ? "{\"code\":1000,\"msg\":\"success\"}":"{\"code\":1001,\"msg\":\"fail\"}";
        //  {"code":1000,"msg":"success"}   {"code":1001,"msg":"fail"}
        PrintWriter out = response.getWriter();
        out.println(jsonStr);
        out.flush();
        out.close();
    }
}
