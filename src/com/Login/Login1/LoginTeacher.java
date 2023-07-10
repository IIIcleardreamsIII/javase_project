package com.Login.Login1;

import com.GradeUse.GradeUse;
import com.Login.Login;
import com.Operation.Add;
import com.Operation.Change;
import com.Operation.Get;

import java.util.Scanner;

public class LoginTeacher implements Login {//管理系统老师端
    @Override
    public void login() {
        //用输出语句完成主界面的编写
        System.out.println ("欢迎来到学生管理系统---老师端");
        System.out.println ();
        System.out.println ("1 添加学生");
        System.out.println ("2 查看学生");
        System.out.println ("3 修改学生");
        System.out.println ("4 成绩系统-老师端");
        System.out.println ("5 退出");
        System.out.println ("请输入您的选择：");

        while (true) {
            Scanner scanner = new Scanner (System.in);
            String s = scanner.next ();
            switch (s) {
                case "1":
                    System.out.println("1 添加学生");
                    new Add ().addStudent ();
                    break;
                case "2":
                    System.out.println("2 查看学生学生");
                    new Get ().getStudent ();
                    break;
                case "3":
                    System.out.println("3 修改学生");
                    new Change ().changeStudent_t ();
                    break;
                case "4":
                    System.out.println ("4 成绩系统");
                    new GradeUse ().login ();
                    break;
                case "5":
                    System.out.println("5 退出");
                    new Login1 ().sign_in ();

            }
        }
    }
    public void test() {
        login ();
    }
}