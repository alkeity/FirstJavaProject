package net.alkeity.homework.homework3.task4.impl;

import net.alkeity.homework.homework3.task4.HasSound;
import net.alkeity.homework.homework3.task4.Mechanism;

public class Kettle extends Mechanism implements HasSound {
    private final String brand;

    protected Kettle(String brand, String name, String description) {
        super(name, description);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public void show() {
        System.out.printf("Kettle %s %s", brand, getName());
    }

    @Override
    public void sound() {
        System.out.println("*sounds of water boiling*");
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Kettle kettle = (Kettle) o;
        return brand.equals(kettle.brand);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + brand.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Kettle{" +
                "brand='" + brand + '\'' +
                "name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                '}';
    }
}
