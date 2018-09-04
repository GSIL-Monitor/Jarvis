package oj.neuqoj.oldoj;

import java.util.Scanner;

/**
 * Created by Poker on 2017/2/20.
 */
public class P1191 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            System.out.println(cal(scan.nextInt()));
        }
    }

    public static int cal(int day) {
        int curr = 1;
        for (int i = 0; i < day - 1; i++) {
            curr = (curr + 1) * 2;
        }
        return curr;
    }

}
