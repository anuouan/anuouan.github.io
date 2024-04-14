package com.qfedu.jdbc.test;

import com.qfedu.jdbc.service.BookService;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Descript 测试BookService借书
 * @Author 千锋涛哥
 * 公众号： Java架构栈
 */
public class BookServiceTest {

    private BookService bookService = new BookService();

    @Test
    public void testBorrowBook(){
        boolean b = bookService.borrowBook("1002", 1, 2);
        assertTrue(b);
    }


}