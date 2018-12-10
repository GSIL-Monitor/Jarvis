package com.mrliuxia.model;

/**
 * Created by pokerface_lx on 16/8/24.
 */
public interface Animal {

    public  String hello = "hello";

    default String defaultHello() {
        return "default hello";
    }

    public void say(String s);
}
