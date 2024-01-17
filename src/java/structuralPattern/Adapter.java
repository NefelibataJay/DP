package src.java.structuralPattern;


/*
将一个类的接口转换成客户希望的另一个接口，主要目的是充当两个不同接口之间的桥梁，使得原本接口不兼容的类能够一起工作。
 */


import java.util.Random;
import java.util.Scanner;

// USB 接口
interface USB {
    void charge();
}

// TypeC 接口
interface TypeC {
    void chargeWithTypeC();
}

// 适配器类
class TypeCAdapter implements USB {
    private TypeC typeC;

    public TypeCAdapter(TypeC typeC) {
        this.typeC = typeC;
    }

    @Override
    public void charge() {
        typeC.chargeWithTypeC();
    }
}

// 新电脑类，使用 TypeC 接口
class NewComputer implements TypeC {
    @Override
    public void chargeWithTypeC() {
        System.out.println("TypeC");
    }
}

// 适配器充电器类，使用 USB 接口
class AdapterCharger implements USB {
    @Override
    public void charge() {
        System.out.println("USB Adapter");
    }
}


class Adapter {
    public static void main(String[] args) {
        // 读取用户选择
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose the type of charger:");
        System.out.println("1. TypeC");
        System.out.println("2. USB Adapter");
        int choice = scanner.nextInt();

        // 根据用户的选择创建相应对象
        if (choice == 1) {
            TypeC newComputer = new NewComputer();
            newComputer.chargeWithTypeC();
        } else if (choice == 2) {
            USB usbAdapter = new AdapterCharger();
            usbAdapter.charge();
        }
        scanner.close();
    }
}
