package net.alkeity.homework3.task4.impl;

import net.alkeity.homework3.task4.HasSound;
import net.alkeity.homework3.task4.Mechanism;

public class Microwave extends Mechanism implements HasSound {
    private final String brand;

    protected Microwave(String brand, String name, String description) {
        super(name, description);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public void show() {
        System.out.printf("Microwave %s %s", brand, getName());
    }

    @Override
    public void sound() {
        System.out.println("Beep-beep!");
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Microwave microwave = (Microwave) o;
        return brand.equals(microwave.brand);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + brand.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Microwave{" +
                "brand='" + brand + '\'' +
                "name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                '}';
    }
}
