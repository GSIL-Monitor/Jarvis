package sort;

import java.util.Arrays;

/**
 * Created by pokerface_lx on 16/8/9.
 */
public class InsertSort {

    public static void sort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i; j >= 0; j--) {
                if (nums[j] > nums[j + 1]) {
                    Sort.swap(nums, j, j + 1);
                }
            }
        }
        System.out.println("Insert Sorting:---" + Arrays.toString(nums));
    }

}
