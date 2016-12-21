package _03_find_in_partially_sorted_matirx;

import java.util.Scanner;

/**
 * Created by pokerface_lx on 16/8/5.
 */
public class FindInPartiallySortedMatirx {

    public static void main(String[] args) {
        int[][] nums = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        int target;
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            target = scan.nextInt();
            findTarget(target, nums);
        }
    }

    private static void findTarget(int target, int[][] nums) {
        int currentX = 0;
        int currentY = nums[0].length - 1;
        while (currentX < nums.length && currentY >= 0) {
            int current = nums[currentX][currentY];
            if (current == target) {
                System.out.println("exists, position:x=" + (currentX + 1) +
                        ",y=" + (currentY + 1));
                return;
            }
            if (current < target) {
                ++currentX;
            } else {
                --currentY;
            }
        }
        System.out.println("not exists");
    }

}
