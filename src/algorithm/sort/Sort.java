package algorithm.sort;

import factory.NumsFactory;

import java.util.Arrays;

/**
 * Created by pokerface_lx on 16/8/9.
 */
public class Sort {

    public static void main(String[] args) {
        int[] nums = NumsFactory.getDistinctRandNums(30, 100);
        System.out.println("Origin Numbers:" + Arrays.toString(nums));
        BubbleSort.sort(nums.clone());
        QuickSort.sort(nums.clone());
        SelectSort.sort(nums.clone());
        InsertSort.sort(nums.clone());
        ShellSort.sort(nums.clone());
        MergeSort.sort(nums.clone());
        HeapSort.sort(nums.clone());
        RadixSort.sort(nums.clone());
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
