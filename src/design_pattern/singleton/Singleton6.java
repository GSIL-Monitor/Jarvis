package design_pattern.singleton;

/**
 * Description: 枚举、多线程安全、没有lazy初始化
 * 这种实现方式还没有被广泛采用，但这是实现单例模式的作家方法。它更简洁，自动支持序列化机制，绝对防止多次实例化
 * <p>
 * 这种方式是Effective Java的做着Josh Bloch提倡的方式，它不仅能避免多线程同步的问题，而且还自动支持序列化机制，防止反序列化重新创建新的对象，
 * 绝对防止多次实例化。不过由于JDK1.5之后才加入枚举特性，用这种方式写不免让人感觉生疏，在实际工作中也很少用
 * <p>
 * 不能通过reflection attack来调用私有构造方法
 * <p>
 * Author: liuxiao
 * Date: 2018/4/4
 */
public enum Singleton6 {

    INSTANCE;

}
