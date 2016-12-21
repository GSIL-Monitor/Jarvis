package bishi.jd;

import java.util.Scanner;

/**
 * Created by pokerface_lx on 16/9/5.
 */

public class P1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int num = scan.nextInt();
            int sum = 0;
            for (int radix = 2; radix < num; radix++) {
                String numStr = Integer.toString(num, radix);
                for (int i = 0; i < numStr.length(); i++) {
                    sum += charNum(numStr.charAt(i));
                }
            }
            int gcd = gcd(sum, num - 2);
            int fm = sum / gcd;
            int fz = (num - 2) / gcd;
            System.out.println(fm + "/" + fz);
        }
    }

    private static int charNum(char c) {
        if (c >= '0' && c <= '9') {
            return (int) (c - '0');
        } else {
            return (int) (c - 'a') + 10;
        }
    }

    private static int gcd(int num1, int num2) {
        while (num2 != 0) {
            int temp = num1 % num2;
            num1 = num2;
            num2 = temp;
        }
        return num1;
    }

}
