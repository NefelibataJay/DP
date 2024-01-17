package src.java.createPattern;


/*
单例模式是一种创建型设计模式， 它的核心思想是保证一个类只有一个实例，并提供一个全局访问点来访问这个实例。
只有一个实例的意思是，在整个应用程序中，只存在该类的一个实例对象，而不是创建多个相同类型的对象。
全局访问点的意思是，为了让其他类能够获取到这个唯一实例，该类提供了一个全局访问点（通常是一个静态方法），通过这个方法就能获得实例。

简易来说，单例设计模式有以下几个优点让我们考虑使用它：
全局控制：保证只有一个实例，这样就可以严格的控制客户怎样访问它以及何时访问它，简单的说就是对唯一实例的受控访问（引用自《大话设计模式》第21章）
节省资源：也正是因为只有一个实例存在，就避免多次创建了相同的对象，从而节省了系统资源，而且多个模块还可以通过单例实例共享数据。
懒加载：单例模式可以实现懒加载，只有在需要时才进行实例化，这无疑会提高程序的性能。
单例设计模式的基本要求

想要实现一个单例设计模式，必须遵循以下规则：
私有的构造函数：防止外部代码直接创建类的实例
私有的静态实例变量：保存该类的唯一实例
公有的静态方法：通过公有的静态方法来获取类的实例

什么时候使用单例设计模式?
资源共享:多个模块共享某个资源的时候，可以使用单例模式，比如说应用程序需要一个全局的配置管理器来存储和管理配置信息、亦或是使用单例模式管理数据库连接池。
只有一个实例:当系统中某个类只需要一个实例来协调行为的时候，可以考虑使用单例模式， 比如说管理应用程序中的缓存，确保只有一个缓存实例，
    避免重复的缓存创建和管理，或者使用单例模式来创建和管理线程池。
懒加载:如果对象创建本身就比较消耗资源，而且可能在整个程序中都不一定会使用，可以使用单例模式实现懒加载。
*/

// 饿汉模式：实例在类加载时就被创建, 这种方式的实现相对简单，但是实例有可能没有使用而造成资源浪费。
class HungrySingleton {
    private static final HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {
        // 私有构造方法，防止外部实例化
    }
    public static HungrySingleton getInstance() {
        return instance;
    }
}

// 懒汉模式：第一次使用时才创建
class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton() {
        // 私有构造方法，防止外部实例化
    }

    // 使用了同步关键字来确保线程安全, 可能会影响性能
    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}


// 双重检查锁定：第一次使用时才创建
public class Singleton {
    private static volatile Singleton instance;
    
    private Singleton() {
        // 私有构造方法，防止外部实例化
    }
    
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
