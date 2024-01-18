package src.java.behaviourPattern;

/*
责任链模式是一种行为型设计模式，它允许你构建一个对象链，让请求从链的一端进入，然后沿着链上的对象依次处理，直到链上的某个对象能够处理该请求为止。

职责链上的处理者就是一个对象，可以对请求进行处理或者将请求转发给下一个节点，
这个场景在生活中很常见，就是一个逐层向上递交的过程，最终的请求要么被处理者所处理，要么处理不了，这也因此可能导致请求无法被处理。

处理者Handler ：定义一个处理请求的接口，包含一个处理请求的抽象方法和一个指向下一个处理者的链接。
具体处理者ConcreteHandler: 实现处理请求的方法，并判断能否处理请求，如果能够处理请求则进行处理，否则将请求传递给下一个处理者。
客户端：创建并组装处理者对象链，并将请求发送到链上的第一个处理者。

 */

interface Handler {
    // 处理请求的方法
    String handleRequest(String request);
    // 设置下一个处理者的方法
    void setNextHandler(Handler nextHandler);
}

class ConcreteHandler implements Handler {
    private Handler nextHandler;

    @Override
    public String handleRequest(String request) {
        // 根据具体情况处理请求，如果无法处理则交给下一个处理者
        if (canHandle(request)) {
            // 处理请求的逻辑
        } else if (nextHandler != null) {
            // 交给下一个处理者处理
            return nextHandler.handleRequest(request);
        } else {
            // 无法处理该请求
            return "无法处理该请求";
        }
        return request;
    }

    @Override
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    // 具体处理者自己的判断条件
    private boolean canHandle(String request) {
        // 根据具体情况判断是否能够处理请求
        System.out.println("正在处理该请求");
        return request.length() > 3 ;
    }
}

// 实现其他的Handler


public class ChainOfResponsibility {
    public static void main(String[] args) {
        // 创建处理者实例
        Handler handler1 = new ConcreteHandler();
        Handler handler2 = new ConcreteHandler();
        // ...

        // 构建责任链
        handler1.setNextHandler(handler2);
        // ...

        handler1.handleRequest("12345");
    }
}
