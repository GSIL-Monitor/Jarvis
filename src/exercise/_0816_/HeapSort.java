package exercise._0816_;

import java.util.Arrays;

/**
 * Created by pokerface_lx on 16/8/16.
 */
public class HeapSort {

    public static void sort(int[] nums) {
        buildMaxHeap(nums);
        heapsort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void buildMaxHeap(int[] nums) {
        int startIndex = getFatherIndex(nums.length - 1);
        for (int i = startIndex; i >= 0; i--) {
            maxHeap(nums, nums.length, i);
        }
    }

    private static void maxHeap(int[] nums, int heapSize, int currentIndex) {
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
            int temp = nums[currentIndex];
            nums[currentIndex] = nums[largestIndex];
            nums[largestIndex] = temp;
            maxHeap(nums, heapSize, largestIndex);
        }
    }

    private static void heapsort(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            maxHeap(nums, i, 0);
        }
    }

    private static int getLeftChildIndex(int index) {
        return (index << 1) + 1;
    }

    private static int getRightChildIndex(int index) {
        return (index << 1) + 2;
    }

    private static int getFatherIndex(int index) {
        return (index - 1) >> 1;
    }

}
