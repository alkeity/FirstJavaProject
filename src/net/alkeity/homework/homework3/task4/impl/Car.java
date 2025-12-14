package net.alkeity.homework.homework3.task4.impl;

import net.alkeity.homework.homework3.task4.HasSound;
import net.alkeity.homework.homework3.task4.Mechanism;

public class Car extends Mechanism implements HasSound {
    private final String brand;

    public Car(String brand, String name, String description) {
        super(name, description);
        this.brand = brand;
    }

    @Override
    public void show() {
        System.out.printf("Car %s %s", brand, getName());
    }

    @Override
    public void sound() {
        System.out.println("Honk-honk!");
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Car car = (Car) o;
        return brand.equals(car.brand);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + brand.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                "name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                '}';
    }
}
