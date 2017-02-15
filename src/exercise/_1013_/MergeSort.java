package exercise._1013_;

import factory.NumFactory;

import java.util.Arrays;

/**
 * Created by pokerface_lx
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] nums = NumFactory.getDistinctRandNums(10, 20);
        sort(nums);
    }

    private static void sort(int[] nums) {
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
        int midIndex = centerIndex + 1;
        int[] tempNums = new int[nums.length];
        int tempIndex = startIndex;
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
