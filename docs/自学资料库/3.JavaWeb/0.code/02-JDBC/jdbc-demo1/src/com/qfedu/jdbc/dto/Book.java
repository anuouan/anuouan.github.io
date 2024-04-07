package com.qfedu.jdbc.dto;

import java.io.Serializable;

/**
 * @Descript 存放图书信息的类
 * @Author 千锋涛哥
 * 公众号： Java架构栈
 *
 * 1.类中属性的个数和类型，与对应的数据表保持一致
 * 2.提供所有属性的get和set方法：Alt+Insert --- Getter And Setter --- 选择所有属性 --- OK
 * 3.提供全参构造器：Alt+Insert --- Constructor --- 选择所有属性 --- OK
 * 4.提供无参构造器：Alt+Insert --- Constructor --- SelectNone
 * 5.重写toString方法：Alt+Insert --- toString --- OK
 * 6.[暂略] 重写hashcode和equals
 * 7.[暂略]实现序列化Serializable接口
 */
public class Book implements Serializable {

    private int bookId;
    private String bookName;
    private String bookAuthor;
    private double bookPrice;
    private int bookStock;
    private String bookDesc;

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookPrice=" + bookPrice +
                ", bookStock=" + bookStock +
                ", bookDesc='" + bookDesc + '\'' +
                '}';
    }

    public Book() {
    }

    public Book(int bookId, String bookName, String bookAuthor, double bookPrice, int bookStock, String bookDesc) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookPrice = bookPrice;
        this.bookStock = bookStock;
        this.bookDesc = bookDesc;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
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

    public int getBookStock() {
        return bookStock;
    }

    public void setBookStock(int bookStock) {
        this.bookStock = bookStock;
    }

    public String getBookDesc() {
        return bookDesc;
    }

    public void setBookDesc(String bookDesc) {
        this.bookDesc = bookDesc;
    }
}
