package algorithm.sort;

import java.util.Arrays;

/**
 * Created by pokerface_lx on 16/8/9.
 */
public class SelectSort {

    public static void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minIndx = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < nums[minIndx]) {
                    minIndx = j;
                }
            }
            Sort.swap(nums, i, minIndx);
        }
        System.out.println("Select Sorting:---" + Arrays.toString(nums));
    }

}
