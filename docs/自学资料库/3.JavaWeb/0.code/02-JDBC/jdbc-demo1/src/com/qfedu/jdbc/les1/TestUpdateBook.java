package com.qfedu.jdbc.les1;

import com.qfedu.jdbc.dao.BookDAO;
import com.qfedu.jdbc.dto.Book;
import com.qfedu.jdbc.utils.DBHelper;

import java.sql.*;

/**
 * @Author Java涛哥  @ 千锋教育
 * @千锋Java微信公众号 Java架构栈
 */
public class TestUpdateBook {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 根据数据记录的主键 修改其他的字段
        // 根据图书ID，修改图书名称、作者、价格、库存、描述
        int id = 1017;
        String name = "MySQL经典教程";
        String author = "李四";
        double price = 88.80;
        int stock = 9;
        String desc = "值得一看的好书";

        //调用 updateBook完成修改
        Book book = new Book(id, name, author, price, stock, desc);
        boolean b = new BookDAO().updateBook(book);
        System.out.println(b?"update book success":"update book fail");
    }

}
