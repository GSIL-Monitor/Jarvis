package design_pattern.singleton;

/**
 * Created by pokerface_lx on 16/9/22.
 */
public class Singleton2 {

    private static Singleton2 instance = null;

    static {
        instance = new Singleton2();
    }

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        return instance;
    }

}
