package com.GradeChange;

import com.Grade.Grade;
import com.GradeUse.GradeUse;
import com.User.User;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class GradeChange {
    public void changeGrade_T() {
        Scanner scanner = new Scanner (System.in);
        Map<Integer, User> map = new TreeMap<> ();
                ObjectInputStream ois = null;
                ObjectOutputStream oos_c = null;
                try {
                    System.out.println ("输入学号");
                    int ac_num = scanner.nextInt ();
                    ois = new ObjectInputStream (new FileInputStream ("src\\com\\Operation\\Student"));
                    map = (TreeMap) ois.readObject ();
                    if (map.get (ac_num) != null) {
                        User user = map.get (ac_num);
                        Grade grade = user.getGrade ();
                        System.out.println ("输入要修改的成绩的科目");
                        System.out.println ("科目列表 java English Math Digital_Electronics physics");
                        String major = scanner.next ();
                        if (major.equalsIgnoreCase ("java")) {
                            System.out.println (grade.getJava ());
                            System.out.println ("输入成绩");
                            grade.setJava (scanner.nextInt ());
                            System.out.println ("修改成功");


                        }else if (major.equalsIgnoreCase ("English")) {
                            System.out.println (grade.getEnglish ());
                            System.out.println ("输入成绩");
                            grade.setEnglish (scanner.nextInt ());
                            System.out.println ("修改成功");


                        }else if (major.equalsIgnoreCase ("Digital_Electronics")) {
                            System.out.println (grade.getDigital_Electronics ());
                            System.out.println ("输入成绩");
                            grade.setDigital_Electronics (scanner.nextInt ());
                            System.out.println ("修改成功");


                        }else if (major.equalsIgnoreCase ("physics")) {
                            System.out.println (grade.getPhysics ());
                            System.out.println ("输入成绩");
                            grade.setPhysics (scanner.nextInt ());
                            System.out.println ("修改成功");

                        }else if (major.equalsIgnoreCase ("Math")) {
                            System.out.println (grade.getMath ());
                            System.out.println ("输入成绩");
                            grade.setMath (scanner.nextInt ());
                            System.out.println ("修改成功");

                        }else {
                            changeGrade_T ();
                        }
                    }else {
                        System.out.println ("不存在该学生");
                        changeGrade_T ();
                    }
                    oos_c = new ObjectOutputStream (new FileOutputStream ("src\\com\\Operation\\Student"));
                    oos_c.writeObject (map);
                    oos_c.flush ();
                    new GradeUse ().login ();
                }catch (IOException |ClassNotFoundException e) {
                    e.printStackTrace ();
                }finally {
                    try {
                        if (null != ois) {
                            ois.close ();
                        }
                    }catch (IOException e) {
                        e.printStackTrace ();
                    }finally {
                        try {
                            if (null != oos_c) {
                                oos_c.close ();
                            }
                        }catch (IOException e) {
                            e.printStackTrace ();
                        }
                    }
                }
    }
}
