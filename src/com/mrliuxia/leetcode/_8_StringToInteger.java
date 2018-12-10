package com.mrliuxia.leetcode;

import java.util.Scanner;

/**
 * Created by Poker on 2016/11/13.
 */
public class _8_StringToInteger {

    public static void main(String[] args) {
        System.out.println((char)87);
        Scanner scan = new Scanner(System.in);
        _8_StringToInteger sti = new _8_StringToInteger();
        while (scan.hasNext()) {
            System.out.println(sti.myAtoi(scan.next()));
        }
    }

    public int myAtoi(String str) {
        if (str.length() == 0) {
            return 0;
        }
        long res = 0l;
        boolean isPositive = true;
        boolean isBegan = false;
        for (int i = 0; i < str.length(); i++) {
            if (!isBegan && str.charAt(i) == ' ') {
                continue;
            }
            if (!isBegan && str.charAt(i) == '+') {
                isPositive = true;
                isBegan = true;
                continue;
            }
            if (!isBegan && str.charAt(i) == '-') {
                isPositive = false;
                isBegan = true;
                continue;
            }
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                break;
            }
            res = res * 10 + (str.charAt(i) - '0');
            isBegan = true;
            if (res > Integer.MAX_VALUE || -res < Integer.MIN_VALUE) {
                break;
            }
        }
        if (isPositive) {
            if (res > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else {
                return (int) res;
            }
        } else {
            if (-res < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            } else {
                return -(int) res;
            }
        }
    }

}
