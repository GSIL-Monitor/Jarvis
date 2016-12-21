package design_pattern.singleton;

/**
 * Created by pokerface_lx on 16/9/22.
 */
public class Singleton6 {

    private final static class Holder{
        private final static Singleton6 INSTANCE = new Singleton6();
    }

    private Singleton6(){}

    public static Singleton6 getInstance() {
        return Holder.INSTANCE;
    }

}
