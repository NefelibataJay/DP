package src.java.behaviourPattern;

/*
它定义了一系列算法（这些算法完成的是相同的工作，只是实现不同），并将每个算法封装起来，使它们可以相互替换，而且算法的变化不会影响使用算法的客户。

举个例子，电商网站对于商品的折扣策略有不同的算法，比如新用户满减优惠，不同等级会员的打折情况不同，这种情况下会产生大量的if-else语句,
并且如果优惠政策修改时，还需要修改原来的代码，不符合开闭原则。

这就可以将不同的优惠算法封装成独立的类来避免大量的条件语句，如果新增优惠算法，可以添加新的策略类来实现，客户端在运行时选择不同的具体策略，
而不必修改客户端代码改变优惠策略。

策略类Strategy: 定义所有支持的算法的公共接口。
具体策略类ConcreteStrategy: 实现了策略接口，提供具体的算法实现。
上下文类Context: 包含一个策略实例，并在需要时调用策略对象的方法。

 */

// 1. 抽象策略抽象类 也可以是接口
public interface Strategy {

    public int calc(int num1,int num2);
}

// 2. 具体策略
class AddStrategy implements Strategy {

    @Override
    public int calc(int num1, int num2) {
        return num1 + num2;
    }

}
class SubstractStrategy implements Strategy {

    @Override
    public int calc(int num1, int num2) {
        return num1 - num2;
    }

}

// 4. 上下文类
class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int calculate(int a, int b) {
        return strategy.calc(a, b);
    }
}

class StrategyExample {
    public static void main(String[] args) {
        // 创建上下文对象，并设置具体的策略
        Context contextA = new Context(new AddStrategy());
        // 执行策略
        contextA.calculate(3,4);

        Context contextB = new Context(new SubstractStrategy());
        contextB.calculate(3,4);

    }
}