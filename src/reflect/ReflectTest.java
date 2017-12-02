package reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Author: liuxiao
 * Created: 2017/10/20 14:10
 * Description:
 */
public class ReflectTest {

    public static void main(String[] args) {
        try {
            //单例模式的反射调用
            Class clazz = Class.forName("reflect.Target");
            Object instance = clazz.getMethod("getInstance", null).invoke(null, null);
            Method method = clazz.getMethod("printHello", null);
            method.invoke(instance, null);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
