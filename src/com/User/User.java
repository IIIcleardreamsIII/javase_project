package com.User;

import com.Student.Student;

public class User extends Student {
    public User () {

    }

    public User (int userName, String password, String name) {
        this.userName = userName;
        this.password = password;
        this.setName (name);
    }

    public void setUserName (int userName) {
        this.userName = userName;
    }

    public int getUserName () {
        return userName;
    }

    private int userName;

    public void setPassword (String password) {
        this.password = password;
    }

    public String getPassword () {
        return password;
    }

    private String password;

    @Override
    public String toString () {
        return  "学号：" + getNum () + " " +
                "班级：" + getMajor () + " " +
                "密码：" + getPassword () + " " +
                "姓名：" + getName () + " " +
                "性别：" + getSex () + " " +
                "生日：" + getBirthday () + " " +
                "电话号码：" + getPhone_number () + " " +
                "居住地址：" + getResidential_Address () + " " +
                "家乡省份：" + getProvince ();

    }
}