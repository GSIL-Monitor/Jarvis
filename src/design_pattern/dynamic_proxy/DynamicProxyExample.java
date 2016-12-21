package design_pattern.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by Poker on 2016/11/11.
 */
public class DynamicProxyExample {

    public static void main(String[] args) {
        ConcreteClass c = new ConcreteClass();
        InvocationHandler handler = new ProxyHandler(c);
        TargetInterface targetInterface =
                (TargetInterface) Proxy.newProxyInstance(c.getClass().getClassLoader(),
                        c.getClass().getInterfaces(), handler);
        int a = targetInterface.targetMethodA(1);
        System.out.println(a);
        int b = targetInterface.targetMethodB(2);
        System.out.println(b);
    }

}
