package com.mrliuxia.jianzhioffer._02_singleton;

/**
 * Created by pokerface_lx on 16/8/5.
 */
public class SingletonBetter {

    private SingletonBetter instance = new SingletonBetter();

    private SingletonBetter() {
    }

    public SingletonBetter getInstance() {
        return instance;
    }

}
