package com.qfedu.sgms.dao;

import com.qfedu.sgms.dto.Student;
import com.qfedu.sgms.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

/**
 * @Description
 * @Author 千锋涛哥
 * 公众号： Java架构栈
 */
public class StudentDAO {

    /**
     * 根据学号和密码查询学生信息
     * @param stuNum
     * @param stuPwd
     * @return 如果学号密码正确返回Student，否则返回null
     */
    public Student queryStudentByNumAndPwd(String stuNum,String stuPwd){
        Student student = null;
        try{
            String sql = "select stu_num stuNum,stu_name stuName,stu_gender stuGender,stu_age stuAge,stu_pwd stuPwd" +
                    " from students where stu_num=? and stu_pwd=?";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            student = queryRunner.query(sql,new BeanHandler<Student>(Student.class),stuNum,stuPwd);
        }catch (Exception e){
            e.printStackTrace();
        }
        return student;
    }

}
