package neuqoj.oldoj;


import java.util.Scanner;

/**
 * Created by Poker on 2016/11/20.
 */
public class P1509 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int num = scan.nextInt();
            move(num, 'A', 'B', 'C');
        }
    }

    private static void move(int num, char from, char by, char to) {
        if (num == 1) {
            System.out.println(from + "---" + to);
        } else {
            move(num - 1, from, to, by);
            System.out.println(from + "---" + to);
            move(num - 1, by, from, to);
        }
    }

}
