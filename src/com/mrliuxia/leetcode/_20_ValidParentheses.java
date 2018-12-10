package com.mrliuxia.leetcode;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Poker on 2016/11/14.
 */
public class _20_ValidParentheses {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            System.out.println(new _20_ValidParentheses().isValid(scan.next()));
        }
    }

    public boolean isValid(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case ')':
                    if (stack.size() == 0 || stack.peek() != '(') {
                        return false;
                    } else {
                        stack.pop();
                    }
                    break;
                case ']':
                    if (stack.size() == 0 || stack.peek() != '[') {
                        return false;
                    } else {
                        stack.pop();
                    }
                    break;
                case '}':
                    if (stack.size() == 0 || stack.peek() != '{') {
                        return false;
                    } else {
                        stack.pop();
                    }
                    break;
                default:
                    stack.push(s.charAt(i));
                    break;
            }
        }
        if (stack.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

}
