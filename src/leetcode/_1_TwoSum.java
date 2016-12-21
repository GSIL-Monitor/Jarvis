package leetcode;

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

/**
 * Created by Poker on 2016/11/11.
 */
public class _1_TwoSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new _1_TwoSum().twoSum(new int[]{2, 3, 7, 9, 10}, 12)));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return null;
    }

}
