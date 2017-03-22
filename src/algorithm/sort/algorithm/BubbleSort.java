package algorithm.sort.algorithm;

import algorithm.sort.base.SortAlgorithm;

/**
 * @Description 冒泡排序
 * @Author liuxiao
 * @Date 2017/3/15
 */
public class BubbleSort implements SortAlgorithm {

	@Override
	public void sort(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = 0; j < nums.length - 1 - i; j++) {
				if (nums[j] > nums[j + 1]) {
					swap(nums, j, j + 1);
				}
			}
		}
	}
}
