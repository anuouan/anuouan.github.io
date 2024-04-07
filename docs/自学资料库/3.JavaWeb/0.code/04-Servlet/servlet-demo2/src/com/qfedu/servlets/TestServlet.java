package com.qfedu.servlets;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description
 * @Author 千锋涛哥
 * 公众号： Java架构栈
 *
 * 创建servlet类的步骤：
 * 1.创建一个命名为 **Servlet
 * 2.继承javax.servlet.http.HttpServlet类
 * 3.重写doGet和doPost方法
 * 4.配置当前Servlet类的访问路径
 */
@WebServlet(value = "/test",loadOnStartup = 1)
public class TestServlet  extends HttpServlet {


    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("------------初始化方法，在当前Servlet实例被创建的时候执行");
        super.init(config);
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("------------Servlet接口定义的service");
        super.service(req, res);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("------------HttpServlet类定义的service");
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String str = "aaa";
           synchronized (this) {
               System.out.println("------------doGet");
               System.out.println(this);
           }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("------------doPost");
    }

    @Override
    public void destroy() {
        System.out.println("------------销毁方法，当当前Servlet类的实例被销毁前调用");
        super.destroy();
    }
}
