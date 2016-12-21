package zzz_test;

import javax.swing.*;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by pokerface_lx on 16/8/10.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(!true && true);
        System.out.println(!true || !true);
    }

    private static boolean isPrime(int num) {
        if (num == 2) {
            return true;
        }
        for (int i = 2;i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}