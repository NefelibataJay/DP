package src.java.behaviourPattern;

/*
观察者模式（发布-订阅模式）属于行为型模式，定义了一种一对多的依赖关系，让多个观察者对象同时监听一个主题对象，当主题对象的状态发生变化时，所有依赖于它的观察者都得到通知并被自动更新。

观察者模式依赖两个模块：
Subject(主题)：也就是被观察的对象，它可以维护一组观察者，当主题本身发生改变时就会通知观察者。
Observer(观察者)：观察主题的对象，当“被观察”的主题发生变化时，观察者就会得到通知并执行相应的处理。

使用观察者模式有很多好处，比如说观察者模式将主题和观察者之间的关系解耦，主题只需要关注自己的状态变化，
而观察者只需要关注在主题状态变化时需要执行的操作，两者互不干扰，并且由于观察者和主题是相互独立的，可以轻松的增加和删除观察者，这样实现的系统更容易扩展和维护。

观察者模式特别适用于一个对象的状态变化会影响到其他对象，并且希望这些对象在状态变化时能够自动更新的情况。
比如说在图形用户界面中，按钮、滑动条等组件的状态变化可能需要通知其他组件更新，这使得观察者模式被广泛应用于GUI框架，比如Java的Swing框架。

 */

import java.util.*;

// 主题接口 （主题）
interface Subject {
    // 注册观察者
    void registerObserver(Observer observer);
    // 移除观察者
    void removeObserver(Observer observer);
    // 通知观察者
    void notifyObservers();
}

// 观察者接口 (观察者)
interface Observer {
    // 更新方法
    void update(String message);
}

// 具体主题实现
class ConcreteSubject implements Subject {
    // 观察者列表
    private List<Observer> observers = new ArrayList<>();
    // 状态
    private String state;

    // 注册观察者
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }
    // 移除观察者
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
    // 通知观察者
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            // 观察者根据传递的信息进行处理
            observer.update(state);
        }
    }

    // 更新状态
    public void setState(String state) {
        this.state = state;
        notifyObservers();
    }
}

// 具体观察者实现
class ConcreteObserver implements Observer {
    // 更新方法
    @Override
    public void update(String message) {
    }
}


class ObserverExample {
    public static void main(String[] args) {

    }
}
