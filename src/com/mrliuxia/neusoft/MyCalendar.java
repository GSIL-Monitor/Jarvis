package com.mrliuxia.neusoft;

import java.util.Calendar;
import java.util.Scanner;

/**
 * Created by pokerface_lx on 16/8/8.
 */
public class MyCalendar {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int year = scan.nextInt();
            int month = scan.nextInt();
            if (month < 1 || month > 12) {
                throw new RuntimeException("input month error");
            }
            Calendar calendar = Calendar.getInstance();
            calendar.clear();
            calendar.set(year, month - 1, 1);
            int xday = calendar.get(Calendar.DAY_OF_WEEK);
            int dayNum = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
            showCalendar(xday, dayNum);
        }
    }

    private static void showCalendar(int xday, int dayNum) {
        System.out.println("Sun" + '\t' + "Mon" + '\t' + "Tue"
                + '\t' + "Wed" + '\t' + "Thu" + '\t' + "Fri" + '\t' + "Sat");
        for (int i = 0; i < xday - 1; i++) {
            System.out.print('\t');
        }
        for (int i = 0; i < dayNum; i++) {
            System.out.print((i + 1) + "\t");
            if (i % 7 == (7 - xday)) {
                System.out.println();
            }
        }
        System.out.println();
    }

}
