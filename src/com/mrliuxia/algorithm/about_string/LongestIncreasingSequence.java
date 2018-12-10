package com.mrliuxia.algorithm.about_string;

import java.util.Arrays;

/**
 * 最长递增子序列问题
 * <p>
 * Created by pokerface_lx on 16/8/17.
 */
public class LongestIncreasingSequence {

    public static int get(int[] nums) {
        int[] f = new int[nums.length];
        f[0] = 1;
        loop:
        for (int i = 1; i < f.length; i++) {
            if (nums[i] > nums[i - 1]) {
                f[i] = f[i - 1] + 1;
                continue loop;
            }
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    f[i] = f[j] + 1;
                    continue loop;
                }
            }
            f[i] = 1;
        }
        System.out.println("f:     " + Arrays.toString(f));
        int max = 0;
        for (int i : f) {
            max = i > max ? i : max;
        }
        return max;
    }

}
