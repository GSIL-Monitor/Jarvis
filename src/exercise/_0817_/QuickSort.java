package exercise._0817_;

import factory.NumsFactory;

import java.net.SocketTimeoutException;
import java.util.Arrays;

/**
 * Created by pokerface_lx on 16/8/17.
 */
public class QuickSort {

    public static void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private static void sort(int[] nums, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        int midIndex = partition(nums, startIndex, endIndex);
        sort(nums, startIndex, midIndex - 1);
        sort(nums, midIndex + 1, endIndex);
    }

    private static int partition(int[] nums, int startIndex, int endIndex) {
        int lowIndex = startIndex;
        int highIndex = endIndex;
        int temp = nums[lowIndex];
        while (lowIndex < highIndex) {
            while (lowIndex < highIndex && nums[highIndex] >= temp) {
                highIndex--;
            }
            nums[lowIndex] = nums[highIndex];
            while (lowIndex < highIndex && nums[lowIndex] <= temp) {
                lowIndex++;
            }
            nums[highIndex] = nums[lowIndex];
        }
        nums[lowIndex] = temp;
        return lowIndex;
    }

    public static void main(String[] args) {
        QuickSort.sort(NumsFactory.getDistinctRandNums(10, 100));
    }

}
