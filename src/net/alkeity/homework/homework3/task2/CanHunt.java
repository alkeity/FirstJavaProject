package net.alkeity.homework.homework3.task2;

public interface CanHunt {
    default void hunt() {
        System.out.println("Creature hunts...");
    }
}
