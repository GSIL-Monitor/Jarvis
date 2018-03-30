package neuqoj.oldoj;

import java.util.Scanner;

/**
 * Created by Poker on 2016/11/20.
 */
public class P1134 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            int line = scan.nextInt();
            int remix = scan.nextInt();
            for (int j = 0; j < remix; j++) {
                for (int k = 0; k < line - 1; k++) {
                    for (int l = 0; l < line / 2 - Math.abs(k - line / 2); l++) {
                        System.out.print(' ');
                    }
                    System.out.print('X');
                    if (k == line / 2) {
                        System.out.println();
                        continue;
                    }
                    for (int l = 0; l < Math.abs(2 * (k-line/2)) - 1; l++) {
                        System.out.print(' ');
                    }
                    System.out.println('X');
                }
            }
            System.out.print('X');
            for (int j = 0; j < line - 2; j++) {
                System.out.print(' ');
            }
            System.out.println('X');
            if (i != n - 1) {
                System.out.println();
            }
        }
    }

}
