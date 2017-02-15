package leetcode;

/**
 * Created by Poker on 2016/11/11.
 */
public class _167_TwoSum_SortedArray {

    public int[] twoSum(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            if (numbers[low] + numbers[high] == target) {
                return new int[]{low + 1, high + 1};
            }
            if (numbers[low] + numbers[high] < target) {
                low++;
            } else {
                high--;
            }
        }
        return null;
    }

}
