package com.qfedu.jdbc.les1;

import com.qfedu.jdbc.dao.BookDAO;
import com.qfedu.jdbc.dto.Book;
import com.qfedu.jdbc.utils.DBHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author Java涛哥  @ 千锋教育
 * @千锋Java微信公众号 Java架构栈
 */
public class TestSelectBooks {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        List<Book> list = new BookDAO().listBooks();
        for(Book b:list){
            System.out.println(b.getBookName()+"\t"+b.getBookAuthor());
        }
    }


}
