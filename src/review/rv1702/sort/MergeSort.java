package review.rv1702.sort;

import sun.security.util.Length;

/**
 * Created by Poker on 2017/2/14.
 */
public class MergeSort extends Sorting {

    @Override
    public void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        int centerIndex = (startIndex + endIndex) >>1;
        sort(nums, startIndex, centerIndex);
        sort(nums, centerIndex + 1, endIndex);
        merge(nums, startIndex, centerIndex, endIndex);
    }

    private void merge(int[] nums, int startIndex, int centerIndex, int endIndex) {
        int leftIndex = startIndex;
        int middIndex = centerIndex + 1;
        int[] result = new int[nums.length];
        int i = startIndex;
        while (leftIndex <= centerIndex && middIndex <= endIndex) {
            result[i++] = nums[leftIndex] <= nums[middIndex] ? nums[leftIndex++] : nums[middIndex++];
        }
        while (leftIndex <= centerIndex) {
            result[i++] = nums[leftIndex++];
        }
        while (middIndex <= endIndex) {
            result[i++] = nums[middIndex++];
        }
        for (i = startIndex; i <= endIndex; i++) {
            nums[i] = result[i];
        }
    }


}
