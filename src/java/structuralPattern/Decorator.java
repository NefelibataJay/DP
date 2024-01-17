package src.java.structuralPattern;


import java.util.Scanner;

// 咖啡接口
interface Coffee {
    void brew();
}

// 具体的黑咖啡类
class BlackCoffee implements Coffee {
    @Override
    public void brew() {
        System.out.println("Brewing Black Coffee");
    }
}

// 具体的拿铁类
class Latte implements Coffee {
    @Override
    public void brew() {
        System.out.println("Brewing Latte");
    }
}

// 装饰者抽象类
public abstract class Decorator implements Coffee {
    protected Coffee coffee;

    public Decorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public void brew() {
        coffee.brew();
    }
}

// 具体的牛奶装饰者类
class MilkDecorator extends Decorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public void brew() {
        System.out.println("Adding Milk");
        super.brew();
    }
}

// 具体的糖装饰者类
class SugarDecorator extends Decorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public void brew() {
        super.brew();
        System.out.println("Adding Sugar");
    }
}

// 客户端代码
class DecoratorExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int coffeeType = scanner.nextInt();
            int condimentType = scanner.nextInt();

            // 根据输入制作咖啡
            Coffee coffee;
            if (coffeeType == 1) {
                coffee = new BlackCoffee();
            } else if (coffeeType == 2) {
                coffee = new Latte();
            } else {
                System.out.println("Invalid coffee type");
                continue;
            }

            // 根据输入添加调料
            if (condimentType == 1) {
                coffee = new MilkDecorator(coffee);
            } else if (condimentType == 2) {
                coffee = new SugarDecorator(coffee);
            } else {
                System.out.println("Invalid condiment type");
                continue;
            }

            // 输出制作过程
            coffee.brew();
        }
    }
}
