package src.java.createPattern;

// 简单工厂
class SimpleFactory {
    public Shape CreatePizza(String ordertype) {
        Shape shape = null;
        if (ordertype.equals("circle")) {
            shape = new Circle();
        } else if (ordertype.equals("square")) {
            shape = new Square();
        }
        return shape;
    }
}


// 抽象产品
interface Shape {
    void draw();
}

// 具体产品 - 圆形
class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Circle");
    }
}

// 具体产品 - 正方形
class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Square");
    }
}

// 抽象工厂
interface ShapeFactory {
    Shape createShape();
}

// 具体工厂 - 创建圆形
class CircleFactory implements ShapeFactory {
    @Override
    public Shape createShape() {
        return new Circle();
    }
}

// 具体工厂 - 创建正方形
class SquareFactory implements ShapeFactory {
    @Override
    public Shape createShape() {
        return new Square();
    }
}

class Factory {
    public static void main(String[] args) {
        ShapeFactory circleFactory = new CircleFactory();
        Shape circle = circleFactory.createShape();
        circle.draw(); // 输出：Circle

        ShapeFactory squareFactory = new SquareFactory();
        Shape square = squareFactory.createShape();
        square.draw(); // 输出：Square
    }
}


