package com.mrliuxia.algorithm.hanoi;

import java.util.Scanner;

/**
 * Created by pokerface_lx on 16/8/29.
 */
public class Hanoi {

    public static int count = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            doTower(scan.nextInt());
        }
    }

    public static void doTower(int height) {
        System.out.println("Hanoi " + height + ":");
        doTower(height, 'A', 'B', 'C');
    }

    private static void doTower(int topN, char from, char by, char to) {
        if (topN == 1) {
            System.out.println("Disk 1 from " + from + " to " + to);
        } else {
            doTower(topN - 1, from, to, by);
            System.out.println("Disk " + topN + " from " + from + " to " + to);
            doTower(topN - 1, by, from, to);
        }
    }

}
