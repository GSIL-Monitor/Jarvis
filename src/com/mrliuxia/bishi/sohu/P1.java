package com.mrliuxia.bishi.sohu;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by pokerface_lx on 16/9/21.
 */
public class P1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int n = scan.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scan.nextInt();
            }
            Stack<Integer> open = new Stack<>();
            open.push(0);
            int index = 0;
            while (index != n - 1) {
                if (open.size() == 0) {
                    break;
                }
                index = open.pop();
                int num = nums[index];
                for (int i = 0; i < num; i++) {
                    if (index + 1 + i < n && !open.contains(index + 1 + i)) {
                        open.push(index + i + 1);
                    }
                }
            }
            if (index != (n - 1)) {
                System.out.println("-1");
            } else {
                System.out.println(n - open.size());
            }
        }
    }

}
