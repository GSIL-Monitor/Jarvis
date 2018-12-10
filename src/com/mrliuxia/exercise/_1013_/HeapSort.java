package com.mrliuxia.exercise._1013_;

import com.mrliuxia.factory.NumFactory;

import java.util.Arrays;

/**
 * Created by pokerface_lx
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] nums = NumFactory.getDistinctRandNums(10, 20);
        sort(nums);
    }

    private static void sort(int[] nums) {
        buildMaxHeap(nums);
        //heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void buildMaxHeap(int[] nums) {

    }

}
