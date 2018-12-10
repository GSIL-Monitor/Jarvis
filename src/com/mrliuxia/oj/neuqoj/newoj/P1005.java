package com.mrliuxia.oj.neuqoj.newoj;

import java.util.Scanner;

/**
 * Author: liuxiao
 * Created: 2017/12/2 18:29
 * Description:
 */
public class P1005 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int n = scan.nextInt();
            int count;
            for (int i = 0; i < n; i++) {
                int m = scan.nextInt();
                count = 0;
                for (int j = 0; j < m; j++) {
                    count += scan.nextInt();
                }
                System.out.println(count);
            }
        }
    }

}
