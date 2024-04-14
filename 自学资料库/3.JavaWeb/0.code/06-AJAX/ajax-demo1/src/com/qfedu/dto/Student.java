package com.qfedu.dto;

/**
 * @Description
 * @Author 千锋涛哥
 * 公众号： Java架构栈
 */
public class Student {

    private String stuNum;
    private String stuName;
    private String stuGender;

    @Override
    public String toString() {
        return "Student{" +
                "stuNum='" + stuNum + '\'' +
                ", stuName='" + stuName + '\'' +
                ", stuGender='" + stuGender + '\'' +
                '}';
    }

    public Student() {
    }

    public Student(String stuNum, String stuName, String stuGender) {
        this.stuNum = stuNum;
        this.stuName = stuName;
        this.stuGender = stuGender;
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuGender() {
        return stuGender;
    }

    public void setStuGender(String stuGender) {
        this.stuGender = stuGender;
    }
}
