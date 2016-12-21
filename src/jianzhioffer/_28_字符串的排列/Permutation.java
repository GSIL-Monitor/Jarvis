package jianzhioffer._28_字符串的排列;

import java.util.Scanner;

/**
 * Created by pokerface_lx on 16/9/14.
 */
public class Permutation {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String str = scan.next();
            permutation(str.toCharArray());
        }
    }

    private static void permutation(char[] chars) {
        if (chars == null || chars.length < 1) {
            return;
        }
        permutation(chars, 0);
        System.out.println();
    }

    private static void permutation(char[] chars, int startIndex) {
        if (startIndex == chars.length - 1) {
            System.out.print(new String(chars) + "");
            return;
        }
        char tempChar;
        for (int i = startIndex; i < chars.length; i++) {
            tempChar = chars[startIndex];
            chars[startIndex] = chars[i];
            chars[i] = tempChar;
            permutation(chars, startIndex + 1);
            tempChar = chars[startIndex];
            chars[startIndex] = chars[i];
            chars[i] = tempChar;
        }
    }

}
