package com.mrliuxia.algorithm.about_string;

import com.mrliuxia.factory.NumFactory;

import java.util.Arrays;

/**
 * 最大子序列（和）
 * <p>
 * Created by pokerface_lx on 16/8/17.
 */
public class MaxSumSequence {

    public static void main(String[] args) {
        int[] nums = NumFactory.getPNDistinctRandNums(10, 10);
        System.out.println(Arrays.toString(nums));
        get(nums);
    }

    public static int get(int[] nums) {
        int[] currentMaxSum = new int[nums.length];
        currentMaxSum[0] = nums[0];
        loop:
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= 0) {
                currentMaxSum[i] = currentMaxSum[i - 1] + nums[i];
                continue loop;
            }
            for (int j = i - 1; j >= 0; j--) {
                if (currentMaxSum[j] >= 0) {
                    currentMaxSum[i] = currentMaxSum[j];
                }
            }
        }
        System.out.println("max sum array:" + Arrays.toString(currentMaxSum));
        int max = 0;
        for (int num : currentMaxSum) {
            max = num > max ? num : max;
        }
        System.out.println(max);
        return max;
    }

}
