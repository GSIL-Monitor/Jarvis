package com.mrliuxia.oj.neuqoj.newoj;

import java.util.Scanner;

/**
 * Author: liuxiao
 * Created: 2017/12/2 18:09
 * Description:
 */
public class P1002 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int n = scan.nextInt();
            for (int i = 0; i < n; i++) {
                System.out.println(scan.nextInt() + scan.nextInt());
            }
        }
    }

}
