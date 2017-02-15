package review.rv1702.design_pattern;

/**
 * Created by Poker on 2017/2/14.
 */
public class Singleton {

    private static Singleton instance;

    private Singleton() {

    }

    public synchronized static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

}
