package com.mrliuxia.model;

/**
 * Created by pokerface_lx on 16/8/16.
 */
public class Student implements Cloneable {

    public Integer age;
    public String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "age:" + age + " name:" + name;
    }

    @Override
    public Object clone() {
        Student stu = null;
        try {
            stu = (Student) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
//        stu.name = new String(this.name);
        return stu;
    }
}
