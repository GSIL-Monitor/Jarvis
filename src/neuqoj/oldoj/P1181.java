package neuqoj.oldoj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Poker on 2016/11/19.
 */
public class P1181 {

    private static List<Integer> numList;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int radix = scan.nextInt();
            int num = scan.nextInt();
            initList(num);
            int step = 0;
            for (; step <= 30; step++) {
//                showList();
                if (checkPalin(numList)) {
                    break;
                }
                reverseAdd(numList, radix);
            }
            if (step <= 30) {
                System.out.println("STEP=" + step);
            } else {
                System.out.println("Impossible!");
            }
        }
    }

    private static void initList(int num) {
        numList = new ArrayList<>();
        String numStr = String.valueOf(num);
        for (int i = 0; i < numStr.length(); i++) {
            numList.add(numStr.charAt(i) - '0');
        }
    }

    private static boolean checkPalin(List<Integer> list) {
        for (int i = 0; i < list.size() / 2; i++) {
            if (list.get(i) != list.get(list.size() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    private static void reverseAdd(List<Integer> list, int radix) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < list.size(); i++) {
            stack.add(list.get(i) + list.get(list.size() - 1 - i));
        }
        numList.clear();
        while (stack.size() > 0) {
            int curNum = stack.pop();
            list.add(curNum % radix);
            if (curNum < radix) {
                continue;
            }
            if (stack.size() == 0) {
                stack.push(curNum / radix);
            } else {
                stack.push(stack.pop() + curNum / radix);
            }
        }
    }

    private static void showList() {
        for (int i = 0; i < numList.size(); i++) {
            System.out.print(numList.get(i));
        }
        System.out.println();
    }

}
