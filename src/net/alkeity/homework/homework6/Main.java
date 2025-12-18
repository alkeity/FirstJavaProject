package net.alkeity.homework.homework6;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {
    private static final Random rand = new Random();

    public static void main(String[] args) {
        task1();
        System.out.println("-------------------");
        task2();
        System.out.println("-------------------");
        task3();
        System.out.println("-------------------");
        task4();
    }

    public static void task1() {
        final String dateFormat = "dd-MM-yyyy";
        String date = "23-12-1995";
        String date2 = "18-12-2025";

        // Проверка, является ли год високосным;
        Predicate<Integer> isLeap = year -> ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0));

        int year = rand.nextInt(1990, 2025);
        System.out.printf(
                "%s is %s year.\n",
                year,
                isLeap.test(year) ? "leap" : "non-leap"
                );

        //Подсчет количества дней между двумя датами
        BinaryFunc<String, Long> dayDiff = (dateStr1, dateStr2) -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
            LocalDate start = LocalDate.parse(dateStr1, formatter);
            LocalDate end = LocalDate.parse(dateStr2, formatter);
            return Math.abs(ChronoUnit.DAYS.between(start, end));
        };

        System.out.printf(
                "Difference between %s and %s is %s days.\n",
                date, date2,
                dayDiff.apply(date, date2)
                );

        //Подсчёт количества полных недель между двумя датами
        BinaryFunc<String, Integer> weekDiff = (dateStr1, dateStr2) -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
            LocalDate start = LocalDate.parse(dateStr1, formatter);
            LocalDate end = LocalDate.parse(dateStr2, formatter);
            return (int) (Math.abs(ChronoUnit.DAYS.between(start, end)) / 7);
        };

        System.out.printf(
                "Difference between %s and %s is %s weeks.\n",
                date, date2,
                weekDiff.apply(date, date2)
        );

        //Подсчёт дня недели по полученной дате
        Function<String, String> weekdayFinder = dateStr -> {
            try {
                Date dateObj = new SimpleDateFormat(dateFormat).parse(dateStr);
                return new SimpleDateFormat("EE").format(dateObj);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        };

        System.out.printf("%s is %s.\n", date, weekdayFinder.apply(date));
    }

    public static void task2() {
        double n1 = 234.567;
        double n2 = 7.456;

        // Сумма двух дробей;
        BinaryFunc<Double, Double> doubleSum = Double::sum;
        System.out.printf("%s + %s = %s\n", n1, n2, doubleSum.apply(n1, n2));
        // Разница двух дробей;
        BinaryFunc<Double, Double> doubleDiff = (num1, num2) -> num1 - num2;
        System.out.printf("%s - %s = %s\n", n1, n2, doubleDiff.apply(n1, n2));
        // Произведение двух дробей;
        BinaryFunc<Double, Double> doubleMultiply = (num1, num2) -> num1 * num2;
        System.out.printf("%s * %s = %s\n", n1, n2, doubleMultiply.apply(n1, n2));
        // Деление двух дробей.
        BinaryFunc<Double, Double> doubleDivision = (num1, num2) -> num1 / num2;
        System.out.printf("%s / %s = %s\n", n1, n2, doubleDivision.apply(n1, n2));
    }

    public static void task3() {
        List<Integer> list = Stream.generate(
                () -> rand.nextInt(-100, 101)
        ).limit(4).toList();

        Function<List<Integer>, Integer> max = Collections::max;
        Function<List<Integer>, Integer> min = Collections::min;

        list.forEach(num -> System.out.printf("%s ", num));
        System.out.println();

        System.out.printf("Max value: %s\n", max.apply(list));
        System.out.printf("Min value: %s\n", min.apply(list));
    }

    public static void task4() {
        List<Integer> list = Stream.generate(
                () -> rand.nextInt(-100, 101)
        ).limit(10).toList();
        list.forEach(num -> System.out.printf("%s ", num));
        System.out.println();


        int randNum = rand.nextInt(-100, 101);
        int randStart = rand.nextInt(-100, 101);
        int randEnd = rand.nextInt(-100, 101);

        if (randStart > randEnd) {
            int tmp = randStart;
            randStart = randEnd;
            randEnd = tmp;
        }

        System.out.printf(
                "Sum of array elems that equals %s: %s\n",
                randNum,
                summ(list, num -> num == randNum)
                );

        int finalRandStart = randStart;
        int finalRandEnd = randEnd;
        System.out.printf(
                "Sum of array elems in range between %s and %s: %s\n",
                randStart, randEnd,
                summ(list, num -> num >= finalRandStart && num <= finalRandEnd)
        );

        System.out.printf(
                "Sum of positive array elems: %s\n",
                summ(list, num -> num > 0)
        );

        System.out.printf(
                "Sum of negative array elems: %s\n",
                summ(list, num -> num < 0)
        );
    }

    private static long summ(List<Integer> array, Predicate<Integer> predicate) {
        return array.stream().filter(predicate).reduce(0, Integer::sum);
    }
}
