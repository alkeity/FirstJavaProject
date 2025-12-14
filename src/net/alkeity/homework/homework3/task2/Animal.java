package net.alkeity.homework.homework3.task2;

import net.alkeity.homework.homework3.task1.Gender;

public abstract class Animal {
    private String name;
    private double weight;
    public final Gender gender;

    protected Animal(String name, double weight, Gender gender) {
        this.name = name;
        this.weight = weight;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Gender getGender() {
        return gender;
    }

    public void eat() {
        System.out.printf("%s %s eats.", this.getClass().getSimpleName(), name);
    }

    public void sleep() {
        System.out.printf("%s %s sleeps.", this.getClass().getSimpleName(), name);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Animal animal = (Animal) o;
        return name.equals(animal.name) && gender == animal.gender;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + gender.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", gender=" + gender +
                '}';
    }
}
