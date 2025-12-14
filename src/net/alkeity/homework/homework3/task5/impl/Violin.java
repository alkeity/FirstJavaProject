package net.alkeity.homework.homework3.task5.impl;

import net.alkeity.homework.homework3.task5.InstrumentMusical;

public class Violin extends InstrumentMusical {
    public Violin(String brand, String name, String description, String history, String sound) {
        super(brand, name, description, history);
        setSound(sound);
    }

    @Override
    public String toString() {
        return "Violin{" +
                "brand='" + getBrand() + '\'' +
                ", name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", history='" + getHistory() + '\'' +
                ", sound='" + getSound() + '\'' +
                '}';
    }
}
