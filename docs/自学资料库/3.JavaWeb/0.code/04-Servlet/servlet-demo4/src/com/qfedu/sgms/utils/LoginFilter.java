package com.qfedu.sgms.utils;

import com.qfedu.sgms.dto.Student;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Description 登录验证过滤器
 * @Author 千锋涛哥
 * 公众号： Java架构栈
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //1.因为此过滤器会拦截所有用户请求（包括受限资源和非受限资源）
        //  所以当一个用户请求被拦截之后，我们需要知道这个请求的路径
        // a.将ServletRequest转换成 HttpServletRequest
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        // b.通过request对象获取用户的请求路径
        String uri = request.getRequestURI();    //  ----  /demo4/IndexPageServlet
        // c.截取uri最后一个/后的路径，即为请求路径
        String requestPath = uri.substring( uri.lastIndexOf("/")+1 );
        System.out.println("requestPath:"+requestPath);

        //2.判断：如果请求路径是非受限资源则直接放行，如果是受限资源则需要验证用户是否登录
        if("CheckServlet".equals(requestPath) || "login".equals(requestPath)){
            //放行
            filterChain.doFilter(servletRequest, servletResponse);
        }else{
            //进入else代码，表示此请求是受限资源，需要验证用户是否登录
            //3.判断session中是否有用户信息，如果有则表示用户已经登录——放行
            //  如果没有则表示用户未登录，转发到登录页面，提示请先登录
            HttpSession session = request.getSession();
            Student stu = (Student) session.getAttribute("stu");
            if(stu != null){
                filterChain.doFilter(servletRequest, servletResponse);
            }else{
                //转到到登录页面
                request.setAttribute("tips","请先登录！");
                request.getRequestDispatcher("login").forward(request,response);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
