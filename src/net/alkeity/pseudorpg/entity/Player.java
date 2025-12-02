package net.alkeity.pseudorpg.entity;

import net.alkeity.pseudorpg.item.implementation.Headwear;

public class Player {
    private final String name;
    private Headwear headwear;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Headwear getHeadwear() {
        return headwear;
    }

    public void setHeadwear(Headwear headwear) {
        this.headwear = headwear;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;
        return name.equals(player.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", headwear=" + headwear +
                '}';
    }
}
