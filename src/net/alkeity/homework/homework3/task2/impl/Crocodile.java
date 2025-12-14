package net.alkeity.homework.homework3.task2.impl;

import net.alkeity.homework.homework3.task1.Gender;
import net.alkeity.homework.homework3.task2.Animal;
import net.alkeity.homework.homework3.task2.CanHunt;

public class Crocodile extends Animal implements CanHunt {
    public Crocodile(String name, double weight, Gender gender) {
        super(name, weight, gender);
    }

    @Override
    public void hunt() {
        System.out.printf("%s %s hunts.", this.getClass().getSimpleName(), getName());
    }

    @Override
    public void eat() {
        hunt();
        super.eat();
    }
}
