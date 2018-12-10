package com.mrliuxia.leetcode;

/**
 * Created by Poker on 2017/1/29.
 */
public class _26_RemoveDuplicateFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length < 2) {
            return nums.length;
        }
        int tmp = 0;
        for (int num : nums) {
            if (tmp == 0 || num > nums[tmp - 1]) {
                nums[tmp++] = num;
            }
        }
//        System.out.println(Arrays.toString(nums));
        return tmp;
    }

    public static void main(String[] args) {
        System.out.println(new _26_RemoveDuplicateFromSortedArray().removeDuplicates(new int[]{3, 3, 5, 6, 6, 7}));
    }

}
