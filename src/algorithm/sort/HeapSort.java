package algorithm.sort;

import java.util.Arrays;

/**
 * Created by pokerface_lx on 16/8/9.
 */
public class HeapSort {

    public static void sort(int[] nums) {
        buildMaxHeap(nums);
        heapsort(nums);
        System.out.println("Heap   Sort:---" + Arrays.toString(nums));
    }

    private static void buildMaxHeap(int[] nums) {
        int startIndex = getParentIndex(nums.length - 1);
        for (int i = startIndex; i >= 0; i--) {
            rebuildMaxHeap(nums, nums.length, i);
        }
    }

    private static void rebuildMaxHeap(int[] nums, int heapSize, int currentIndex) {
        int leftChildIndex = getLeftChildIndex(currentIndex);
        int rightChildIndex = getRightChildIndex(currentIndex);
        int largestIndex = currentIndex;
        if (leftChildIndex < heapSize && nums[leftChildIndex] > nums[largestIndex]) {
            largestIndex = leftChildIndex;
        }
        if (rightChildIndex < heapSize && nums[rightChildIndex] > nums[largestIndex]) {
            largestIndex = rightChildIndex;
        }
        if (largestIndex != currentIndex) {
            Sort.swap(nums, currentIndex, largestIndex);
            rebuildMaxHeap(nums, heapSize, largestIndex);
        }
    }

    private static void heapsort(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            Sort.swap(nums, 0, i);
            rebuildMaxHeap(nums, i, 0);
        }
    }

    private static int getParentIndex(int currentIndex) {
        return (currentIndex - 1) >> 1;
    }

    private static int getLeftChildIndex(int currentIndex) {
        return (currentIndex << 1) + 1;
    }

    private static int getRightChildIndex(int currentIndex) {
        return (currentIndex << 1) + 2;
    }

}