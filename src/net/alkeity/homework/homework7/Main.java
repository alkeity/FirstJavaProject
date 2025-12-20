package net.alkeity.homework.homework7;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String path = "F:/f2.txt";
        task3(path);
    }

    //Пользователь вводит с клавиатуры пути к двум тек-
    //стовым файла. Программа должна проверить совпадают
    //ли их строки. Если нет, то вывести несовпадающую строку
    //из каждого файла.
    public static void task1() {
        Path path1, path2;
        try (Scanner scanner = new Scanner(System.in)) {
            path1 = getPathFromInput(scanner, "Enter path to the first text file:");
            path2 = getPathFromInput(scanner, "Enter path to the second text file:");
        }
        catch (Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
            return;
        }

        TxtContentComparer txtComparer = new TxtContentComparer(path1, path2);

        System.out.println("Non-identical strings:");
        boolean isIdentical = txtComparer.compareContent();
        if (isIdentical) System.out.println("All identical!");

    }

    //Пользователь с клавиатуры вводит путь к файлу. Про-
    //грамма должна найти длину самой длинной строки. После
    //работы программы на экран отображается полученное
    //число и сама строка.
    public static void task2() {
        Path path;
        try (Scanner scanner = new Scanner(System.in)) {
            path = getPathFromInput(scanner, "Enter path to the text file:");
        }
        catch (Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
            return;
        }

        List<String> content;
        try {
            content = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        String longestStr = content.stream().max(Comparator.comparingInt(String::length)).get();

        System.out.printf(
                "Longest string in file has length of %s. It is:\n%s\n",
                longestStr.length(),
                longestStr
        );
    }

//    В файле на разных строках находятся элементы мас-
//    сивов целых. Первая строка содержит элементы первого
//    массива, вторая второго и так далее.
//    Необходимо загрузить данные из файла в разные масси-
//    вы, показать каждый массив на экран, показать максимум
//    и минимум в каждом массиве, сумму элементов каждого
//    массива. Также нужно отобразить максимум и минимум
//    среди всех массивов, а также общую сумму всех массивов.
    public static void task3(String pathStr) {
        Path path = Path.of(pathStr);

        List<String> content;
        try {
            content = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        List<List<Integer>> listOfLists = new ArrayList<>();

        for (String line : content) {
            if (line.isBlank()) continue;

            List<Integer> list = Arrays.stream(
                    line.split(" ")).toList()
                    .stream().map(Integer::valueOf)
                    .toList();
            listOfLists.add(list);
        }

        int sum = 0;
        int min = 0;
        int max = 0;

        for (List<Integer> list : listOfLists) {
            System.out.println("Current array:");
            list.forEach(num -> System.out.printf("%s ", num));
            System.out.println();

            System.out.printf(
                    "Max value: %s\n",
                    Collections.max(list)
            );

            System.out.printf(
                    "Min value: %s\n",
                    Collections.min(list)
            );

            System.out.printf(
                    "Sum of elements: %s\n",
                    list.stream().reduce(0, Integer::sum)
            );
            System.out.println("--------------------");

            sum += list.stream().reduce(0, Integer::sum);
            min = Math.min(min, Collections.min(list));
            max = Math.max(max, Collections.max(list));
        }

        System.out.printf(
                "Max value between all arrays: %s\n",
                max
                );
        System.out.printf(
                "Min value between all arrays: %s\n",
                min
        );
        System.out.printf(
                "Sum of elements of all arrays: %s\n",
                sum
        );
    }


    //Пользователь с клавиатуры вводит путь к файлу и мас-
    //сив целых. Необходимо сохранить исходный массив в пер-
    //вой строке файла, четные значения из массива во второй
    //строке файла, нечетные в третьей, перевернутый массив
    //в четвертой.
    public static void task4() {
        Path path;
        List<Integer> intList = new ArrayList<>();
        try (Scanner scanner = new Scanner(System.in)) {
            path = getPathFromInput(scanner, "Enter path to the text file:");

            System.out.println("Enter size of array:");
            int len = Math.abs(getInputInt(scanner, "Please enter integer!"));

            System.out.println("Enter numbers for array:");
            for (int i = 0; i < len; i++) {
                intList.add(getInputInt(scanner, "Please enter integer!"));
            }
        }
        catch (Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
            return;
        }

        List<String> content = new ArrayList<>();
        content.add(
                intList.stream()
                        .map(Object::toString)
                        .collect(Collectors.joining(" "))
        );
        content.add(
                intList.stream()
                        .filter(n -> n % 2 == 0)
                        .map(Object::toString)
                        .collect(Collectors.joining(" "))
        );

        content.add(
                intList.stream()
                        .filter(n -> n % 2 != 0)
                        .map(Object::toString)
                        .collect(Collectors.joining(" "))
        );

        content.add(
                intList.reversed().stream()
                        .map(Object::toString)
                        .collect(Collectors.joining(" "))
        );

        try {
            Files.write(path, content.stream().toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Path getPathFromInput(Scanner scanner, String label) throws Exception {
        System.out.println(label);
        String pathStr = scanner.nextLine();
        Path path = Path.of(pathStr);
        if (!Files.exists(path)) throw new FileNotFoundException("File does not exists!");

        return path;
    }

    public static int getInputInt(Scanner scanner, String errorMsg) {
        boolean isValid = false;
        int result = 0;
        while (!isValid) {
            try {
                result = scanner.nextInt();
                isValid = true;
            }
            catch (InputMismatchException exc) {
                System.out.println(errorMsg);
                scanner.nextLine();
            }
        }
        return result;
    }

}
