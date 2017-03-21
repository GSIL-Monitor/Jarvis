package algorithm.sort;

/**
 * @Description 归并排序
 * @Author liuxiao
 * @Date 2017/3/15
 */
public class MergeSort implements SortAlgorithm {

	@Override
	public void sort(int[] nums) {
		sort(nums, 0, nums.length - 1);
	}

	private void sort(int[] nums, int startIndex, int endIndex) {
		if (startIndex >= endIndex) {
			return;
		}
		int centerIndex = (startIndex + endIndex) >>1;
		sort(nums, startIndex, centerIndex);
		sort(nums, centerIndex + 1, endIndex);
		merge(nums, startIndex, centerIndex, endIndex);
	}

	private void merge(int[] nums, int startIndex, int centerIndex, int endIndex) {
		int leftIndex = startIndex;
		int middIndex = centerIndex + 1;
		int[] result = new int[nums.length];
		int i = startIndex;
		while (leftIndex <= centerIndex && middIndex <= endIndex) {
			result[i++] = nums[leftIndex] <= nums[middIndex] ? nums[leftIndex++] : nums[middIndex++];
		}
		while (leftIndex <= centerIndex) {
			result[i++] = nums[leftIndex++];
		}
		while (middIndex <= endIndex) {
			result[i++] = nums[middIndex++];
		}
		for (i = startIndex; i <= endIndex; i++) {
			nums[i] = result[i];
		}
	}

}
