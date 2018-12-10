package com.mrliuxia.nowcoder.huawei;

import java.util.Scanner;

/**
 * 题目说明
 * 蛇形矩阵是由1开始的自然数依次排列成的一个矩阵上三角形。
 *
 * 样例输入
 * 5
 * 样例输出
 * 1 3 6 10 15
 * 2 5 9 14
 * 4 8 13
 * 7 12
 * 11
 *
 * Created by pokerface_lx on 16/8/16.
 */
public class P2_15 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int n = scan.nextInt();
            int[][] nums = new int[n][n];
            int temp = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    nums[i - j][j] = temp++;
                }
            }
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums[i].length; j++) {
                    if (j == 0) {
                        System.out.print(nums[i][j]);
                        continue;
                    }
                    if (nums[i][j] == 0) {
                        break;
                    }
                    System.out.print(" " + nums[i][j]);
                }
                System.out.println();
            }
        }
    }

}
