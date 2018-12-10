package com.mrliuxia.design_pattern.singleton;

/**
 * Description: 懒汉式、线程不安全、没有lazy初始化
 * 最基本的实现方式，这种实现最大的问题就是不支持多线程。因为没有加锁，所以严格意义上它并不算单例模式
 * 这种方式lazy loading很明显，不要求线程安全，再多线程不能正常工作
 * <p>
 * Author: liuxiao
 * Date: 2018/4/4
 */
public class Singleton1 {

    private static Singleton1 instance;

    private Singleton1() {

    }

    public static Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }

}
