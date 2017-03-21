package neuqoj;

import java.util.*;

/**
 * Created by Poker on 2017/3/14.
 */
public class P1664 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = scan.nextInt();
		}
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			int currNum = nums[i];
			if (map.containsKey(currNum)) {
				System.out.print(zipCode(nums, i, map));
			}else {
				System.out.print(-currNum);
			}
			map.put(currNum, i);
			if (i < n - 1) {
				System.out.print(" ");
			}
		}
	}

	private static int zipCode(int[] nums, int currIndex, Map<Integer, Integer> map) {
		int lastIndex = map.get(nums[currIndex]);
		Set<Integer> set = new HashSet<>();
		int count = 0;
		for (int i = lastIndex + 1; i < currIndex; i++) {
			if (!set.contains(nums[i])) {
				set.add(nums[i]);
				count++;
			}
		}
		return count;
	}

}
