package heiheihei.j0034_triangle;

import java.util.Scanner;

/**
 * Created by Poker on 2016/12/28.
 */
public class Hello {

    private static Scanner scan;

    public static void main(String[] args) {
        scan = new Scanner(System.in);
        while (true) {
            showMenu();
            int order = 0;
            try {
                order = Integer.parseInt(scan.next());
            } catch (NumberFormatException nfe) {
                System.out.println("input invalid.\n");
                continue;
            }
            switch (order) {
                case 0:
                    return;
                case 1:
                    generateName();
                    break;
                case 2:
                    calculateFactorial();
                    break;
                default:
                    System.out.println("input invalid.\n");
                    break;
            }
        }
    }

    private static void showMenu() {
        System.out.println("--- Order Menu ---");
        System.out.println(" 1: generate a name");
        System.out.println(" 2: calculate factorial of a number");
        System.out.println(" 0: exit");
        System.out.println("------------------");
        System.out.print("input your order: ");
    }

    private static void generateName() {
        System.out.print("input your last name: ");
        String lastName = scan.next();
        System.out.print("input your first name: ");
        String firstName = scan.next();
        StringBuilder res = new StringBuilder();
        res.append(firstName.toUpperCase().charAt(0)).append(".")
                .append(lastName.toUpperCase().charAt(0)).append(lastName.substring(1));
        System.out.println("result: " + res.toString() + '\n');
    }

    private static void calculateFactorial() {
        System.out.print("input the number: ");
        String str = scan.next();
        if (str.charAt(str.length() - 1) == '!') {
            str = str.substring(0, str.length() - 1);
        }
        int num = 0;
        try {
            num = Integer.valueOf(str);
        } catch (NumberFormatException nfe) {
            System.out.println("input invalid.");
            return;
        }
        int res = 1;
        for (int i = 0; i < num; i++) {
            res *= (i + 1);
        }
        System.out.println("result: " + res + '\n');
    }

}
