package exercise._0907_;

import factory.NumFactory;

import java.util.Arrays;

/**
 * Created by pokerface_lx on 16/9/8.
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] nums = NumFactory.getDistinctRandNums(20, 100);
        System.out.println(Arrays.toString(nums));
        sort(nums);
    }

    private static void sort(int[] nums) {
        buildMaxHeap(nums);
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void buildMaxHeap(int[] nums) {
        int startIndex = getParentIndex(nums.length - 1);
        for (int i = startIndex; i >= 0; i--) {
            rebuildMaxHeap(nums, nums.length, i);
        }
    }

    private static void rebuildMaxHeap(int[] nums, int heapSize, int currentIndex) {
        int leftChildIndex = getLeftIndex(currentIndex);
        int rightChildIndex = getRightIndex(currentIndex);
        int largestIndex = currentIndex;
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
            int temp = nums[i];
            nums[i] = nums[0];
            nums[0] = temp;
            rebuildMaxHeap(nums, i, 0);
        }
    }

    private static int getParentIndex(int index) {
        return (index - 1) >> 1;
    }

    private static int getLeftIndex(int index) {
        return (index << 1) + 1;
    }

    private static int getRightIndex(int index) {
        return (index << 1) + 2;
    }


}
