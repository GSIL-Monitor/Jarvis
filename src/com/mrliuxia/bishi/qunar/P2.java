package com.mrliuxia.bishi.qunar;

import java.util.*;

/**
 * 完全二叉树
 * Created by pokerface_lx on 16/9/20.
 */
public class P2 {

    private static List<String> strList;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String str = scan.nextLine();
            List<Character> list = new ArrayList<>();
            for (int i = 2; i < str.length(); i = i + 5) {
                list.add(str.charAt(i));
            }
            int height = 0;
            int n = list.size();
            while (n > 0) {
                n = n >> 1;
                height++;
            }

            strList = new ArrayList<>();
            int currIndex = 0;
            loop:
            for (int i = 0; i < height; i++) {
                int preLength = (int) Math.pow(2, height - 1 - i) - 1;
                // 字母
                printBlank(preLength);
                for (int j = 0; j < Math.pow(2, i); j++) {
                    if (currIndex >= list.size()) {
                        printBlank(1);
                    } else {
                        printChar(list.get(currIndex));
                    }
                    printBlank(preLength * 2 + 1);
                    currIndex++;
                }
                println();
                if (currIndex >= list.size()) {
                    break;
                }
                // 斜线
                for (int j = 0; j < Math.pow(2, height - i - 2); j++) {
                    printBlank(preLength - j - 1);
                    for (int k = 0; k < Math.pow(2, i); k++) {
                        if (k != 0) {
                            printBlank(preLength * 2 - j * 2 - 1);
                        }
                        if (Math.pow(2, i + 1) - 2 + 2 * k + 1 < list.size()) {
                            printChar('/');
                        } else {
                            printBlank(1);
                        }
                        printBlank(j * 2 + 1);
                        if (Math.pow(2, i + 1) - 2 + 2 * k + 2 < list.size()) {
                            printChar('\\');
                        } else {
                            printBlank(1);
                        }
                    }
                    printBlank(preLength - j);
                    println();
                }
            }
            for (String s: strList) {
                System.out.println(new StringBuffer(s).reverse().toString());
            }
        }
    }

    private static void printBlank(int length) {
        for (int i = 0; i < length; i++) {
            System.out.print(" ");
            if (strList.size() == 0) {
                strList.add("");
            }
            else if (strList.get(strList.size() - 1).length() == 0) {
                strList.set(strList.size()-1," ");
            } else {
                strList.set(strList.size() - 1, strList.get(strList.size() - 1) + " ");
            }
        }
    }

    private static void printChar(char c) {
        System.out.print(c);
        if (strList.size() == 0) {
            strList.add("");
        }
        else if (strList.get(strList.size() - 1).length() == 0) {
            strList.set(strList.size()-1,c+"");
        } else {
            strList.set(strList.size() - 1, strList.get(strList.size() - 1) + c);
        }
    }

    private static void println() {
        System.out.println();
        strList.add("");
    }
}
