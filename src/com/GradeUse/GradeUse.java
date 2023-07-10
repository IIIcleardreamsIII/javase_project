package com.GradeUse;

import com.GradeChange.AddGrade;
import com.GradeChange.GetGrade;
import com.GradeChange.GradeChange;
import com.Login.Login;
import com.Login.Login1.Login1;
import com.Login.Login1.LoginStudent;

import java.util.Scanner;

public class GradeUse implements Login {
    public void login(int ac_num) {
        System.out.println ("欢迎来到学生管理系统---学生端");
        System.out.println ();
        System.out.println ("1 查看");
        System.out.println ("2 退出");
        while (true) {
            Scanner scanner = new Scanner (System.in);
            int s = scanner.nextInt ();
            switch (s) {
                case 1:
                    System.out.println("1 查看");
                    new GetGrade ().getGrade_Student (ac_num);
                    break;
                case 2:
                    System.out.println("2 退出");
                    new LoginStudent ().login (ac_num);
                    break;

            }
        }
    }
    @Override
    public void login () {
        System.out.println ("欢迎来到学生管理系统---老师端");
        System.out.println ();
        System.out.println ("1 查看");
        System.out.println ("2 修改");
        System.out.println ("3 添加学生");
        System.out.println ("4 退出");
        while (true) {
            Scanner scanner = new Scanner (System.in);

            switch (scanner.next ()) {
                case "1":
                    System.out.println("1 查看");
                    new GetGrade ().getGrade_Teacher ();
                    break;
                case "2":
                    System.out.println("2 修改");
                    new GradeChange ().changeGrade_T ();;
                    break;
                case "3":
                    System.out.println ("3 添加学生");
                    new AddGrade ().addGrade ();
                case "4":
                    System.out.println ("4 退出");
                    new Login1 ().sign_in ();
                default:
                    login ();
                    break;

            }
        }
    }
    public void test() {
        login ();
    }
    public void test(int ac_num) {
        login (ac_num);
    }
}
