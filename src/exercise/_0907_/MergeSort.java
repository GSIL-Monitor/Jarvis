package exercise._0907_;

import factory.NumsFactory;
import sun.management.snmp.jvmmib.JvmThreadInstanceEntryMBean;

import java.util.Arrays;

/**
 * Created by pokerface_lx on 16/9/8.
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] nums = NumsFactory.getDistinctRandNums(20, 100);
        System.out.println(Arrays.toString(nums));
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
        int[] tempNums = new int[nums.length];
        int tempIndex = startIndex;
        int leftIndex = startIndex;
        int midIndex = centerIndex + 1;
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
