package nowcoder.huawei;

import java.util.Scanner;

/**
 * Created by pokerface_lx on 16/8/12.
 */
public class P5 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            System.out.println(Integer.parseInt(scan.next().substring(2), 16));
        }
    }

}
