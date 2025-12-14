package net.alkeity.homework.homework3.task4.impl;

import net.alkeity.homework.homework3.task4.HasSound;
import net.alkeity.homework.homework3.task4.Mechanism;

public class Ship extends Mechanism implements HasSound {
    protected Ship(String name, String description) {
        super(name, description);
    }

    @Override
    public void show() {
        System.out.printf("Ship %s", getName());
    }

    @Override
    public void sound() {
        System.out.println("Too-doo!");
    }
}
