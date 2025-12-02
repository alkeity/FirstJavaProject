package net.alkeity.homework3.task1.implementations;

import net.alkeity.homework3.task1.Gender;
import net.alkeity.homework3.task1.Workable;

import java.util.Date;

public class Pilot extends Human implements Workable {

    public Pilot(String name, Date birthDate, String birthPlace, Gender gender) {
        super(name, birthDate, birthPlace, gender);
    }

    @Override
    public void work() {
        System.out.printf("%s pilots the plane somewhere...", getName());
    }

    @Override
    public String toString() {
        return "Pilot{" +
                "name='" + getName() + '\'' +
                ", birthDate=" + birthDate +
                ", birthPlace='" + birthPlace + '\'' +
                '}';
    }
}
