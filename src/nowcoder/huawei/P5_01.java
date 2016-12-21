package nowcoder.huawei;

import java.util.*;

/**
 * 判断短字符串中的所有字符是否在长字符串中全部出现
 * 输入例子:
 * bc
 * abc
 * 输出例子:
 * true
 * <p>
 * Created by pokerface_lx on 16/8/25.
 */
public class P5_01 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String shortStr = scan.nextLine();
            String longStr = scan.nextLine();
            Set<Character> shortSet = new TreeSet<>();
            Set<Character> longSet = new TreeSet<>();
            for (int i = 0; i < shortStr.length(); i++) {
                shortSet.add(shortStr.charAt(i));
            }
            for (int i = 0; i < longStr.length(); i++) {
                longSet.add(longStr.charAt(i));
            }
            boolean flag = true;
            for (Character c: shortSet) {
                if (!longSet.contains(c)) {
                    flag = false;
                    break;
                }
            }
            System.out.println(flag);
        }
    }

}
