package net.alkeity.classwork.pseudorpg.item;

import java.util.UUID;

public abstract class Item {
    private final UUID uuid;
    private final String name;
    private final ItemRarity rarity;

    protected Item(String name, ItemRarity rarity) {
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.rarity = rarity;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public ItemRarity getRarity() {
        return rarity;
    }

    public abstract void interact();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;
        return uuid.equals(item.uuid) && name.equals(item.name);
    }

    @Override
    public int hashCode() {
        int result = uuid.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Item{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                '}';
    }
}
