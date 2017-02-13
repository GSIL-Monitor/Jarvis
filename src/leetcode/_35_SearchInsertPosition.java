package leetcode;

/**
 * Created by Poker on 2017/1/29.
 */
public class _35_SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int startIndex = 0;
        int endIndex = nums.length - 1;
        while (startIndex <= endIndex) {
            int midIndex = (startIndex + endIndex) / 2;
            if (target == nums[midIndex]) {
                return midIndex;
            }
            if (target < nums[midIndex]) {
                endIndex = midIndex - 1;
            } else {
                startIndex = midIndex + 1;
            }
        }
        return startIndex;
    }

    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2 = {1, 2, 3, 4};
        int[] a3 = {1, 2, 3, 9};
        System.out.println("1 " + new _35_SearchInsertPosition().searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println("2 " + new _35_SearchInsertPosition().searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println("3 " + new _35_SearchInsertPosition().searchInsert(new int[]{1, 3, 5, 6}, 7));
        System.out.println("4 " + new _35_SearchInsertPosition().searchInsert(new int[]{1, 3, 5, 6}, 0));
    }

}
