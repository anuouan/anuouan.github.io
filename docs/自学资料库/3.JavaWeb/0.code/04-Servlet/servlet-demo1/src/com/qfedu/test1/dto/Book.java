package com.qfedu.test1.dto;

/**
 * @Description 图书实体类
 * @Author 千锋涛哥
 * 公众号： Java架构栈
 */
public class Book {
    private String bookId;
    private String bookName;
    private String bookAuthor;
    private double bookPrice;
    private String bookImgPath;

    public Book() {
    }

    public Book(String bookId, String bookName, String bookAuthor, double bookPrice, String bookImgPath) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookPrice = bookPrice;
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

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookImgPath() {
        return bookImgPath;
    }

    public void setBookImgPath(String bookImgPath) {
        this.bookImgPath = bookImgPath;
    }
}
