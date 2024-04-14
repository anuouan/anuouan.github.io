package com.qfedu.bookmall.ms.service;

import com.qfedu.bookmall.ms.dao.BookDAO;
import com.qfedu.bookmall.ms.dto.Book;
import com.qfedu.bookmall.ms.utils.PageHelper;

import java.util.List;

/**
 * @Description 图书管理的业务实现
 * @Author 千锋涛哥
 * 公众号： Java架构栈
 */
public class BookService {

    private BookDAO bookDAO = new BookDAO();

    /**
     * 添加图书业务实现
     * @param book
     * @return
     */
    public boolean saveBook(Book book){
        int i = bookDAO.insertBook(book);
        return i>0?true:false;
    }

    /**
     * 删除图书业务实现
     * @param bookId
     * @return
     */
    public boolean deleteBook(String bookId){
        int i = bookDAO.deleteBook(bookId);
        return i>0?true:false;
    }

    /**
     * 根据ID查询一个图书的业务实现
     * @param bookId
     * @return
     */
    public Book getBook(String bookId){
        Book book = bookDAO.selectBookByBookId(bookId);
        return book;
    }


    /**
     * 修改图书业务实现
     * @param book
     * @return
     */
    public boolean modifyBook(Book book){
        int i = bookDAO.updateBook(book);
        return i>0?true:false;
    }

    /**
     * 分页查询图书信息
     * @param pageNum 页码
     * @param pageSize 每页显示的条数
     * @return
     */
    public PageHelper<Book> listBooksByPage( int pageNum,int pageSize){
        //1.查询当前页码的数据
        int start = (pageNum-1)*pageSize;
        int limit = pageSize;
        List<Book> bookList = bookDAO.selectBooks(start,limit);

        //2.查询并计算图书总页数
        //a.查询总记录
        long count = bookDAO.selectBookCount();
        //b.根据总记录数和每页显示的条数，计算总页数
        long pageCount = count%pageSize == 0 ? count/pageSize: count/pageSize+1;

        //3.将分页数据都放到一个PageHelper对象
        PageHelper<Book> bookPageHelper = new PageHelper<Book>(bookList, pageNum, (int)pageCount);

        return bookPageHelper;
    }


}
