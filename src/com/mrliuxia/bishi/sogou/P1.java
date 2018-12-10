package com.mrliuxia.bishi.sogou;

import java.util.Scanner;

/**
 * Created by pokerface_lx on 16/9/12.
 */
public class P1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String str = scan.next();
            int length = longestSubStrLength(str);
            if (length % 2 == 0) {
                System.out.println(length / 2);
            } else {
                System.out.println((length - 1) / 2);
            }
        }
    }

    private static int longestSubStrLength(String str) {
        if (str == null) {
            return 0;
        }
        if (str.length() <= 1) {
            return str.length();
        }
        int longest = 1;
        loop:
        for (int i = 0; i < str.length(); i++) {
            for (int j = 1; isValid(str, i + j) && isValid(str, i - j); j++) {
//                if (isBroad(str,i+j) || isBroad(str, i-j)) {
//                    if (str.charAt(i + j) == str.charAt(i - j)) {
//                        int length = j * 2 + 1;
//                        longest = longest < length ? length : longest;
//                        continue loop;
//                    }
//                }
                if (str.charAt(i + j) == str.charAt(i - j)) {
                    int length = j * 2 + 1;
                    longest = longest < length ? length : longest;
                } else {
                    continue loop;
                }
            }
        }
        loop:
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) != str.charAt(i + 1)) {
                continue loop;
            }
            for (int j = 1; isValid(str, i + 1 + j) && isValid(str, i - j); j++) {
                if (str.charAt(i + 1 + j) == str.charAt(i - j)) {
                    int length = j * 2 + 2;
                    longest = longest < length ? length : longest;
                } else {
                    continue loop;
                }
            }
        }
        return longest;
    }

    private static boolean isValid(String str, int index) {
        if (index >= 0 && index < str.length()) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isBroad(String str, int index) {
        if (index == 0 || index == str.length() - 1) {
            return true;
        } else {
            return false;
        }
    }
}
