package algorithm;

/**
 * Created by Poker on 2016/11/8.
 */
public class 连续子数组最大乘积 {

    private static int maxSubProduct(int[] nums) {
        int[] min = new int[nums.length];
        int[] max = new int[nums.length];
        int result = 0;
        min[0] = nums[0];
        max[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min[i] = min(nums[i], nums[i] * min[i - 1], nums[i] * max[i - 1]);
            max[i] = max(nums[i], nums[i] * min[i - 1], nums[i] * max[i - 1]);
            result = max[i] > result ? max[i] : result;
        }
        return result;
    }

    private static int max(int a, int b, int c) {
        int max = a;
        max = b > max ? b : max;
        max = c > max ? c : max;
        return max;
    }

    private static int min(int a, int b, int c) {
        int min = a;
        min = b < min ? b : min;
        min = c < min ? c : min;
        return min;
    }


}
