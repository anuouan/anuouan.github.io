package com.qfedu.jdbc.dao;

import com.qfedu.jdbc.dto.Book;
import com.qfedu.jdbc.dto.Student;

import java.util.List;

/**
 * @Descript
 * @Author 千锋涛哥
 * 公众号： Java架构栈
 */
public class Test {

    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();

        //测试添加
        //Student student = new Student("1009", "Lucy", "女", 18);
        //boolean b = studentDAO.insertStudent(student);
        //System.out.println(b);

        //测试修改
        //Student student = new Student("1009", "Lily", "女", 19);
        //boolean b = studentDAO.updateStudent(student);
        //System.out.println(b);

        //测试删除
        //boolean b = studentDAO.deleteStudent("1009");
        //System.out.println(b);

        //测试查询
        //Student student = studentDAO.queryStudent("1008");
        //System.out.println(student);

        //List<Student> list = studentDAO.listStudents();
        //System.out.println(list);

        Book book = new Book(0, "大学语文", "王五", 28.80, 6, "清华大学出版社");
        //boolean b = new BookDAO().insertBook(book);
        //System.out.println(b);

        Book book1 = new BookDAO().queryBook(1018);
        System.out.println(book1);
    }
}
