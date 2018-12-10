package com.mrliuxia.offer;

import java.util.Arrays;

/**
 * Created by Poker on 2016/11/3.
 */
public class _13_调整数组顺序使奇数位于偶数前面 {

    public static void main(String[] args) {
        int[] nums = {6,2,1,4,3,7,8,9,0,8};
        new _13_调整数组顺序使奇数位于偶数前面().reOrderArray(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void reOrderArray(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int lowIndex = 0;
        int highIndex = array.length - 1;
        while (highIndex > lowIndex) {
            while (highIndex > lowIndex) {
                if (array[lowIndex] % 2 == 1) {
                    lowIndex++;
                }
            }
            while (highIndex > lowIndex) {
                if (array[highIndex] % 2 == 0) {
                    highIndex--;
                }
            }
            int temp = array[lowIndex];
            array[lowIndex] = array[highIndex];
            array[highIndex] = temp;
        }
        return;
    }

}
