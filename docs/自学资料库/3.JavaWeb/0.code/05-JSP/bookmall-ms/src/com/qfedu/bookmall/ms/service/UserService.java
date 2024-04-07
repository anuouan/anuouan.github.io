package com.qfedu.bookmall.ms.service;

import com.qfedu.bookmall.ms.dao.UserDAO;
import com.qfedu.bookmall.ms.dto.User;

/**
 * @Description 管理员相关业务实现
 * @Author 千锋涛哥
 * 公众号： Java架构栈
 */
public class UserService {

    /**
     * 管理员登录业务：根据账号密码验证管理登录，验证通过返回user对象，否则返回null
     * @param userName
     * @param userPwd
     * @return
     */
    public User checkLogin(String userName, String userPwd){
        //1.根据userName查询管理员信息
        UserDAO userDAO = new UserDAO();
        User user = userDAO.selectUserByUserName(userName);
        //2.判断密码
        if(user != null && user.getUserPwd() .equals(userPwd)){
            return user;
        }else{
            return null;
        }
    }

}
