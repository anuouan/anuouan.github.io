package com.qfedu.jdbc.utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Descript
 * @Author 千锋涛哥
 * 公众号： Java架构栈
 */
public class DBHelper {
    //1.定义数据库连接信息
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/db_test3?characterEncoding=utf8";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "@QFedu123";

    //1️⃣定义ThreadLocal容器
    private static final ThreadLocal<Connection> local = new ThreadLocal<>();

    //2.静态初始化块注册驱动
    static{
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //3.创建数据库连接
    public static Connection getConnectin(){
        // 2️⃣从ThreadLocal容器中获取连接
        Connection connection = local.get();
        try {
            if(connection == null){
                //3️⃣如果容器中没有连接，则创建连接，并将创建的连接存放到容器
                connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
                local.set(connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    //4. 4️⃣关闭连接
    // 如果使用ThreadLocal存储数据库连接，关闭连接时同时要将Connection对象从ThreadLocal中移除
    public static void closeConnection(){
        // 获取到当前线程使用的数据库连接对象
        Connection connection = local.get();
        try {
            if(connection !=null && !connection.isClosed()){
                connection.close();
            }
            // 将关闭后的连接对象从ThreadLocal中移除
            local.remove();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeStatement(Statement statement){
        closeStatement(null,statement);
    }

    public static void closeStatement(ResultSet resultSet, Statement statement){
        try {
            if(resultSet!=null && !resultSet.isClosed()){
                resultSet.close();
            }
            if(statement!=null && !statement.isClosed()){
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
