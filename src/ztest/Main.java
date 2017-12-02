package ztest;

import java.lang.reflect.Method;

/**
 * Created by coderxiao on 16/8/10.
 */
public class Main {

    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("util.LogUtil");
            Method method = clazz.getMethod("log", String.class, String.class);
            method.invoke(null, "lx", "hello");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}