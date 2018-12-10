package com.mrliuxia.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Poker on 2017/2/22.
 */
public class _15_3Sum {

    public static void main(String[] args) {
//        List<List<Integer>> list = new _15_3Sum().threeSum(new int[]{0, 1, 3, -1, 5, 2, -4, -3, -5});
//        List<List<Integer>> list = new _15_3Sum().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        List<List<Integer>> list = new _15_3Sum().threeSum(new int[]{0,0,0});
        for (List<Integer> l : list) {
            for (Integer i : l) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }



    public List<List<Integer>> threeSum(int[] nums) {
        quick_sort(nums, 0, nums.length - 1);
        List<List<Integer>> resultList = new ArrayList<>();
        for (int startIndex = 0; startIndex < nums.length - 2; startIndex++) {
            int lowIndex = startIndex + 1;
            int highIndex = nums.length - 1;
            while (lowIndex < highIndex) {
                if (sum(nums, startIndex, lowIndex, highIndex) == 0) {
                    List<Integer> list = Arrays.asList(new Integer[]{nums[startIndex], nums[lowIndex], nums[highIndex]});
                    if (!contains(resultList, list)) {
                        resultList.add(list);
                    }
                }
                if (sum(nums, startIndex, lowIndex, highIndex) <= 0) {
                    lowIndex++;
                } else {
                    highIndex--;
                }
            }
        }
        return resultList;
    }

    private boolean contains(List<List<Integer>> numsList, List<Integer> target) {
        if (numsList == null || numsList.size() == 0) {
            return false;
        }
        for (List<Integer> list : numsList) {
            if (list.get(0) == target.get(0) && list.get(1) == target.get(1) && list.get(2) == target.get(2)) {
                return true;
            }
        }
        return false;
    }

    private int sum(int[] nums, int... positions) {
        int sum = 0;
        for (int pos : positions) {
            sum += nums[pos];
        }
        return sum;
    }

    private void quick_sort(int[] nums, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        int midIndex = partition(nums, startIndex, endIndex);
        quick_sort(nums, startIndex, midIndex - 1);
        quick_sort(nums, midIndex + 1, endIndex);
    }

    private int partition(int[] nums, int lowIndex, int highIndex) {
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
