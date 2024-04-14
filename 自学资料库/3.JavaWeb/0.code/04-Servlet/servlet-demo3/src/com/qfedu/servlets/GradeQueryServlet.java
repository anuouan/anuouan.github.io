package com.qfedu.servlets;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * @Description  查询成绩
 * @Author 千锋涛哥
 * 公众号： Java架构栈
 */
@WebServlet("/gradeQuery")
public class GradeQueryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("~~~~~~~~~~~~~~~doGet");
        //1.接收学号和课程编号
        String stuNum = request.getParameter("stuNum");
        String curseId = request.getParameter("curseId");

        //2.查询数据库
        int grade = 95;

        //3.通过response响应浏览器
        //【设置响应状态行】
        //setStatus : 设置状态行中的状态码
        response.setStatus(200);

        //【设置响应头】
        //setContentType: 设置响应头中的Content-Type属性，设置响应客户端的数据格式
        response.setContentType("text/html"); //等价于： response.setHeader("Content-Type","text/html");
        //setContentLength：设置响应客户端的数据长度（一般无需设置）
        //response.setContentLength(1024);      //等价于：
        //setHeader ： 设置其他的响应头属性
        response.setHeader("Connection","keep-alive");

        //【设置响应正文】
        //setCharacterEncoding：设置响应客户端的数据编码格式
        response.setCharacterEncoding("utf-8");
        // 通过response对象获取输出流出
        // 字节流（如果要响应文件数据给客户端，则需要使用字节流）
        //ServletOutputStream outputStream = response.getOutputStream();
        // 字符流（如果响应文本数据-HTML文档，则使用字符流）
        PrintWriter out = response.getWriter();
        //通过流写出的数据，就会以响应正文的形式传输给客户端浏览器，如果浏览器可以识别数据，则直接显示
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='utf-8'>");
        out.println("<title>学生成绩查询结果</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div style='padding:50px; font-size:50px; text-align:center; border:1px gray solid; margin:auto'>");
        out.println("<label>您的成绩为：</label>");
        out.println("<label style='color:red'>"+grade+"</label>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取请求正文
        // getInputStream ：获取客户端请求的输入流
        ServletInputStream inputStream = request.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        // 从输入流中读取请求正文
        String s = reader.readLine();
        System.out.println(s);
    }


}
