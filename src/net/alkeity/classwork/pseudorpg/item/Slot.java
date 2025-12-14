package net.alkeity.classwork.pseudorpg.item;

public class Slot<T extends Item> {
    private T equippedItem;

    public void equip(T item) {
        equippedItem = item;
    }

    public void takeOff() {
        equippedItem = null;
    }

    public boolean isAvailable() {
        return equippedItem == null;
    }
}
