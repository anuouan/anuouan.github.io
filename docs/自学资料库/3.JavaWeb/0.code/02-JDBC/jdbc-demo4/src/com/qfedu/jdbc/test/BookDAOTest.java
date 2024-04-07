package com.qfedu.jdbc.test;

import com.qfedu.jdbc.dao.BookDAO;
import com.qfedu.jdbc.dto.Book;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
/**
 * @Descript
 * @Author 千锋涛哥
 * 公众号： Java架构栈
 */
public class BookDAOTest {

    private BookDAO bookDAO = new BookDAO();

    @Test
    public void testInsertBook(){
        Book book = new Book(0, "C语言程序设计", "谭浩强", 66.80, 12, "鼻祖级教程");
        int i = bookDAO.insertBook(book);
        assertEquals(1,i);
    }

    @Test
    public void testDeleteBook(){
        int i = bookDAO.deleteBook(1018);
        assertEquals(1,i);
    }

    @Test
    public void testUpdateBook(){
        Book book = new Book(2, "Java王者归来", "张某人", 99.99, 99, "学完你就是大佬");
        int i = bookDAO.updateBook(book);
        assertEquals(1,i);
    }

    @Test
    public void testQueryBook(){
        Book book = bookDAO.queryBook(1);
        System.out.println(book);
    }

    @Test
    public void testListBooks(){
        List<Book> list = bookDAO.listBooks();
        for (Book book: list){
            System.out.println(book);
        }
    }

    @Test
    public void testGetCount(){
        long count = bookDAO.getCount();
        System.out.println(count);
    }
}
