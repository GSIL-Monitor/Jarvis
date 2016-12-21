package algorithm.dynamic_programming;

import java.util.Arrays;

/**
 * Created by Poker on 2016/11/14.
 */
public class _01package {

    public static void main(String[] args) {
//        int[] w = {2, 2, 6, 5, 4}
        int[] w = {4, 5, 6, 2, 2};
//        int[] v = {6, 3, 5, 4, 6}
        int[] v = {6, 4, 5, 3, 6};
//        System.out.println(Arrays.toString(new _01package().maxValue(w, v, 10)));
        new _01package().maxValue(w, v, 10);
    }

    public void maxValue(int[] weight, int[] value, int capacity) {
        int[][] f = new int[weight.length + 1][capacity + 1];
        for (int i = 1; i <= weight.length; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (j < weight[i]) {
                    f[i][j] = f[i - 1][j];
                } else {
                    f[i][j] = Integer.max(f[i - 1][j], f[i - 1][j - weight[i]] + value[i]);
                }
            }
        }
        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < f[i].length; j++) {
                System.out.print(f[i][j] + " ");
            }
            System.out.println();
        }
//        int j = capacity;
//        int[] res = new int[weight.length];
//        for (int i = weight.length; i >= 0; i--) {
//            if (i == 0) {
//                if (f[i][j] > 0) {
//                    res[i] = 1;
//                } else {
//                    res[i] = 0;
//                }
//                break;
//            }
//            if (f[i][j] > f[i - 1][j]) {
//                res[i] = 1;
//                j -= value[i];
//            } else {
//                res[i] = 0;
//            }
//        }
//        return res;
    }

}
