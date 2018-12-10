package com.mrliuxia.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Author: liuxiao
 * Created: 2017/9/24 18:49
 * Description:
 */
public class PrintUtil {

    public static void print(String str) {
        System.out.print(str);
    }

    public static void println(String str) {
        System.out.println(str);
    }

    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void printCollection(Collection collection) {
        for (Object o : collection) {
            System.out.println(o.toString());
        }
    }

    public static void printList(List list) {
        print("list:[");
        int index = 0;
        for (Object o : list) {
            if (index++ == 0) {
                print(o.toString());
            } else {
                print(", " + o.toString());
            }
        }
        println("]");
    }

    public static void printBlankLine() {
        System.out.println();
    }

    public static void printDivision() {
        System.out.println("---------------------------------------");
    }

    public static void printMap(Map map) {
        printMap(map, null);
    }

    public static void printMap(Map<Object, Object> map, String name) {
        printDivision();
        println(name + ":");
        for (Map.Entry entry : map.entrySet()) {
            println("[key=" + String.format("%-10s", entry.getKey()) + "  ->  value=" + entry.getValue() + "]");
        }
        printDivision();
    }

    public static void print(int length, String str) {
        String template = "%-" + length + "s";
        print(String.format(template, str));
    }

    public static void print(int length, Object... args) {
        StringBuilder sb = new StringBuilder();
        for (Object o : args) {
            sb.append(String.valueOf(o));
        }
        print(length, sb.toString());
    }

    public static void println(int length, String str) {
        String template = "%-" + length + "s";
        println(String.format(template, str));
    }

    public static void println(int length, Object... args) {
        StringBuilder sb = new StringBuilder();
        for (Object o : args) {
            sb.append(String.valueOf(o));
        }
        println(length, sb.toString());
    }

}
