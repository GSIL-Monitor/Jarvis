package bishi.sohu;

import java.util.Scanner;

/**
 * Created by pokerface_lx on 16/9/21.
 */
public class P3 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String s = scan.next();
            int k = scan.nextInt();
            while (k != 0) {
                for (int i = 0; i < s.length() - 1; ++i) {
                    if (s.charAt(i) <= s.charAt(i + 1)) {
                        s = s.substring(0, i) + s.substring(i + 1);
                        continue;
                    }
                    k--;
                }
            }
            System.out.println(s);
        }
    }

}
