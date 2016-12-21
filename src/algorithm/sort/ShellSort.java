package algorithm.sort;

import java.util.Arrays;

/**
 * Created by pokerface_lx on 16/8/9.
 */
public class ShellSort {

    public static void sort(int[] nums) {
        int space = 1;
        while (space < nums.length / 3) {
            space = space * 3 + 1;  // <O(n^(3/2)) by Knuth,1973>: 1, 4, 13, 40, 121, ...
        }
        while (space > 0) {
            for (int i = space; i < nums.length; i++) {
                for (int j = i - space; j >= 0; j -= space) {
                    if (nums[j] > nums[j + space]) {
                        Sort.swap(nums, j, j + space);
                    }
                }
            }
            space /= 3;
        }
        System.out.println("Shell  Sort:---" + Arrays.toString(nums));
    }

}
