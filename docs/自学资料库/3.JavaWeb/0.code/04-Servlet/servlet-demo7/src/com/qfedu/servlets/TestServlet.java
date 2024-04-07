package com.qfedu.servlets;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @Description
 * @Author 千锋涛哥
 * 公众号： Java架构栈
 */
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取当前web应用在服务器上的信息
        //ServletContext对象 —— Servlet上下文对象
        //1.获取ServletContext对象
        ServletContext servletContext = getServletContext();

        //2.通过ServletContext对象获取当前web应用的上下文路径
        //   就是当前web应用在web服务器上的访问路径
        String contextPath = servletContext.getContextPath();

        //3.通过ServletContext对象获取web项目中的目录在 服务器上的绝对路径
        String realPath = servletContext.getRealPath("/files");

        //【session对象】
        String value = request.getParameter("param");
        HttpSession session = request.getSession();
        session.setAttribute("skey",value);

        servletContext.setAttribute("ckey",value);

        //通过ServletContext对象获取web.xml中配置的全局参数
        // getInitParameterNames()：获取web.xml中全局参数所有的key[key1,key2]
        Enumeration<String> keys = servletContext.getInitParameterNames();
        // getInitParameter(key): 根据key获取value
        String v1 = servletContext.getInitParameter("key1");
        String v2 = servletContext.getInitParameter("key2");

        //1.获取ServletConfig对象
        //getServletConfig() : 获取当前Servlet类的ServletConfig对象
        ServletConfig servletConfig = getServletConfig();

        //2.通过ServletConfig获取当前Servlet类路径
        String servletName = servletConfig.getServletName();

        //3.通过ServletConfig对象加载当前Servlet类的初始化参数
        //getInitParameterNames 获取当前Servlet所有初始化参数的key
        Enumeration<String> names = servletConfig.getInitParameterNames();

        //getInitParameter 根据key获取value
        String v3 = servletConfig.getInitParameter("key3");

        System.out.println("TestServlet:"+v3);


    }
}
