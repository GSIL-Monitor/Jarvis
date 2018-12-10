package com.mrliuxia.reflect;

/**
 * Author: liuxiao
 * Created: 2017/10/20 14:06
 * Description:
 */
public class Target {

    private static Target instance;

    private Target() {

    }

    public static synchronized Target getInstance() {
        if (instance == null) {
            synchronized (Target.class) {
                instance = new Target();
            }
        }
        return instance;
    }

    public void printHello() {
        System.out.println("hello");
    }

}
