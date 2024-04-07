package com.qfedu.jdbc.dao;

import com.qfedu.jdbc.utils.DBHelper;

import java.sql.*;

/**
 * @Descript
 * @Author 千锋涛哥
 * 公众号： Java架构栈
 */
public class BookDAO {

    /**
     * 修改库存
     * @param bid 要修改库存的图书编号
     * @param num  book_stock=book_stock-num
     * @return
     */
    public boolean updateStock(int bid,int num){
        boolean flag = false;
        Connection connection = null;
        PreparedStatement preparedStatement2 = null;
        try{
            //2.修改`books`表中的库存
            connection = DBHelper.getConnectin();
            System.out.println("修改图书库存--------"+connection);
            String sql2 = "update books set book_stock=book_stock-? where book_id=?";
            preparedStatement2 = connection.prepareStatement(sql2);
            preparedStatement2.setInt(1,num);
            preparedStatement2.setInt(2,bid);
            int j = preparedStatement2.executeUpdate();
            flag = j>0;
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBHelper.closeStatement(preparedStatement2);
        }
        return flag;
    }

}
