package net.alkeity.homework3.task1.implementations;

import net.alkeity.homework3.task1.Gender;
import net.alkeity.homework3.task1.Workable;

import java.util.Date;

public class Builder extends Human implements Workable {

    public Builder(String name, Date birthDate, String birthPlace, Gender gender) {
        super(name, birthDate, birthPlace, gender);
    }

    @Override
    public void work() {
        System.out.printf("%s builds something...", getName());
    }

    @Override
    public String toString() {
        return "Builder{" +
                "name='" + getName() + '\'' +
                ", birthDate=" + birthDate +
                ", birthPlace='" + birthPlace + '\'' +
                '}';
    }
}
