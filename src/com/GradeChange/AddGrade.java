package com.GradeChange;

import com.Grade.Grade;
import com.GradeUse.GradeUse;
import com.User.User;

import java.io.*;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AddGrade {
    public void addGrade() {
        Scanner scanner = new Scanner (System.in);
        Map<Integer, User> map;
        ObjectInputStream ois_add = null;
        try {
            System.out.println ("输入学号");
            int ac_num = scanner.nextInt ();
            ois_add = new ObjectInputStream (new FileInputStream ("src\\com\\Operation\\Student"));
            map = (TreeMap) ois_add.readObject ();
            if (map.get (ac_num) != null) {
                User user = map.get (ac_num);
                Grade grade = new Grade ();
                System.out.println ("高数成绩");
                grade.setMath (scanner.nextInt ());

                System.out.println ("Java成绩");
                grade.setJava (scanner.nextInt ());

                System.out.println ("物理成绩");
                grade.setPhysics (scanner.nextInt ());

                System.out.println ("英语成绩");
                grade.setEnglish (scanner.nextInt ());

                System.out.println ("数电成绩");
                grade.setDigital_Electronics (scanner.nextInt ());

                user.setGrade (grade);
                map.put (ac_num, user);
                ObjectOutputStream oos_add = null;
                try {
                    oos_add = new ObjectOutputStream (new FileOutputStream ("src\\com\\Operation\\Student"));
                    oos_add.writeObject (map);
                    oos_add.flush ();
                }catch (IOException e) {
                    e.printStackTrace ();
                }finally {
                    try {
                        if (null != oos_add) {
                            oos_add.close ();
                        }
                    }catch (IOException e) {
                        e.printStackTrace ();
                    }
                }
            }else {
                System.out.println ("不存在该学生");
                addGrade ();
            }

        }catch (IOException | ClassNotFoundException e) {

        }finally {
            try {
                if (null != ois_add) {
                    ois_add.close ();
                }
            }catch (IOException e) {
                e.printStackTrace ();
            }
        }
        new GradeUse ().login ();
    }
}
