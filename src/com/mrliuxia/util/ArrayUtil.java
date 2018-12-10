package com.mrliuxia.util;

import java.util.Arrays;

/**
 * Created by pokerface_lx on 16/6/22.
 */
public class ArrayUtil {

    /**
     * 检查index是否是数组objects的合法下标
     *
     * @param objects
     * @param index
     * @return
     */
    public static boolean isValid(int[] objects, int index) {
        if (index >= 0 && index < objects.length) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 将数组中索引为i和j的两个元素交换位置
     *
     * @param objects
     * @param i
     * @param j
     */
    public static void exchangeElement(int[] objects, int i, int j) {
        if (isValid(objects, i) && isValid(objects, j)) {
            int temp = objects[i];
            objects[i] = objects[j];
            objects[j] = temp;
        }
    }

    /**
     * 输出数组
     *
     * @param objects
     */
    public static void sout(int[] objects) {
        System.out.println(Arrays.toString(objects));
    }

}
