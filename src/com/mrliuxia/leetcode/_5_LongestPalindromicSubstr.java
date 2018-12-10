package com.mrliuxia.leetcode;

/**
 * Created by Poker on 2017/2/13.
 */
public class _5_LongestPalindromicSubstr {

    public String longestPalindrome(String s) {
        String res = "";
        int currMaxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s, i - currMaxLen - 1, i)) {
                res = s.substring(i - currMaxLen - 1, i + 1);
                currMaxLen = currMaxLen +2;
            } else if (isPalindrome(s, i - currMaxLen, i)) {
                res = s.substring(i - currMaxLen, i + 1);
                currMaxLen = currMaxLen + 1;
            }
        }
        return res;
    }

    private boolean isPalindrome(String s, int begin, int end) {
        if (begin > end) {
            return false;
        }
        if (begin < 0 || end >= s.length()) {
            return false;
        }
        while (begin < end) {
            if (s.charAt(begin++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

}
