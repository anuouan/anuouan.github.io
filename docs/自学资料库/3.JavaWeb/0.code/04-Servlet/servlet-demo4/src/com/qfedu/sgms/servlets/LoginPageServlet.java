package com.qfedu.sgms.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Description  响应登录页面
 * @Author 千锋涛哥
 * 公众号： Java架构栈
 */
@WebServlet("/login")
public class LoginPageServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("-----doPost");
        // doPost调用doGet
        doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("-----doGet");

        //接收从CheckServlet传递的提示信息
        String tips = (String) request.getAttribute("tips");

        //响应一个登录界面
        response.setStatus(200);
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='utf-8'>");
        out.println("<title>学生成绩查询系统-登录</title>");
        out.println("</head>");
        out.println("<body>");
        //显示提示信息
        if(tips != null){
            out.println("<label style='color:red'>"+tips+"</label>");
        }
        // 点击登录之后跳转到另一个CheckServlet，在一个项目中action的值可以只写 CheckServlet的url
        out.println("<form action='CheckServlet' method='post'>");
        out.println("<h3>学生成绩查询系统—学生登录</h3>");
        out.println("<p>学号：<input type='text' name='stuNum' placeholder='学生学号'/></p>");
        out.println("<p>密码：<input type='password' name='stuPwd' placeholder='登录密码'/></p>");
        out.println("<p><input type='submit' value='登录'/></p>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
        out.flush();
        out.close();
    }
}
