package factory;

import java.util.*;

/**
 * Created by pokerface_lx on 16/6/20.
 */
public class NumsFactory {

    private final static int DEFAULT_max = 99;

    public static int[] getRandomNums(int length) {
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = (int) (Math.random() * DEFAULT_max) + 1;
        }
        return nums;
    }

    public static int[] getRandomNums(int length, int max) {
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = (int) (Math.random() * max) + 1;
        }
        return nums;
    }

    public static int[] getDistinctRandNums(int length) {
        if (length > DEFAULT_max) {
            throw new RuntimeException("ur length is larger than default length");
        }
        int[] nums = new int[length];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < DEFAULT_max; i++) {
            list.add(i);
        }
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * (DEFAULT_max - i));
            nums[i] = list.get(index) + 1;
            list.remove(index);
        }
        return nums;
    }

    public static int[] getDistinctRandNums(int length, int max) {
        Set<Integer> set = new HashSet<>();
        while (set.size() < length) {
            set.add((int) (Math.random() * max) + 1);
        }
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = (int) set.toArray()[i];
        }
        return nums;
    }

    @Deprecated
    public static int[] getDistinctRandNums1(int length, int max) {
        int[] nums = new int[length];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            list.add(i);
        }
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * (max - i));
            nums[i] = list.get(index) + 1;
            list.remove(index);
        }
        return nums;
    }

    public static int[] getPNDistinctRandNums(int length, int max) {
        Set<Integer> set = new HashSet<>();
        while (set.size() < length) {
            set.add(((int) (Math.random() * max) + 1) * 2 - max);
        }
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = (int) set.toArray()[i];
        }
        return nums;
    }

}
