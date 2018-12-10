package com.mrliuxia.bishi.meituan;

import java.util.Scanner;

/**
 * Created by pokerface_lx on 16/9/9.
 */
public class P2 {
    private static int length;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String numsStr = scan.nextLine();
        Scanner numsScan = new Scanner(numsStr);
        length = numsStr.split(" ").length;
        int[] nums = new int[length];
        int[] maxSize = new int[length];
        int max = 0;
        for (int i = 0; i < length; i++) {
            nums[i] = numsScan.nextInt();
        }
        for (int i = 0; i < length; i++) {
            int size = 1;
            for (int j = i - 1; isValid(j); j--) {
                if (nums[j] >= nums[i]) {
                    size++;
                } else {
                    break;
                }
            }
            for (int j = i + 1; isValid(j); j++) {
                if (nums[j] >= nums[i]) {
                    size++;
                } else {
                    break;
                }
            }
            int a = nums[i] * size;
            if (max < a) {
                max = a;
            }
        }
        System.out.println(max);
    }

    private static boolean isValid(int index) {
        if (index >= 0 && index < length) {
            return true;
        } else {
            return false;
        }
    }
}
