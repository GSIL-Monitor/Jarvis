package design_pattern.singleton;

/**
 * Created by pokerface_lx on 16/9/22.
 */
public class Singleton1 {

    private static final Singleton1 INSTANCE = new Singleton1();

    private Singleton1(){}

    public static Singleton1 getInstance() {
        return INSTANCE;
    }

}
