package design_pattern.observer;

/**
 * Created by pokerface_lx on 16/9/8.
 */
public class ObserverTest {

    public static void main(String[] args) {
        MyObserved myObserved = new MyObserved();
        MyObserver myObserver = new MyObserver();
        myObserved.addObserver(myObserver);
        myObserved.addObserver(new MyObserver());
        myObserved.notifyObserver("message 1");
        myObserved.removeObserver(myObserver);
        myObserved.notifyObserver("message 2");
    }

}
