package net.alkeity.homework3.task1.implementations;

import net.alkeity.homework3.task1.Gender;
import net.alkeity.homework3.task1.Workable;

import java.util.Date;

public class Sailor extends Human implements Workable {

    public Sailor(String name, Date birthDate, String birthPlace, Gender gender) {
        super(name, birthDate, birthPlace, gender);
    }

    @Override
    public void work() {
        System.out.printf("%s sails the (un)known seas...", getName());
    }

    @Override
    public String toString() {
        return "Sailor{" +
                "name='" + getName() + '\'' +
                ", birthDate=" + birthDate +
                ", birthPlace='" + birthPlace + '\'' +
                '}';
    }
}
