package algorithm.sort;

/**
 * @Description 选择排序
 * @Author liuxiao
 * @Date 2017/3/15
 */
public class SelectSort implements SortAlgorithm {

	@Override
	public void sort(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			int minIndx = i;
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] < nums[minIndx]) {
					minIndx = j;
				}
			}
			if (minIndx == i) {
				continue;
			}
			swap(nums, i, minIndx);
		}
	}

}