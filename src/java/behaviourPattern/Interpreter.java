package src.java.behaviourPattern;

/*
解释器模式（Interpreter Pattern）是一种行为型设计模式，它定义了一个语言的文法，并且建立一个【解释器】来解释该语言中的句子。
比如说SQL语法、正则表达式，这些内容比较简短，但是表达的内容可不仅仅是字面上的那些符号，计算机想要理解这些语法，就需要解释这个语法规则，
因此解释器模式常用于实现编程语言解释器、正则表达式处理等场景。

抽象表达式（Abstract Expression）： 定义了解释器的接口，包含了解释器的方法 interpret。
终结符表达式（Terminal Expression）： 在语法中不能再分解为更小单元的符号。
非终结符表达式（Non-terminal Expression）： 文法中的复杂表达式，它由终结符和其他非终结符组成。
上下文（Context）： 包含解释器之外的一些全局信息，可以存储解释器中间结果，也可以用于向解释器传递信息。

举例来说，表达式 "3 + 5 * 2"，数字 "3" 和 "5"， "2" 是终结符，而运算符 "+", "*"都需要两个操作数, 属于非终结符。

 */


// 抽象表达式接口
interface Expression {
    int interpret();
}

class TerminalExpression implements Expression {
    private int value;

    public TerminalExpression(int value) {
        this.value = value;
    }

    @Override
    public int interpret() {
        return value;
    }
}

class AddExpression implements Expression {
    private Expression left;
    private Expression right;

    public AddExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret() {
        return left.interpret() + right.interpret();
    }
}

class InterpreterContext {
    // 可以在上下文中存储一些全局信息或状态
}


public class Interpreter {
    public static void main(String[] args) {
        InterpreterContext context = new InterpreterContext();

        Expression expression = new AddExpression(
                new TerminalExpression(1),
                new TerminalExpression(2)
        );

        int result = expression.interpret();
        System.out.println("Result: " + result);
    }
}
