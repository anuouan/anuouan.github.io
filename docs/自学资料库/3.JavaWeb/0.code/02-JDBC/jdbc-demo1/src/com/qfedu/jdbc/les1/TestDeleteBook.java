package com.qfedu.jdbc.les1;

import com.mysql.cj.jdbc.Driver;
import com.qfedu.jdbc.dao.BookDAO;
import com.qfedu.jdbc.utils.DBHelper;

import java.sql.*;
import java.util.Scanner;

/**
 * @Author Java涛哥  @ 千锋教育
 * @千锋Java微信公众号 Java架构栈
 */
public class TestDeleteBook {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你要删除的图书的ID：");
        String s = scanner.nextLine();
        int bid = Integer.parseInt(s);

        //调用deleteBook方法完成图书的删除
        boolean b = new BookDAO().deleteBook(bid);
        System.out.println(b?"delete book success":"delete book fail");
    }


}
