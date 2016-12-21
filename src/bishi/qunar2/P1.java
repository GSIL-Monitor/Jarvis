package bishi.qunar2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by pokerface_lx
 */
public class P1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println(System.currentTimeMillis());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis());
        while (scan.hasNext()) {
            String str1 = scan.next();
            String str2 = scan.next();
            System.out.println(isSame(str1, str2) && isSame(str2, str1));
        }
    }

    private static boolean isSame(String str, String cmpStr) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
        }
        int currentSize = set.size();
        for (int i = 0; i < cmpStr.length(); i++) {
            set.add(cmpStr.charAt(i));
        }
        if (set.size() == currentSize) {
            return true;
        } else {
            return false;
        }
    }

}
