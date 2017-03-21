package algorithm.sort;

/**
 * @Description 希尔排序
 * @Author liuxiao
 * @Date 2017/3/15
 */
public class ShellSort implements SortAlgorithm {

	@Override
	public void sort(int[] nums) {
		int space = 1;
		while (space < nums.length / 3) {
			space = space * 3 + 1;  // <O(n^(3/2)) by Knuth,1973>: 1, 4, 13, 40, 121, ...
		}
		while (space > 0) {
			for (int i = space; i < nums.length; i++) {
				for (int j = i - space; j >= 0; j -= space) {
					if (nums[j] > nums[j + space]) {
						swap(nums, j, j + space);
					}
				}
			}
			space /= 3;
		}
	}

}
