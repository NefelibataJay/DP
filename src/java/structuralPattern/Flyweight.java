package src.java.structuralPattern;

/*
享元模式是一种结构型设计模式，在享元模式中，对象被设计为可共享的，可以被多个上下文使用，而不必在每个上下文中都创建新的对象。

想要了解享元模式，就必须要区分什么是内部状态，什么是外部状态。
内部状态是指那些可以被多个对象共享的状态，它存储在享元对象内部，并且对于所有享元对象都是相同的，这部分状态通常是不变的。
而外部状态是享元对象依赖的、可能变化的部分。这部分状态不存储在享元对象内部，而是在使用享元对象时通过参数传递给对象。

举个例子，图书馆中有很多相同的书籍，但每本书都可以被多个人借阅，图书馆里的书就是内部状态，人就是外部状态。

再举个开发中的例子，假设我们在构建一个简单的图形编辑器，用户可以在画布上绘制不同类型的图形，而图形就是所有图形对象的内部状态（不变的），而图形的坐标位置就是图形对象的外部状态（变化的）。
如果图形编辑器中有成千上万的图形对象，每个图形对象都独立创建并存储其内部状态，那么系统的内存占用可能会很大，
在这种情况下，享元模式共享相同类型的图形对象，每种类型的图形对象只需创建一个共享实例，然后通过设置不同的坐标位置个性化每个对象，通过共享相同的内部状态，降低了对象的创建和内存占用成本。
 */

import java.util.*;
import java.util.Scanner;

// 步骤 1: 定义享元接口
public interface Flyweight {
    // 操作外部状态
    void operation(String externalState);
}

// 步骤 2: 实现具体享元类
class ConcreteFlyweight implements Flyweight {
    private String intrinsicState; // 内部状态

    public ConcreteFlyweight(String intrinsicState) {
        this.intrinsicState = intrinsicState;
        System.out.println("ConcreteFlyweight created: " + intrinsicState);
    }

    @Override
    public void operation(String externalState) {
        System.out.println("Intrinsic State: " + intrinsicState + ", External State: " + externalState);
    }
}

class FlyweightFactory {
    private Map<String, Flyweight> flyweights = new HashMap<>();

    public Flyweight getFlyweight(String key) {
        if (!flyweights.containsKey(key)) {
            flyweights.put(key, new ConcreteFlyweight(key));
        }
        return flyweights.get(key);
    }
}


class FlyweightExample {
    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();

        // 获取或创建享元对象，并传递外部状态
        Flyweight flyweight1 = factory.getFlyweight("A");
        flyweight1.operation("External State 1");

        Flyweight flyweight2 = factory.getFlyweight("B");
        flyweight2.operation("External State 2");

        Flyweight flyweight3 = factory.getFlyweight("A"); // 重复使用已存在的享元对象
        flyweight3.operation("External State 3");
    }
}


enum ShapeType {
    CIRCLE, RECTANGLE, TRIANGLE
}

class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

// 享元
interface Shape {
    void draw(Position position);
}

class ConcreteShape implements Shape {
    private ShapeType shapeType;

    public ConcreteShape(ShapeType shapeType) {
        this.shapeType = shapeType;
    }

    @Override
    public void draw(Position position) {
        System.out.println(shapeType + (isFirstTime ? " drawn" : " shared") + " at (" + position.getX() + ", " + position.getY() + ")");
    }

    private boolean isFirstTime = true;

    public void setFirstTime(boolean firstTime) {
        isFirstTime = firstTime;
    }
}

class ShapeFactory {
    private Map<ShapeType, Shape> shapes = new HashMap<>();

    public Shape getShape(ShapeType type) {
        if (!shapes.containsKey(type)) {
            shapes.put(type, new ConcreteShape(type));
        }
        return shapes.get(type);
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShapeFactory factory = new ShapeFactory();

        while (scanner.hasNext()) {
            String command = scanner.nextLine();
            processCommand(factory, command);
        }
    }

    private static void processCommand(ShapeFactory factory, String command) {
        String[] parts = command.split(" ");
        ShapeType type = ShapeType.valueOf(parts[0]);
        int x = Integer.parseInt(parts[1]);
        int y = Integer.parseInt(parts[2]);

        Shape shape = factory.getShape(type);
        shape.draw(new Position(x, y));
        ((ConcreteShape) shape).setFirstTime(false);
    }
}
