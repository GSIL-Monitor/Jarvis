package com.mrliuxia.bishi.qunar;

import java.util.Scanner;

/**
 * 最长公共子串
 * Created by pokerface_lx on 16/9/20.
 */
public class P3 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String str1 = scan.next().toLowerCase();
            String str2 = scan.next().toLowerCase();
            int len1 = str1.length();
            int len2 = str2.length();
            int[][] maxArr = new int[len1][len2];
            int maxLen = 0;
            int maxIndex = 0;
            for (int i = 0; i < len1; i++) {
                for (int j = 0; j < len2; j++) {
                    if (i == 0 || j == 0) {
                        maxArr[i][j] = 0;
                        continue;
                    }
                    if (str1.charAt(i) == str2.charAt(j)) {
                        maxArr[i][j] = maxArr[i - 1][j - 1] + 1;
                        if (maxArr[i][j] > maxLen) {
                            maxLen = maxArr[i][j];
                            maxIndex = i;
                        }
                    } else {
                        maxArr[i][j] = 0;
                    }
                }
            }
            System.out.println(str1.substring(maxIndex - maxLen + 1, maxIndex + 1));
        }
    }

}

//            int maxLen = len1>len2?len1:len2;
//            int[] maxArr = new int[maxLen];
//            int[] maxIndex = new int[maxLen];
//            int[] c = new int[maxLen];
//            for (int i = 0; i < len1; i++) {
//                for (int j = 0; j < len2; j++) {
//                    if (str1.charAt(i) == str2.charAt(j)) {
//                        if (i==0||j==0) {
//                            c[j] = 1;
//                        } else {
//                            c[j] = c[j-1]+1
//                        }
//                    } else {
//                        c[j] = 0
//                    }
//                }
//            }
