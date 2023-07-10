package com.Operation;

import com.Login.Login1.LoginStudent;
import com.Login.Login1.LoginTeacher;
import com.User.User;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Get {
    public void getStudent() {
        //查询学生，并且拥有不同的查询方式
        Map<Integer, User> map2 = new TreeMap<> ();
        System.out.println ("输入数字决定查找方式");
        System.out.println ("1-按学号查询 2-按专业查询 3-按家乡省份查询 4-查看所有学生 5-查看同寝室学生 6-退出");
        Scanner scanner = new Scanner (System.in);
        switch (scanner.next ()) {
            case "1":
                System.out.println ("请输入要查找学生对应的学号");
                Scanner scanner1 = new Scanner (System.in);
                int num = scanner1.nextInt ();
                ObjectInputStream ois = null;

                try {
                    ois = new ObjectInputStream (new FileInputStream ("C:\\Users\\杨骜捷\\IdeaProjects\\ProjectFinal\\src\\com\\Operation\\Student"));
                    map2 = (TreeMap) ois.readObject ();
                    System.out.println (map2.get (num));
                }catch (IOException | ClassNotFoundException e) {
                    System.out.println ("不存在该学生");
                    getStudent ();
                } finally {
                    if (null != ois) {
                        try {
                            ois.close ();
                        }catch (IOException e) {
                            e.printStackTrace ();
                        }
                    }
                }
                new LoginTeacher ().login ();
                break;
            case "2":
                System.out.println ("按班级查找,请输入对应的专业");
                Scanner scanner2 = new Scanner (System.in);
                String major = scanner2.nextLine ();
                ObjectInputStream ois2 = null;
                Map<Integer, User> map3 = new TreeMap<> ();
                try {
                    ois2 = new ObjectInputStream (new FileInputStream ("C:\\Users\\杨骜捷\\IdeaProjects\\ProjectFinal\\src\\com\\Operation\\Student"));
                    Map<Integer, User> map4 = (TreeMap) ois2.readObject ();

                    for (Integer obj : map4.keySet ()) {
                        //首先通过foreach遍历map1
                        if (map4.get (obj).getMajor ().equalsIgnoreCase (major)) {
                            //将相要查询班级的学生放入同一map-map2
                            map3.put (obj, map4.get (obj));
                        }
                    }
                    for (Integer obj : map3.keySet ()) {
                        //遍历学生
                        System.out.println ( "学生:" + map3.get (obj));
                    }
                }catch (IOException | ClassNotFoundException | NullPointerException e) {
                    System.out.println ("不存在对应专业或者有人未输入专业选项");
                    getStudent ();
                } finally {
                    if (null != ois2) {
                        try {
                            ois2.close ();
                        }catch (IOException e) {
                            e.printStackTrace ();
                        }
                    }
                }
                new LoginTeacher ().login ();
                break;
            case "3":
                System.out.println ("按家乡省份查找,请输入对应的省份");
                Scanner scanner4 = new Scanner (System.in);
                String province = scanner4.next ();
                ObjectInputStream ois3 = null;
                Map<Integer, User> map4 = new TreeMap<Integer, User> ();
                try {
                    ois3 = new ObjectInputStream (new FileInputStream ("C:\\Users\\杨骜捷\\IdeaProjects\\ProjectFinal\\src\\com\\Operation\\Student"));
                    Map<Integer, User> map1 = (TreeMap) ois3.readObject ();
                    for (Integer obj : map1.keySet ()) {
                        //遍历map1
                        if (map1.get (obj).getProvince ().equalsIgnoreCase (province)) {
                            //将相要查询相同省份的学生放入同一map-map2
                            map4.put (obj, map1.get (obj));
                        }
                    }
                    for (Integer obj : map4.keySet ()) {
                        //遍历map4
                        System.out.println ("学号：" + obj + " " + "学生:" + map4.get (obj));
                    }

                }catch (IOException | ClassNotFoundException |NullPointerException e) {
                    System.out.println ("输入错误省份或者有人未输入省份");
                    getStudent ();
                } finally {
                    if (null != ois3) {
                        try {
                            ois3.close ();
                        }catch (IOException e) {
                            e.printStackTrace ();
                        }
                    }
                }
                new LoginTeacher ().login ();
                break;
            case "4":
                ObjectInputStream ois4 = null;
                try {
                    ois4 = new ObjectInputStream (new FileInputStream ("C:\\Users\\杨骜捷\\IdeaProjects\\ProjectFinal\\src\\com\\Operation\\Student"));
                    Map<Integer, User> map1 = (TreeMap) ois4.readObject ();
                    for (Integer obj : map1.keySet ()) {
                        //遍历map1
                        System.out.println (map1.get (obj));
                    }
                }catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace ();
                } finally {
                    if (null != ois4) {
                        try {
                            ois4.close ();
                        }catch (IOException e) {
                            e.printStackTrace ();
                        }
                    }
                }
                new LoginTeacher ().login ();
                break;
            case "5":
                System.out.println ("按寝室查找,请输入对应的寝室");
                Scanner scanner5 = new Scanner (System.in);
                String residential_Address = scanner5.next ();
                ObjectInputStream ois5 = null;
                Map<Integer, User> map5 = new TreeMap<Integer, User> ();
                try {
                    ois5 = new ObjectInputStream (new FileInputStream ("C:\\Users\\杨骜捷\\IdeaProjects\\ProjectFinal\\src\\com\\Operation\\Student"));
                    Map<Integer, User> map1 = (TreeMap) ois5.readObject ();
                    for (Integer obj : map1.keySet ()) {
                        //遍历map1
                        if (map1.get (obj).getResidential_Address ().equalsIgnoreCase (residential_Address)) {
                            //将相要查询相同省份的学生放入同一map-map2
                            map5.put (obj, map1.get (obj));
                        }
                    }
                    for (Integer obj : map5.keySet ()) {
                        //遍历map4
                        System.out.println ("学生:" + map5.get (obj));
                    }
                }catch (IOException | ClassNotFoundException | NullPointerException e) {
                    System.out.println ("不存在该寝室或者有人未输入寝室");
                    getStudent ();
                } finally {
                    if (null != ois5) {
                        try {
                            ois5.close ();
                        }catch (IOException e) {
                            e.printStackTrace ();
                        }
                    }
                }
                new LoginTeacher ().login ();
                break;
            case "6":
                System.out.println ("退出");
                new LoginTeacher ().login ();
        }
    }
    public void getStudent(int ac_num) {
        Map<Integer, User> map2 = new TreeMap<> ();
        //重载查询方法，因为学生只需要也只应该查询自己,故将学号作为参数传来
        System.out.println ("按学号查询 ");
        int num = ac_num;
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream (new FileInputStream ("C:\\Users\\杨骜捷\\IdeaProjects\\ProjectFinal\\src\\com\\Operation\\Student"));
            map2 = (TreeMap) ois.readObject ();
            System.out.println (map2.get (num));

        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace ();
        } finally {
            if (null != ois) {
                try {
                    ois.close ();
                }catch (IOException e) {
                    e.printStackTrace ();
                }
            }
        }
        new LoginStudent ().login (ac_num);
    }
    public void getAll() {//查看所有账号--仅管理员有此权限
        ObjectInputStream ois_s = null;
        ObjectInputStream ois_t = null;
        ObjectInputStream ois_m = null;
        try {
            ois_s = new ObjectInputStream (new FileInputStream ("src\\com\\Operation\\Student"));
            ois_m = new ObjectInputStream (new FileInputStream ("src\\com\\Operation\\Master"));
            ois_t = new ObjectInputStream (new FileInputStream ("src\\com\\Operation\\Teacher"));
            Map<Integer, User> map1 = (TreeMap) ois_s.readObject ();
            Map<Integer, User> map2 = (TreeMap) ois_m.readObject ();
            Map<Integer, User> map3 = (TreeMap) ois_t.readObject ();
            System.out.println ("学生");
            for (Integer obj : map1.keySet ()) {
                //遍历map1
                System.out.println (map1.get (obj));
            }
            System.out.println ("管理员");
            for (Integer integer: map2.keySet ()) {
                //遍历map2
                System.out.println (map2.get (integer));
            }
            System.out.println ("老师");
            for (Integer integer: map3.keySet ()) {
                //遍历map3
                System.out.println (map3.get (integer));
            }
        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace ();
        } finally {
            if (null != ois_s) {
                try {
                    ois_s.close ();
                }catch (IOException e) {
                    e.printStackTrace ();
                }
            }
            if (null != ois_m) {
                try {
                    ois_m.close ();
                }catch (IOException e) {
                    e.printStackTrace ();
                }
            }
            if (null != ois_t) {
                try {
                    ois_t.close ();
                }catch (IOException e) {
                    e.printStackTrace ();
                }
            }
        }
    }
}
