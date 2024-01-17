package src.java.structuralPattern;


/*
在代理模式中，允许一个对象（代理）充当另一个对象（真实对象）的接口，以控制对这个对象的访问。通常用于在访问某个对象时引入一些间接层(中介的作用)，
这样可以在访问对象时添加额外的控制逻辑，比如限制访问权限，延迟加载。

Spring 框架的 AOP 模块使用了代理模式来实现切面编程。通过代理，Spring 能够在目标对象的方法执行前、执行后或抛出异常时插入切面逻辑，而不需要修改原始代码。
Java 提供了动态代理机制，允许在运行时生成代理类。

代理模式和适配器模式有什么区别
代理模式的主要目的是控制对对象的访问。通常用于在访问真实对象时引入一些额外的控制逻辑，如权限控制、延迟加载等。
适配器模式的主要目的是使接口不兼容的对象能够协同工作。适配器模式允许将一个类的接口转换成另一个类的接口，使得不同接口的类可以协同工作。

 */

// 1. 定义抽象主题
interface Subject {
    void request();
}

// 2. 定义真实主题
class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("RealSubject handles the request.");
    }
}

// 3. 定义代理
public class Proxy implements Subject {
    // 包含一个引用
    private RealSubject realSubject;

    @Override
    public void request() {
        // 在访问真实主题之前可以添加额外的逻辑
        // 例如用户身份判断
        if (realSubject == null) {
            realSubject = new RealSubject();
        }
        // 调用真实主题的方法
        realSubject.request();

        // 在访问真实主题之后可以添加额外的逻辑
    }
}

class ProxyExample {
    public static void main(String[] args) {
        // 使用代理
        Subject proxy = new Proxy();
        proxy.request();
    }
}
