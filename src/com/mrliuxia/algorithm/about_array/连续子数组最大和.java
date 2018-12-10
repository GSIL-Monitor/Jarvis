package com.mrliuxia.algorithm.about_array;

/**
 * Created by Poker on 2016/11/8.
 */
public class 连续子数组最大和 {

    public static int maxSubSum(int[] nums) {
        int max = nums[0];
        int currSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (currSum < 0) {
                currSum = nums[i];
            } else {
                currSum += nums[i];
            }
            max = currSum > max ? currSum : max;
        }
        return max;
    }

}
