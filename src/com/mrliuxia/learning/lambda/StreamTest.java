package com.mrliuxia.learning.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by Poker on 2017/2/23.
 */
public class StreamTest {

    public static void main(String[] args) {

        //filter
        List<String> strings = Arrays.asList("a", "ab", "abc", "abcd", "abcde");
        List<String> filtered = strings.stream().filter(s -> s.length() > 2).collect(Collectors.toList());
        System.out.println("Origin strings: " + Arrays.toString(strings.toArray()));
        System.out.println("Filtered strings: " + Arrays.toString(filtered.toArray()));

        //limit
        Random random = new Random();
        System.out.println("\nRandom Numbers: ");
        random.ints().limit(3).forEach(System.out::println);

        //com.mrliuxia.jarvis.map
        List<Integer> nums = Arrays.asList(1, 2, 3, 2);
        List<Integer> squares = nums.stream().map(a -> a * a).distinct().collect(Collectors.toList());
        System.out.println("\nOrigin nums: " + Arrays.toString(nums.toArray()));
        System.out.println("Square nums: " + Arrays.toString(squares.toArray()));

        //sorted
        System.out.println();
        random.ints().limit(10).sorted().forEach(a -> System.out.print(a + " "));
        System.out.println();

        //parallelStream
        List<String> strings1 = Arrays.asList("abc", "", "abcd", "a", "ab");
        int count = (int) strings1.parallelStream().filter(s -> s.length() == 0).count();
        System.out.println(Arrays.toString(strings1.toArray()));
        System.out.println("length=0 count: " + count);

    }

}
