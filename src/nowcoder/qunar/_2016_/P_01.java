package nowcoder.qunar._2016_;

import java.util.Scanner;
import java.util.Stack;

/**
 * 写一段代码，判断一个包括'{','[','(',')',']','}'的表达式是否合法(注意看样例的合法规则。)
 * 给定一个表达式A,请返回一个bool值，代表它是否合法。
 * 测试样例：
 * "[a+b*(5-4)]*{x+b+b*(({1+2)}}"
 * 返回：false
 * Created by pokerface_lx on 16/8/19.
 */
public class P_01 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            System.out.println(new P_01().chkLegal(scan.nextLine()));
        }
    }

    public boolean chkLegal(String A) {
        String str = A;
        Stack<Character> oprStack = new Stack<>();
        String dic = "{}[]()";
        boolean flag = true;
        loop:
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c != '[' && c != ']' && c != '(' && c != ')' && c != '{' && c != '}') {
                continue;
            }
            if (c == '(' || c == '[' || c == '{') {
                oprStack.push(c);
                continue;
            }
            if (oprStack.size() == 0 || oprStack.isEmpty()) {
                flag = false;
                break;
            }
            char popChar = oprStack.pop();
            switch (c) {
                case ')':
                    if (popChar != '(') {
                        flag = false;
                        break loop;
                    }
                    break;
                case ']':
                    if (popChar != '[') {
                        flag = false;
                        break loop;
                    }
                    break;
                case '}':
                    if (popChar != '{') {
                        flag = false;
                        break loop;
                    }
                    break;
            }
        }
        if (!oprStack.isEmpty()) {
            flag = false;
        }
        return flag;
    }

}
