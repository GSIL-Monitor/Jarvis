package algorithm.sort.algorithm;

import algorithm.sort.base.ISortAlgorithm;

/**
 * Author: liuxiao
 * Created: 2018/5/11 11:36
 * Description:
 */
public class BaseSortAlgorithm implements ISortAlgorithm {

    private final String TAG = this.getClass().getSimpleName();

    @Override
    public void sort(int[] nums) {
        System.out.println(TAG + " doSort()");
    }

    @Override
    public void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}
