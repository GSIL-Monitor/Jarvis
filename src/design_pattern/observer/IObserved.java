package design_pattern.observer;

/**
 * Created by pokerface_lx on 16/9/8.
 */
public interface IObserved {

    public void addObserver(IWatcher o);

    public void removeObserver(IWatcher o);

    public void notifyObserver(String str);

}
