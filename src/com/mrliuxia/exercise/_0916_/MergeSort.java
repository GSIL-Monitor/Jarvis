package com.mrliuxia.exercise._0916_;

import com.mrliuxia.factory.NumFactory;

import java.util.Arrays;

/**
 * Created by pokerface_lx on 16/9/16.
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] nums = NumFactory.getDistinctRandNums(20, 100);
        sort(nums);
    }

    private static void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
        System.out.println("merge sort:" + Arrays.toString(nums));
    }

    private static void sort(int[] nums, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        int centerIndex = (startIndex + endIndex) / 2;
        sort(nums, startIndex, centerIndex);
        sort(nums, centerIndex + 1, endIndex);
        merge(nums, startIndex, centerIndex, endIndex);
    }

    private static void merge(int[] nums, int startIndex, int centerIndex, int endIndex) {
        int[] tempNums = new int[nums.length];
        int lowIndex = startIndex;
        int midIndex = centerIndex + 1;
        int tempIndex = startIndex;
        while (lowIndex <= centerIndex && midIndex <= endIndex) {
            if (nums[lowIndex] < nums[midIndex]) {
                tempNums[tempIndex++] = nums[lowIndex++];
            } else {
                tempNums[tempIndex++] = nums[midIndex++];
            }
        }
        while (lowIndex <= centerIndex) {
            tempNums[tempIndex++] = nums[lowIndex++];
        }
        while (midIndex <= endIndex) {
            tempNums[tempIndex++] = nums[midIndex++];
        }
        while (startIndex <= endIndex) {
            nums[startIndex] = tempNums[startIndex++];
        }
    }
}
