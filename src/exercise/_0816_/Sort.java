package exercise._0816_;

import factory.NumFactory;
import java.util.Arrays;

/**
 * Created by pokerface_lx on 16/8/16.
 */
public class Sort {

    public static void main(String[] args) {
        int[] nums = NumFactory.getDistinctRandNums(20, 100);
        System.out.println("origin:" + Arrays.toString(nums));
        MergeSort.sort(nums.clone());
        QuickSort.sort(nums.clone());
        HeapSort.sort(nums.clone());
    }

}
