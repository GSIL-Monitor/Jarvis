package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Poker on 2016/11/12.
 */
public class _371_SumOfTwoIntegers {

    public int getSum(int a, int b) {
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }

    public static void main(String[] arsg) {
        Scanner scan = new Scanner(System.in);
        _371_SumOfTwoIntegers sum = new _371_SumOfTwoIntegers();
        while (scan.hasNext()) {
            System.out.println(sum.getSum(scan.nextInt(), scan.nextInt()));
        }
    }

}
