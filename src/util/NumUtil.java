package util;

import com.sun.corba.se.impl.orbutil.ObjectStreamClassUtil_1_3;

import javax.xml.parsers.FactoryConfigurationError;
import java.util.*;
import java.util.concurrent.CancellationException;

/**
 * Created by Poker on 2016/12/21.
 */
public class NumUtil {

    public static void swap(int[] nums) {
        if (nums.length != 2) {
            throw new RuntimeException("array length must be 2.");
        }
        nums[0] = nums[0] ^ nums[1];
        nums[1] = nums[0] ^ nums[1];
        nums[0] = nums[0] ^ nums[1];
    }

    public static <T> void print(T[] nums) {
        System.out.println(Arrays.toString(nums));
    }

    public static void print(int[] nums) {
        System.out.println(Arrays.toString(nums));
    }

    public static double sumOfList(List<Double> list) {
        double result = 0;
        for (int i = 0; i < list.size(); i++) {
            result += list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2};
        swap(nums);
        System.out.println(nums[0] + " " + nums[1]);
    }

}
