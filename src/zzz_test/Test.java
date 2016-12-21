package zzz_test;

import java.util.Scanner;

/**
 * Created by zzz_test.Poker on 2016/11/20.
 */
public class Test {
    public static void main(String[] args) {
        while (true) {
            System.out.println("请输入一大于1的自然数");
            Scanner scanner = new Scanner(System.in);
            String string = scanner.nextLine();
            int k = Integer.parseInt(string);
            if (k > 1) {
                System.out.println(k + "尾相等数最小和为：" + findNumber(k));
            } else System.out.println("你输入的数不合法，请重新输入");
        }
    }

    public static int findNumber(int k) {
        boolean flag = false;
        int product = 1;
        int[] arr = new int[1000];
        if (k >= 1000) {
            flag = true;
            k = k % 1000;
        }
        for (int Power = 1; Power <= 1001; ++Power) {
            product *= k;
            if (flag || product >= 1000) {
                flag = true;
                product = product % 1000;
                if (arr[product] == 0) arr[product] = Power;
                else return Power + arr[product];
            }
        }
        return -1;
    }
}