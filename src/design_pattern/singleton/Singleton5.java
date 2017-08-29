package design_pattern.singleton;

/**
 * Created by pokerface_lx on 16/9/22.
 */
public class Singleton5 {

    private static Singleton5 instance = new Singleton5();

    private Singleton5() {}

    public synchronized static Singleton5 getInstance() {
        synchronized (Singleton5.class) {
            if (instance == null) {
                instance = new Singleton5();
            }
        }
        return instance;
    }

}
