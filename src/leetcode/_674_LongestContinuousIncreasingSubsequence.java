package leetcode;

import factory.NumFactory;
import util.PrintUtil;

/**
 * Author: liuxiao
 * Created: 2017/9/24 18:44
 * <p>
 * Description:
 * Given an unsorted array of integers, find the length of longest continuous increasing subsequence.
 * <p>
 * Example 1:
 * Input: [1,3,5,4,7]
 * Output: 3
 * Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3.
 * Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4.
 * Example 2:
 * Input: [2,2,2,2,2]
 * Output: 1
 * Explanation: The longest continuous increasing subsequence is [2], its length is 1.
 * Note: Length of the array will not exceed 10,000.
 */
public class _674_LongestContinuousIncreasingSubsequence {

    public int findLengthOfLCIS(int[] nums) {
        int[] currLength = new int[nums.length];
        int maxLenght = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                currLength[0] = 1;
            } else if (nums[i] > nums[i - 1]) {
                currLength[i] = currLength[i - 1] + 1;
            } else {
                currLength[i] = 1;
            }
            maxLenght = currLength[i] > maxLenght ? currLength[i] : maxLenght;
        }
        return maxLenght;
    }

    public static void main(String[] args) {
        _674_LongestContinuousIncreasingSubsequence lcis = new _674_LongestContinuousIncreasingSubsequence();
        for (int i = 0; i < 10; i++) {
            int[] nums = NumFactory.getRandomNums(7, 15);
            PrintUtil.printArray(nums);
            System.out.println(lcis.findLengthOfLCIS(nums));
            PrintUtil.printDivision();
        }
    }
}
