package zzz_test;

/**
 * @Description
 * @Author liuxiao
 * @Date 2017/3/16
 */
public class HJ {

	public int[][] getMaxTwoDimenMatrix(int[][] matrix) {
		int currMaxSum = 0;
		int[][] res = new int[2][2];
		for (int i = 0; i < matrix.length - 1; i++) {
			for (int j = 0; j < matrix[i].length - 1; j++) {
				if (matrix[i][j] + matrix[i][j + 1] + matrix[i + 1][j] + matrix[i + 1][j + 1] > currMaxSum) {
					res[0][0] = matrix[i][j];
					res[0][1] = matrix[i][j+1];
					res[1][0] = matrix[i+1][j];
					res[0][1] = matrix[i+1][j+1];
				}
			}
		}
		return res;
	}
}
