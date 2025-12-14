package net.alkeity.classwork.pseudorpg.item;

import java.util.Random;

public enum ItemRarity {
    COMMON("Common"),
    RARE("Rare"),
    VERY_RARE("Very rare"),
    LEGENDARY("Legendary");

    public final String printName;

    private ItemRarity(String printName) {
        this.printName = printName;
    }

    public static ItemRarity getRandomRarity() {
        ItemRarity[] rarities = values();
        Random random = new Random();
        int index = random.nextInt(0, rarities.length);
        return rarities[index];
    }
}
