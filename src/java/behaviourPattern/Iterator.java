package src.java.behaviourPattern;

import java.util.*;

/*
迭代器模式是一种行为设计模式，是一种使用频率非常高的设计模式，在各个语言中都有应用，
其主要目的是提供一种统一的方式来访问一个聚合对象中的各个元素，而不需要暴露该对象的内部表示。
通过迭代器，客户端可以顺序访问聚合对象的元素，而无需了解底层数据结构。

迭代器接口Iterator：定义访问和遍历元素的接口, 通常会包括hasNext()方法用于检查是否还有下一个元素，
以及next()方法用于获取下一个元素。有的还会实现获取第一个元素以及获取当前元素的方法。
具体迭代器ConcreteIterator：实现迭代器接口，实现遍历逻辑对聚合对象进行遍历。
抽象聚合类：定义了创建迭代器的接口，包括一个createIterator方法用于创建一个迭代器对象。
具体聚合类：实现在抽象聚合类中声明的createIterator() 方法，返回一个与具体聚合对应的具体迭代器

 */

// 迭代器接口
public interface Iterator{
    // 检查是否还会有下一个元素
    boolean hasNext();
    // 获取下一个元素
    Object next();
}

// 定义具体迭代器：实现迭代器接口，遍历集合。
class ConcreteIterator implements Iterator {
    private int index;
    private List<Object> elements;

    // 构造函数初始化迭代器
    public ConcreteIterator(List<Object> elements) {
        this.elements = elements;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < elements.size();
    }

    @Override
    public Object next() {
        if (hasNext()) {
            return elements.get(index++);
        }
        return null;
    }
}

// 定义聚合接口：通常包括createIterator()方法，用于创建迭代器
interface Iterable {
    Iterator createIterator();
}

// 具体聚合
class ConcreteIterable implements Iterable {
    private List<Object> elements;

    // 构造函数初始化可迭代对象
    public ConcreteIterable(List<Object> elements) {
        this.elements = elements;
    }

    @Override
    public Iterator createIterator() {
        return new ConcreteIterator(elements);
    }
}

class IteratorExample {
    public static void main(String[] args) {
        List<Object> elements = new ArrayList<>();
        elements.add("Element 1");
        elements.add("Element 2");
        elements.add("Element 3");

        Iterable iterable = new ConcreteIterable(elements);
        Iterator iterator = iterable.createIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

