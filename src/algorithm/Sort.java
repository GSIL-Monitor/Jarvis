package algorithm;

import factory.NumFactory;

import java.util.Arrays;

/**
 * Created by pokerface_lx on 16/6/20.
 */
public class Sort {

    /**
     * 冒泡排序
     *
     * @param nums
     */
    public void bubbleSort(int[] nums) {
        System.out.println("冒泡排序:");
        System.out.println("0" + Arrays.toString(nums));
        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
            System.out.println((nums.length - i) + Arrays.toString(nums));
        }
    }

    /**
     * 选择排序
     *
     * @param nums
     */
    public void selectSort(int[] nums) {
        System.out.println("选择排序:");
        System.out.println("0" + Arrays.toString(nums));
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
            System.out.println((i + 1) + Arrays.toString(nums));
        }
    }

    /**
     * 插入排序
     *
     * @param nums
     */
    public void insertSort(int[] nums) {
        System.out.println("插入排序:");
        System.out.println("0" + Arrays.toString(nums));
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[i]) {
                    for (int k = j; k < i; k++) {
                        int temp = nums[j];
                        nums[j] = nums[i];
                        nums[i] = temp;
                    }
                }
            }
            System.out.println(i + Arrays.toString(nums));
        }
    }

    /**
     * 希尔排序
     *
     * @param nums
     */
    public void shellSort(int[] nums) {

    }

    /**
     * 合并/并归排序
     *
     * @param nums
     */
    public void mergeSort(int[] nums) {

    }

    /**
     * 快速排序
     *
     * @param nums
     */
    public void quickSort(int[] nums) {

    }

    /**
     * 堆排序
     *
     * @param nums
     */
    public void heapSort(int[] nums) {

    }

    /**
     * 基数排序?
     *
     * @param nums
     */
    public void radixSort(int[] nums) {

    }

    public static void main(String[] args) {
        Sort sort = new Sort();
        sort.bubbleSort(NumFactory.getRandomNums(10));
        sort.selectSort(NumFactory.getRandomNums(10));
        sort.insertSort(NumFactory.getRandomNums(10));
    }

}
