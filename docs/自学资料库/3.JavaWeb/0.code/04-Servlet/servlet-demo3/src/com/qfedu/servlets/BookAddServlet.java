package com.qfedu.servlets;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description 添加图书
 * @Author 千锋涛哥
 * 公众号： Java架构栈
 */
@WebServlet("/BookAddServlet")
public class BookAddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //getParameter 方法参数字符串 必须要和 form表单中输入框的name属性一致
        //              此方法获取的客户端提交的数据一律为String类型，根据需要可以进行类型转换
        int id = Integer.parseInt(request.getParameter("bookId"));//5
        String name = request.getParameter("bookName");
        String author = request.getParameter("bookAuthor");
        double price = Double.parseDouble(request.getParameter("bookPrice"));

        System.out.println("图书编号:"+id);
        System.out.println("图书名称:"+name);
        System.out.println("图书作者:"+author);
        System.out.println("图书价格:"+price);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 如果页面采用form表单post方式提交数据，数据是通过 请求正文 传递的
        // 1.我们可以通过请求正文获取数据
        //ServletInputStream inputStream = request.getInputStream();
        //BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        //String s = reader.readLine();
        //System.out.println("请求正文数据："+s);

        //在servlet中接收数据之间，通过request对象设置http请求数据的编码方式
        request.setCharacterEncoding("utf-8");

        // 2.form表单post方式提交的数据，也可以通过request对象的getParameter方法接收，之前是不能打开request输入流
        int id = Integer.parseInt(request.getParameter("bookId"));//5
        String name = request.getParameter("bookName");
        String author = request.getParameter("bookAuthor");
        double price = Double.parseDouble(request.getParameter("bookPrice"));

        System.out.println("图书编号:"+id);
        System.out.println("图书名称:"+name);
        System.out.println("图书作者:"+author);
        System.out.println("图书价格:"+price);

    }


}
