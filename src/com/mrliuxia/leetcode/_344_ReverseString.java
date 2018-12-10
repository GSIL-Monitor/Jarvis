package com.mrliuxia.leetcode;

/**
 * Created by Poker on 2016/11/14.
 */
public class _344_ReverseString {

    public static void main(String[] args) {
        System.out.println(new _344_ReverseString().reverseString("asdf"));
    }

    public String reverseString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(s.length() - 1 - i));
        }
        return sb.toString();
    }

}
