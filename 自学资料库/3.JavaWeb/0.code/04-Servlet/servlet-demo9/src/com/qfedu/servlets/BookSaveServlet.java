package com.qfedu.servlets;

import com.qfedu.dto.Book;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Collection;
import java.util.UUID;

/**
 * @Description 接收图书信息并保存
 * @Author 千锋涛哥
 * 公众号： Java架构栈
 */
@WebServlet("/BookSaveServlet")
@MultipartConfig
public class BookSaveServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //1.设置utf-8编码
        request.setCharacterEncoding("utf-8");

        //2.接收普通文本
        //当网页提交数据的表单设置了 enctype="multipart/form-data"之后不能直接使用getParameter接收文本数据
        //需要在当前serlvet类添加 @MultipartConfig 用于处理非压缩提交的数据
        String id = request.getParameter("bookId");
        String name = request.getParameter("bookName");

        //3. 接收表单提交的图片
        // getPart("输入框name属性"): 接收表单中的文件
        Part bookImg = request.getPart("bookImg");
        //  getParts(): 接收表单中所有文件
        //Collection<Part> parts = request.getParts();

        //4.保存图片
        // a.获取files目录在web服务器上的路径（不是工作空间的路径）
        ServletContext servletContext = getServletContext();
        String dir = servletContext.getRealPath("/files");

        // b.给上传的文件重命名 （不同用户有可能上传相同名称的图片，如果不重命名将导致文件覆盖）
        //   文件重命名后缀名不能改变
        String header = bookImg.getHeader("Content-Disposition");  //form-data; name="bookImg"; filename="千锋武汉（横版）.jpg"
        //   截取上传的文件的后缀名
        int begin = header.lastIndexOf(".");
        int end = header.lastIndexOf("\"");
        String ext = header.substring(begin, end);
        // 取名（时间毫秒数、UUID、雪花算法）
        String fileName  = UUID.randomUUID().toString()+ext;

        //c.存储文件到目录
        bookImg.write(dir+"\\"+fileName);

        //5.将图书信息保存到数据库: 保存到数据库的是图片的访问路径（不是绝对路径）
        Book book = new Book(id, name, "files/" + fileName);
        //调用BookDAO 将book对象保存到数据库
    }
}
