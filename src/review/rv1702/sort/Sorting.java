package review.rv1702.sort;

import factory.NumFactory;
import util.NumUtil;

import java.io.File;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by Poker on 2017/2/14.
 */
public abstract class Sorting {

    public void sortArray(int[] nums) {
        System.out.println(getClass().getSimpleName());
        printBeforeSort(nums);
        sort(nums);
        printAfterSort(nums);
    }

    public void sort(int[] nums) {

    }

    public void printBeforeSort(int[] nums) {
        System.out.print("Before: ");
        NumUtil.print(nums);
    }

    public void printAfterSort(int[] nums) {
        System.out.print("After:  ");
        NumUtil.print(nums);
        System.out.println();
    }

    public void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        new QuickSort().swap(a, 0, 2);
        System.out.println(Arrays.toString(a));
        new QuickSort().sortArray(NumFactory.getRandomNums(9, 10));
        new MergeSort().sortArray(NumFactory.getRandomNums(9, 10));
        new HeapSort().sortArray(NumFactory.getRandomNums(9, 10));

        File brand = new File("");
        long timestamp = brand.lastModified();
        Date date = new Date(timestamp);
    }

}
