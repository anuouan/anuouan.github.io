package com.qfedu.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Description
 * @Author 千锋涛哥
 * 公众号： Java架构栈
 */
@WebFilter("/FirstServlet")
public class MyFilter02 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MyFilter02-----before");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("MyFilter02-----after");
    }

    @Override
    public void destroy() {

    }
}
