package bishi.jd;

import javax.swing.*;
import java.util.Scanner;

/**
 * Created by pokerface_lx on 16/9/5.
 */
public class P2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int n = scan.nextInt();
            int[] heights = new int[n];
            for (int i = 0; i < n; i++) {
                heights[i] = scan.nextInt();
            }
            int count = 0;
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    boolean flag = check(heights,i,j);
                    if (check(heights, i, j)) {
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    private static boolean check(int[] heights, int a, int b) {
        if (b - a == 1) {
            return true;
        }
        boolean rightFlag = true;
        for (int i = a + 1; i < b; i++) {
            if (heights[i] > heights[a] || heights[i] > heights[b]) {
                rightFlag = false;
                break;
            }
        }
        boolean leftFlag = true;
        for (int i = a - 1; i >= 0; i--) {
            if (heights[i] > heights[a] || heights[i] > heights[b]) {
                leftFlag = false;
                break;
            }
        }
        for (int i = heights.length - 1; i > b; i--) {
            if (heights[i] > heights[a] || heights[i] > heights[b]) {
                leftFlag = false;
                break;
            }
        }
        return leftFlag || rightFlag;
    }

}
