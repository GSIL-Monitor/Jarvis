import java.util.Scanner;

/**
 * Created by pokerface_lx on 16/9/20.
 */
public class P1_0 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int n = scan.nextInt();
            int count = 0;
            loop:
            for (int i = 1; i <= n; i++) {
                String s = String.valueOf(i);
                for (int j = 0; j < s.length(); j++) {
                    if (s.charAt(j) != '0' && s.charAt(j) != '1') {
                        continue loop;
                    }
                }
                count++;
            }
            System.out.println(count);
        }
    }

}
