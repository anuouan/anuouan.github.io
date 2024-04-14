package com.qfedu.jdbc.test;

/**
 * @Descript
 * @Author 千锋涛哥
 * 公众号： Java架构栈
 */
public class TestJDBC {

    public static void main(String[] args) {
        //假如我想添加图书，需要调用TestInsertBook 类中的 insertBook方法
        //假如我想删除图书，需要调用TestDeleteBook 类中的 deleteBook方法
        // ....
        //如果我们将每个JDBC的增删查改方法单独定义在一个类中，一则调用不方便，二则不便于管理
        //因此：我们将对数据表中同一张表的不同JDBC操作方法定义在同一个类中
    }
}
