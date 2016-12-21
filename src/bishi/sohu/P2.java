package bishi.sohu;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by pokerface_lx on 16/9/21.
 */
public class P2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String s = scan.next();
            int maxLen = 0;
            for (int i = 0; i < s.length(); i++) {
                int preMaxLen = 0;
                int backMaxLen = 0;
                Set<Character> set = new HashSet<>();
                for (int j = i; j < s.length(); j++) {
                    if (s.charAt(j) >= 'A' && s.charAt(j) <= 'E') {
                        set.add(s.charAt(j));
                    }
                    if (set.size() == 5) {
                        preMaxLen = s.length() - (j - i + 1);
                        break;
                    }
                }
                for (int j = 0; j < i; j++) {
                    if (s.charAt(j) >= 'A' && s.charAt(j) <= 'E') {
                        set.add(s.charAt(j));
                    }
                    if (set.size() == 5) {
                        preMaxLen = (i - j - 1);
                        break;
                    }
                }
                set = new HashSet<>();
                for (int j = i; j >= 0; j--) {
                    if (s.charAt(j) >= 'A' && s.charAt(j) <= 'E') {
                        set.add(s.charAt(j));
                    }
                    if (set.size() == 5) {
                        backMaxLen = s.length() - (i - j + 1);
                        break;
                    }
                }
                for (int j = s.length() - 1; j > i; j--) {
                    if (s.charAt(j) >= 'A' && s.charAt(j) <= 'E') {
                        set.add(s.charAt(j));
                    }
                    if (set.size() == 5) {
                        backMaxLen = j - i - 1;
                        break;
                    }
                }
                if (preMaxLen > maxLen) {
                    maxLen = preMaxLen;
                }
                if (backMaxLen > maxLen) {
                    maxLen = backMaxLen;
                }
            }
            System.out.println(maxLen);
        }
    }

}
