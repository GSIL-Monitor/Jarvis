package nowcoder.huawei;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 题目描述
 * 实现删除字符串中出现次数最少的字符，若多个字符出现次数一样，则都删除。
 * 输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
 * <p>
 * Created by pokerface_lx on 16/8/16.
 */
public class P2_03 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String str = scan.next();
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                if (map.containsKey(str.charAt(i))) {
                    map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
                } else {
                    map.put(str.charAt(i), 1);
                }
            }
            int min = Collections.min(map.values());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < str.length(); i++) {
                if (map.get(str.charAt(i)) != min) {
                    sb.append(str.charAt(i));
                }
            }
            System.out.println(sb.toString());
        }
    }

}
