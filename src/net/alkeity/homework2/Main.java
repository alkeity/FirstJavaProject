package net.alkeity.homework2;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Rectangle(10, 20),
                new Square(23),
                new Circle(13)
        };

        for(Shape shape : shapes) {
            System.out.println("This is " + shape.getClass().getSimpleName() + " with area " + shape.getS());
        }
    }
}
