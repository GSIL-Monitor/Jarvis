package _02_singleton;

/**
 * Created by pokerface_lx on 16/8/5.
 */
public class SingletonCommon {

    private static SingletonCommon instance = null;

    private SingletonCommon() {
    }

    public SingletonCommon getInstance() {
        if (instance == null) {
            synchronized (SingletonCommon.class) {
                if (instance == null) {
                    instance = new SingletonCommon();
                }
            }
        }
        return instance;
    }

}
