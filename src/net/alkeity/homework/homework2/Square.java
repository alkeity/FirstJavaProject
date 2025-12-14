package net.alkeity.homework.homework2;

public class Square extends Shape {
    private double side;

    public Square(double side) {
        setSide(side);
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    @Override
    double getS() {
        return side * 2;
    }
}
