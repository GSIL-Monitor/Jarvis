package zzz_test;

import javax.swing.*;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by pokerface_lx on 16/8/10.
 */
public class Main {

    public static void main(String[] args) {
        final Data data = new Data();
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                public void run() {
                    for (int j = 0; j < 5; j++) {
                        data.setData(new Random().nextInt(10));
                    }
                }
            }).start();
        }
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                public void run() {
                    for (int j = 0; j < 5; j++) {
                        data.getData();
                    }
                }
            }).start();
        }
    }

    private static class Data{
        private int data;
        private ReadWriteLock lock = new ReentrantReadWriteLock();

        public void setData(int data) {
            lock.writeLock().lock();
            try {
                System.out.println(Thread.currentThread().getName() + "准备写入数据");
                this.data = data;
                System.out.println(Thread.currentThread().getName() + "写入" + this.data);
            } finally {
                lock.writeLock().unlock();
            }
        }

        public void getData() {
            lock.readLock().lock();
            try {
                System.out.println(Thread.currentThread().getName() + "准备读取数据");
                System.out.println(Thread.currentThread().getName() + "读取" + this.data);
            }finally {
                lock.readLock().unlock();
            }
        }

    }

}