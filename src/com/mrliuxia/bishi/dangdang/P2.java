package com.mrliuxia.bishi.dangdang;

import java.util.Scanner;

/**
 * Created by pokerface_lx
 */
public class P2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int num = scan.nextInt();
            System.out.println(lastRemaining(num, 3) + 1);
        }
    }

    private static int lastRemaining(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }

}
