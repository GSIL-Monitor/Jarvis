package sort;

import java.util.Arrays;

/**
 * Created by pokerface_lx on 16/8/9.
 */
public class RadixSort {

    public static void sort(int[] nums) {
        int[][] bucket = new int[10][nums.length];
        int[] counter = new int[10];
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            int length = String.valueOf(nums[i]).length();
            maxLength = length > maxLength ? length : maxLength;
        }
        for (int i = 0; i < maxLength; i++) {
            for (int num : nums) {
                int radix = (int) (num / Math.pow(10, i)) % 10;
                bucket[radix][counter[radix]++] = num;
            }
            int index = 0;
            for (int j = 0; j < 10; j++) {
                for (int k = 0; ; k++) {
                    if (bucket[j][k] == 0) {
                        break;
                    }
                    nums[index++] = bucket[j][k];
                    bucket[j][k] = 0;
                    counter[j] = 0;
                }
            }
        }
        System.out.println("Radix  Sort:---" + Arrays.toString(nums));
    }

}
