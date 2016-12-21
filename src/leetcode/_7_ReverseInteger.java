package leetcode;

import java.util.Scanner;

/**
 * Created by Poker on 2016/11/13.
 */
public class _7_ReverseInteger {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            System.out.println(new _7_ReverseInteger().reverse(scan.nextInt()));
        }
    }

    public int reverse(int x) {
        boolean isPositive = x > 0 ? true : false;
        long res = 0;
        String s = String.valueOf(x);
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                break;
            }
            res = res * 10 + (s.charAt(i) - '0');
            if ((isPositive && res > Integer.MAX_VALUE) || (!isPositive && -res < Integer.MIN_VALUE)) {
                return 0;
            }
        }
        if (isPositive) {
            return (int) res;
        } else {
            return -(int) res;
        }
    }

}
