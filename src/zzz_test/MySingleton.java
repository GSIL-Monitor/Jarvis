package zzz_test;

/**
 * Created by Poker on 2017/1/11.
 */
public class MySingleton {

    private static MySingleton instance;

    private MySingleton(){}

    private static MySingleton getInstance() {
        if (instance == null) {
            synchronized (MySingleton.class) {
                instance = new MySingleton();
            }
        }
        return instance;
    }

}
