package net.alkeity.homework3.task5.impl;

import net.alkeity.homework3.task5.InstrumentMusical;

public class Ukulele extends InstrumentMusical {
    public Ukulele(String brand, String name, String description, String history, String sound) {
        super(brand, name, description, history);
        setSound(sound);
    }

    @Override
    public String toString() {
        return "Ukulele{" +
                "brand='" + getBrand() + '\'' +
                ", name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", history='" + getHistory() + '\'' +
                ", sound='" + getSound() + '\'' +
                '}';
    }
}
