package com.qfedu.jdbc.test;

import com.qfedu.jdbc.dao.StudentDAO;
import com.qfedu.jdbc.dto.Student;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Descript 此类是StudentDAO的单元测试类
 * @Author 千锋涛哥
 * 公众号： Java架构栈
 */
public class StudentDAOTest {

    //1.在测试类中定义成员变量：创建被测试类的对象
    private StudentDAO studentDAO = new StudentDAO();

    //2创建测试方法 ： 用来测试StudentDAO类中的insertStudent方法
    //a.测试方法名=test+被测试方法名
    //b.测试方法无参数无返回值
    @Test
    public void testInsertStudent(){
        //准备被测试方法所需的参数
        Student stu = new Student("1008","Tom","男",20);
        //调用被测试方法，获取结果
        boolean b = studentDAO.insertStudent(stu);
        //断言返回结果(成立 | 不成立)
        assertTrue(b);
    }

    @Test
    public void testQueryStudent(){
        String snum = "1008";
        Student student = studentDAO.queryStudent(snum);
        assertEquals("Tom2",student.getStuName());
    }

    @Test
    public void testListStudents(){
        List<Student> studentList = studentDAO.listStudents();
        assertEquals(8,studentList.size());
    }
}