package design_pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pokerface_lx on 16/9/8.
 */
public class MyObserved implements Observed {

    private List<Observer> observerList;

    public MyObserved() {
        observerList = new ArrayList<>();
    }

    @Override
    public void notifyObserver(String str) {
        for (Observer o: observerList) {
            o.update(str);
        }
    }

    @Override
    public void removeObserver(Observer o) {
        observerList.remove(o);
    }

    @Override
    public void addObserver(Observer o) {
        observerList.add(o);
    }
}
