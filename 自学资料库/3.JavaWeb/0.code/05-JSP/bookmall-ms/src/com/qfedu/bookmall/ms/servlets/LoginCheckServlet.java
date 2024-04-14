package com.qfedu.bookmall.ms.servlets;

import com.qfedu.bookmall.ms.dto.User;
import com.qfedu.bookmall.ms.service.UserService;

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
@WebServlet("/LoginCheckServlet")
public class LoginCheckServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接收账号和密码
        String userName = request.getParameter("userName");
        String userPwd = request.getParameter("userPwd");

        //2.调用UserService校验登录
        UserService userService = new UserService();
        User user = userService.checkLogin(userName, userPwd);

        //3.根据校验结果进行跳转和提示
        if(user == null ){
            //登录失败: 转发到login.jsp,传递错误提示信息
            request.setAttribute("tips","<label style='color:red'>账号或密码错误，登录失败！</label>");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }else{
            //登录成功：将用户信息存储到session
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            //重定向到index.jsp
            response.sendRedirect("index.jsp");
        }
    }
}
