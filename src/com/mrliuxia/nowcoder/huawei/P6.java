package com.mrliuxia.nowcoder.huawei;

import java.util.Scanner;

/**
 * Created by pokerface_lx on 16/8/12.
 */
public class P6 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int num = scan.nextInt();
            while (num != 1) {
                for (int i = 2; i <= num; i++) {
                    if (num % i == 0) {
                        num /= i;
                        System.out.print(i + " ");
                        break;
                    }
                }
            }
        }
    }

}
