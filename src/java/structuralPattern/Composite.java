package src.java.structuralPattern;

/*
组合模式是一种结构型设计模式，它将对象组合成树状结构来表示“部分-整体”的层次关系。组合模式使得客户端可以统一处理单个对象和对象的组合，而无需区分它们的具体类型。

我们用“省份-城市”举个例子，省份中包含了多个城市，如果将之比喻成一个树形结构，城市就是叶子节点，它是省份的组成部分，而“省份”就是合成节点，可以包含其他城市，形成一个整体，
省份和城市都是组件，它们都有一个共同的操作，比如获取信息。
 */

import java.util.ArrayList;
import java.util.List;

// 组件接口
interface Component {
    void operation();
}

// 叶子节点
class Leaf implements Component {
    @Override
    public void operation() {
        System.out.println("Leaf operation");
    }
}

// 组合节点：包含叶子节点的操作行为
public class Composite implements Component {
    private List<Component> components = new ArrayList<>();

    public void add(Component component) {
        components.add(component);
    }

    public void remove(Component component) {
        components.remove(component);
    }

    @Override
    public void operation() {
        System.out.println("Composite operation");
        for (Component component : components) {
            component.operation();
        }
    }
}

// 客户端代码
class CompositeExample {
    public static void main(String[] args) {
        // 创建叶子节点
        Leaf leaf = new Leaf();
        // 创建组合节点，并添加叶子节点
        Composite composite = new Composite();
        composite.add(leaf);

        composite.operation(); // 统一调用
    }
}
