package net.alkeity.classwork.streamapi;

import java.awt.*;
import java.math.BigDecimal;

public class Car {
    private String name;
    private final int year;
    private BigDecimal price;
    private Color color;

    public Car(String name, int year, BigDecimal price, Color color) {
        this.year = year;
        setName(name);
        setPrice(price);
        setColor(color);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", color=" + color +
                '}';
    }
}
