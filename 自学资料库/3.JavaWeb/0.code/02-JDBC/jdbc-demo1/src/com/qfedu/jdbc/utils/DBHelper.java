package com.qfedu.jdbc.utils;

import java.sql.*;

/**
 * @Descript  JDBC数据库连接帮助类
 * @Author 千锋涛哥
 * 公众号： Java架构栈
 */
public class DBHelper {

    /*将创建数据库连接所需的字符串定义为常量，集中管理*/
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/db_test3?characterEncoding=utf8";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "@QFedu123";

    /**
     * 注册驱动只需执行一次，因此我们放在帮助类的静态初始化块中完成
     */
    static{
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("-----------注册驱动失败");
        }
    }

    /**
     * 创建数据库连接对象
     */
    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("-----------创建连接失败");
        }
        return connection;
    }

    /**
     * 关闭连接
     * 多态的应用：使用Statement接口做参数，既可以传递Statement接口对象，也可以传递PreparedStatement接口对象
     */
    public static void close(Statement statement, Connection connection){
        close(null,statement,connection);
    }

    /**
     * 关闭连接
     */
    public static void close(ResultSet resultSet,Statement statement, Connection connection){
        try {
            if(resultSet!=null && !resultSet.isClosed()){
                resultSet.close();
            }
            if(statement!=null && !statement.isClosed()){
                statement.close();
            }
            if(connection!=null && !connection.isClosed()){
                connection.close();
            }
        }catch (Exception e){
            System.out.println("~~~~~关闭数据库连接失败");
        }
    }

}
