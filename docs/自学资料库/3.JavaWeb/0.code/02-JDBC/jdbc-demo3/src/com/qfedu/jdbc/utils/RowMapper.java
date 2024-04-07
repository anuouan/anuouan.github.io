package com.qfedu.jdbc.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Descript 用于定义结果集映射的接口
 * @Author 千锋涛哥
 * 公众号： Java架构栈
 */
public interface RowMapper<T> {

    public T getRow(ResultSet resultSet) throws SQLException;

}
