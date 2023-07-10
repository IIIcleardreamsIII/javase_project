package com.Operation;

import com.Grade.Grade;
import com.Login.Login1.LoginMaster;
import com.Login.Login1.LoginTeacher;
import com.User.User;

import java.io.*;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Add {
    public void addStudent() {
        //输入学生信息
        //先反序列化出map
        while (true) {
            User student = new User ();
            Map<Integer, User> map = new TreeMap<> ();
            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream (new FileInputStream ("src\\com\\Operation\\Student"));
                map = (TreeMap) ois.readObject ();

            }catch (IOException | ClassNotFoundException e) {
                e.printStackTrace ();
            }finally {
                try {
                    if (null != ois) {
                        ois.close ();
                    }
                }catch (IOException e) {
                    e.printStackTrace ();
                }
            }
            Scanner scanner = new Scanner (System.in);

            System.out.println ("输入学号");
            student.setNum (scanner.nextInt ());

            System.out.println ("设置初始密码");
            student.setPassword ("20210101");

            System.out.println ("输入年龄");
            student.setAge (scanner.nextInt ());

            System.out.println ("输入生日");
            student.setBirthday (scanner.nextInt ());

            System.out.println ("输入性别");
            student.setSex (scanner.next ());

            System.out.println ("输入姓名");
            student.setName (scanner.next ());

            System.out.println ("输入学科");
            student.setMajor (scanner.next ());

            System.out.println ("输入居住寝室");
            student.setResidential_Address (scanner.next ());

            System.out.println ("输入家乡省份");
            student.setProvince (scanner.next ());

            System.out.println ("是否需要输入成绩呢？？");
            System.out.println ("需要输入  '需要'");
            if (scanner.next ().equals ("需要")) {
                //学生成绩的输入，由于成绩方面比较特殊故在Student类中设置内部类单独存档
                System.out.println ("输入学生成绩");
                Grade grade = new Grade ();

                System.out.println ("输入Java成绩");
                grade.setJava (scanner.nextInt ());

                System.out.println ("输入英语成绩");
                grade.setEnglish (scanner.nextInt ());

                System.out.println ("输入数学成绩");
                grade.setMath (scanner.nextInt ());

                System.out.println ("输入数电成绩");
                grade.setDigital_Electronics (scanner.nextInt ());

                System.out.println ("输入物理成绩");
                grade.setPhysics (scanner.nextInt ());
                student.setGrade (grade);
            }
            //将数据存入map，以学生学号为key，student对象为value
            map.put (student.getNum (), student);

            //将map序列化存入文件。
            //由于是序列化过的，其他人无法通过修改文件来修改数据，只能通过老师端和管理员端来修改数据。

            ObjectOutputStream oos = null;
            try {
                oos = new ObjectOutputStream (new FileOutputStream ("src\\com\\Operation\\Student"));
                oos.writeObject (map);
                oos.flush ();
            } catch (IOException e){
                e.printStackTrace ();
            } finally {
                if (null != oos) {
                    try {
                        oos.close ();
                    }catch (IOException e) {
                        e.printStackTrace ();
                    }
                }
            }
            System.out.println ("输入-1结束");
            if (scanner.nextInt () == -1) {
                new LoginTeacher ().login ();
            }
        }
    }
    public void addStudent_m() {
        Map<Integer, User> map = new TreeMap<> ();
        User student = new User ();
        while (true) {
            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream (new FileInputStream ("src\\com\\Operation\\Student"));
                map =(TreeMap) ois.readObject ();
            }catch (IOException | ClassNotFoundException e) {
                e.printStackTrace ();
            }finally {
                try {
                    if (null != ois) {
                        ois.close ();
                    }
                }catch (IOException e) {
                    e.printStackTrace ();
                }
            }
            Scanner scanner = new Scanner (System.in);

            System.out.println ("输入学号");
            student.setNum (scanner.nextInt ());

            System.out.println ("设置初始密码");
            student.setPassword ("20210101");

            System.out.println ("输入年龄");
            student.setAge (scanner.nextInt ());

            System.out.println ("输入性别");
            student.setSex (scanner.next ());

            System.out.println ("输入姓名");
            student.setName (scanner.next ());

            System.out.println ("输入学科");
            student.setMajor (scanner.next ());

            System.out.println ("输入居住地址--寝室号");
            student.setResidential_Address (scanner.next ());

            map.put (student.getNum (), student);
            FileOutputStream fos = null;
            ObjectOutputStream oos = null;
            try {
                fos = new FileOutputStream ("src\\com\\Operation\\Student");
                oos = new ObjectOutputStream (fos);
                oos.writeObject (map);
                oos.flush ();
            } catch (IOException e){
                e.printStackTrace ();
            } finally {
                if (null != fos) {
                    try {
                        fos.close ();
                    }catch (IOException e) {
                        e.printStackTrace ();
                    }
                }
                if (null != oos) {
                    try {
                        oos.close ();
                    }catch (IOException e) {
                        e.printStackTrace ();
                    }
                }
            }
            System.out.println ("输入-1结束");
            if (scanner.nextInt () == -1) {
                new LoginMaster ().login ();
            }
        }
    }
}
