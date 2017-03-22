package factory;

import java.util.*;

/**
 * Created by pokerface_lx on 16/6/20.
 */
public class NumFactory {

    private final static int DEFAULT_max = 99;

    public static int[] getRandomNums(int size) {
        int[] nums = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
//            nums[i] = (int) (Math.random() * DEFAULT_max) + 1;
            nums[i] = random.nextInt(size)+1;
        }
        return nums;
    }

    public static int[] getRandomNums(int size, int max) {
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = (int) (Math.random() * max) + 1;
        }
        return nums;
    }

    public static int[] getDistinctRandNums(int size) {
        if (size > DEFAULT_max) {
            throw new RuntimeException("ur size is larger than default size");
        }
        int[] nums = new int[size];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < DEFAULT_max; i++) {
            list.add(i);
        }
        for (int i = 0; i < size; i++) {
            int index = (int) (Math.random() * (DEFAULT_max - i));
            nums[i] = list.get(index) + 1;
            list.remove(index);
        }
        return nums;
    }

    public static int[] getDistinctRandNums(int size, int max) {
        Set<Integer> set = new HashSet<>();
        while (set.size() < size) {
            set.add((int) (Math.random() * max) + 1);
        }
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = (int) set.toArray()[i];
        }
        return nums;
    }

    @Deprecated
    public static int[] getDistinctRandNums1(int size, int max) {
        int[] nums = new int[size];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            list.add(i);
        }
        for (int i = 0; i < size; i++) {
            int index = (int) (Math.random() * (max - i));
            nums[i] = list.get(index) + 1;
            list.remove(index);
        }
        return nums;
    }

    public static int[] getPNDistinctRandNums(int size, int max) {
        Set<Integer> set = new HashSet<>();
        while (set.size() < size) {
            set.add(((int) (Math.random() * max) + 1) * 2 - max);
        }
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = (int) set.toArray()[i];
        }
        return nums;
    }

}
