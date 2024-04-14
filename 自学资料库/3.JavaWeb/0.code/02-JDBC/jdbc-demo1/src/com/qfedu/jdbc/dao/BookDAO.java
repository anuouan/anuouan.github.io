package com.qfedu.jdbc.dao;

import com.qfedu.jdbc.dto.Book;
import com.qfedu.jdbc.utils.DBHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Descript DAO Data Access Object 数据访问对象
 * @Author 千锋涛哥
 * 公众号： Java架构栈
 */
public class BookDAO {

    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet rs;

    public boolean deleteBook(int bid) {
        boolean flag = false;
        try{
            connection = DBHelper.getConnection();
            String sql = "delete from books where book_id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,bid);
            int i = preparedStatement.executeUpdate();
            flag = i>0;
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            DBHelper.close(preparedStatement,connection);
        }
        return flag;
    }

    public boolean insertBook(Book book) {
        boolean flag = false;
        try{
            //调用工具类，获取数据库连接对象
            connection = DBHelper.getConnection();
            String sql = "insert into books(book_name,book_author,book_price,book_stock,book_desc) values(?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,book.getBookName());
            preparedStatement.setString(2,book.getBookAuthor());
            preparedStatement.setDouble(3,book.getBookPrice());
            preparedStatement.setInt(4,book.getBookStock());
            preparedStatement.setString(5,book.getBookDesc());
            int i = preparedStatement.executeUpdate();  // 如果i>0，表示DML操作是成功的；如果i=0表示DML操作对数据表中的数据没有影响
            flag = i>0;
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBHelper.close(preparedStatement,connection);
        }
        return flag;
    }

    public Book queryBook(int bid) {
        Book book = null;
        try {
            connection = DBHelper.getConnection();
            String sql = "select book_id,book_name,book_author,book_price,book_stock,book_desc from books where book_id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, bid);
            //通过executeQuery方法执行查询语句，并且将查询的结果存放到一个ResultSet对象中（结果集）
            rs = preparedStatement.executeQuery();
            //处理结果：从rs中获取查询结果
            if (rs.next()) {
                int id = rs.getInt("book_id");
                String name = rs.getString("book_name");
                String author = rs.getString("book_author");
                double price = rs.getDouble("book_price");
                int stock = rs.getInt("book_stock");
                String desc = rs.getString("book_desc");
                //我们需要将查询到的一条数据库图书记录的6个值返回
                book = new Book(id, name, author, price, stock, desc);
            }
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            DBHelper.close(rs, preparedStatement, connection);
        }
        return book;
    }

    public List<Book> listBooks(){
        List<Book> bookList = new ArrayList<>();
        try {
            connection = DBHelper.getConnection();
            String sql = "select book_id,book_name,book_author,book_price,book_stock,book_desc from books";
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                int bookId = rs.getInt("book_id");
                String bookName = rs.getString("book_name");
                String bookAuthor = rs.getString("book_author");
                double bookPrice = rs.getDouble("book_price");
                int bookStock = rs.getInt("book_stock");
                String bookDesc = rs.getString("book_desc");
                Book book = new Book(bookId, bookName, bookAuthor, bookPrice, bookStock, bookDesc);
                bookList.add(book);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBHelper.close(rs, statement, connection);
        }
        return bookList;
    }

    public boolean updateBook(Book book)  {
        boolean flag = false;
        try {
            connection = DBHelper.getConnection();
            String sql = "update books set book_name=?,book_author=?,book_price=?,book_stock=?,book_desc=? where book_id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, book.getBookName());
            preparedStatement.setString(2, book.getBookAuthor());
            preparedStatement.setDouble(3, book.getBookPrice());
            preparedStatement.setInt(4, book.getBookStock());
            preparedStatement.setString(5, book.getBookDesc());
            preparedStatement.setInt(6, book.getBookId());
            int i = preparedStatement.executeUpdate();
            flag = i > 0;
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            DBHelper.close(preparedStatement, connection);
        }
        return flag;
    }

}
