package bishi._360;

import java.util.Scanner;

/**
 * Created by pokerface_lx on 16/9/20.
 */
public class P1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int max = scan.nextInt();
            if (max == 1){
                System.out.println(1);
                continue;
            }
            if (String.valueOf(max).charAt(0) > '1') {
                System.out.println((int) Math.pow(2, String.valueOf(max).length())-1);
            }else {
                int n = (int)Math.pow(2,String.valueOf(max).length()-1);
                int[] nums = new int[n];
                for (int i = 0; i < nums.length; i++) {
                    nums[i] = Integer.parseInt(Integer.toBinaryString(i));
                }
                int temp = Integer.parseInt(String.valueOf(max).substring(1));
                int count = (int) Math.pow(2, String.valueOf(max).length()-1)-1;
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i]<=temp) {
                        count++;
                    }
                }
                System.out.println(count);
            }
        }
    }



}
