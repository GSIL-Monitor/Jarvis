package com.mrliuxia.oj.neuqoj.oldoj;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Poker on 2016/11/20.
 * unfinished
 */
public class P1168 {

    private static List<Integer> list;

    public static void main(String[] args) {
        list = new LinkedList<>();
        list.add(5);
        list.add(6);
        multiply(8);
    }

    private static void multiply(int num) {
        if (list.size() == 0) {
            list.add(num);
            return;
        }
        boolean carry = false;
        ListIterator iterator = list.listIterator();
        while (iterator.hasNext()) {
            int curNum = (int) iterator.next();
            curNum *= num;
            curNum = carry ? curNum + 1 : curNum;
            if (curNum > 9) {
                carry = true;
                iterator.set(curNum % 10);
                if (!iterator.hasNext()) {
                    iterator.add(1);
                    break;
                }
            } else {
                carry = false;
                iterator.set(curNum);
            }
        }
        return;
    }

}
