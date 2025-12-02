package net.alkeity.homework3.task3;

import java.util.InputMismatchException;

public class Money {
    private int integer;
    private int fraction;

    public Money(int integer, int fraction) {
        setAmount(integer, fraction);
    }

    public int getInteger() {
        return integer;
    }

    public void setInteger(int integer) {
        this.integer = integer;
    }

    public int getFraction() {
        return fraction;
    }

    public void setFraction(int fraction) {
        if (fraction < 0) throw new InputMismatchException("Fraction part supports only positive numbers");
        this.fraction = fraction;
    }

    public void setAmount(int integer, int fraction) {
        setInteger(integer);
        setFraction(fraction);
    }

    public String getAmount() {
        return "%s.%s".formatted(integer, fraction);
    }

    public void printAmount() {
        System.out.printf("%s.%s", integer, fraction);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Money money = (Money) o;
        return integer == money.integer && fraction == money.fraction;
    }

    @Override
    public int hashCode() {
        int result = integer;
        result = 31 * result + fraction;
        return result;
    }

    @Override
    public String toString() {
        return "Money{" +
                "integer=" + integer +
                ", fraction=" + fraction +
                '}';
    }
}
