package com.qfedu.jdbc.les1;

import com.qfedu.jdbc.dao.BookDAO;
import com.qfedu.jdbc.dto.Book;
import com.qfedu.jdbc.utils.DBHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Java涛哥  @ 千锋教育
 * @千锋Java微信公众号 Java架构栈
 */
public class TestSelectBook {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //根据图书ID，查询一本图书信息
        Book book = new BookDAO().queryBook(1014);
        System.out.println(book.getBookId());
        System.out.println(book.getBookName());
    }


}
