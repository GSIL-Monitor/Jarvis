package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Author: liuxiao
 * Date: 2017/8/25
 * Description:
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * <p>
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * <p>
 * The replacement must be in-place, do not allocate extra memory.
 * <p>
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class _31_Next_Permutation {

    public static void main(String[] args) {
        _31_Next_Permutation permutation = new _31_Next_Permutation();
        int nums[] = new int[]{4, 2, 0, 2, 3, 2, 0};
        System.out.print(Arrays.toString(nums) + " -> ");
        permutation.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void nextPermutation(int[] nums) {
        int lastIndex = findLastIndex(nums, nums.length - 1);
        int startIndex = findFirstIndex(nums, lastIndex);
        if (lastIndex == startIndex) {
            int lenght = nums.length - 1;
            for (int i = 0; i < lenght / 2; i++) {
                nums[i] = nums[i] ^ nums[lenght - i];
                nums[lenght - i] = nums[i] ^ nums[lenght - i];
                nums[i] = nums[i] ^ nums[lenght - i];
            }
        } else {
            int temp = nums[lastIndex];
            List<Integer> leftNums = new ArrayList<>();
            for (int i = startIndex; i < nums.length; i++) {
                if (i == lastIndex) {
                    continue;
                }
                leftNums.add(nums[i]);
            }
            Collections.sort(leftNums);
            nums[startIndex] = temp;
            for (int i = startIndex + 1, j = 0; i < nums.length; i++, j++) {
                nums[i] = leftNums.get(j);
            }
        }
    }

    private int findLastIndex(int[] nums, int currIndex) {
        if (currIndex < 0) {
            return -1;
        }
        for (int i = currIndex - 1; i >= 0; i--) {
            if (nums[currIndex] > nums[i]) {
                return currIndex;
            }
        }
        return findLastIndex(nums, currIndex - 1);
    }

    private int findFirstIndex(int[] nums, int lastIndex) {
        for (int i = lastIndex - 1; i >= 0; i--) {
            if (nums[i] < nums[lastIndex]) {
                return i;
            }
        }
        return -1;
    }

}
