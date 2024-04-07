package com.qfedu.servlets;

import com.google.gson.Gson;
import com.qfedu.dto.Student;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * @Description 测试JSON转换
 * @Author 千锋涛哥
 * 公众号： Java架构栈
 */
@WebServlet("/TestJsonServlet")
public class TestJsonServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //1.接收请求正文
        request.setCharacterEncoding("utf-8");
        ServletInputStream inputStream = request.getInputStream();
        StringBuilder builder = new StringBuilder();
        byte[] bs = new byte[1024];
        int len = -1;
        while((len = inputStream.read(bs))!=-1){
            String s = new String(bs,0,len,"utf-8");
            builder.append(s);
        }
        String str = builder.toString();
        System.out.println(str);
        //2.将接收的json字符串，转换成Java对象(Student)
        Gson gson = new Gson();
        Student student = gson.fromJson(str, Student.class);
        System.out.println(student);

        //3.java对象转换成JSON格式
        Student stu2 = new Student("10006","Lucy","女");
        String jsonStr = gson.toJson(stu2);
        //将json格式字符串响应给ajax请求
        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.println(jsonStr);
        out.flush();
        out.close();
    }
}
