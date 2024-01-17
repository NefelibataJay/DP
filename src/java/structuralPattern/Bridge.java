package src.java.structuralPattern;

/*
桥接模式（Bridge Pattern）是一种结构型设计模式，它的UML图很像一座桥，它通过将【抽象部分】与【实现部分】分离，使它们可以独立变化，从而达到降低系统耦合度的目的。
桥接模式的主要目的是通过组合建立两个类之间的联系，而不是继承的方式。

举个简单的例子，图形编辑器中，每一种图形都需要蓝色、红色、黄色不同的颜色，如果不使用桥接模式，可能需要为每一种图形类型和每一种颜色都创建一个具体的子类，
而使用桥接模式可以将图形和颜色两个维度分离，两个维度都可以独立进行变化和扩展，如果要新增其他颜色，只需添加新的 Color 子类，不影响图形类；反之亦然。
 */


interface Software {
    public void run();
}

class AppStore implements Software {

    @Override
    public void run() {
        System.out.println("run app store");
    }
}

class Camera implements Software {

    @Override
    public void run() {
        System.out.println("run camera");
    }
}

abstract class Phone {

    protected Software software;

    public void setSoftware(Software software) {
        this.software = software;
    }

    public abstract void run();

}

class Oppo extends Phone {

    @Override
    public void run() {
        System.out.println("run oppo");
    }
}

class Vivo extends Phone {

    @Override
    public void run() {
        System.out.println("run vivo");
    }
}


public class Bridge {
    public static void main(String[] args) {

    }
}
