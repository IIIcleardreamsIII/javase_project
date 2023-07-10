package com.Login.Login1;

import com.Login.Login;
import com.User.User;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Login1 implements Login {
    private Map<Integer, User> map2 = new TreeMap <Integer, User>();
    public void sign_in() {
        System.out.println ("1-登录 2-注册 3-结束");
        Scanner scanner = new Scanner (System.in);
        switch (scanner.next ()) {
            case "1":
                login ();
                break;
            case "2":
                register ();
                break;
            case "3":
                System.exit (0);
                break;
            default:
                sign_in ();
                break;
        }

    }
    //实现Login接口方法为普通的登录界面
    @Override
    public void login () {
        System.out.println ("输入选择 学生 老师 管理员 退出1");
        Scanner scanner = new Scanner (System.in);
        switch (scanner.next ()){
            case "学生":
                System.out.println ("登录界面-学生");
                System.out.println ("账号");
                int account_num = 0;
                ObjectInputStream ois = null;
                try {
                    account_num = scanner.nextInt ();
                    //反序列化
                    ois = new ObjectInputStream (new FileInputStream ("C:\\Users\\杨骜捷\\IdeaProjects\\ProjectFinal\\src\\com\\Operation\\Student"));
                    map2 = (TreeMap) ois.readObject ();
                }catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace ();
                }catch (InputMismatchException e){
                    System.out.println ("不存在该学生，请重新输入");
                    login ();
                }finally {
                    if (null != ois) {
                        try {
                            ois.close ();
                        }catch (IOException e) {
                            e.printStackTrace ();
                        }
                    }
                }
                try {
                    User user = map2.get (account_num);
                    if (user != null) {
                        System.out.println ("密码");
                        String password = scanner.next ();
                        if (user.getPassword ().equalsIgnoreCase (password)) {
                            System.out.println ("欢迎来到学生管理系统");
                                    System.out.println ("进入学生端");
                                    new LoginStudent ().login (account_num);
                                    break;
                        }
                    }else {
                        sign_in ();
                    }
                }catch (NullPointerException e) {
                    sign_in ();
                }finally {
                    try {
                        if (ois != null) {
                            ois.close ();
                        }
                    }catch (IOException e) {
                        e.printStackTrace ();
                    }
                }
                break;
            case "老师":
                System.out.println ("登录界面-老师");
                System.out.println ("账号");
                int account_num_t = 0;
                ObjectInputStream ois_t = null;
                try {
                    account_num_t = scanner.nextInt ();
                    //反序列化
                    ois_t = new ObjectInputStream (new FileInputStream ("C:\\Users\\杨骜捷\\IdeaProjects\\ProjectFinal\\src\\com\\Operation\\Teacher"));
                    map2 = (TreeMap) ois_t.readObject ();
                }catch (IOException | ClassNotFoundException e) {
                    login ();
                    e.printStackTrace ();
                } catch (InputMismatchException e){
                    System.out.println ("不存在该老师，请重新输入");
                    login ();
                }finally {
                    if (null != ois_t) {
                        try {
                            ois_t.close ();
                        }catch (IOException e) {
                            e.printStackTrace ();
                        }
                    }
                }
                try {
                    User user = map2.get (account_num_t);
                    if (user != null) {
                        System.out.println ("密码");
                        String password = scanner.next ();
                        if (user.getPassword ().equalsIgnoreCase (password)) {
                            System.out.println ("欢迎来到学生管理系统");
                            System.out.println ("进入老师端");
                            new LoginTeacher ().login ();
                            break;
                        }
                    }else {
                        sign_in ();
                    }
                }catch (NullPointerException e) {
                    sign_in ();
                }finally {
                    try {
                        if (ois_t != null) {
                            ois_t.close ();
                        }
                    }catch (IOException e) {
                        e.printStackTrace ();
                    }
                }
            case "管理员":
                System.out.println ("登录界面-管理员");
                System.out.println ("账号");
                int account_num_m = 0;
                ObjectInputStream ois_m = null;
                try {
                    account_num_m = scanner.nextInt ();
                    //反序列化
                    ois_m = new ObjectInputStream (new FileInputStream ("C:\\Users\\杨骜捷\\IdeaProjects\\ProjectFinal\\src\\com\\Operation\\Master"));
                    map2 = (TreeMap) ois_m.readObject ();
                }catch (IOException | ClassNotFoundException e) {
                    login ();
                    e.printStackTrace ();
                }catch (InputMismatchException e){
                    System.out.println ("不存在该管理员，请重新输入");
                    login ();
                } finally {
                    if (null != ois_m) {
                        try {
                            ois_m.close ();
                        }catch (IOException e) {
                            e.printStackTrace ();
                        }
                    }
                }
                try {
                    User user1 = map2.get (account_num_m);
                    if (user1 != null) {
                        System.out.println ("密码");
                        String password = scanner.next ();
                        if (user1.getPassword ().equalsIgnoreCase (password)) {
                            System.out.println ("欢迎来到学生管理系统");
                            System.out.println ("进入管理员端");
                            new LoginMaster ().login ();
                            break;
                        }
                    }else {
                        sign_in ();
                    }
                }catch (NullPointerException e) {
                    sign_in ();
                }finally {
                    try {
                        if (ois_m != null) {
                            ois_m.close ();
                        }
                    }catch (IOException e) {
                        e.printStackTrace ();
                    }
                }
            case "退出":
                System.out.println ("回到选择界面");
                sign_in ();
            default:
                login ();
                break;
        }

    }
    public void test() {
        login ();
    }
