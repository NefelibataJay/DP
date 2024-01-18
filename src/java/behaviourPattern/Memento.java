package src.java.behaviourPattern;

/*
备忘录模式（Memento Pattern）是一种行为型设计模式，它允许在不暴露对象实现的情况下捕获对象的内部状态并在对象之外保存这个状态，以便稍后可以将其还原到先前的状态。

发起人Originator： 需要还原状态的那个对象，负责创建一个【备忘录】，并使用备忘录记录当前时刻的内部状态。
备忘录Memento: 存储发起人对象的内部状态，它可以包含发起人的部分或全部状态信息，但是对外部是不可见的，只有发起人能够访问备忘录对象的状态。

备忘录有两个接口，发起人能够通过宽接口访问数据，管理者只能看到窄接口，并将备忘录传递给其他对象。
管理者Caretaker: 负责存储备忘录对象，但并不了解其内部结构，管理者可以存储多个备忘录对象。
客户端：在需要恢复状态时，客户端可以从管理者那里获取备忘录对象，并将其传递给发起人进行状态的恢复。

 */

import java.util.*;

class Originator {
    private String state;

    public void setState(String state) {
        this.state = state;
    }
    public String getState() {
        return state;
    }
    // 创建备忘录对象
    public Memento createMemento() {
        return new Memento(state);
    }
    // 通过备忘录对象恢复状态
    public void restoreFromMemento(Memento memento) {
        state = memento.getState();
    }
}

public class Memento {

    private String state;
    // 保存发起人的状态
    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

class Caretaker {
    private List<Memento> mementos = new ArrayList<>();

    public void addMemento(Memento memento) {
        mementos.add(memento);
    }

    public Memento getMemento(int index) {
        return mementos.get(index);
    }
}


class MementoExample {
    public static void main(String[] args) {
        // 创建发起人对象
        Originator originator = new Originator();
        originator.setState("State 1");

        // 创建管理者对象
        Caretaker caretaker = new Caretaker();

        // 保存当前状态
        caretaker.addMemento(originator.createMemento());

        // 修改状态
        originator.setState("State 2");

        // 再次保存当前状态
        caretaker.addMemento(originator.createMemento());

        // 恢复到先前状态
        originator.restoreFromMemento(caretaker.getMemento(0));

        System.out.println("Current State: " + originator.getState());
    }
}
