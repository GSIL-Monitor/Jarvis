package com.mrliuxia.learning.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Poker on 2017/2/23.
 */
public class LambdaTest {

    public static void main(String[] args) {

        MathOperation addition = (int a, int b) -> a + b;
        MathOperation subtraction = (a, b) -> a - b;
        MathOperation multiplication = (int a, int b) -> {
            return a * b;
        };
        MathOperation division = (a, b) -> a / b;

        System.out.println("10+5=" + operate(10, 5, addition));
        System.out.println("10-5=" + operate(10, 5, subtraction));
        System.out.println("10*5=" + operate(10, 5, multiplication));
        System.out.println("10/5=" + operate(10, 5, division));

        List<String> list = new ArrayList<>();
        Collections.sort(list, (s1, s2) -> s1.compareTo(s2));

    }

    private static int operate(int a, int b, MathOperation operation) {
        return operation.operation(a, b);
    }

    private interface MathOperation {
        int operation(int a, int b);
    }

}
