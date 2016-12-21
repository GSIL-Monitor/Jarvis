package jianzhioffer._34_丑数;

import java.util.*;

/**
 * 题目：我们把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。
 * 求从小到大的顺序的第 1500个丑数。
 * <p>
 * Created by pokerface_lx on 16/9/15.
 */
public class UglyNumber {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            System.out.println(getUglyNumber(scan.nextInt()));
        }
    }


    private static int getUglyNumber(int targetIndex) {
        if (targetIndex <= 0) {
            return 0;
        }
        int[] nums = new int[targetIndex];
        nums[0] = 1;
        int nextIndex = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        while (nextIndex < targetIndex) {
            int min = min(nums[index2] * 2, nums[index3] * 3, nums[index5] * 5);
            nums[nextIndex++] = min;
            while (nums[index2] * 2 <= min) {
                index2++;
            }
            while (nums[index3] * 3 <= min) {
                index3++;
            }
            while (nums[index5] * 5 <= min) {
                index5++;
            }
        }
        return nums[targetIndex - 1];
    }

    public static int getUglyNumber2(int index) {
        if (index <= 0) {
            return 0;
        }
        int[] pUglyNumbers = new int[index];
        pUglyNumbers[0] = 1;
        int nextUglyIndex = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        while (nextUglyIndex < index) {
            int min = min(pUglyNumbers[p2] * 2, pUglyNumbers[p3] * 3, pUglyNumbers[p5] * 5);
            pUglyNumbers[nextUglyIndex] = min;
            while (pUglyNumbers[p2] * 2 <= pUglyNumbers[nextUglyIndex]) {
                p2++;
            }
            while (pUglyNumbers[p3] * 3 <= pUglyNumbers[nextUglyIndex]) {
                p3++;
            }
            while (pUglyNumbers[p5] * 5 <= pUglyNumbers[nextUglyIndex]) {
                p5++;
            }
            nextUglyIndex++;
        }
        return pUglyNumbers[nextUglyIndex - 1];
    }

    private static int min(int a, int b, int c) {
        int min = a < b ? a : b;
        min = c < min ? c : min;
        return min;
    }
}
