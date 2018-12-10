package algorithm.sort.algorithm;

import algorithm.sort.base.SortAlgorithm;

/**
 * Author: liuxiao
 * Created: 2018/11/10 14:03
 * Description:
 */
public class SleepSort implements SortAlgorithm {

    @Override
    public void sort(int[] nums) {
        for (int num : nums) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(num);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(num);
                }
            }).start();
        }
    }

}
