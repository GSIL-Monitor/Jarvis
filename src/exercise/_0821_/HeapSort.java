package exercise._0821_;

import factory.NumsFactory;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by pokerface_lx on 16/8/21.
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] nums  = NumsFactory.getPNDistinctRandNums(20, 100);
        System.out.println(Arrays.toString(nums));
        HeapSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums) {
        buildMaxHeap(nums);
        heapSort(nums);
    }

    private static void buildMaxHeap(int[] nums) {
        int startIndex = getParentIndex(nums.length - 1);
        for (int i = startIndex; i >= 0; i--) {
            rebuildMaxHeap(nums, nums.length, i);
        }
    }

    private static void rebuildMaxHeap(int[] nums, int heapSize, int currentIndex) {
        int largestIndex = currentIndex;
        int leftChildIndex = getLeftChildIndex(currentIndex);
        int rightChildIndex = getRightChildIndex(currentIndex);
        if (leftChildIndex < heapSize && nums[leftChildIndex] > nums[largestIndex]) {
            largestIndex = leftChildIndex;
        }
        if (rightChildIndex < heapSize && nums[rightChildIndex] > nums[largestIndex]) {
            largestIndex = rightChildIndex;
        }
        if (largestIndex != currentIndex) {
            int temp = nums[largestIndex];
            nums[largestIndex] = nums[currentIndex];
            nums[currentIndex] = temp;
            rebuildMaxHeap(nums, heapSize, largestIndex);
        }
    }

    private static void heapSort(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            rebuildMaxHeap(nums, i, 0);
        }
    }


    private static int getParentIndex(int index) {
        return (index - 1) >> 1;
    }

    private static int getLeftChildIndex(int index) {
        return (index << 1) + 1;
    }

    private static int getRightChildIndex(int index) {
        return (index << 1) + 2;
    }
}
