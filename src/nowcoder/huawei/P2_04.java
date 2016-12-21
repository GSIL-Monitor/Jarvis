package nowcoder.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目描述
 * 计算最少出列多少位同学，使得剩下的同学排成合唱队形
 * 说明：
 * N位同学站成一排，音乐老师要请其中的(N-K)位同学出列，使得剩下的K位同学排成合唱队形。
 * 合唱队形是指这样的一种队形：设K位同学从左到右依次编号为1，2…，K，他们的身高分别为T1，T2，…，TK，
 * 则他们的身高满足存在i（1<=i<=K）使得Ti<T2<......<Ti-1<Ti>Ti+1>......>TK。
 * 你的任务是，已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形。
 * <p>
 * Created by pokerface_lx on 16/8/17.
 */
public class P2_04 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] students = new int[n];
        for (int i = 0; i < n; i++) {
            students[i] = scan.nextInt();
        }
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = 1;
        leftLoop:
        for (int i = 1; i < n; i++) {
            if (students[i] > students[i - 1]) {
                leftMax[i] = leftMax[i - 1] + 1;
                continue leftLoop;
            }
            for (int j = i - 1; j >= 0; j--) {
                if (students[i] > students[j]) {
                    leftMax[i] = leftMax[j] + 1;
                    continue leftLoop;
                }
            }
            leftMax[i] = 1;
        }
        rightMax[n - 1] = 1;
        rightLoop:
        for (int i = n - 2; i >= 0; i--) {
            if (students[i] > students[i + 1]) {
                rightMax[i] = rightMax[i + 1] + 1;
                continue rightLoop;
            }
            for (int j = i + 1; j < n; j++) {
                if (students[i] > students[j]) {
                    rightMax[i] = rightMax[j] + 1;
                    continue rightLoop;
                }
            }
            rightMax[i] = 1;
        }
        System.out.println("left" + Arrays.toString(leftMax));
        System.out.println("right" + Arrays.toString(rightMax));
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = (leftMax[i] + rightMax[i]) > max ? (leftMax[i] + rightMax[i]) : max;
        }
        System.out.println(max);
        System.out.println(n + 1 - max);
    }

}
