package com.qfedu.sgms.dao;

import com.qfedu.sgms.dto.Grade;
import com.qfedu.sgms.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

/**
 * @Description
 * @Author 千锋涛哥
 * 公众号： Java架构栈
 */
public class GradeDAO {

    /**
     * 根据学号和课程号查询这个学生这门课的成绩
     * @param snum
     * @param cid
     * @return
     */
    public Grade queryGradeBySnumAndCid(String snum,String cid){
        Grade grade = null;
        try{
            //注意查询出的列名要取别名，和grade对象的属性一致
            String sql = "select s.stu_num snum,s.stu_name sname,c.course_id cid,c.course_name cname ,g.score score " +
                    "from students s INNER JOIN grades g INNER JOIN courses c " +
                    "on s.stu_num = g.snum and g.cid = c.course_id " +
                    "where s.stu_num=? and c.course_id=?";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            grade = queryRunner.query(sql,new BeanHandler<Grade>(Grade.class),snum,cid);
        }catch (Exception e){
            e.printStackTrace();
        }
        return grade;
    }

}
