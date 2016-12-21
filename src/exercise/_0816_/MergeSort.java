package exercise._0816_;

import java.util.Arrays;

/**
 * Created by pokerface_lx on 16/8/16.
 */
public class MergeSort {

    public static void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private static void sort(int[] nums, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        int centerIndex = (startIndex + endIndex) / 2;
        sort(nums, startIndex, centerIndex);
        sort(nums, centerIndex + 1, endIndex);
        merge(nums, startIndex, centerIndex, endIndex);
    }

    private static void merge(int[] nums, int startIndex, int centerIndex, int endIndex) {
        int leftIndex = startIndex;
        int tempIndex = startIndex;
        int midIndex = centerIndex + 1;
        int[] tempNums = new int[nums.length];
        while (leftIndex <= centerIndex && midIndex <= endIndex) {
            if (nums[leftIndex] < nums[midIndex]) {
                tempNums[tempIndex++] = nums[leftIndex++];
            } else {
                tempNums[tempIndex++] = nums[midIndex++];
            }
        }
        while (leftIndex <= centerIndex) {
            tempNums[tempIndex++] = nums[leftIndex++];
        }
        while (midIndex <= endIndex) {
            tempNums[tempIndex++] = nums[midIndex++];
        }
        while (startIndex <= endIndex) {
            nums[startIndex] = tempNums[startIndex++];
        }
    }

}
