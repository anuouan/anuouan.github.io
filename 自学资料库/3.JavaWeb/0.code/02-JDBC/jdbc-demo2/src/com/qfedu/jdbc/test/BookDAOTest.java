package com.qfedu.jdbc.test;

import com.qfedu.jdbc.dao.BookDAO;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Descript 用于测试借书业务
 * @Author 千锋涛哥
 * 公众号： Java架构栈
 */
public class BookDAOTest {

    private BookDAO bookDAO = new BookDAO();

    @Test
    public void testBorrowBook(){
        //boolean b = bookDAO.borrowBook("1002", 1, 3);
        //assertTrue(b);
    }

}
