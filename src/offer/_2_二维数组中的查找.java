package offer;

/**
 * Created by Poker on 2016/11/2.
 */
public class _2_二维数组中的查找 {

    public boolean find(int[][] array, int target) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }
        int row = 0;
        int col = array[0].length - 1;
        while (row >= 0 && row < array.length && col >= 0 && col < array[0].length) {
            if (target == array[row][col]) {
                return true;
            }
            if (target < array[row][col]) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }

}
