package src.java.createPattern;


/*
该模式的核心思想是基于现有的对象创建新的对象，而不是从头开始创建。
在原型模式中，通常有一个原型对象，它被用作创建新对象的模板。新对象通过复制原型对象的属性和状态来创建，而无需知道具体的创建细节。

为什么要使用原型模式
如果一个对象的创建过程比较复杂时（比如需要经过一系列的计算和资源消耗），那每次创建该对象都需要消耗资源，
而通过原型模式就可以复制现有的一个对象来迅速创建/克隆一个新对象，不必关心具体的创建细节，可以降低对象创建的成本。

什么时候实现原型模式
相比于直接实例化对象，通过原型模式复制对象可以减少资源消耗，提高性能，尤其在对象的创建过程复杂或对象的创建代价较大的情况下。
当需要频繁创建相似对象、并且可以通过克隆避免重复初始化工作的场景时可以考虑使用原型模式，在克隆对象的时候还可以动态地添加或删除原型对象的属性，创造出相似但不完全相同的对象，提高了灵活性。
但是使用原型模式也需要考虑到如果对象的内部状态包含了引用类型的成员变量，那么实现深拷贝就会变得较为复杂，需要考虑引用类型对象的克隆问题。
 */

import java.util.Scanner;

public abstract class Prototype implements Cloneable {
    public abstract Prototype clone();
    public abstract String getDetails();

    // 公共的 clone 方法
    public Prototype clonePrototype() {
        try {
            return (Prototype) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}

// 具体矩形原型类
class RectanglePrototype extends Prototype {
    private String color;
    private int width;
    private int height;

    // 构造方法
    public RectanglePrototype(String color, int width, int height) {
        this.color = color;
        this.width = width;
        this.height = height;
    }

    // 克隆方法
    @Override
    public Prototype clone() {
        return clonePrototype();
    }

    // 获取矩形的详细信息
    @Override
    public String getDetails() {
        return "Color: " + color + ", Width: " + width + ", Height: " + height;
    }
}

class PrototypeExample{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取需要创建的矩形数量
        int N = scanner.nextInt();

        // 读取每个矩形的属性信息并创建矩形对象
        for (int i = 0; i < N; i++) {
            String color = scanner.next();
            int width = scanner.nextInt();
            int height = scanner.nextInt();

            // 创建原型对象
            Prototype originalRectangle = new RectanglePrototype(color, width, height);

            // 克隆对象并输出详细信息
            Prototype clonedRectangle = originalRectangle.clone();
            System.out.println(clonedRectangle.getDetails());
        }
    }
}

