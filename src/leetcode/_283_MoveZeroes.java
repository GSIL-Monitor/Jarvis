package leetcode;

import java.util.Arrays;

/**
 * Created by Poker on 2017/1/29.
 */
public class _283_MoveZeroes {

    public void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        int i = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[i++] = num;
            }
        }
        while (i < nums.length) {
            nums[i++] = 0;
        }
//        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        new _283_MoveZeroes().moveZeroes(new int[]{3, 0, 1, 1, 0, 2, 3});
    }

}
