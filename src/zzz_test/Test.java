package zzz_test;

import effective_java.ch2.NutritionFacts2;

import java.util.Scanner;

/**
 * Created by zzz_test.Poker on 2016/11/20.
 */
public class Test {
    public static void main(String[] args) {

        System.out.println(new Test().maxArea(new int[]{2,1,2}));
    }

    public int maxArea(int[] height) {
        int len = height.length, low = 0, high = len -1 ;
        int maxArea = 0;
        while (low < high) {
            maxArea = Math.max(maxArea, (high - low) * Math.min(height[low], height[high]));
            if (height[low] < height[high]) {
                low++;
            } else {
                high--;
            }
        }
        return maxArea;
    }

    public static int findNumber(int k) {
        boolean flag = false;
        int product = 1;
        int[] arr = new int[1000];
        if (k >= 1000) {
            flag = true;
            k = k % 1000;
        }
        for (int Power = 1; Power <= 1001; ++Power) {
            product *= k;
            if (flag || product >= 1000) {
                flag = true;
                product = product % 1000;
                if (arr[product] == 0) arr[product] = Power;
                else return Power + arr[product];
            }
        }
        return -1;
    }
}