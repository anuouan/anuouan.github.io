package com.qfedu.dto;

/**
 * @Description 图书信息实体类
 * @Author 千锋涛哥
 * 公众号： Java架构栈
 */
public class Book {

    private String bookId;
    private String bookName;
    private String bookImgPath;

    public Book() {
    }

    public Book(String bookId, String bookName, String bookImgPath) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookImgPath = bookImgPath;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookImgPath() {
        return bookImgPath;
    }

    public void setBookImgPath(String bookImgPath) {
        this.bookImgPath = bookImgPath;
    }
}
