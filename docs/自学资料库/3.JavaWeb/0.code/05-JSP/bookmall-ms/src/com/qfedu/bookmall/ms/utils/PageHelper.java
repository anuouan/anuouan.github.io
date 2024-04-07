package com.qfedu.bookmall.ms.utils;

import java.util.List;

/**
 * @Description 分页帮助类
 * @Author 千锋涛哥
 * 公众号： Java架构栈
 */
public class PageHelper<T> {

    //存放页面数据的List集合
    public List<T> list;

    //存放当前页码
    public int pageNum;

    //存放总页数
    public int pageCount;

    public PageHelper() {
    }

    public PageHelper(List<T> list, int pageNum, int pageCount) {
        this.list = list;
        this.pageNum = pageNum;
        this.pageCount = pageCount;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
}
