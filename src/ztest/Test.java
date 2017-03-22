package ztest;

/**
 * Created by ztest.Poker on 2016/11/20.
 */
public class Test{
    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        int a;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            for (int j = 0; j < Integer.MAX_VALUE; j++) {
                a = 12345;
                a *= 65;
            }
        }
        System.out.println(System.currentTimeMillis() - time);
        time = System.currentTimeMillis();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            for (int j = 0; j < Integer.MAX_VALUE; j++) {
                a = 12345;
                a = a << 2;
            }
        }
        System.out.println(System.currentTimeMillis() - time);

    }
}