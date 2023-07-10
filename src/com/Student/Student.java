package com.Student;

import com.Grade.Grade;

import java.io.Serializable;


//学生基本信息
public class Student implements Serializable {
    private static final long serialVersionUID = 20030626L;

    public Grade getGrade () {
        return grade;
    }

    public void setGrade (Grade grade) {
        this.grade = grade;
    }
    private Grade grade;

    public String getPhone_number () {
        return phone_number;
    }

    public void setPhone_number (String phone_number) {
        this.phone_number = phone_number;
    }

    private String phone_number;//电话号码或者邮箱地址

    public String getSex () {
        return sex;
    }

    public void setSex (String sex) {
        this.sex = sex;
    }
    private String sex;//性别
    public int getBirthday () {
        return birthday;
    }

    public void setBirthday (int birthday) {
        this.birthday = birthday;
    }

    private int birthday;//生日
    public String getMajor () {
        return Major;
    }

    public void setMajor (String major) {
        Major = major;
    }

    private String Major;//学科
    public int getNum () {
        return num;
    }

    public void setNum (int num) {
        this.num = num;
    }

    private int num;//学号

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    private String name;//姓名

    public String getResidential_Address () {
        return residential_Address;
    }

    public void setResidential_Address (String residential_Address) {
        this.residential_Address = residential_Address;
    }

    private String residential_Address;//居住地址

    public int getAge () {
        return age;
    }

    public void setAge (int age) {
        this.age = age;
    }

    private int age;//年龄

    public String getProvince () {
        return province;
    }

    public void setProvince (String province) {
        this.province = province;
    }

    private String province;//家乡省份
    public Student() {

    }

    public Student(int num, String name, String residential_Address, int age, String major, String sex, String phone_number, String province, Grade grade) {
        this.age = age;
        this.name= name;
        this.num = num;
        this.residential_Address = residential_Address;
        this.Major = major;
        this.sex = sex;
        this.phone_number = phone_number;
        this.province = province;
        this.grade = grade;
    }

    @Override
    public String toString () {
        return  "学号：" + getNum () + " " +
                "班级：" + getMajor () + " " +
                "姓名：" + getName () + " " +
                "性别：" + getSex () + " " +
                "生日：" + getBirthday () + " " +
                "电话号码：" + getPhone_number () + " " +
                "居住地址：" + getResidential_Address () + " " +
                "家乡省份：" + getProvince ();
    }
}
