package jianzhioffer._14_调整数组顺序使奇数位于偶数之前;

import java.util.Scanner;

/**
 * 题目:输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有奇数位于数组的前半部分，所有偶数位予数组的后半部分。
 * <p>
 * Created by pokerface_lx on 16/9/12.
 */
public class ReorderArray {

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        reOrderArray(nums);
        print(nums);
    }

    private static void reOrderArray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int lowIndex = 0;
        int highIndex = nums.length - 1;
        while (lowIndex < highIndex) {
            while (lowIndex < highIndex && nums[lowIndex] % 2 == 1) {
                lowIndex++;
            }
            while (lowIndex < highIndex && nums[highIndex] % 2 == 0) {
                highIndex--;
            }
            int temp = nums[lowIndex];
            nums[lowIndex] = nums[highIndex];
            nums[highIndex] = temp;
        }
    }

    private static void print(int[] nums) {
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

}
