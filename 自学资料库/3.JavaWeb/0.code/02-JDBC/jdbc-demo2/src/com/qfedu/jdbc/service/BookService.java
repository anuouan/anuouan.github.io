package com.qfedu.jdbc.service;

import com.qfedu.jdbc.dao.BookDAO;
import com.qfedu.jdbc.dao.RecordDAO;
import com.qfedu.jdbc.utils.DBHelper;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Descript 图书管理的业务类
 * @Author 千锋涛哥
 * 公众号： Java架构栈
 */
public class BookService {

    private RecordDAO recordDAO = new RecordDAO();
    private BookDAO bookDAO = new BookDAO();

    /**
     * 借书业务，包含两个步骤，这两个步骤要么同时成功，要么同时失败——事务
     */
    public boolean borrowBook(String stuNum,int bookId,int num){
        boolean r = false;
        Connection connection = DBHelper.getConnectin();
        System.out.println("service-------"+connection);
        try {
            connection.setAutoCommit(false);
            //1.添加借书记录
            boolean b1 = recordDAO.insertRecord(stuNum, bookId, num);
            int m = 10/0;  //制造异常
            //2.修改图书库存
            boolean b2 = bookDAO.updateStock(bookId, num);
            // 结果处理
            r = b1 && b2;
            connection.commit();
        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            DBHelper.closeConnection();
        }
        return r;
    }

}
