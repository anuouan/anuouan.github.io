package com.qfedu.sgms.servlets;

import com.qfedu.sgms.dto.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Description 提供登录成功之后的主页面
 * @Author 千锋涛哥
 * 公众号： Java架构栈
 */
@WebServlet("/IndexPageServlet")
public class IndexPageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //响应一个登录界面
        response.setStatus(200);
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='utf-8'>");
        out.println("<title>学生成绩查询系统-主页面</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<table border='1' width='100%' height='700'>");
        out.println("<tr height='100'><td colspan='2'><label>学生成绩查询系统欢迎您！</label></td></tr>");
        out.println("<tr>");
        out.println("<td width='200'>2-1</td>");
        out.println("<td align='center' valign='top'>");
        //查询成绩的表单 ： 修改action属性为 GradeQueryServlet
        out.println("<form action='GradeQueryServlet' method='post'>");
        out.println("<h3>查询成绩</h3>");
        out.println("<p>学号：<input type='text' name='stuNum' placeholder='学生学号'/></p>");
        out.println("<p>课程：<input type='text' name='courseId' placeholder='课程编号'/></p>");
        out.println("<p><input type='submit' value='查询'/></p>");
        out.println("</form>");
        out.println("</td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
