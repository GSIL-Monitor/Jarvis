package util;

import java.util.Arrays;
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


}
