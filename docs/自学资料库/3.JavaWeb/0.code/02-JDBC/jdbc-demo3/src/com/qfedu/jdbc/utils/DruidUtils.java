package com.qfedu.jdbc.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Descript Druid数据库连接池工具类
 * @Author 千锋涛哥
 * 公众号： Java架构栈
 */
public class DruidUtils {

    //1.定义DruidDataSource对象：表示Druid数据库连接池（数据源）
    private static DruidDataSource druidDataSource;

    //2.静态代码块初始化定义DruidDataSource对象
    static{
        try {
            //读取druid.properties文件中配置的属性
            InputStream is = DruidUtils.class.getResourceAsStream("druid.properties");
            Properties properties = new Properties();
            properties.load(is);
            //使用属性文件初始化DruidDataSource对象
            druidDataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //3.创建静态方法，从连接池对象中获取连接
    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection =  druidDataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
