package com.mrliuxia.oj.neuqoj.newoj;

import java.util.Scanner;

/**
 * Author: liuxiao
 * Created: 2017/12/2 18:12
 * Description:
 */
public class P1003 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            if (a == 0 && b == 0) {
                return;
            } else {
                System.out.println(a + b);
            }
        }
    }

}
