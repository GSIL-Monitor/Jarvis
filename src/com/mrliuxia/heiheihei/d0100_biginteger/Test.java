package com.mrliuxia.heiheihei.d0100_biginteger;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Poker on 2016/11/29.
 */
public class Test {

    private static Stack<MyBigInteger> numStack = new Stack<>();
    private static Stack<StringBuffer> expressionStack = new Stack<>();
    private static boolean flag = true;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            String str = scan.nextLine();
            if (str.equals("")) {
                if (!flag) {
                    System.out.println("Error --- insufficient operands");
                } else {
                    if (expressionStack.size() == 1 && numStack.size() == 1) {
                        StringBuffer expression = expressionStack.pop();
                        MyBigInteger result = numStack.pop();
                        System.out.println(expression.toString() + "=" + result);
                    } else if (expressionStack.size() > 0 || numStack.size() > 0) {
                        System.out.print("Error --- remaining in stack:");
                        while (numStack.size() > 0) {
                            System.out.print(numStack.pop() + " ");
                        }
                        System.out.println();
                    }
                }
                clear();
                continue;
            }
            String[] s = str.split(" ");
            for (int i = 0; i < s.length; i++) {
                calculate(s[i]);
            }
        }
    }

    private static void calculate(String s) {
        int currExpLevel;
        if (s == "-1") {
            return;
        }
        switch (s) {
            case "+":
                if (numStack.size() < 2 || expressionStack.size() < 2) {
                    flag = false;
                    break;
                }
                currExpLevel = 1;
                MyBigInteger num1 = numStack.pop();
                MyBigInteger num2 = numStack.pop();
                StringBuffer exp1 = expressionStack.pop();
                StringBuffer exp2 = expressionStack.pop();
                if (isExpression(exp1.toString())) {
                    exp1.insert(0, "(").append(")");
                }
                if (isExpression(exp2.toString())) {
                    exp2.insert(0, "(").append(")");
                }
                expressionStack.push(exp2.append("+").append(exp1));
                numStack.push(num1.add(num2));
                break;
            case "*":
                if (numStack.size() < 2 || expressionStack.size() < 2) {
                    flag = false;
                    break;
                }
                currExpLevel = 2;
                MyBigInteger num3 = numStack.pop();
                MyBigInteger num4 = numStack.pop();
                StringBuffer exp3 = expressionStack.pop();
                StringBuffer exp4 = expressionStack.pop();
                if (isExpression(exp3.toString())) {
                    exp3.insert(0, '(').append(')');
                }
                if (isExpression(exp4.toString())) {
                    exp4.insert(0, '(').append(')');
                }
                expressionStack.push(exp4.append('*').append(exp3));
                numStack.push(num3.multiply(num4));
                break;
            case "^":
                if (numStack.size() < 2 || expressionStack.size() < 2) {
                    flag = false;
                    break;
                }
                currExpLevel = 3;
                MyBigInteger num5 = numStack.pop();
                MyBigInteger num6 = numStack.pop();
                StringBuffer exp5 = expressionStack.pop();
                StringBuffer exp6 = expressionStack.pop();
                if (isExpression(exp6.toString())) {
                    exp6.insert(0, '(').append(')');
                }
                expressionStack.push(exp6.append('^').append(exp5));
                numStack.push(num6.exponentiate(num5.toInteger()));
                break;
            default:
                if (s.length() == 0) {
                    break;
                }
                int i = 0;
                for (; i < s.length(); i++) {
                    if (s.charAt(i) != '0') {
                        break;
                    }
                }
                String sub = "";
                if (i == s.length()) {
                    sub = "0";
                } else {
                    sub = s.substring(i);
                }
                numStack.push(new MyBigInteger(sub));
                expressionStack.push(new StringBuffer(sub));
                break;
        }
    }

    private static boolean isExpression(String s) {
        if (s.contains("+") || s.contains("*") || s.contains("^")) {
            return true;
        } else {
            return false;
        }
    }

    private static void clear() {
        numStack = new Stack<>();
        expressionStack = new Stack<>();
        flag = true;
    }
}
