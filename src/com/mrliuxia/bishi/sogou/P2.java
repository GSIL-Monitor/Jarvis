package com.mrliuxia.bishi.sogou;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by pokerface_lx on 16/9/12.
 */
public class P2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int n = scan.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
            min = nums[i] < min ? nums[i] : min;
            max = nums[i] > max ? nums[i] : max;
        }
        List<Integer> dicList = new ArrayList<>();
        loop:
        for (int i = min + 1; i <= max; i++) {
            for (int j = 2; j <= i / 2; j++) {
                if (i % j == 0) {
                    continue loop;
                }
            }
            dicList.add(i);
        }
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int dic : dicList) {
                    if (dic > nums[j]) {
                        continue;
                    }
                    if (dic > nums[i] && dic < nums[j]) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }

}