//注册账号
    private void register() {
        Scanner scanner = new Scanner (System.in);
        User user = new User ();
                System.out.println ("注意学号格式为age-XXXXXX");
                System.out.println ("注意工号格式为age-XXXX");
                System.out.println ("注意管理员号格式为age-XX");
                System.out.println ("age即入学入职年份");
                System.out.println ("设置号码");
                user.setUserName (scanner.nextInt ());
                user.setNum (user.getUserName ());
                System.out.println ("设置密码");
                user.setPassword (scanner.next ());
                System.out.println ("输入姓名");
                user.setName (scanner.next ());
                if (user.getUserName ()/10000 < 100) {//管理员注册
                    Map<Integer, User> map3;
                    ObjectInputStream ois1 = null;
                    try {
                        ois1 = new ObjectInputStream (new FileInputStream ("C:\\Users\\杨骜捷\\IdeaProjects\\ProjectFinal\\src\\com\\Operation\\Master"));
                        map3 = (TreeMap) ois1.readObject ();
                        map3.put (user.getUserName (), user);
                        //先反序列化调出treemap，防止序列化时覆盖旧的对象，然后将新的学生注册进文件，再序列化treemap
                        FileOutputStream fos = null;
                        ObjectOutputStream oos = null;
                        try {
                            fos = new FileOutputStream ("C:\\Users\\杨骜捷\\IdeaProjects\\ProjectFinal\\src\\com\\Operation\\Master");
                            oos = new ObjectOutputStream (fos);
                            oos.writeObject (map3);
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
                        //序列化反序列化的treemap
                    }catch (IOException e){
                        //如果为第一个注册的用户，因为文件为空里面并没有数据，读不了报空指针异常了，那么就可以直接序列化写入，无需反序列化再序列化
                        FileOutputStream fos = null;
                        ObjectOutputStream oos = null;
                        Map<Integer, User> map_m = new TreeMap<> ();
                        try {
                            map_m.put (user.getUserName (), user);
                            fos = new FileOutputStream ("C:\\Users\\杨骜捷\\IdeaProjects\\ProjectFinal\\src\\com\\Operation\\Master");
                            oos = new ObjectOutputStream (fos);
                            oos.writeObject (map_m);
                            oos.flush ();
                        } catch (IOException exception){
                            exception.printStackTrace ();
                        } finally {
                            if (null != fos) {
                                try {
                                    fos.close ();
                                }catch (IOException ioException) {
                                    ioException.printStackTrace ();
                                }
                            }
                            if (null != oos) {
                                try {
                                    oos.close ();
                                }catch (IOException exception1) {
                                    exception1.printStackTrace ();
                                }
                            }
                        }
                    }catch (ClassNotFoundException e) {
                        e.printStackTrace ();
                    }finally {
                        try {
                            if (null != ois1) {
                                ois1.close ();
                            }
                        }catch (IOException e) {
                            e.printStackTrace ();
                        }
                    }
                    sign_in();
                }else if (user.getUserName ()/10000>100 && user.getUserName ()/10000 < 10000) {//老师注册
                    Map<Integer, User> map3;
                    ObjectInputStream ois1 = null;
                    try {
                        ois1 = new ObjectInputStream (new FileInputStream ("C:\\Users\\杨骜捷\\IdeaProjects\\ProjectFinal\\src\\com\\Operation\\Teacher"));
                        map3 = (TreeMap) ois1.readObject ();
                        map3.put (user.getUserName (), user);
                        FileOutputStream fos = null;
                        ObjectOutputStream oos = null;
                        try {
                            fos = new FileOutputStream ("C:\\Users\\杨骜捷\\IdeaProjects\\ProjectFinal\\src\\com\\Operation\\Teacher");
                            oos = new ObjectOutputStream (fos);
                            oos.writeObject (map3);
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
                    }catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace ();
                    }catch (NullPointerException e) {
                        FileOutputStream fos = null;
                        ObjectOutputStream oos = null;
                        Map<Integer, User> map_t = new TreeMap<> ();
                        try {
                            map_t.put (user.getUserName (), user);
                            fos = new FileOutputStream ("C:\\Users\\杨骜捷\\IdeaProjects\\ProjectFinal\\src\\com\\Operation\\Teacher");
                            oos = new ObjectOutputStream (fos);
                            oos.writeObject (map_t);
                            oos.flush ();
                        } catch (IOException exception){
                            exception.printStackTrace ();
                        } finally {
                            if (null != fos) {
                                try {
                                    fos.close ();
                                }catch (IOException ioException) {
                                    ioException.printStackTrace ();
                                }
                            }
                            if (null != oos) {
                                try {
                                    oos.close ();
                                }catch (IOException exception1) {
                                    exception1.printStackTrace ();
                                }
                            }
                        }
                    }finally {
                        try {
                            if (null != ois1) {
                                ois1.close ();
                            }
                        }catch (IOException e) {
                            e.printStackTrace ();
                        }
                    }
                    sign_in();
                } else {//学生注册
                    Map<Integer, User> map3;
                    ObjectInputStream ois1 = null;
                    try {
                        ois1 = new ObjectInputStream (new FileInputStream ("C:\\Users\\杨骜捷\\IdeaProjects\\ProjectFinal\\src\\com\\Operation\\Student"));
                        map3 = (TreeMap) ois1.readObject ();
                        map3.put (user.getUserName (), user);
                        FileOutputStream fos = null;
                        ObjectOutputStream oos = null;
                        try {
                            fos = new FileOutputStream ("C:\\Users\\杨骜捷\\IdeaProjects\\ProjectFinal\\src\\com\\Operation\\Student");
                            oos = new ObjectOutputStream (fos);
                            oos.writeObject (map3);
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
                    }catch (IOException |ClassNotFoundException e) {
                        FileOutputStream fos = null;
                        ObjectOutputStream oos = null;
                        Map<Integer, User> map_s = new TreeMap<> ();
                        try {
                            fos = new FileOutputStream ("C:\\Users\\杨骜捷\\IdeaProjects\\ProjectFinal\\src\\com\\Operation\\Student");
                            oos = new ObjectOutputStream (fos);
                            map_s.put (user.getUserName (), user);
                            oos.writeObject (map_s);
                            oos.flush ();
                        } catch (IOException exception){
                            exception.printStackTrace ();
                        } finally {
                            if (null != fos) {
                                try {
                                    fos.close ();
                                }catch (IOException ioException) {
                                    ioException.printStackTrace ();
                                }
                            }
                            if (null != oos) {
                                try {
                                    oos.close ();
                                }catch (IOException exception1) {
                                    exception1.printStackTrace ();
                                }
                            }
                        }
                    }finally {
                        try {
                            if (null != ois1) {
                                ois1.close ();
                            }
                        }catch (IOException e) {
                            e.printStackTrace ();
                        }
                    }
                    sign_in();
                }
        }
    }