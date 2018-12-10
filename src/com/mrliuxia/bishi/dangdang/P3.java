package com.mrliuxia.bishi.dangdang;

import java.util.Scanner;

/**
 * Created by pokerface_lx
 */
public class P3 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int time = scan.nextInt();
            int a = 1;
            int b = 0;
            for (int i = 0; i < time; i++) {
                int temp = a;
                a = b;
                b += temp;
            }
            System.out.println(a + " " + b);
        }
    }

}
