package com.qfedu.sgms.servlets;

import com.qfedu.sgms.dao.GradeDAO;
import com.qfedu.sgms.dto.Grade;
import com.qfedu.sgms.dto.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Description 根据客户端传递的学号、课程号查询成绩
 * @Author 千锋涛哥
 * 公众号： Java架构栈
 */
@WebServlet("/GradeQueryServlet")
public class GradeQueryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //如果允许客户端get和post方式提交，我们可以在doGet中调用doPost,业务代码写在doPost
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //1.接收客户端输入的学号、课程ID
        String snum = request.getParameter("stuNum");
        String cid = request.getParameter("courseId");

        //2.调用GradeDAO中的方法根据学号、课程号查询成绩
        GradeDAO gradeDAO = new GradeDAO();
        Grade grade = gradeDAO.queryGradeBySnumAndCid(snum, cid);

        //3.查询到成绩之后，将成绩传递到GradePageServlet
        //   由GradePageServlet响应给浏览器一个页面，并把成绩显示出来
        request.setAttribute("grade", grade);
        request.getRequestDispatcher("GradePageServlet").forward(request, response);
    }

}
