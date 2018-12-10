package com.mrliuxia.leetcode;

import java.util.Scanner;

/**
 * Created by Poker on 2017/2/15.
 */
public class _58_LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        s = s.trim();
        return s.length() - 1 - s.lastIndexOf(' ');
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            System.out.println(new _58_LengthOfLastWord().lengthOfLastWord(scan.nextLine()));
        }
    }

}
