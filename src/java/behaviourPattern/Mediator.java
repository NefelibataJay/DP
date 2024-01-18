package src.java.behaviourPattern;

/*
中介者模式（Mediator Pattern）也被称为调停者模式，是一种行为型设计模式，它通过一个中介对象来封装一组对象之间的交互，从而使这些对象不需要直接相互引用。
这样可以降低对象之间的耦合度，使系统更容易维护和扩展。

抽象中介者（Mediator）： 定义中介者的接口，用于各个具体同事对象之间的通信。

具体中介者（Concrete Mediator）： 实现抽象中介者接口，负责协调各个具体同事对象的交互关系，它需要知道所有具体同事类，并从具体同事接收消息，向具体同事对象发出命令。

抽象同事类（Colleague）： 定义同事类的接口，维护一个对中介者对象的引用，用于通信。

具体同事类（Concrete Colleague）： 实现抽象同事类接口，每个具体同事类只知道自己的行为，而不了解其他同事类的情况，因为它们都需要与中介者通信，通过中介者协调与其他同事对象的交互。

 */


import java.util.*;

// 抽象中介者
public interface Mediator {
    void register(Colleague colleague); // 客户注册
    void relay(String from, String to,String ad); // 转发
}

// 具体中介者
class ConcreteMediator implements Mediator {

    private List<Colleague> colleagues = new ArrayList<Colleague>();

    @Override
    public void register(Colleague colleague) {
        if (!colleagues.contains(colleague)) {
            colleagues.add(colleague);
            colleague.setMedium(this);
        }
    }

    @Override
    public void relay(String from, String to, String ad) {
        // TODO Auto-generated method stub
        for (Colleague cl : colleagues) {
            String name = cl.getName();
            if (name.equals(to)) {
                cl.receive(from, ad);
            }
        }
    }
}

// 同事类
abstract class Colleague {

    protected Mediator mediator;
    protected String name;

    public Colleague(String name) {
        this.name = name;
    }

    public void setMedium(Mediator mediator) {
        this.mediator = mediator;
    }

    public String getName() {
        return name;
    }

    public abstract void send(String to, String ad);
    public abstract void receive(String from, String ad);

}

// 具体同事类
class Buyer extends Colleague {

    public Buyer(String name) {
        super(name);
    }

    @Override
    public void send(String to, String ad) {
        // TODO Auto-generated method stub
        mediator.relay(name, to, ad);
    }

    @Override
    public void receive(String from, String ad) {
        // TODO Auto-generated method stub
        System.out.println(name + "接收到来自" + from + "的消息:" + ad);
    }

}

// 客户端
class MediatorExample{
    public static void main(String[] args) {
        // 创建中介者
        Mediator mediator = new ConcreteMediator();

        // 创建同事对象
        Colleague colleague1 = new Buyer("张三");
        Colleague colleague2 = new Buyer("李四");

//        colleague1.setMedium(mediator);
//        colleague2.setMedium(mediator);

        // 注册同事对象到中介者
        mediator.register(colleague1);
        mediator.register(colleague2);

        // 同事对象之间发送消息
        colleague1.send("李四", "你好，我是张三");
        colleague2.send("张三", "你好，我是李四");
    }
}
