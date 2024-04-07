package com.qfedu.sgms.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.*;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @Description 数据库连接池工具类
 * @Author 千锋涛哥
 * 公众号： Java架构栈
 */
public class DruidUtils {

    private static DruidDataSource druidDataSource;

    static{
        try {
            InputStream is = DruidUtils.class.getResourceAsStream("druid.properties");
            Properties properties = new Properties();
            properties.load(is);
            druidDataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接池数据源对象
     * @return
     */
    public static DataSource getDataSource(){
        return druidDataSource;
    }

    /**
     * 从数据库连接池中获取数据库连接对象
     * @return
     */
    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = druidDataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
