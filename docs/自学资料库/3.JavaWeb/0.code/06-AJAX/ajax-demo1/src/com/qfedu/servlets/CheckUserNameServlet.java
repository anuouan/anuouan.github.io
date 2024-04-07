package com.qfedu.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Description 检测注册页面输入的用户名是否可用
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
        String userName = request.getParameter("userName");

        //2.检查用户名是否存在（查数据库）
        // 测试规则：只要用户名不是以admin开头就都可以使用
        boolean r = !userName.startsWith("admin");
        String str = r?"<label style='color:green'>用户名可用！</label>":"<label style='color:red'>用户名不可用！</label>";

        //3.通过response的输出流、响应ajax请求
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.println(str);
        out.flush();
        out.close();
    }
}
