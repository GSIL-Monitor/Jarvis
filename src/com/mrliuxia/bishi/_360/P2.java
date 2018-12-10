package com.mrliuxia.bishi._360;

import java.util.Scanner;

/**
 * Created by pokerface_lx on 16/9/20.
 */
public class P2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            char[][] chars = new char[3][3];
            for (int i = 0; i < 3; i++) {
                String str = scan.nextLine();
                for (int j = 0; j < 3; j++) {
                    chars[i][j] = str.charAt(j);
                }
            }
            boolean flag = true;
            loop:
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 3; j++) {
                    if (chars[i][j]!=chars[2-i][2-j]) {
                        flag = false;
                        break loop;
                    }
                }
            }
            if (flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

}
