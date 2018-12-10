package com.mrliuxia.util;

/**
 * Author: liuxiao
 * Created: 2017/10/19 17:09
 * Description:
 */
public class LogUtil {

    public static void log(String tag, String content) {
        System.out.println(tag + ": " + content);
    }

    public static void log(String tag, Exception e) {
        log(tag, e.getMessage());
        e.printStackTrace();
    }

}
