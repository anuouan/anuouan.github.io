package com.qfedu.jdbc.dao;

import com.qfedu.jdbc.dto.Book;
import com.qfedu.jdbc.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @Descript 完成图书信息数据库操作
 * @Author 千锋涛哥
 * 公众号： Java架构栈
 */
public class BookDAO {

    public int insertBook(Book book){
        int i= 0;
        try {
            //1.编写SQL
            String sql = "insert into books(book_name,book_author,book_price,book_stock,book_desc) values(?,?,?,?,?)";
            //2.准备参数
            Object[] params = {book.getBookName(),book.getBookAuthor(),book.getBookPrice(),book.getBookStock(),book.getBookDesc()};
            //3.调用commons-dbutils中的QueryRunner执行SQL
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            i = queryRunner.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    public int deleteBook(int bookId){
        int i = 0;
        try {
            String sql = "delete from books where book_id=?";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            i = queryRunner.update(sql,bookId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    public int updateBook(Book book){
        int i=0;
        try {
            String sql = "update books set book_name=?,book_author=?,book_price=?,book_stock=?,book_desc=? where book_id=?";
            Object[] params = {book.getBookName(),book.getBookAuthor(),book.getBookPrice(),book.getBookStock(),book.getBookDesc(),book.getBookId()};
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            i = queryRunner.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    public Book queryBook(int bookId){
        Book book = null;
        try {
            String sql = "select book_id bookId,book_name bookName,book_author bookAuthor,book_price bookPrice,book_stock bookStock,book_desc bookDesc from books where book_id=?";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            //1.对于查询操作，我们需要通过QueryRunner对象调用query方法来执行
            //2.所有的query方法都需要一个ResultSetHandler的参数，通过此参数指定query方法的返回类型
            //  如果SQL指令执行之后返回的是一行记录，我们通过BeanHandler指定查询结果封装的实体类类型
            //  要求：查询结果集的字段名必须与指定的实体类的属性名匹配
            //     方案1：创建实体类的时候，实体类中属性的名字与数据表中的列名相同
            //     方案2：查询语句字段取别名，让字段别名与实体类属性名一致
            book = queryRunner.query(sql, new BeanHandler<Book>(Book.class), bookId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    public Book queryBook2(int bookId){
        Book book = null;
        try {
            String sql = "select book_id,book_name,book_author,book_price,book_stock,book_desc from books where book_id=?";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            //1.对于查询操作，我们需要通过QueryRunner对象调用query方法来执行
            //2.所有的query方法都需要一个ResultSetHandler的参数，通过此参数指定query方法的返回类型
            //  如果SQL指令执行之后返回的是一行记录，我们通过BeanHandler指定查询结果封装的实体类类型
            //  要求：查询结果集的字段名必须与指定的实体类的属性名匹配
            //     方案3：自定义ResultSetHandler结果处理
            ResultSetHandler<Book> resultSetHandler = new ResultSetHandler<Book>() {
                @Override
                public Book handle(ResultSet resultSet) throws SQLException {
                    Book book = null;
                    if(resultSet.next()) {
                        int id = resultSet.getInt("book_id");
                        String bookName = resultSet.getString("book_name");
                        String bookAuthor = resultSet.getString("book_author");
                        double bookPrice = resultSet.getDouble("book_price");
                        int bookStock = resultSet.getInt("book_stock");
                        String bookDesc = resultSet.getString("book_desc");
                        book = new Book(id,bookName,bookAuthor,bookPrice,bookStock,bookDesc);
                    }
                    return book;
                }
            };
            book = queryRunner.query(sql, resultSetHandler, bookId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    public List<Book> listBooks(){
        List<Book> bookList = null;
        try {
            String sql = "select  book_id bookId,book_name bookName,book_author bookAuthor,book_price bookPrice,book_stock bookStock,book_desc bookDesc  from books";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            //如果SQL指令执行之后返回的是多行记录，我们通过BeanListHandler指定查询结果封装的实体类的集合类型
            bookList = queryRunner.query(sql, new BeanListHandler<Book>(Book.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }

    public long getCount(){
        long count = 0;
        String sql = "select count(1) from books";
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        // 如果SQL指令执行之后返回的是一个值时，我们通过ScalarHandler指定返回类型
        // QueryRunner在处理统计操作时，是以long类型进行操作的，因此不能直接转成Integer
        // 如果我们确定这个值在int范围内，我们可以在得到long类型之后进行强转，建议使用long处理
        ScalarHandler<Long> scalarHandler = new ScalarHandler<Long>();
        try {
            count = queryRunner.query(sql, scalarHandler);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}
