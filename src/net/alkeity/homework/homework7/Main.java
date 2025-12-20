package net.alkeity.homework.homework7;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        task1();
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

    private static Path getPathFromInput(Scanner scanner, String expl) throws Exception {
        System.out.println(expl);
        String pathStr = scanner.nextLine();
        Path path = Path.of(pathStr);
        if (!Files.exists(path)) throw new FileNotFoundException("File does not exists!");

        return path;
    }

}
