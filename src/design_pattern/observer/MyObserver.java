package design_pattern.observer;

/**
 * Created by pokerface_lx on 16/9/8.
 */
public class MyObserver implements Observer {
    @Override
    public void update(String str) {
        System.out.println("receiving message --- "+ str);
    }
}
