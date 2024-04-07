package com.qfedu.sgms.servlets;

import com.qfedu.sgms.dao.StudentDAO;
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
 * @Description 验证学生登录
 * @Author 千锋涛哥
 * 公众号： Java架构栈
 */
@WebServlet("/CheckServlet")
public class CheckServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 接收学号和密码
        request.setCharacterEncoding("utf-8");
        String num = request.getParameter("stuNum");
        String pwd = request.getParameter("stuPwd");

        //2.调用StudentDAO中的方法，根据学号和密码查询学生
        StudentDAO studentDAO = new StudentDAO();
        Student student = studentDAO.queryStudentByNumAndPwd(num, pwd);

        //3.判断查询结果，响应客户端
        //根据登录验证的不同结果响应给客户端不同的页面
        if(student == null){
            //登录失败：响应客户端登录页面,提示“登录失败，学号或密码错误！”

            //转发到下一个Servlet是可以通过request传递数据过去的
            request.setAttribute("tips","登录失败，学号或密码错误！");
            //转发到LoginPageServlet：在当前Servlet类的doPost方法转到，也会转发到下一个Servelt的doPost
            request.getRequestDispatcher("login").forward(request,response);
        }else{
            //当学生登录成功，将学生信息存储到session
            HttpSession session = request.getSession();
            session.setAttribute("stu",student);

            //登录成功：响应客户端系统的主页
            //重定向到IndexPageServlet：无需传递参数到IndexPageServlet，所以我们可以使用重定向
            response.sendRedirect("IndexPageServlet");
        }
    }
}
