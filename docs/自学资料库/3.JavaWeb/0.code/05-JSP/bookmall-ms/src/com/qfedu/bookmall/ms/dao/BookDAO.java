package com.qfedu.bookmall.ms.dao;

import com.qfedu.bookmall.ms.dto.Book;
import com.qfedu.bookmall.ms.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @Description 完成图书信息的数据库操作
 * @Author 千锋涛哥
 * 公众号： Java架构栈
 */
public class BookDAO {

    /**
     * 添加图书信息
     * @param book
     * @return
     */
    public int insertBook(Book book){
        int i = 0;
        try {
            String sql = "insert into books(book_id,book_name,book_author,book_price,book_img_path,book_desc,book_stcok,book_type) values(?,?,?,?,?,?,?,?)";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            //给SQL中的参数赋值
            Object[] params = {book.getBookId(),book.getBookName(),book.getBookAuthor(),book.getBookPrice(),book.getBookImgPath(),book.getBookDesc(),book.getBookStock(),book.getBookType()};
            i = queryRunner.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    /**
     * 分页查询图书信息
     * @param start 查询数据的起始行索引
     * @param limit 最多返回的数据记录数（每页显示的条数）
     * @return 返回的集合中只包含一页的数据
     */
    public List<Book> selectBooks(int start,int limit){
        List<Book> bookList = null;
        try {
            String sql = "select book_id bookId,book_name bookName,book_author bookAuthor,book_price bookPrice,book_img_path bookImgPath,book_desc bookDesc,book_stcok bookStock,book_type bookType" +
                    " from books limit ?,?";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            bookList = queryRunner.query(sql, new BeanListHandler<Book>(Book.class),start,limit);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }

    /**
     * 查询图书的总记录数
     * @return
     */
    public long selectBookCount(){
        long count = 0;
        try {
            String sql = "select count(1) from books";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            count = queryRunner.query(sql,new ScalarHandler<Long>());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
     * 根据图书ID删除一个图书信息
     * @param bookId
     * @return
     */
    public int deleteBook(String bookId){
        int i = 0;
        try {
            String sql = "delete from books where book_id=?";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            i = queryRunner.update(sql, bookId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    /**
     * 根据图书ID查询一个图书信息
     */
    public Book selectBookByBookId(String bookId){
        Book book = null;
        try {
            String sql = "select book_id bookId,book_name bookName,book_author bookAuthor,book_price bookPrice,book_img_path bookImgPath,book_desc bookDesc,book_stcok bookStock,book_type bookType from books where book_id=?";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            book = queryRunner.query(sql, new BeanHandler<Book>(Book.class),bookId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    /**
     * 根据图书ID修改一个图书信息
     * @param book
     * @return
     */
    public int updateBook(Book book){
        int i = 0;
        try {
            String sql = "update books set book_name=?,book_author=?,book_price=?,book_img_path=?,book_desc=?,book_stcok=?,book_type=? where book_id=?";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            Object[] params = {book.getBookName(),book.getBookAuthor(),book.getBookPrice(),book.getBookImgPath(),book.getBookDesc(),book.getBookStock(),book.getBookType(),book.getBookId()};
            i = queryRunner.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
}
