package bishi.wanmeishijie;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by pokerface_lx on 16/9/19.
 */
public class P2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            List<Integer> list = new ArrayList<>();
            int start = scan.nextInt();
            int end = scan.nextInt();
            for (int i = start; i < end-1; i++) {
                if (isPrime(i) && isPrime(i + 2)) {
                    list.add(i);
                    list.add(i + 2);
                }
//                i = i + 2;
            }
            if (list.size()>0) {
                for (int i = 0; i < list.size(); i++) {
                    if (i == list.size() - 1) {
                        System.out.println(list.get(i));
                    } else {
                        System.out.print(list.get(i) + " ");
                    }
                }
            } else {
                System.out.println("no");
            }
        }
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
