package net.alkeity.homework.homework3.task4;

public abstract class Mechanism {
    private String name;
    private String description;

    protected Mechanism(String name, String description) {
        setName(name);
        setDescription(description);
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

    public void show() {
        System.out.println(name);
    }
    public void desc() {
        System.out.println(description);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Mechanism mechanism = (Mechanism) o;
        return name.equals(mechanism.name) && description.equals(mechanism.description);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + description.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Mechanism{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
