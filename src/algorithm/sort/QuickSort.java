package algorithm.sort;

/**
 * @Description 快速排序
 * @Author liuxiao
 * @Date 2017/3/15
 */
public class QuickSort implements SortAlgorithm{

	@Override
	public void sort(int[] nums) {
		sort(nums, 0, nums.length-1);
	}

	private void sort(int[] nums, int startIndex, int endIndex) {
		if (startIndex >= endIndex) {
			return;
		}
		int midIndex = partition(nums, startIndex, endIndex);
		sort(nums, startIndex, midIndex - 1);
		sort(nums, midIndex + 1, endIndex);
	}

	private int partition(int[] nums, int startIndex, int endIndex) {
		int lowIndex = startIndex;
		int highIndex = endIndex;
		int temp = nums[lowIndex];
		while (lowIndex < highIndex) {
			while (lowIndex < highIndex && nums[highIndex] > temp) {
				highIndex--;
			}
			nums[lowIndex] = nums[highIndex];
			while (lowIndex < highIndex && nums[lowIndex] <= temp) {
				lowIndex++;
			}
			nums[highIndex] = nums[lowIndex];
		}
		nums[lowIndex] = temp;
		return lowIndex;
	}

}
