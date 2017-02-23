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

        MathOperation addition = (int a, int b) -> a + b;
        MathOperation subtraction = (a, b) -> a - b;
        MathOperation multiplication = (int a, int b) -> {return a * b;};
        MathOperation division = (a, b) -> a / b;

        System.out.println("10+5="+operate(10, 5, addition));
        System.out.println("10-5="+operate(10, 5, subtraction));
        System.out.println("10*5="+operate(10, 5, multiplication));
        System.out.println("10/5="+operate(10, 5, division));


    }

    private static int operate(int a, int b, MathOperation operation) {
        return operation.operation(a, b);
    }

    private interface MathOperation {
        int operation(int a, int b);
    }

}