package heiheihei.w0082_simple_operator;

import java.util.Scanner;

/**
 * Created by Poker on 2016/12/21.
 */
public class OperatorUtil {

    public static String add(String originStr, String numStr) {
        double origin = Double.parseDouble(originStr);
        double num = Double.parseDouble(numStr);
        double result = origin + num;
        return removeZeros(String.valueOf(result));
    }

    public static String minus(String originStr, String numStr) {
        double origin = Double.parseDouble(originStr);
        double num = Double.parseDouble(numStr);
        double result = origin - num;
        return removeZeros(String.valueOf(result));
    }

    public static String multiply(String originStr, String numStr) {
        double origin = Double.parseDouble(originStr);
        double num = Double.parseDouble(numStr);
        double result = origin * num;
        return removeZeros(String.valueOf(result));
    }

    public static String divide(String originStr, String numStr) {
        double origin = Double.parseDouble(originStr);
        double num = Double.parseDouble(numStr);
        double result = origin / num;
        return removeZeros(String.valueOf(result));
    }


    public static String removeZeros(String s) {
        int endIndex = s.length() - 1;
        while (s.charAt(endIndex) == '0') {
            endIndex--;
        }
        if (s.charAt(endIndex) == '.') {
            endIndex--;
        }
        return s.substring(0, endIndex + 1);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String s1 = scan.next();
            String op = scan.next();
            String s2 = scan.next();
            switch (op) {
                case "+":
                    System.out.println(add(s1, s2));
                    break;
                case "-":
                    System.out.println(minus(s1, s2));
                    break;
                case "*":
                    System.out.println(multiply(s1, s2));
                    break;
                case "/":
                    System.out.println(divide(s1, s2));
                    break;
            }
        }
    }


}
