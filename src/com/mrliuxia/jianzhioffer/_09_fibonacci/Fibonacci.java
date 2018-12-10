package com.mrliuxia.jianzhioffer._09_fibonacci;

/**
 * Created by pokerface_lx on 16/9/12.
 */
public class Fibonacci {

    public static void main(String[] args) {
        long currentTime = System.currentTimeMillis();
        System.out.println("slow:" + fibonacci_slow(50));
        System.out.println("time:" + (System.currentTimeMillis() - currentTime));
        currentTime = System.currentTimeMillis();
        System.out.println("quick:" + fibonacci_quick(51));
        System.out.println("time:" + (System.currentTimeMillis() - currentTime));
    }

    private static int fibonacci_quick(int n) {
        int[] result = {0, 1};
        if (n < 2) {
            return result[n];
        }
        int a = 0;
        for (int i = 2; i < n; i++) {
            a = result[0] + result[1];
            result[0] = result[1];
            result[1] = a;
        }
        return a;
    }

    private static int fibonacci_slow(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci_slow(n - 1) + fibonacci_slow(n - 2);
    }

}
