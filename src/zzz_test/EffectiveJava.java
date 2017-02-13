package zzz_test;

import java.util.HashMap;

/**
 * Created by Poker on 2017/2/4.
 */
public class EffectiveJava<K, V> {

    public static void main(String[] args) {

    }

    public static <K, V> HashMap<K, V> newInstance() {
        return new HashMap<K, V>();
    }

}
