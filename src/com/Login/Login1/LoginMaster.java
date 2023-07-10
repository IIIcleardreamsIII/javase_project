package com.Login.Login1;

import com.GradeChange.GetGrade;
import com.Login.Login;
import com.Operation.Add;
import com.Operation.Change;
import com.Operation.Get;

import java.util.Scanner;

public class LoginMaster implements Login {

    @Override
    public void login () {
        //用输出语句完成主界面的编写
        System.out.println ("欢迎来到学生管理系统---管理员端");
        System.out.println ();
        System.out.println ("1 添加学生");
        System.out.println ("2 删除学生");
        System.out.println ("3 修改学生");
        System.out.println ("4 查看所有人");
        System.out.println ("5 查看所有成绩");
        System.out.println ("6 退出");
        System.out.println ("请输入您的选择：");

        while (true) {
            Scanner scanner = new Scanner (System.in);
            switch (scanner.next ()) {
                case "1":
                    System.out.println("1 添加学生");
                    new Add ().addStudent_m ();
                    break;
                case "2":
                    //管理员特有
                    System.out.println("2 删除学生");
                    new Change ().deleteStudent ();
                    break;
                case "3":
                    System.out.println("3 修改学生");
                    new Change ().changeStudent_m ();
                    break;
                case "4":
                    //管理员特有
                    System.out.println ("4 查看所有人");
                    new Get ().getAll ();
                    break;
                case "5":
                    //管理员特有
                    System.out.println ("5 查看所有成绩");
                    new GetGrade ().getAllGrade ();
                    break;
                case "6":
                    System.out.println("6 退出");
                    new Login1 ().sign_in ();
                    break;

            }
        }
    }
    public void test() {
        login ();
    }

}
