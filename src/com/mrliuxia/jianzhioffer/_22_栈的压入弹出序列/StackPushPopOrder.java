package com.mrliuxia.jianzhioffer._22_栈的压入弹出序列;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by pokerface_lx on 16/9/13.
 */
public class StackPushPopOrder {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String pushStr = scan.next();
            String popStr = scan.next();
            System.out.println(isPopOrder(pushStr, popStr));
        }
    }

    private static boolean isPopOrder(String pushStr, String popStr) {
        if (pushStr.length() != popStr.length()) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        int pushIndex = 0;
        int popIndex = 0;
        int length = pushStr.length();
        while (pushIndex < length) {
            if (stack == null || stack.size() == 0) {
                stack.push(pushStr.charAt(pushIndex++));
            }
            while (pushIndex < length && stack.peek() != popStr.charAt(popIndex)) {
                stack.push(pushStr.charAt(pushIndex++));
            }
            while (stack.size() > 0 && stack.peek() == popStr.charAt(popIndex)) {
                stack.pop();
                popIndex++;
            }
        }
        if (popIndex != length) {
            return false;
        } else {
            return true;
        }
    }

    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA.length != popA.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int pushIndex = 0;
        int popIndex = 0;
        int length = pushA.length;
        while (pushIndex < length) {
            if (stack == null || stack.size() == 0) {
                stack.push(pushA[pushIndex++]);
            }
            while (pushIndex < length && stack.peek() != popA[popIndex]) {
                stack.push(pushA[pushIndex++]);
            }
            while (stack.size() > 0 && stack.peek() == popA[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        if (popIndex != length) {
            return false;
        } else {
            return true;
        }
    }

}
