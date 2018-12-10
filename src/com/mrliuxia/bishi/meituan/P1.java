package com.mrliuxia.bishi.meituan;

import java.util.Scanner;

/**
 * Created by pokerface_lx on 16/9/9.
 */
public class P1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int money = scan.nextInt();
            int count = 0;
            for (int i = 0; i * 100 <= money; i++) {
                for (int j = 0; (i * 100 + j * 50) <= money; j++) {
                    for (int k = 0; (i * 100 + j * 50 + k * 20) <= money; k++) {
                        for (int l = 0; (i * 100 + j * 50 + k * 20 + l * 10) <= money; l++) {
                            for (int m = 0; (i * 100 + j * 50 + k * 20 + l * 10 + m * 5) <= money; m++) {
                                count++;
                            }
                        }

                    }
                }
            }
            System.out.println(count);
        }

    }
}