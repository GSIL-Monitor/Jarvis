package com.mrliuxia.offer;

import java.util.ArrayList;

/**
 * Created by Poker on 2016/11/3.
 */
public class _19_顺时针打印矩阵 {

    public static void main(String[] args) {
        int[][] nums = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}, {17, 18, 19, 20}};
        int[][] nums2 = {{1},{2},{3}};
        int[][] nums3 = {{1,2},{3,4},{5,6},{7,8},{9,10}};
        new _19_顺时针打印矩阵().printMatrix(nums3);
    }

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> nums = new ArrayList<>();
        if (matrix == null) {
            return nums;
        }
        int curRow = 0;
        int curCol = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        while (curRow < rows / 2 && curCol < cols / 2) {
            for (int i = curCol; i < cols - curCol; i++) {
                nums.add(matrix[curRow][i]);
            }
            for (int i = curRow + 1; i < rows - curRow; i++) {
                nums.add(matrix[i][cols - curCol - 1]);
            }
            if (curRow * 2 + 1 < rows) {
                for (int i = cols - curCol - 2; i >= curCol; i--) {
                    nums.add(matrix[rows - curRow - 1][i]);
                }
            }
            if (curCol * 2 + 1 < cols) {
                for (int i = rows - curRow - 2; i > curRow; i--) {
                    nums.add(matrix[i][curCol]);
                }
            }
            curRow++;
            curCol++;
        }
        return nums;
    }


}
