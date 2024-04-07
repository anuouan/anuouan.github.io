package com.qfedu.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Description
 * @Author 千锋涛哥
 * 公众号： Java架构栈
 * 1.创建一个类实现javax.servlet.Filter接口
 * 2.实现Filter接口中的init、doFilter、destroy抽象方法
 *    init 是过滤器初始化方法，用于获取过滤器的初始化参数等
 *    destory 是过滤器的销毁方法，用以释放资源
 *    doFilter 方法 用于定义过滤器的业务
 * 3.在doFilter实现过滤器业务
 */
public class MyFilter01 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        System.out.println("MyFilter01~~~~~~before");
        //放行:运行继续执行浏览器请求的目标资源
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("MyFilter01~~~~~~after");
    }

    @Override
    public void destroy() {
    }
}
