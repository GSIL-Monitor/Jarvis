package sort;

import java.util.Arrays;

import static sort.Sort.swap;

/**
 * Created by pokerface_lx on 16/8/9.
 */
public class BubbleSort {

    public static void sort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
        System.out.println("Bubble Sorting:---" + Arrays.toString(nums));
    }

}
