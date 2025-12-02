package net.alkeity.pseudorpg.item.type;

public interface Wearable {
    default void wear() {
        String text = "Players wears a gear item";
        System.out.println(text);
    }
    default void takeOff() {
        String text = "Players takes off a gear item";
        System.out.println(text);
    }
}
