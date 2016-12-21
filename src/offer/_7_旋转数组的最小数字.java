package offer;

/**
 * Created by Poker on 2016/11/2.
 */
public class _7_旋转数组的最小数字 {

    public static void main(String[] args) {
        int[] nums = {6501, 6828, 6963, 7036, 7422, 7674, 8146, 8468, 8704, 8717, 9170, 9359, 9719, 9895, 9896, 9913, 9962, 154, 293, 334, 492, 1323, 1479, 1539, 1727, 1870, 1943, 2383, 2392, 2996, 3282, 3812, 3903, 4465, 4605, 4665, 4772, 4828, 5142, 5437, 5448, 5668, 5706, 5725, 6300, 6335};
        System.out.println(new _7_旋转数组的最小数字().minNumberInRotateArray(nums));
    }

    public int minNumberInRotateArray(int[] array) {
        int low = 0;
        int high = array.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (array[mid] > array[high]) {
                low = mid + 1;
            } else if (array[mid] == array[high]) {
                high--;
            } else {
                high = mid;
            }
        }
        return array[low];
    }

}
