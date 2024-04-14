package com.qfedu.jdbc.dao;

import com.qfedu.jdbc.dto.Student;
import com.qfedu.jdbc.utils.CommonDAO;
import com.qfedu.jdbc.utils.DruidUtils;
import com.qfedu.jdbc.utils.RowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Descript students表的数据访问类
 * @Author 千锋涛哥
 * 公众号： Java架构栈
 */
public class StudentDAO {

    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    //1、添加学生信息
    public boolean insertStudent(Student student){
        String sql = "insert into students(stu_num,stu_name,stu_gender,stu_age) values(?,?,?,?)";
        boolean b = new CommonDAO().update(sql, student.getStuNum(), student.getStuName(), student.getStuGender(), student.getStuAge());
        return b;
    }

    public boolean deleteStudent(String stuNum){
        String sql = "delete from students where stu_num=?";
        boolean b = new CommonDAO().update(sql, stuNum);
        return b;
    }

    public boolean updateStudent(Student student){
        String sql = "update students set stu_name=?,stu_gender=?,stu_age=? where stu_num=?";
        boolean b = new CommonDAO().update(sql, student.getStuName(), student.getStuGender(), student.getStuAge(), student.getStuNum());
        return b;
    }

    //2、根据学号查询一个学生记录
    public Student queryStudent(String snum){
        String sql = "select stu_num,stu_name,stu_gender,stu_age from students where stu_num=?";
        //自定义结果集处理
        RowMapper<Student> rowMapper = new RowMapper<Student>(){
            public Student getRow(ResultSet resultSet) throws SQLException {
                String stuNum = resultSet.getString("stu_num");
                String stuName = resultSet.getString("stu_name");
                String stuGender = resultSet.getString("stu_gender");
                int stuAge = resultSet.getInt("stu_age");
                Student stu = new Student(stuNum,stuName,stuGender,stuAge);
                return stu;
            }
        };
        //调用通用方法查询
        List<Student> list =  new CommonDAO<Student>().select(sql, rowMapper,snum);
        Student student = list.get(0);
        return student;
    }

    //3、查询多个学生信息
    public List<Student> listStudents(){
        String sql = "select stu_num,stu_name,stu_gender,stu_age from students";
        //自定义结果集处理
        RowMapper<Student> rowMapper = new RowMapper<Student>(){
            public Student getRow(ResultSet resultSet) throws SQLException {
                String stuNum = resultSet.getString("stu_num");
                String stuName = resultSet.getString("stu_name");
                String stuGender = resultSet.getString("stu_gender");
                int stuAge = resultSet.getInt("stu_age");
                Student stu = new Student(stuNum,stuName,stuGender,stuAge);
                return stu;
            }
        };
        List<Student> list = new CommonDAO<Student>().select(sql, rowMapper);
        return list;
    }

}
