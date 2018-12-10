package com.mrliuxia.oj.neuqoj.newoj;

import java.util.Scanner;

/**
 * Author: liuxiao
 * Created: 2017/12/2 18:24
 * Description:
 */
public class P1004 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int sum, n;
        while (scan.hasNext()) {
            sum = 0;
            n = scan.nextInt();
            if (n == 0) {
                return;
            } else {
                for (int i = 0; i < n; i++) {
                    sum += scan.nextInt();
                }
                System.out.println(sum);
            }
        }
    }

}
