package bishi.qunar;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 找出作弊司机
 * Created by pokerface_lx on 16/9/20.
 */
public class P1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String numStr = scan.next();
            int index = 0;
            int count = 0;
            for (int i = 1; i < numStr.length() - 1; i = i + 2) {
                if (count == 0) {
                    index = i;
                    count++;
                } else {
                    if (numStr.charAt(i) == numStr.charAt(index)) {
                        count++;
                    } else {
                        count--;
                    }
                }
            }
            if (count > 0) {
                System.out.println(numStr.charAt(index));
            } else {
                System.out.println("-1");
            }
        }
    }

}
