package jianzhioffer._11_power;

import java.util.Scanner;

/**
 * 实现pow函数
 * <p>
 * Created by pokerface_lx on 16/9/12.
 */
public class Power {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            long currentTime = System.currentTimeMillis();
            System.out.println(power_lowb(a, b));
            System.out.println("time:" + (System.currentTimeMillis() - currentTime));
            currentTime = System.currentTimeMillis();
            System.out.println(power(a, b));
            System.out.println("time:" + (System.currentTimeMillis() - currentTime));
        }
    }

    private static double power_lowb(double base, int exponent) {
        double result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }

    private static double power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        if (exponent % 2 == 0) {
            exponent = exponent >> 1;
            return power(base, exponent) * power(base, exponent);
        } else {
            return power(base, exponent) * base;
        }
    }

}
