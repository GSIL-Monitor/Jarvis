package design_pattern.observer;

/**
 * Created by pokerface_lx on 16/9/8.
 */
public interface Observed {

    public void addObserver(Observer o);

    public void removeObserver(Observer o);

    public void notifyObserver(String str);

}
