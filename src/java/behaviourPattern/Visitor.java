package src.java.behaviourPattern;

/*
访问者模式（Visitor Pattern）是一种行为型设计模式，可以在不改变对象结构的前提下，对对象中的元素进行新的操作。

举个例子，假设有一个动物园，里面有不同种类的动物，比如狮子、大象、猴子等。
每个动物都会被医生检查身体，被管理员投喂，被游客观看，医生，游客，管理员都属于访问者。

访问者模式结构较为复杂，但是访问者模式将同一类操作封装在一个访问者中，使得相关的操作彼此集中，提高了代码的可读性和维护性。
它常用于对象结构比较稳定，但经常需要在此对象结构上定义新的操作，这样就无需修改现有的元素类，只需要定义新的访问者来添加新的操作。
 */

// 定义动物接口
interface Animal {
    void accept(Visitor visitor);
}

// 具体元素类：狮子
class Lion implements Animal {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

// 具体元素类：大象
class Elephant implements Animal {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

// 具体元素类：猴子
class Monkey implements Animal {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}


// 定义访问者接口
interface Visitor {
    void visit(Animal animal);
}

// 具体访问者类：医生
class Doctor implements Visitor {
    @Override
    public void visit(Animal animal) {
        System.out.println("Doctor visit " + animal.getClass().getSimpleName());
    }
}

// 具体访问者类：管理员
class Zookeeper implements Visitor {
    @Override
    public void visit(Animal animal) {
        System.out.println("Zookeeper visit " + animal.getClass().getSimpleName());
    }
}

// 具体访问者类：游客
class VisitorPerson implements Visitor {
    @Override
    public void visit(Animal animal) {
        System.out.println("VisitorPerson visit " + animal.getClass().getSimpleName());
    }
}

class VisitorExample {
    public static void main(String[] args) {
        Animal lion = new Lion();
        Animal elephant = new Elephant();
        Animal monkey = new Monkey();

        Visitor vet = new Doctor();
        Visitor zookeeper = new Zookeeper();
        Visitor visitorPerson = new VisitorPerson();

        // 动物接受访问者的访问
        lion.accept(vet);
        elephant.accept(zookeeper);
        monkey.accept(visitorPerson);
    }
}
