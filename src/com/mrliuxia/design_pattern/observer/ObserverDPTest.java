package com.mrliuxia.design_pattern.observer;

/**
 * Created by pokerface_lx on 16/9/8.
 */
public class ObserverDPTest {

    public static void main(String[] args) {

        IObserved pat = new MyObserved();
        IWatcher watcher1 = new MyWatcher();
        IWatcher watcher2 = new MyWatcher();
        pat.addObserver(watcher1);
        pat.addObserver(watcher2);

        pat.notifyObserver("message 1");
        pat.removeObserver(watcher1);
        pat.notifyObserver("message 2");

    }

}
