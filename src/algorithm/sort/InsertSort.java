package algorithm.sort;

/**
 * @Description 插入排序
 * @Author liuxiao
 * @Date 2017/3/15
 */
public class InsertSort implements SortAlgorithm {

	@Override
	public void sort(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i; j >= 0; j--) {
				if (nums[j] > nums[j + 1]) {
					swap(nums, j, j + 1);
				}
			}
		}
	}
}
