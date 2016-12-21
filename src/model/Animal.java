package model;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by pokerface_lx on 16/8/24.
 */
public interface Animal {

    public  String hello = "hello";

    default String defaultHello() {
        return "default hello";
    }

    public void say(String s);
}
