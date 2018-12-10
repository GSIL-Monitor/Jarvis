package com.mrliuxia.design_pattern.singleton;

/**
 * Description: 饿汉式、线程安全、没有lazy初始化
 * 基于classloader机制避免了多线程同步的问题，不过，instance在类装载时就实例话，虽然导致类装载的原因有很多种，
 * 在单例模式中大多数都是调用getInstance方法，但是也不能确定是否有其他的方式（或者其他的静态方法）导致类装载，
 * 这时候初始化instance显然没有达到lazy loading的效果
 * 优点：没有加锁，执行效率会提高
 * 缺点：类加载时就初始化，浪费内存
 * <p>
 * Author: liuxiao
 * Date: 2018/4/4
 */
public class Singleton3 {

    private static Singleton3 instance = new Singleton3();

    private Singleton3() {

    }

    public static Singleton3 getInstance() {
        return instance;
    }

}
