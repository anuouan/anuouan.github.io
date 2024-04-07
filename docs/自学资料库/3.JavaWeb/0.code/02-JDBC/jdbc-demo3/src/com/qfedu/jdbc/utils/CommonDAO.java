package com.qfedu.jdbc.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @Descript 公共DAO，用于封装公共的JDBC操作
 * @Author 千锋涛哥
 * 公众号： Java架构栈
 */
public class CommonDAO<T> {

    /**
     * 公共DML操作
     * @param sql 执行的SQL指令
     * @return
     */
    /**
     * sql : delete from students where stu_num=?
     * args: snum
     *
     * sql : insert into students(stu_num,stu_name,stu_gender,stu_age) values(?,?,?,?)
     * args: 1009  Lucy  女   18
     */
    public boolean update(String sql, Object... args){
        boolean b = false;
        try{
            Connection connection = DruidUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length ; i++) {
                preparedStatement.setObject(i+1,args[i]);
            }
            int i = preparedStatement.executeUpdate();
            b = i>0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return b;
    }

    /**
     * 查询：
     * 查询一条结果
     * 查询多条结果
     *
     * sql: select * from books;   List<Book>
     * sql: select * from students;  List<Student>
     */
    public List<T> select(String sql, RowMapper<T> rowMapper,Object...args){
        List<T> list = new ArrayList<>();
        try{
            Connection connection = DruidUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i <args.length ; i++) {
                preparedStatement.setObject(i+1,args[i]);
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                // 从查询结果中取出一条记录（多个值），封装到一个实体类对象中
                //  getRow就是方法调用者在调用方法时，传递进来的用于映射查询结果的方法
               T t =  rowMapper.getRow(resultSet);
               list.add(t);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

}
