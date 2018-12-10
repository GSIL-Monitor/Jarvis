package com.mrliuxia.oj.neuqoj.newoj;

import java.util.Scanner;

/**
 * Author: liuxiao
 * Created: 2017/12/2 18:05
 * Description:
 */
public class P1829 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int size = scan.nextInt();
            int count = 0;
            for (int i = 0; i < size; i++) {
                if (scan.nextInt() <= 35) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

}
