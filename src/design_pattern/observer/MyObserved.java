package design_pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pokerface_lx on 16/9/8.
 */
public class MyObserved implements IObserved {

    private List<IWatcher> watcherList;

    public MyObserved() {
        watcherList = new ArrayList<>();
    }

    @Override
    public void notifyObserver(String str) {
        for (IWatcher o: watcherList) {
            o.update(str);
        }
    }

    @Override
    public void removeObserver(IWatcher o) {
        watcherList.remove(o);
    }

    @Override
    public void addObserver(IWatcher o) {
        watcherList.add(o);
    }
}
