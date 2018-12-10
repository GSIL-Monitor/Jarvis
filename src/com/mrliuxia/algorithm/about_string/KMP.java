package com.mrliuxia.algorithm.about_string;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Author: liuxiao
 * Created: 2017/12/1 17:39
 * Description: 字符串匹配算法
 */
public class KMP {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String haystack = scan.next();
            String needle = scan.next();
            doFind(haystack, needle);
        }
    }

    public static void doFind(String source, String pattern) {
        System.out.println("pattern: " + Arrays.toString(pattern.toCharArray()));
        System.out.println("next:    " + Arrays.toString(getNext(pattern.toCharArray())));
        System.out.println("index: " + find(source.toCharArray(), pattern.toCharArray()));
    }

    public static int find(char[] source, char[] pattern) {
        int i = 0, j = 0;
        int sLen = source.length;
        int pLen = pattern.length;
        int[] next = getNext(pattern);
        while (i < sLen && j < pLen) {
            if (j == -1 || source[i] == pattern[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == pLen) {
            return i - j;
        }
        return -1;
    }

    private static int[] getNext(char[] charSeq) {
        int[] next = new int[charSeq.length];
        next[0] = -1;
        int i = 1;
        int k = -1;
        while (i < charSeq.length - 1) {
            if (k == -1 || charSeq[i] == charSeq[k]) {
                i++;
                k++;
                next[i] = k;
            } else {
                k = next[k];
            }
        }
        return next;
    }

}
