package algorithm.sort.base;

/**
 * @Description
 * @Author liuxiao
 * @Date 2017/3/15
 */
public interface SortAlgorithm {

	void sort(int[] nums);

	default void swap(int[] nums, int i, int j) {
		nums[i] = nums[i] ^ nums[j];
		nums[j] = nums[i] ^ nums[j];
		nums[i] = nums[i] ^ nums[j];
	}

}