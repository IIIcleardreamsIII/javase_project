package com.GradeChange;

import com.GradeUse.GradeUse;
import com.User.User;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class GetGrade {
    public void getGrade_Student(int ac_num) {
        //查询成绩-学生
        Map<Integer, User> map = new TreeMap<> ();
        ObjectInputStream ois = null;
        try {
            //先将map反序列化出来
            ois = new ObjectInputStream (new FileInputStream ("src\\com\\Operation\\Student"));
            map = (TreeMap) ois.readObject ();
            //由于学生只需查询自己的成绩，那么可以直接给map.get（）传参，无需输入
            User user = map.get (ac_num);
            System.out.println (user.getGrade ());
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
        new GradeUse ().login (ac_num);

    }
    public void getGrade_Teacher() {
        //查询成绩-老师
        Map<Integer, User> map = new TreeMap<> ();
        Scanner scanner = new Scanner (System.in);
        System.out.println ("输入数字来选择查询方式 1-查询个人成绩 2-查询班级成绩 3-科目成绩 4-平均分 5-退出");
        String x = scanner.next ();
        switch (x) {
            case "1":
                ObjectInputStream ois = null;
                try {
                    System.out.println ("输入学号");
                    int ac_num = scanner.nextInt ();
                    ois = new ObjectInputStream (new FileInputStream ("src\\com\\Operation\\Student"));
                    map = (TreeMap) ois.readObject ();
                    if(map.get (ac_num) != null) {
                        User user = map.get (ac_num);
                        System.out.println (user.getGrade ());
                    }else {
                        System.out.println ("不存在该学生");
                        getGrade_Teacher ();
                    }
                }catch (IOException | ClassNotFoundException|NullPointerException e) {
                    System.out.println ("不存在该学生");
                    getGrade_Teacher ();
                }finally {
                    try {
                        if (null != ois) {
                            ois.close ();
                        }
                    }catch (IOException e) {
                        e.printStackTrace ();
                    }
                }
                getGrade_Teacher ();
                break;
            case "2":
                System.out.println ("输入查询班级");
                String major = scanner.next ();
                ObjectInputStream ois1 = null;
                try {
                    ois1 = new ObjectInputStream (new FileInputStream ("src\\com\\Operation\\Student"));
                    Map<Integer, User> map1 = (TreeMap) ois1.readObject ();
                    Map<Object, User> map2 = new TreeMap ();
                    for (Object obj : map1.keySet ()) {
                        //首先遍历map1 比较map1.get (obj).getMajor ()和major
                        if (map1.get (obj).getMajor ().equalsIgnoreCase (major)) {
                            //将相要查询班级的学生放入同一map-map2
                            map2.put (obj, map1.get (obj));
                        }
                    }
                    for (Object obj : map2.keySet ()) {
                        //遍历学生成绩
                        System.out.println ("学号：" + obj + " " + "学生成绩:" + map2.get (obj).getGrade ());
                    }

                }catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace ();
                }catch (InputMismatchException e){
                    System.out.println ("不存在该班级");
                    getGrade_Teacher ();
                }finally {
                    try {
                        if (null != ois1) {
                            ois1.close ();
                        }
                    }catch (IOException e) {
                        e.printStackTrace ();
                    }
                }

                break;
            case "3":
                System.out.println ("输入查询科目");
                System.out.println ("科目列表 java English Math Digital_Electronics physics");
                System.out.println ("输入avg可查询平均分");
                String major1 = scanner.next ();
                ObjectInputStream ois2 = null;
                try {
                    ois2 = new ObjectInputStream (new FileInputStream ("src\\com\\Operation\\Student"));
                    Map<Integer, User> map1 = (TreeMap) ois2.readObject ();
                    if (major1.equalsIgnoreCase ("java")) {
                        for (int key : map1.keySet()) {
                            User value = map1.get(key);
                            System.out.println("学号 "+key+ " 姓名 : " + value.getName () + " "+ major1 + "成绩:" + value.getGrade ().getJava ());
                        }
                    }else if (major1.equalsIgnoreCase ("English")) {
                        for (int key : map1.keySet ()) {
                            User value = map1.get (key);
                            System.out.println ("学号 " + key + " 姓名 : " + value.getName () + " "+ major1 + "成绩:" + value.getGrade ().getEnglish ());
                        }
                    }else if (major1.equalsIgnoreCase ("Digital_Electronics")) {
                        for (int key : map1.keySet ()) {
                            User value = map1.get (key);
                            System.out.println ("学号 " + key + " 姓名 : " + value.getName () +" "+ major1 + "成绩:" + value.getGrade ().getDigital_Electronics ());
                        }
                    }else if (major1.equalsIgnoreCase ("physics")) {
                        for (int key : map1.keySet ()) {
                            User value = map1.get (key);
                            System.out.println ("学号 " + key + " 姓名 : " + value.getName () +" "+ major1 + "成绩:" + value.getGrade ().getPhysics ());
                        }
                    }else if (major1.equalsIgnoreCase ("Math")) {
                        for (int key : map1.keySet ()) {
                            User value = map1.get (key);
                            System.out.println ("学号 " + key + " 姓名 : " + value.getName ()+ " "+ major1 + "成绩:" + value.getGrade ().getMath ());
                        }
                    }else if (major1.equalsIgnoreCase ("avg")) {
                        for (int key : map1.keySet ()) {
                            User value = map1.get (key);
                            System.out.println ("学号 " + key + " 姓名 : " + value.getName () + " "+ major1 + "成绩:" + value.getGrade ().getAvg ());
                        }
                    } else {
                        getGrade_Teacher ();
                    }
                }catch (IOException | ClassNotFoundException|NullPointerException e) {
                    getGrade_Teacher ();
                    e.printStackTrace ();
                }finally {
                    if (null != ois2) {
                        try {
                            ois2.close ();
                        } catch (IOException e) {
                            e.printStackTrace ();
                        }
                    }
                }
                getGrade_Teacher ();
                break;
            case "4":
                System.out.println ("请输入查询方式 1-查询个人成绩的平均数 2-查询班级成绩的平均数");
                switch (scanner.next ()) {
                    case "1":
                        System.out.println ("输入学号");
                        int ac_num = scanner.nextInt ();
                        ObjectInputStream ois_avg = null;
                        try {
                            ois_avg = new ObjectInputStream (new FileInputStream ("src\\com\\Operation\\Student"));
                            Map<Integer, User> map_avg = (TreeMap) ois_avg.readObject ();
                            System.out.println (map_avg.get (ac_num).getGrade ().getAvg ());
                        }catch (IOException | ClassNotFoundException e) {
                            e.printStackTrace ();
                        }finally {
                            try {
                                if (null != ois_avg) {

                                    ois_avg.close ();
                                }
                            }catch (IOException e) {
                                e.printStackTrace ();
                            }
                            getGrade_Teacher ();
                        }
                        break;
                    case "2":
                        System.out.println ("输入要查询的班级");
                        String major_avg = scanner.next ();
                        ObjectInputStream ois_avg1 = null;
                        try {
                            ois_avg1 = new ObjectInputStream (new FileInputStream ("src\\com\\Operation\\Student"));

                            Map<Integer, User> map1 = (TreeMap) ois_avg1.readObject ();
                            Map<Object, User> map2 = new TreeMap ();
                            for (Object obj : map1.keySet ()) {
                                //首先遍历map1 比较map1.get (obj).getMajor ()和major_avg
                                if (map1.get (obj).getMajor ().equalsIgnoreCase (major_avg)) {
                                    //将相要查询班级的学生放入同一map-map2
                                    map2.put (obj, map1.get (obj));
                                }
                            }
                            double avg_major = 0;
                            int i = 0;
                            for (Object obj : map2.keySet ()) {
                                avg_major = avg_major + map2.get (obj).getGrade ().sumGrade ()/5;
                                i++;
                            }
                            System.out.println ("班级平均成绩为" + avg_major/i);
                        }catch (IOException | ClassNotFoundException| NullPointerException e) {
                            getGrade_Teacher ();
                        }finally {
                            try {
                                if (null != ois_avg1) {
                                    ois_avg1.close ();
                                }
                            }catch (IOException e) {
                                e.printStackTrace ();
                            }
                        }
                }
            case "5":
                new GradeUse().login ();
        }
    }
    public void getAllGrade() {

        ObjectInputStream ois_avg1 = null;
        try {
            ois_avg1 = new ObjectInputStream (new FileInputStream ("src\\com\\Operation\\Student"));
            Map<Integer, User> map1 = (TreeMap) ois_avg1.readObject ();
            for (Integer obj : map1.keySet ()) {
                System.out.println (map1.get (obj).getName () + " " + map1.get (obj).getGrade ());
            }
        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace ();
        }finally {
            try {
                if (null != ois_avg1) {
                    ois_avg1.close ();
                }
            }catch (IOException e) {
                e.printStackTrace ();
            }
        }
    }

}
