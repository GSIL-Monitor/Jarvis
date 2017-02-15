package review.rv1702.sort;

import java.io.File;

/**
 * Created by Poker on 2017/2/14.
 */
public class HeapSort extends Sorting{

    @Override
    public void sort(int[] nums) {
        buildMaxHeap(nums);
        heapSort(nums);
    }

    private void buildMaxHeap(int[] nums) {
        int startIndex = getFatherIndex(nums.length - 1);
        for (int i = startIndex; i >= 0; i--) {
            rebuildMaxHeap(nums, nums.length, i);
        }
    }

    private void rebuildMaxHeap(int[] nums, int heapSize, int currIndex){
        int leftChildIndex = getLeftIndex(currIndex);
        int rightChildIndex = getRightIndex(currIndex);
        int largestNodeIndex = leftChildIndex < heapSize && nums[currIndex] < nums[leftChildIndex] ? leftChildIndex : currIndex;
        largestNodeIndex = rightChildIndex < heapSize && nums[largestNodeIndex] < nums[rightChildIndex] ? rightChildIndex : largestNodeIndex;
        if (largestNodeIndex != currIndex) {
            swap(nums, largestNodeIndex, currIndex);
            rebuildMaxHeap(nums, heapSize, largestNodeIndex);
        }
    }

    private void heapSort(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);
             rebuildMaxHeap(nums, i, 0);
        }
    }

    private int getFatherIndex(int index) {
        return (index - 1) >> 1;
    }

    private int getLeftIndex(int index) {
        return (index << 1) + 1;
    }

    private int getRightIndex(int index) {
        return (index << 1) + 2;
    }


}
