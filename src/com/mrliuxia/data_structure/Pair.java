package com.mrliuxia.data_structure;

import java.util.Objects;

/**
 * Description: 两个Object的组合
 * 参考：android.com.mrliuxia.jarvis.util.Pair
 * <p>
 * Author: liuxiao
 * Date: 2018/3/30
 */
public class Pair<F, S> {

    public final F first;
    public final S second;

    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair<?, ?> p = ((Pair<?, ?>) obj);
        return Objects.equals(p.first, first) && Objects.equals(p.second, second);
    }

    @Override
    public int hashCode() {
        return (first == null ? 0 : first.hashCode()) ^ (second == null ? 0 : second.hashCode());
    }

    @Override
    public String toString() {
        return String.format("Pair{%s, %s}", String.valueOf(first), String.valueOf(second));
    }

    public static <A, B> Pair<A, B> create(A a, B b) {
        return new Pair<>(a, b);
    }

}
