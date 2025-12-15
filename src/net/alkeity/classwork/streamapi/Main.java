package net.alkeity.classwork.streamapi;

import java.awt.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        taskCars();
    }

    public static void taskCars() {
        int[] years = { 1995, 1980, 2000, 2010, 2025, 2020, 2015, 2013 };
        Color[] colors = {
                Color.WHITE, Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.MAGENTA, Color.GREEN
        };
        String[] brands = { "BMW", "Toyota", "Ford", "Ferrari", "Opel", "Lada" };

        Random rand = new Random();

        List<Car> cars = Stream.generate(
                () -> new Car(
                        brands[rand.nextInt(brands.length)],
                        years[rand.nextInt(years.length)],
                        BigDecimal.valueOf(rand.nextInt(20000, 200000)),
                        colors[rand.nextInt(colors.length)]
                )
        ).limit(10).toList();

        for (Car car : cars) {
            System.out.println(car);
        }


    }

    public static void taskNumbers() {
        int max = 10;
        int min = -10;
        int size = 20;

        int[] numbers = Numbers.generateRandomArray(size, min, max);

        int value = (int) ((Math.random() * (max - min)) + min);

        for (int i = 0; i < size; i++) {
            System.out.printf("%s ", numbers[i]);
        }
        System.out.println();

        System.out.printf("Amount of odds: %s\n", Numbers.getAmountOfOdds(numbers));
        System.out.printf("Amount of evens: %s\n", Numbers.getAmountOfEvens(numbers));
        System.out.printf("Amount of zeros: %s\n", Numbers.getAmountOfZeros(numbers));
        System.out.printf("Amount of random value %s: %s\n", value, Numbers.getAmountOfValues(numbers, value));
    }
}
