package neuqoj.oldoj;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Poker on 2016/11/20.
 */
public class P1103 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int radix = scan.nextInt();
            int curNum = 1;
            int power = 0;
            if (radix == 1) {
                continue;
            }
            while (curNum < 1000) {
                curNum *= radix;
                power++;
            }
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            while (power < 1000) {
                curNum = curNum % 1000;
                if (map.containsKey(curNum)) {
                    System.out.println(map.get(curNum) + power);
                    break;
                }
                map.put(curNum, power);
                curNum *= radix;
                power++;
            }
        }
    }

}
