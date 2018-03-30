package leetcode;

/**
 * Author: liuxiao
 * Created: 2018/2/11 16:34
 *
 * Description:
 * Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 */
public class _34_Search_for_a_Range {

    public int[] searchRange(int[] nums, int target) {
        int startIndex = 0;
        int endIndex = nums.length - 1;
        while (endIndex - startIndex > 1) {
            binarySearch(nums, startIndex, endIndex, target);
        }
        return null;
    }

    private void binarySearch(int[] nums, int startIndex, int endIndex, int target) {
        int midIndex = (startIndex + endIndex) / 2;
        if (midIndex == target) {

        } else if (midIndex > target) {

        } else {//mid < tar

        }
    }

}
