package com.Login.Login1;

import com.GradeUse.GradeUse;
import com.Login.Login;
import com.Operation.Change;
import com.Operation.Get;

import java.util.Scanner;

public class LoginStudent implements Login{
    public void login(int ac_num) {
        //重载login方法，传入参数ac_num为了方便后续使用
        System.out.println ("欢迎来到学生管理系统---学生端");
        System.out.println ();
        System.out.println ("1 查看");
        System.out.println ("2 修改");
        System.out.println ("3 成绩查询");
        System.out.println ("4 退出");
        while (true) {
            Scanner scanner = new Scanner (System.in);
            int s = scanner.nextInt ();
            switch (s) {
                case 1:
                    System.out.println("1 查看");
                    new Get ().getStudent (ac_num);
                    break;
                case 2:
                    System.out.println("2 修改");
                    new Change ().changeStudent (ac_num);
                    break;
                case 3:
                    System.out.println ("3 成绩系统");
                    new GradeUse ().login (ac_num);
                case 4:
                    System.out.println("4 退出");
                    new Login1 ().sign_in ();
                    break;

            }
        }
    }

    @Override
    public void login () {

    }
    public void test() {
        System.out.println ("输入学号");
        Scanner scanner = new Scanner (System.in);
        login (scanner.nextInt ());
    }
}

