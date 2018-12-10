package com.mrliuxia.design_pattern.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Poker on 2016/11/9.
 */
public class ProxyHandler implements InvocationHandler {

    private Object concreteClass;

    public ProxyHandler(Object concreteClass) {
        this.concreteClass = concreteClass;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy:"+proxy.getClass().getName());
        System.out.println("method:"+method.getClass().getName());
        System.out.println("args:"+args.getClass().getName());
        System.out.println("before invoke method...");
        Object o = method.invoke(concreteClass,args);
        System.out.println("after invoke method...");
        return o;
    }

}
