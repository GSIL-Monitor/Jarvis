package com.mrliuxia.design_pattern.dynamic_proxy;

/**
 * Created by Poker on 2016/11/9.
 */
public class ConcreteClass implements TargetInterface {

    @Override
    public int targetMethodA(int num) {
        System.out.println("method a start---");
        System.out.println("num:" + num);
        System.out.println("method a end.");
        return num;
    }

    @Override
    public int targetMethodB(int num) {
        System.out.println("method b start---");
        System.out.println("num" + num);
        System.out.println("method b end.");
        return num;
    }
}
