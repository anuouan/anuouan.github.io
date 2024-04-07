package com.qfedu.jdbc.les1;

import com.qfedu.jdbc.dao.BookDAO;
import com.qfedu.jdbc.dto.Book;
import com.qfedu.jdbc.utils.DBHelper;

import java.sql.*;

/**
 * @Author Java涛哥  @ 千锋教育
 * @千锋Java微信公众号 Java架构栈
 */
public class TestInsertBook {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String name = "MySQL";
        String author = "张三";
        double price = 66.88;
        int stock = 4;
        String desc = "MySQL神书";

        //调用insertBook方法完成图书的保存
        Book book = new Book(0,name, author, price, stock, desc);
        boolean b = new BookDAO().insertBook(book);
        System.out.println(b?"add book success":"add book fail");
    }


}
