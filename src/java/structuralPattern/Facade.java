package src.java.structuralPattern;


/*
外观模式Facade Pattern, 也被称为“门面模式”，是一种结构型设计模式，外观模式定义了一个高层接口，这个接口使得子系统更容易使用，同时也隐藏了子系统的复杂性。
门面模式可以将子系统关在“门里”隐藏起来，客户端只需要通过外观接口与外观对象进行交互，而不需要直接和多个子系统交互，无论子系统多么复杂，对于外部来说是隐藏的，这样可以降低系统的耦合度。
举个例子，假设你正在编写的一个模块用来处理文件读取、解析、存储，我们可以将这个过程拆成三部分，然后创建一个外观类，将文件系统操作、数据解析和存储操作封装在外观类中，为客户端提供一个简化的接口，
如果后续需要修改文件处理的流程或替换底层子系统，也只需在外观类中进行调整，不会影响客户端代码。

优缺点和使用场景
外观模式通过提供一个简化的接口，隐藏了系统的复杂性，降低了客户端和子系统之间的耦合度，客户端不需要了解系统的内部实现细节，也不需要直接和多个子系统交互，只需要通过外观接口与外观对象进行交互。
但是如果需要添加新的子系统或修改子系统的行为，就可能需要修改外观类，这违背了“开闭原则”。
外观模式的应用也十分普遍，下面几种情况都使用了外观模式来进行简化。

Spring框架是一个广泛使用外观模式的例子。Spring框架提供了一个大量的功能，包括依赖注入、面向切面编程（AOP）、事务管理等。
Spring的ApplicationContext可以看作是外观，隐藏了底层组件的复杂性，使得开发者可以更轻松地使用Spring的功能。
JDBC提供了一个用于与数据库交互的接口。DriverManager类可以看作是外观，它简化了数据库驱动的加载和连接的过程，隐藏了底层数据库连接的复杂性。
Android系统的API中也使用了外观模式。例如，Activity类提供了一个外观，使得开发者可以更容易地管理应用的生命周期，而无需关心底层的事件和状态管理。
 */

class CPU {

    public void start() {
        System.out.println("cpu is start...");
    }

    public void shutDown() {
        System.out.println("CPU is shutDown...");
    }
}

class Disk {
    public void start() {
        System.out.println("Disk is start...");
    }

    public void shutDown() {
        System.out.println("Disk is shutDown...");
    }
}

class Memory {
    public void start() {
        System.out.println("Memory is start...");
    }

    public void shutDown() {
        System.out.println("Memory is shutDown...");
    }
}

class Computer {

    private CPU cpu;
    private Memory memory;
    private Disk disk;

    public Computer() {
        cpu = new CPU();
        memory = new Memory();
        disk = new Disk();
    }

    public void start() {
        System.out.println("Computer start begin");
        cpu.start();
        disk.start();
        memory.start();
        System.out.println("Computer start end");
    }

    public void shutDown() {
        System.out.println("Computer shutDown begin");
        cpu.shutDown();
        disk.shutDown();
        memory.shutDown();
        System.out.println("Computer shutDown end...");
    }
}


public class Facade {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.start();
        System.out.println("=================");
        computer.shutDown();
    }
}
