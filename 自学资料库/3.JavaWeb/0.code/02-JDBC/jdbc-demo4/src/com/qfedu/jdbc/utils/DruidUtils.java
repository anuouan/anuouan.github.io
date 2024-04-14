package com.qfedu.jdbc.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Descript
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
