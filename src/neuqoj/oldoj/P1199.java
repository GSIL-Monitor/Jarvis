package neuqoj.oldoj;

import javax.xml.stream.XMLOutputFactory;
import java.util.Scanner;

/**
 * Created by Poker on 2016/11/20.
 */
public class P1199 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int a = scan.nextInt();
            int n = scan.nextInt();
            int m = scan.nextInt();
            int x = scan.nextInt();
            int[] ax = new int[n];
            int[] tx = new int[n];
            try {
                ax[3] = 1;
                tx[4] = 1;
            } catch (Exception e) {
            }
            if (n > 5) {
                for (int i = 5; i < n; i++) {
                    ax[i] = ax[i - 1] + ax[i - 2];
                    tx[i] = tx[i - 1] + tx[i - 2];
                }
            }
            int[] as = new int[n];
            int[] ts = new int[n];
            as[1]=1;
            as[2]=1;
            for (int i = 3; i <n; i++) {
                as[i]=as[i-1]+ax[i];
                ts[i]=ts[i-1]+tx[i];
            }
            int t = (m - a * as[n - 1]) / ts[n - 1];
            System.out.println(a * as[x] + t * ts[x]);
        }
    }

}
