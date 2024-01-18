package src.java.behaviourPattern;

/*
命令模式是一种行为型设计模式，其允许将请求封装成一个对象(命令对象，包含执行操作所需的所有信息)，并将命令对象按照一定的顺序存储在队列中，
然后再逐一调用执行，这些命令也可以支持反向操作，进行撤销和重做。

这样一来，发送者只需要触发命令就可以完成操作，不需要知道接受者的具体操作，从而实现两者间的解耦。

举个现实中的应用场景，遥控器可以控制不同的设备，在命令模式中，可以假定每个按钮都是一个命令对象，包含执行特定操作的命令，
不同设备对同一命令的具体操作也不同，这样就可以方便的添加设备和命令对象。

命令接口Command：接口或者抽象类，定义执行操作的接口。
具体命令类ConcreteCommand: 实现命令接口，执行具体操作，在调用execute方法时使“接收者对象”根据命令完成具体的任务，比如遥控器中的“开机”，“关机”命令。
接收者类Receiver: 接受并执行命令的对象，可以是任何对象，遥控器可以控制空调，也可以控制电视机，电视机和空调负责执行具体操作，是接收者。
调用者类Invoker: 发起请求的对象，有一个将命令作为参数传递的方法。它不关心命令的具体实现，只负责调用命令对象的 execute() 方法来传递请求，在本例中，控制遥控器的“人”就是调用者。
客户端：创建具体的命令对象和接收者对象，然后将它们组装起来。

 */


public interface Command {
    void execute();
    void undo();
}

class TurnOffLight implements Command {

    private Light light;

    public TurnOffLight(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.Off();
    }

    @Override
    public void undo() {
        light.On();
    }

}

class Light {
    // Receiver
    String loc = "";

    public Light(String loc) {
        this.loc = loc;
    }

    public void On() {
        System.out.println(loc + " On");
    }

    public void Off() {
        System.out.println(loc + " Off");
    }

}

class Controller {
    // Invoker

    public Command command;

    public Controller(Command command) {
        this.command = command;
    }

    public void CommandExecute() {
        command.execute();
    }

    public void CommandUndo() {
        command.undo();
    }

}

class CommandExample{
    public static void main(String[] args) {
        Light receiver = new Light("Bedroom");
        Command command = new TurnOffLight(receiver);
        Controller invoker = new Controller(command);

        invoker.CommandExecute();
        invoker.CommandUndo();
    }
}

