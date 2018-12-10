package com.mrliuxia.leetcode;

import java.util.Scanner;

/**
 * Created by Poker on 2017/1/26.
 */
public class _9_PalindromeNumbers {

    public boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        }
        if (x < 0 || x % 10 == 0) {
            return false;
        }
        String numStr = String.valueOf(x);
        for (int i = 0; i < numStr.length() / 2; i++) {
            if (numStr.charAt(i) != numStr.charAt(numStr.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println(new _9_PalindromeNumbers().isPalindrome(scan.nextInt()));
        }
    }

}
