package com.mrliuxia.design_pattern.singleton;

/**
 * Description: 登记式/静态内部类、线程安全、lazy初始化
 * 这种方式能达到双检锁方式一样的功效，但是实现更简单。对静态域使用延迟初始化，应使用这种方式而不是双检锁方式。这种方式只适用于静态域的情况，
 * 双检锁方式可以在实例域需要延迟初始化时使用。
 * <p>
 * 这种方式同样利用了classloader机制来保证初始化instance时只有一个线程，它跟第3中方式不同的是：第3种方式只要类被装载了，那么instance就会
 * 被实例话，没有达到lazy loading的洗哦啊过，而这种方式是Singleton类被装载了，instance不一定被初始化。因为SingletonHolder类没有被主动
 * 使用，只有通过显式调用getInstance方法时，才会显示装载SingletonHolder类，从而实例化instance。
 * <p>
 * 想象一下，如果实例话instance很消耗资源，所以让它延迟加载，另一方面，又不希望在Singleton类加载时就是梨花，因为不能确保其还可能在其他的地方被主动使用而被加载，
 * 那么这个时候实例话instance显然是不合适的。这个时候，这种方式相比第3种方式就显得更合理。
 * <p>
 * Author: liuxiao
 * Date: 2018/4/4
 */
public class Singleton5 {

    private static class SingletonHolder{
        public static final Singleton5 INSTANCE = new Singleton5();
    }

    private Singleton5() {

    }

    public static final Singleton5 getInstance() {
        return SingletonHolder.INSTANCE;
    }

}
