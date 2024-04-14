package com.qfedu.bookmall.ms.dao;

import com.qfedu.bookmall.ms.dto.User;
import com.qfedu.bookmall.ms.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * @Description 用于实现管理员的数据库操作
 * @Author 千锋涛哥
 * 公众号： Java架构栈
 */
public class UserDAO {

    /**
     * 根据管理员登录名查询管理员信息
     * @param userName
     * @return
     */
    public User selectUserByUserName(String userName){
        User user = null;
        try {
            String sql = "select user_id userId,user_name userName,user_pwd userPwd,real_name realName,user_gender userGender,user_tel userTel,user_desc userDesc from users where user_name=?";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            user = queryRunner.query(sql, new BeanHandler<User>(User.class),userName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

}
