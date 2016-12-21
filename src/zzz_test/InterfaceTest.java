package zzz_test;

/**
 * Created by pokerface_lx on 16/9/2.
 */
public interface InterfaceTest extends Inter1,Inter2{

    default void test() {
        System.out.println();
    }
}
