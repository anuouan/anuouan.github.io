package com.qfedu.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Description 校验验证码
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

        //1.接收帐号、密码、验证码
        String userName = request.getParameter("userName");
        String userPwd = request.getParameter("userPwd");
        String userCode = request.getParameter("userCode");

        //2.从session取出生成验证码时存储的正确的验证码
        HttpSession session = request.getSession();
        String vCode = (String) session.getAttribute("vCode");

        //3.将用户输入的验证码和从session取出的正确的验证码进行对比
        if(userCode.equals(vCode)){
            //验证码正确,继续校验帐号和密码
            //...
            System.out.println("---验证码正确");
        }else{
            //验证码错误,转发到登录页面，并提示验证码错误（在此案例中登录页面是用html实现的，不能显示提示信息）
            System.out.println("---验证码错误");
        }
    }
}
