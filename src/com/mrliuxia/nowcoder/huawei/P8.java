package com.mrliuxia.nowcoder.huawei;

import java.util.*;

/**
 * Created by pokerface_lx on 16/8/12.
 */
public class P8 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int n = scan.nextInt();
            Map<Integer, Integer> map = new TreeMap<>();
            for (int i = 0; i < n; i++) {
                int key = scan.nextInt();
                int value = scan.nextInt();
                if (map.containsKey(key)) {
                    map.put(key, map.get(key) + value);
                } else {
                    map.put(key, value);
                }
            }
            for (Integer key : map.keySet()) {
                System.out.println(key + " " + map.get(key));
            }

        }
    }


}
