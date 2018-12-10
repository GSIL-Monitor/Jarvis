package com.mrliuxia.design_pattern.singleton;

/**
 * Description: 懒汉式、线程安全、lazy初始化
 * 这种方式具备很好的lazy loading，能够在多线程中很好的工作，但是，效率很低，99%的情况下不需要同步
 * 优点：第一次调用才初始化，避免内存浪费
 * 缺点：必须加锁才能保证单例，但加锁会影响效率
 * getInstance()的性能对应用程序不是很关键（该方法使用不太频繁）
 * <p>
 * Author: liuxiao
 * Date: 2018/4/4
 */
public class Singleton2 {

    private static Singleton2 instance;

    private Singleton2() {

    }

    public static synchronized Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }

}
