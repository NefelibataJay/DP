package src.java.behaviourPattern;

/*
状态模式（State Pattern）是一种行为型设计模式，它适用于一个对象在在不同的状态下有不同的行为时，比如说电灯的开、关、闪烁是不停的状态，
状态不同时，对应的行为也不同，在没有状态模式的情况下，为了添加新的状态或修改现有的状态，往往需要修改已有的代码，这违背了开闭原则，
而且如果对象的状态切换逻辑和各个状态的行为都在同一个类中实现，就可能导致该类的职责过重，不符合单一职责原则。

而状态模式将每个状态的行为封装在一个具体状态类中，使得每个状态类相对独立，并将对象在不同状态下的行为进行委托，
从而使得对象的状态可以在运行时动态改变，每个状态的实现也不会影响其他状态。

State（状态）： 定义一个接口，用于封装与Context的一个特定状态相关的行为。
ConcreteState（具体状态）： 负责处理Context在状态改变时的行为, 每一个具体状态子类实现一个与Context的一个状态相关的行为。
Context（上下文）: 维护一个具体状态子类的实例，这个实例定义当前的状态。
 */

// 状态接口
public interface State {
    void handle();
}

// 具体状态类1
class ConcreteState1 implements State {
    @Override
    public void handle() {
        // 执行在状态1下的操作
        System.out.println("State 1");
    }
}

// 具体状态类2
class ConcreteState2 implements State {
    @Override
    public void handle() {
        // 执行在状态2下的操作
        System.out.println("State 2");
    }
}

// 上下文类
class StateContext {
    private State currentState;

    public void setState(State state) {
        this.currentState = state;
    }

    public void request() {
        currentState.handle();
    }
}

class StateExample {
    public static void main(String[] args) {
        StateContext context = new StateContext();

        State state1 = new ConcreteState1();
        State state2 = new ConcreteState2();

        context.setState(state1);
        context.request(); // 执行在状态1下的操作

        context.setState(state2);
        context.request(); // 执行在状态2下的操作
    }
}

