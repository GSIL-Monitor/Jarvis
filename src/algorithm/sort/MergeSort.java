package algorithm.sort;

import java.util.Arrays;

/**
 * Created by pokerface_lx on 16/8/9.
 */
public class MergeSort {

    public static void main(String[] srg) {
        int[] nums = {10, 4, 6, 3, 8, 2, 5, 7};
        sort(nums);
    }

    public static void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
        System.out.println("Merge  Sorting:---" + Arrays.toString(nums));
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

    public static void merge(int[] nums, int startIndex, int centerIndex, int endIndex) {
        int[] tempNums = new int[nums.length];
        int midIndex = centerIndex + 1;
        int tempIndex = startIndex;
        int copyIndex = startIndex;
        int leftIndex = startIndex;
        while (leftIndex <= centerIndex && midIndex <= endIndex) {
            if (nums[leftIndex] <= nums[midIndex]) {
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
        while (copyIndex <= endIndex) {
            nums[copyIndex] = tempNums[copyIndex++];
        }
    }

}
