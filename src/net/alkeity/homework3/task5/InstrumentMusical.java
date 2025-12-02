package net.alkeity.homework3.task5;

public abstract class InstrumentMusical {
    private final String brand;
    private String name;
    private String description;
    private String history;
    private String sound;

    public InstrumentMusical(String brand, String name, String description, String history) {
        this.brand = brand;
        setName(name);
        setDescription(description);
        setHistory(history);
    }

    public String getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        InstrumentMusical that = (InstrumentMusical) o;
        return brand.equals(that.brand) && name.equals(that.name) && description.equals(that.description) && history.equals(that.history);
    }

    @Override
    public int hashCode() {
        int result = brand.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + history.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "InstrumentMusical{" +
                "brand='" + brand + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", history='" + history + '\'' +
                '}';
    }
}
