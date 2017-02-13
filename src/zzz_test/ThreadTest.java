package zzz_test;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Poker on 2016/12/21.
 */
public class ThreadTest {

    public static void main(String[] args) {
        new MyThread("thread1").start();
        new MyThread("thread2").start();
    }

    private static class MyThread extends Thread {
        private String name;
        private static int count = 0;

        public MyThread(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                synchronized ((Object) count) {
                    count++;
                    System.out.println(name + ": " + count);
                }
            }
        }
    }

}
