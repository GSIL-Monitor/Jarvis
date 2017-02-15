package review.rv1702.sort;

import java.util.Arrays;

/**
 * Created by Poker on 2017/2/14.
 */
public class QuickSort extends Sorting {

    @Override
    public void sort(int[] nums) {
        sort(nums, 0, nums.length-1);
    }

    private void sort(int[] nums, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        int midIndex = partition(nums, startIndex, endIndex);
        sort(nums, startIndex, midIndex - 1);
        sort(nums, midIndex + 1, endIndex);
    }

    private int partition(int[] nums, int startIndex, int endIndex) {
        int lowIndex = startIndex;
        int highIndex = endIndex;
        int temp = nums[lowIndex];
        while (lowIndex < highIndex) {
            while (lowIndex < highIndex && nums[highIndex] > temp) {
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
}
