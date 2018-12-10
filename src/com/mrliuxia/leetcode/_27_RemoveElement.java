package com.mrliuxia.leetcode;

/**
 * Created by Poker on 2017/1/29.
 */
public class _27_RemoveElement {

    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int num : nums) {
            if (num != val) {
                nums[i++] = num;
            }
        }
//        System.out.println(Arrays.toString(nums));
        return i;
    }

    public static void main(String[] args) {
        System.out.println(new _27_RemoveElement().removeElement(new int[]{2, 3, 2, 3, 4}, 3));
    }

}
