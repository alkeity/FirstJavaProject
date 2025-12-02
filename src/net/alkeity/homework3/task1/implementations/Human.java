package net.alkeity.homework3.task1.implementations;

import net.alkeity.homework3.task1.Gender;

import java.util.Date;

public class Human {
    private String name;
    public final Date birthDate;
    public final String birthPlace;
    public final Gender gender;

    public Human(String name, Date birthDate, String birthPlace, Gender gender) {
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.gender = gender;
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Human human)) return false;

        return birthDate.equals(human.birthDate) && birthPlace.equals(human.birthPlace);
    }

    @Override
    public int hashCode() {
        int result = birthDate.hashCode();
        result = 31 * result + birthPlace.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", birthPlace='" + birthPlace + '\'' +
                '}';
    }
}
