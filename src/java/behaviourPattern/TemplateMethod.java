package src.java.behaviourPattern;

/*
模板方法模式（Template Method Pattern）是一种行为型设计模式, 它定义了一个算法的骨架，将一些步骤的实现延迟到子类。
模板方法模式使得子类可以在不改变算法结构的情况下，重新定义算法中的某些步骤。

举个简单的例子，做一道菜通常都需要包含至少三步：
1.准备食材  2.亨饪过程  3.上菜
不同菜品的亨饪过程是不一样的，但是我们可以先定义一个”骨架”，包含这三个步骤，亨饪过程的过程放到具体的炒菜类中去实现，
这样，无论炒什么菜，都可以沿用相同的炒菜算法，只需在子类中实现具体的炒菜步骤，从而提高了代码的复用性。

 */

// 模板类
abstract class AbstractTemplate {
    // 模板方法，定义了算法的骨架
    public final void templateMethod() {
        step1();
        step2();
        step3();
    }

    // 抽象方法，由子类实现
    protected abstract void step1();
    protected abstract void step2();
    protected abstract void step3();
}

// 具体类
class ConcreteClass extends AbstractTemplate {
    @Override
    protected void step1() {
        System.out.println("Step 1");
    }

    @Override
    protected void step2() {
        System.out.println("Step 2 ");
    }

    @Override
    protected void step3() {
        System.out.println("Step 3");
    }
}

public class TemplateMethod {
    public static void main(String[] args) {
        AbstractTemplate template = new ConcreteClass();
        template.templateMethod();
    }
}
