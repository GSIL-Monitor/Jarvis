package com.mrliuxia.jianzhioffer._45_圆圈中最后剩下的数字;

/**
 * Created by pokerface_lx on 16/9/16.
 */
public class LastRemaining {

    public static void main(String[] rags) {

        System.out.println(lastRemaining(5,1));
    }

    private static int lastRemaining(int n, int m) {
        if (n == 1) {
            return 0;
        } else {
            return (lastRemaining(n - 1, m) + m) % n;
        }
    }

}
