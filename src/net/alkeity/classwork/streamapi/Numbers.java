package net.alkeity.classwork.streamapi;

import java.util.Random;
import java.util.stream.IntStream;

public class Numbers {

    public static int[] generateRandomArray(int size, int min, int max) {
        int[] array = new int[size];
        Random generator = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = generator.nextInt(min, max + 1);
        }

        return array;
    }

    public static long getAmountOfOdds(int[] array) {
        return IntStream.of(array).filter(x -> x % 2 != 0).count();
    }

    public static long getAmountOfEvens(int[] array) {
        return IntStream.of(array).filter(x -> x % 2 == 0).count();
    }

    public static long getAmountOfZeros(int[] array) {
        return IntStream.of(array).filter(x -> x == 0).count();
    }

    public static long getAmountOfValues(int[] array, int value) {
        return IntStream.of(array).filter(x -> x == value).count();
    }

}
