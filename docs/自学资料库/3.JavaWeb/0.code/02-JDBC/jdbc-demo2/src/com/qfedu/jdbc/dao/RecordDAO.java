package com.qfedu.jdbc.dao;

import com.qfedu.jdbc.utils.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @Descript 完成对借书记录表的JDBC操作
 * @Author 千锋涛哥
 * 公众号： Java架构栈
 */
public class RecordDAO {

    /**
     *  添加借书记录
     * @param snum 借书的学生的学号
     * @param bid 借书的图书编号
     * @param num 借书的数量
     * @return 添加借书记录成功返回true，失败返回false
     */
    public boolean insertRecord(String snum,int bid,int num){
        boolean flag = false;
        Connection connection = null;
        PreparedStatement preparedStatement1 = null;
        try{
            //1.向`records`表添加借书记录
            connection = DBHelper.getConnectin();
            System.out.println("添加借书记录--------"+connection);
            String sql1 = "insert into records(snum,bid,borrow_num,is_return,borrow_date) values(?,?,?,0,sysdate())";
            preparedStatement1 = connection.prepareStatement(sql1);
            preparedStatement1.setString(1,snum);
            preparedStatement1.setInt(2,bid);
            preparedStatement1.setInt(3,num);
            int i = preparedStatement1.executeUpdate();
            flag = i>0;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBHelper.closeStatement(preparedStatement1);
        }
        return flag;
    }

}
