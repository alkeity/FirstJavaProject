package net.alkeity.homework.homework8;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        try {
            task2();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //При старте приложения запускаются три потока. Пер-
    //вый поток заполняет массив случайными числами. Два
    //других потока ожидают заполнения. Когда массив запол-
    //нен оба потока запускаются. Первый поток находит сумму
    //элементов массива, второй поток среднеарифметическое
    //значение в массиве. Полученный массив, сумма и средне-
    //арифметическое возвращаются в метод main, где должны
    //быть отображены.
    public static void task1() throws InterruptedException {
        List<Integer> nums = new ArrayList<>();
        int size = 10;
        int min = -100;
        int max = 100;
        AtomicLong sum = new AtomicLong();
        AtomicReference<Double> mean = new AtomicReference<>((double) 0);

        Thread threadGenerate = new Thread(
                () -> {
                    nums.addAll(generateIntArray(size, min, max));
                }
        );

        Thread threadSum = new Thread(
                () -> {
                    sum.set(nums.stream().reduce(0, Integer::sum));
                    System.out.println("Sum done");
                }
        );

        Thread threadMean = new Thread(
                () -> {
                    long meanSum = nums.stream().reduce(0, Integer::sum);
                    mean.set((double) (meanSum / nums.size()));
                    System.out.println("Mean done");
                }
        );

        threadGenerate.start();
        threadGenerate.join();

        threadMean.start();
        threadSum.start();

        threadMean.join();
        threadSum.join();

        System.out.println("Random array:");
        nums.forEach(num -> System.out.printf("%s ", num));
        System.out.println();

        System.out.printf("Sum: %s\n", sum);
        System.out.printf("Mean: %s\n", mean);
    }

    private static List<Integer> generateIntArray(int size, int min, int max) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < size; i++) list.add(random.nextInt(min, max + 1));

        return list;
    }

    //Пользователь с клавиатуры вводит путь к файлу. После
    //чего запускаются три потока. Первый поток заполняет
    //файл случайными числами. Два других потока ожидают
    //заполнения. Когда файл заполнен оба потока стартуют.
    //Первый поток находит все простые числа, второй поток
    //факториал каждого числа в файле. Результаты поиска
    //каждый поток должен записать в новый файл.
    // TODO В методе main необходимо отобразить статистику выполненных операций.
    public static void task2() throws InterruptedException {
        Path filepath;
        try (Scanner scanner = new Scanner(System.in)) {
            filepath = getPathFromInput(scanner, "Enter file path:");
        }
        catch (Exception e) {
            e.printStackTrace();
            return;
        }

        if (!getExtension(filepath).equals("txt")) {
            System.out.println("Unsupported file format. Please use txt.");
            return;
        }

        if (Files.notExists(filepath)) {
            try {
                Files.createFile(filepath);
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }

        Thread generateThread = new Thread(
                () -> {
                    List<Integer> list = generateIntArray(20, -120, 130);
                    try {
                        Files.write(
                                filepath,
                                list.stream().map(Objects::toString)
                                        .collect(Collectors.joining(" ")).getBytes()
                        );
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        );

        Thread findPrimeNumsThread = new Thread(
                () -> findPrimeNumbersFromFile(filepath)
        );

        Thread findFactorialThread = new Thread(
                () -> findFactorialsFromFile(filepath)
        );

        generateThread.start();
        generateThread.join();

        findFactorialThread.start();
        findPrimeNumsThread.start();

        findFactorialThread.join();
        findPrimeNumsThread.join();
    }

    private static void findPrimeNumbersFromFile(Path path) {
        List<Integer> list;

        try {
            List<String> content = Files.readAllLines(path);
            list = Arrays.stream(content.getFirst().split(" ")).toList()
                    .stream().map(Integer::valueOf).toList();
        } catch (IOException e) {
            System.out.println("IOException: something went wrong while reading file.");
            e.printStackTrace();
            return;
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        List<Integer> primes = new ArrayList<>();

        for (int num : list) {
            if (isPrime(num)) primes.add(num);
        }

        String newPathStr = path.getParent().toString() + File.separator + "primes.txt";
        Path newPath = Path.of(newPathStr);

        if (Files.notExists(newPath)) {
            try {
                Files.createFile(newPath);
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }

        try {
            Files.write(
                    newPath,
                    primes.stream().map(Objects::toString)
                            .collect(Collectors.joining(" ")).getBytes()
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void findFactorialsFromFile(Path path) {
        List<Integer> list;

        try {
            List<String> content = Files.readAllLines(path);
            list = Arrays.stream(content.getFirst().split(" ")).toList()
                    .stream().map(Integer::valueOf).toList();
        } catch (IOException e) {
            System.out.println("IOException: something went wrong while reading file.");
            e.printStackTrace();
            return;
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        List<String> factorials = new ArrayList<>();

        for (int number : list) {
            BigInteger factorial = factorial(number);
            factorials.add("!%d = %d".formatted(number, factorial));
        }

        String newPathStr = path.getParent().toString() + File.separator + "factorials.txt";
        Path newPath = Path.of(newPathStr);

        if (Files.notExists(newPath)) {
            try {
                Files.createFile(newPath);
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }

        try {
            Files.write(newPath, factorials);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isPrime(int num) {
        if (num < 2) return false;

        for (int i = 2; i < Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }

        return true;
    }

    private static BigInteger factorial(int number) {
        BigInteger result = BigInteger.valueOf(1);

        for (int i = 2; i <= number ; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        return result;
    }

    //Пользователь с клавиатуры вводит путь к существую-
    //щей директории и к новой директории. После чего запу-
    //скается поток, который должен скопировать содержимое
    //директории в новое место. Необходимо сохранить струк-
    //туру директории.
    // TODO В методе main необходимо отобразить статистику выполненных операций.
    public static void task3() {
        Path source, destination;
        try (Scanner scanner = new Scanner(System.in)) {
            source = getPathFromInput(scanner, "Enter source path:");
            destination = getPathFromInput(scanner, "Enter destination path:");
        }
        catch (Exception e) {
            e.printStackTrace();
            return;
        }

        if (Files.notExists(source)) {
            System.out.println("Source path does not exists!");
            return;
        }


    }

    //Пользователь с клавиатуры вводит путь к существующей
    //директории и слово для поиска. После чего запускаются
    //два потока. Первый должен найти файлы, содержащие
    //искомое слово и слить их содержимое в один файл. Второй
    //поток ожидает завершения работы первого потока. После
    //чего проводит вырезание всех запрещенных слов (список
    //этих слов нужно считать из файла с запрещенными сло-
    //вами) из полученного файла.
    //TODO В методе main необходимо отобразить статистику выполненных операций.
    public static void task4() {}

    private static Path getPathFromInput(Scanner scanner, String label) {
        System.out.println(label);
        String pathStr = scanner.nextLine();
        return Path.of(pathStr);
    }

    private static String getExtension(Path path) {
        String filename = path.getFileName().toString();
        int dotIndex = filename.lastIndexOf('.');

        if (dotIndex == -1 || dotIndex == filename.length() - 1) return "";
        else return filename.substring(dotIndex + 1);
    }

}
