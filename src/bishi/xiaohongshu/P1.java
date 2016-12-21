package bishi.xiaohongshu;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Poker on 2016/10/30.
 */
public class P1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            String equation = scan.nextLine();
            if (isValid(equation)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    private static boolean isValid(String equation) {
        Stack<Character> open = new Stack<>();
        for (int i = 0; i < equation.length(); i++) {
            switch (equation.charAt(i)) {
                case '(':
                    open.push('1');
                    break;
                case ')':
                    if (open.size() > 0) {
                        open.pop();
                    } else {
                        return false;
                    }
                    break;
            }
        }
        if (open.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

}
