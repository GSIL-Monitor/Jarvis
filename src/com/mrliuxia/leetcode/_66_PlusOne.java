package com.mrliuxia.leetcode;

import java.util.Arrays;

/**
 * Created by Poker on 2017/1/30.
 */
public class _66_PlusOne {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] res = new int[digits.length + 1];
        res[0]=1;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new _66_PlusOne().plusOne(new int[]{1, 2, 9})));
    }

}
