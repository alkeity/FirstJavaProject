package net.alkeity.pseudorpg.item.implementation;

import net.alkeity.pseudorpg.item.Item;
import net.alkeity.pseudorpg.item.ItemRarity;
import net.alkeity.pseudorpg.item.type.Wearable;

public class Headwear extends Item implements Wearable {
    protected Headwear(String name, ItemRarity rarity) {
        super(name, rarity);
    }

    @Override
    public void interact() {
        System.out.printf("Player picks up Headwear item: %s%n", getName());
    }

    @Override
    public void wear() {
        System.out.printf("Player wears Headwear item: %s%n", getName());
    }

    @Override
    public void takeOff() {
        System.out.printf("Player takes off Headwear item: %s%n", getName());
    }
}
