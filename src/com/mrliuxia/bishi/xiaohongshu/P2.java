package com.mrliuxia.bishi.xiaohongshu;

import java.util.Scanner;

/**
 * Created by Poker on 2016/10/30.
 */
public class P2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            String oriStr = scan.nextLine();
            fix(oriStr);
        }

    }

    private static void fix(String oriStr) {
        char[] res = new char[oriStr.length()];
        int index = 0;
        for (int i = 0; i < oriStr.length(); i++) {
            if (i < oriStr.length() - 2 && oriStr.charAt(i) == 'a'
                    && oriStr.charAt(i + 1) == 'b' && oriStr.charAt(i + 2) == 'c') {
                i = i + 2;
            } else {
                res[index++] = oriStr.charAt(i);
            }
        }
        for (int i = 0; i < index; i++) {
            System.out.print(res[i]);
        }
    }

}
