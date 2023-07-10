package com.Operation;

import com.Login.Login1.LoginMaster;
import com.Login.Login1.LoginStudent;
import com.Login.Login1.LoginTeacher;
import com.User.User;

import java.io.*;
import java.util.*;

public class Change {

    public void deleteStudent() {
        //删除学生--此权限仅管理员拥有
        Map<Integer, User> map2 = new TreeMap<> ();
        System.out.println ("请输入要删除学生对应的学号");
        Scanner scanner = new Scanner (System.in);
        int num = scanner.nextInt ();
        ObjectInputStream ois = null;

        try {
            //反序列化
            ois = new ObjectInputStream (new FileInputStream ("C:\\Users\\杨骜捷\\IdeaProjects\\ProjectFinal\\src\\com\\Operation\\Student"));
            map2 = (TreeMap) ois.readObject ();
            System.out.println (map2.remove (num));
            //序列化
            ObjectOutputStream oos_del = null;
            try {
                FileOutputStream fos_del = new FileOutputStream ("C:\\Users\\杨骜捷\\IdeaProjects\\ProjectFinal\\src\\com\\Operation\\Student");
                oos_del = new ObjectOutputStream (fos_del);
                oos_del.writeObject (map2);
                System.out.println ("删除成功");
                oos_del.flush ();
            }catch (FileNotFoundException e) {
                e.printStackTrace ();
            }finally {
                try {
                    if (null != oos_del) {
                        oos_del.close ();
                    }
                }catch (IOException e) {
                    e.printStackTrace ();
                }
            }
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
    }

    public void changeStudent_t() {
        //老师修改学生
        ObjectInputStream ois1 = null;
        try {
            //先将map反序列化出来
            ois1 = new ObjectInputStream (new FileInputStream ("src\\com\\Operation\\Student"));
            Map<Integer, User> map3 = (TreeMap) ois1.readObject ();
            Scanner scanner = new Scanner (System.in);
            System.out.println ("输入要修改学生的学号");
            int num1 = scanner.nextInt ();
            if (map3.get (num1) != null && num1>2018000001 && num1 < 10000000000L) {
                User student1 = map3.get (num1);
                System.out.println (student1);
                System.out.println ("然后请输入对应数字来确定修改部分");
                System.out.println ("1-密码 2-生日 3-电话号码 4-居住寝室 5-专业 6-性别 7-家乡省份 8-储存，退出 ");
                switch (scanner.next ()) {
                    case "1":
                        System.out.println (student1.getPassword ());
                        System.out.println ("输入修改的密码");
                        student1.setPassword (scanner.next ());
                        //通过num（key）来存储User对象
                        map3.put (num1, student1);
                        inputStudent (map3);
                        break;
                    case "2":
                        System.out.println (student1.getBirthday ());
                        System.out.println ("输入修改的生日");
                        student1.setBirthday (scanner.nextInt ());
                        map3.put (num1, student1);
                        inputStudent (map3);
                        break;
                    case "3":
                        System.out.println (student1.getPhone_number ());
                        System.out.println ("输入修改的电话号码或者邮箱地址");
                        student1.setPhone_number (scanner.next ());
                        map3.put (num1, student1);
                        inputStudent (map3);
                        break;
                    case "4":
                        System.out.println (student1.getResidential_Address ());
                        System.out.println ("输入修改的居住寝室  ");
                        student1.setResidential_Address (scanner.next ());
                        map3.put (num1, student1);
                        inputStudent (map3);
                        break;
                    case "5":
                        System.out.println (student1.getMajor ());
                        System.out.println ("输入修改至的专业");
                        student1.setMajor (scanner.next ());
                        map3.put (num1, student1);
                        inputStudent (map3);
                        break;
                    case "6":
                        System.out.println (student1.getSex ());
                        System.out.println ("输入修改至的性别");
                        student1.setSex (scanner.next ());
                        map3.put (num1, student1);
                        inputStudent (map3);
                        break;
                    case "7":
                        System.out.println (student1.getProvince ());
                        System.out.println ("输入修改的家乡省份");
                        student1.setProvince (scanner.next ());
                        map3.put (num1, student1);
                        inputStudent (map3);
                        break;
                    default:
                        new LoginTeacher ().login ();
                        break;

                }
            }else {
                changeStudent_t ();
            }
        }catch (IOException | ClassNotFoundException e) {
           e.printStackTrace ();
        }finally {
            try {
                if (null != ois1) {
                    ois1.close ();
                }
            } catch (IOException e) {
                e.printStackTrace ();
            }
        }
        new LoginTeacher ().login ();

    }
    public void changeStudent(int num1) {
        Map<Integer, User> map2 = null;
        //学生修改自己
        ObjectInputStream ois = null;
        try {//先将map反序列化出来
            ois = new ObjectInputStream (new FileInputStream ("src\\com\\Operation\\Student"));
            map2 = (TreeMap) ois.readObject ();
            Scanner scanner = new Scanner (System.in);
            User student1 = map2.get (num1);
            System.out.println (student1);
            System.out.println ("然后请输入对应数字来确定修改部分");
            System.out.println ("1-密码 2-生日 3-电话号码或者邮箱地址 4-居住寝室 5-退出");

            int x = scanner.nextInt ();
            switch (x) {
                case 1:
                    System.out.println (student1.getPassword ());
                    System.out.println ("输入修改的密码");
                    student1.setPassword (scanner.next ());
                    //通过num（key）来存储
                    map2.put (num1, student1);
                    FileOutputStream fosm = null;
                    ObjectOutputStream oosm = null;
                    try {
                        //序列化
                        fosm = new FileOutputStream ("src\\com\\Operation\\Student");
                        oosm = new ObjectOutputStream (fosm);
                        oosm.writeObject (map2);
                        oosm.flush ();
                    } catch (IOException e){
                        e.printStackTrace ();
                    } finally {
                        if (null != fosm) {
                            try {
                                fosm.close ();
                            }catch (IOException e) {
                                e.printStackTrace ();
                            }
                        }
                        if (null != oosm) {
                            try {
                                oosm.close ();
                            }catch (IOException e) {
                                e.printStackTrace ();
                            }
                        }
                    }
                    new LoginStudent().login (num1);
                    break;
                case 2:
                    System.out.println (student1.getBirthday ());
                    System.out.println ("输入修改的生日");
                    student1.setBirthday (scanner.nextInt ());
                    map2.put (num1, student1);
                    FileOutputStream fosm1 = null;
                    ObjectOutputStream oosm1 = null;
                    try {
                        fosm1 = new FileOutputStream ("src\\com\\Operation\\Student");
                        oosm1 = new ObjectOutputStream (fosm1);
                        oosm1.writeObject (map2);
                        oosm1.flush ();
                    } catch (IOException e){
                        e.printStackTrace ();
                    } finally {
                        if (null != fosm1) {
                            try {
                                fosm1.close ();
                            }catch (IOException e) {
                                e.printStackTrace ();
                            }
                        }
                        if (null != oosm1) {
                            try {
                                oosm1.close ();
                            }catch (IOException e) {
                                e.printStackTrace ();
                            }
                        }
                    }
                    new LoginStudent().login (num1);
                    break;
                case 3:
                    System.out.println (student1.getPhone_number ());
                    System.out.println ("输入修改的电话号码或者邮箱地址");
                    student1.setPhone_number (scanner.next ());
                    map2.put (num1, student1);
                    FileOutputStream fosm2 = null;
                    ObjectOutputStream oosm2 = null;
                    try {
                        fosm2 = new FileOutputStream ("src\\com\\Operation\\Student");
                        oosm2 = new ObjectOutputStream (fosm2);
                        oosm2.writeObject (map2);
                        oosm2.flush ();
                    } catch (IOException e){
                        e.printStackTrace ();
                    } finally {
                        if (null != fosm2) {
                            try {
                                fosm2.close ();
                            }catch (IOException e) {
                                e.printStackTrace ();
                            }
                        }
                        if (null != oosm2) {
                            try {
                                oosm2.close ();
                            }catch (IOException e) {
                                e.printStackTrace ();
                            }
                        }
                    }
                    new LoginStudent().login (num1);
                    break;
                case 4:
                    System.out.println (student1.getResidential_Address ());
                    System.out.println ("输入修改的居住地址");
                    student1.setResidential_Address (scanner.next ());
                    new LoginStudent().login ();
                    map2.put (num1, student1);
                    FileOutputStream fosm3 = null;
                    ObjectOutputStream oosm3 = null;
                    try {
                        fosm3 = new FileOutputStream ("src\\com\\Operation\\Student");
                        oosm3 = new ObjectOutputStream (fosm3);
                        oosm3.writeObject (map2);
                        oosm3.flush ();
                    } catch (IOException e){
                        e.printStackTrace ();
                    } finally {
                        if (null != fosm3) {
                            try {
                                fosm3.close ();
                            }catch (IOException e) {
                                e.printStackTrace ();
                            }
                        }
                        if (null != oosm3) {
                            try {
                                oosm3.close ();
                            }catch (IOException e) {
                                e.printStackTrace ();
                            }
                        }
                    }
                    new LoginStudent().login (num1);
                    break;
                case 5:
                    System.out.println ("退出");
                    new LoginStudent ().login (num1);
            }
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
    }
    public void changeStudent_m() {
        //管理员修改学生
        ObjectInputStream ois1 = null;
        try {
            //先将map反序列化出来
            ois1 = new ObjectInputStream (new FileInputStream ("src\\com\\Operation\\Student"));
            Map<Integer, User> map3 = (TreeMap) ois1.readObject ();
            Scanner scanner = new Scanner (System.in);
            System.out.println ("输入要修改学生的学号");
            int num1 = scanner.nextInt ();
           if(map3.get (num1) != null) {
               User student1 = map3.get (num1);
               System.out.println (student1);
               System.out.println ("然后请输入对应数字来确定修改部分");
               System.out.println ("1-密码 2-居住寝室 3-学科 4-家乡省份 5-姓名 else-储存，退出 ");
               String x = scanner.next ();
               switch (x) {
                   case "1":
                       System.out.println (student1.getPassword ());
                       System.out.println ("输入修改的密码");
                       student1.setPassword (scanner.next ());
                       //通过num（key）来存储User对象
                       map3.put (num1, student1);
                       inputStudent (map3);
                       break;
                   case "2":
                       System.out.println (student1.getResidential_Address ());
                       System.out.println ("输入修改的居住寝室  ");
                       student1.setResidential_Address (scanner.next ());
                       map3.put (num1, student1);
                       inputStudent (map3);
                       break;
                   case "3":
                       System.out.println (student1.getMajor ());
                       System.out.println ("输入修改至的学科");
                       student1.setMajor (scanner.next ());
                       map3.put (num1, student1);
                       inputStudent (map3);
                       break;
                   case "4":
                       System.out.println (student1.getProvince ());
                       System.out.println ("输入修改的家乡省份");
                       student1.setProvince (scanner.next ());
                       map3.put (num1, student1);
                       inputStudent (map3);
                       break;
                   case "5":
                       System.out.println (student1.getName ());
                       System.out.println ("输入修改的姓名");
                       student1.setName (scanner.next ());
                       map3.put (num1, student1);
                       inputStudent (map3);
                       break;
                   default:
                       changeStudent_m ();
                       break;

               }
           }else {
               System.out.println ("不存在该学生");
               changeStudent_m ();
           }
        }catch (IOException | ClassNotFoundException e) {
            System.out.println ("不存在该学生");
            changeStudent_m ();
        }finally {
            try {
                if (null != ois1) {
                    ois1.close ();
                }
            } catch (IOException e) {
                e.printStackTrace ();
            }
        }
        new LoginMaster ().login ();

    }
    private void inputStudent(Map map3) {
        FileOutputStream fosm3 = null;
        ObjectOutputStream oosm3 = null;
        try {
            fosm3 = new FileOutputStream ("src\\com\\Operation\\Student");
            oosm3 = new ObjectOutputStream (fosm3);
            oosm3.writeObject (map3);
            oosm3.flush ();
        } catch (IOException e){
            e.printStackTrace ();
        } finally {
            if (null != fosm3) {
                try {
                    fosm3.close ();
                }catch (IOException e) {
                    e.printStackTrace ();
                }
            }
            if (null != oosm3) {
                try {
                    oosm3.close ();
                }catch (IOException e) {
                    e.printStackTrace ();
                }
            }
        }
    }
}