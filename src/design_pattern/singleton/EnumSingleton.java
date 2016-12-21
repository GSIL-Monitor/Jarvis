package design_pattern.singleton;

/**
 * Created by pokerface_lx on 16/9/13.
 */
public enum EnumSingleton {
    INSTANCE;
    public Integer getInt(String s) {
        return (int)(s.charAt(0));
    }
}
