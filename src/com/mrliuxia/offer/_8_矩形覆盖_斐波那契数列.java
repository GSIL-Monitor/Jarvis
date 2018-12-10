package com.mrliuxia.offer;

import java.util.Scanner;

/**
 * Created by Poker on 2016/11/3.
 */
public class _8_矩形覆盖_斐波那契数列 {

    public int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int f1 = 0;
        int f2 = 1;
        while (n-- > 2) {
            f2 = f1 + f2;
            f1 = f2 - f1;
        }
        return f2;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            System.out.println(new _8_矩形覆盖_斐波那契数列().fibonacci(scan.nextInt()));
        }
    }

}
