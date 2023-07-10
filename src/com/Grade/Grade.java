package com.Grade;

import com.Student.Student;

import java.io.Serializable;

public  class Grade implements Serializable {
    private static final long serialVersionUID = 20030626430381L;
    public int getMath () {
        return Math;
    }

    public void setMath (int math) {
        Math = math;
    }

    private int Math;//高数

    public int getJava () {
        return Java;
    }

    public void setJava (int java) {
        Java = java;
    }

    private int Java;

    public int getEnglish () {
        return English;
    }

    public void setEnglish (int english) {
        English = english;
    }

    private int English;

    public int getDigital_Electronics () {
        return Digital_Electronics;
    }

    public void setDigital_Electronics (int digital_Electronics) {
        Digital_Electronics = digital_Electronics;
    }

    private int Digital_Electronics;//数电
    public double getAvg() {
        return (getDigital_Electronics () + getMath () + getEnglish () + getJava ())/4;
    }

    public int getPhysics () {
        return physics;
    }

    public void setPhysics (int physics) {
        this.physics = physics;
    }

    private int physics;
    public Grade() {

    }
    public Grade(int math, int English, int Digital_Electronics, int Java, int physics) {
        this.Digital_Electronics = Digital_Electronics;
        this.Math = math;
        this.English = English;
        this.Java = Java;
        this.physics = physics;
    }
    public int getGrade(String s) {
        if (s.equalsIgnoreCase ("Math")) {
            return getMath ();
        }else if (s.equalsIgnoreCase ("Digital_Electronics")) {
            return getDigital_Electronics ();
        }else if (s.equalsIgnoreCase ("java")) {
            return getJava ();
        }else if (s.equalsIgnoreCase ("physics")) {
            return getPhysics ();
        }else if (s.equalsIgnoreCase ("english")){
            return getEnglish ();
        }else {
            System.out.println ("不存在这个科目");
            return 0;
        }
    }
    @Override
    public String toString () {
        return  "Java：" + getJava () +
                " 英语：" +getEnglish () +
                " 数学：" + getMath () +
                " 数电：" + getDigital_Electronics () +
                " 物理：" + getPhysics ();
    }

    public int sumGrade() {
        return getJava () + getEnglish () + getMath () + getDigital_Electronics () + getPhysics ();
    }
}