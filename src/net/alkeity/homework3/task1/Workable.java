package net.alkeity.homework3.task1;

public interface Workable {
    default void work() {
        System.out.println("Creature does something...");
    }
}
