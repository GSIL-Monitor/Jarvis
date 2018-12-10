package com.mrliuxia.jianzhioffer._04_replace_blank;

import java.util.Arrays;

/**
 * Created by pokerface_lx on 16/8/5.
 */
public class ReplaceBlank {

    public static void main(String[] args) {
        String str = " we are happy. ";
        replaceBlankByArr(str);
        replaceBlankBySB(str);
    }

    private static void replaceBlankByArr(String str) {
        int blankNum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                blankNum++;
            }
        }
        char[] chars = new char[str.length() + blankNum * 2];
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                chars[index++] = '%';
                chars[index++] = '2';
                chars[index++] = '0';
            } else {
                chars[index++] = str.charAt(i);
            }
        }
        System.out.println(String.valueOf(chars));
    }

    private static void replaceBlankBySB(String str) {
        String[] splStr = str.split(" ");
        StringBuffer sb = new StringBuffer();
        for (String s : splStr) {
            sb.append(s).append("%20");
        }
        System.out.println(sb.toString());
    }

}
