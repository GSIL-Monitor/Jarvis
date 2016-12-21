package bishi.didi;

import java.util.Scanner;

/**
 * Created by pokerface_lx on 16/9/18.
 */
public class P2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            System.out.println(count(scan.nextInt()));
        }
    }

    private static int count(int n) {
        if (n == 0 || n < 5) {
            return 0;
        }
        int count = 0;
        for (int i = n; i > 4; i--) {
            int num = i;
            while (num % 5==0&&num > 1) {
                num = num / 5;
                count++;
            }
        }
        return count;
    }

}
