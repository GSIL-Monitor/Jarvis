package jianzhioffer._10_number_of_1_in_binary;

import java.util.Scanner;

/**
 * 思想:吧一个整数减去1之后再和原来的证书做位与运算,得到的结果相当于:
 * 把整数的二进制表示中的最右边的一个1变成0
 *
 * Created by pokerface_lx on 16/9/12.
 */
public class NumberOf1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            System.out.println(numberOf1(scan.nextInt()));
        }
    }

    private static int numberOf1(int n) {
        int count = 0;
        while (n > 0) {
            ++count;
            n = n & (n-1);
        }
        return count;
    }

}
