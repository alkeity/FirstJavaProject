package net.alkeity.homework.homework2;

public class Circle extends Shape{
    private double radius;

    public Circle(double radius) {
        setRadius(radius);
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    double getS() {
        return Math.PI * (radius * radius);
    }
}
