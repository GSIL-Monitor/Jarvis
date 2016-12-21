package bishi.qunar2;

import java.util.Scanner;

/**
 * Created by pokerface_lx
 */
public class P2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int num = scan.nextInt();
            for (int i = num + 1; ; i++) {
                if (isDc(String.valueOf(i))) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }

    private static boolean isDc(String s) {
        char[] chs = s.toCharArray();
        int lowIndex = 0;
        int highIndex = chs.length - 1;
        while (highIndex >= lowIndex) {
            if (chs[lowIndex++] != chs[highIndex--]) {
                return false;
            }
        }
        return true;
    }

}
