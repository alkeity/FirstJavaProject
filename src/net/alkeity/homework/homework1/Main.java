package net.alkeity.homework.homework1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // note: uncommenting and trying to run all of these in the same run
        // will probably result in exceptions bc of scanner
//        printMessage();
//        calculatePercent();
//        concatNumber();
//        shuffleNumber();
//        getSeason();
//        convertMeters();
//        oddNumbers();
//        multiplyTables();
//        randomArrayStats(10, -10, 10);
//        arraysFromRandomArray(10, -10, 10);
//        drawLineMain();
//        sortArrayMain();
    }

    // task 1
    public static void printMessage() {
        System.out.println("\"Your time is limited,\n so don’t waste it\n living someone else’s life\"\n Steve Jobs");
    }

    // task 2
    public static void calculatePercent() {
        double number, percent;
        String errorMsg = "Incorrect input! Please enter a number.";

        try (Scanner scanner = new Scanner(System.in)) {
            number = getInputDouble(scanner, "Enter number:", errorMsg);
            percent = getInputDouble(scanner, "Enter percent:", errorMsg);
        }
        double result = number / 100 * percent;
        System.out.println("Result: ".concat(Double.toString(result)));
    }

    // task 3
    public static void concatNumber() {
        int number = -1;
        String result = "";
        String errorMsg = "Incorrect input! Please enter a digit.";

        try (Scanner scanner = new Scanner(System.in)) {
            for (int i = 0; i < 3; i++) {
                while (true) {
                    number = getInputInt(scanner, "Enter digit " + (i + 1), errorMsg);
                    if (number < 0 || number > 10) {
                        System.out.println(errorMsg);
                    }
                    else {
                        result = result.concat(Integer.toString(number));
                        break;
                    }
                }
            }
        }

        System.out.println("Result: ".concat(result));
    }

    // task 4
    public static void shuffleNumber() {
        String errorMsg = "Incorrect input! Please enter a six digit number.";
        int number = -1;
        String result = "";

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                number = getInputInt(scanner, "Enter a six digit number", errorMsg);
                result = Integer.toString(number);
                if (result.length() != 6) {
                    System.out.println(errorMsg);
                }
                else {
                    break;
                }
            }
        }

        StringBuilder builder = new StringBuilder(result);
        char tmpLetter1 = result.charAt(0);
        char tmpLetter2 = result.charAt(5);
        builder.setCharAt(0, tmpLetter2);
        builder.setCharAt(5, tmpLetter1);

        tmpLetter1 = result.charAt(1);
        tmpLetter2 = result.charAt(4);
        builder.setCharAt(1, tmpLetter2);
        builder.setCharAt(4, tmpLetter1);

        System.out.println("Result: ".concat(builder.toString()));
    }

    // task 5
    public static void getSeason() {
        int number = -1;
        String[] seasons = { "Spring", "Summer", "Autumn", "Winter" };
        String errorMsg = "Incorrect input! Please enter a number between 1 and 12 included.";

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                number = getInputInt(scanner, "Enter month number: ", errorMsg);
                if (number < 1 || number > 13) {
                    System.out.println(errorMsg);
                }
                else {
                    break;
                }
            }
        }

        if (number >= 3 && number <= 5) {
            System.out.println(seasons[0]);
        } else if (number >= 6 && number <= 8) {
            System.out.println(seasons[1]);
        } else if (number >= 9 && number <= 11) {
            System.out.println(seasons[2]);
        } else {
            System.out.println(seasons[3]);
        }
    }

    // task 6
    public static void convertMeters() {
        String errorMsg = "Invalid input! Please use numbers.";
        String errorMsg2 = "Invalid input! Please use numbers between 1 and 3.";
        double meters = 0;
        int choice = 0;

        try (Scanner scanner = new Scanner(System.in)) {
            meters = getInputDouble(scanner, "Enter meters to convert: ", errorMsg);

            while (choice < 1 || choice > 3) {
                choice = getInputInt(
                        scanner,
                        "Convert to:\n1. Miles\n2. Inches\n3. Yards",
                        errorMsg2);
                if (choice < 1 || choice > 3) System.out.println(errorMsg2);
                else break;
            }
        }

        double result = 0;
        String unit = "";

        switch (choice) {
            case 1:
                result = meters * 0.000621;
                unit = "miles";
                break;
            case 2:
                result = meters * 39.370079;
                unit = "inches";
                break;
            case 3:
                result = meters * 1.093613;
                unit = "yards";
                break;
            default: break;
        }

        System.out.println(meters + " meters equials to " + result + " " + unit);
    }

    // task 7
    public static void oddNumbers() {
        int num1, num2;
        String errorMsg = "Incorrect input! Please enter a number.";

        try (Scanner scanner = new Scanner(System.in)) {
            num1 = getInputInt(scanner, "Enter number 1:", errorMsg);
            num2 = getInputInt(scanner, "Enter number 2:", errorMsg);
        }

        if (num1 > num2) {
            int tmp = num1;
            num1 = num2;
            num2 = tmp;
        }

        if (num1 % 2 == 0) ++num1;

        for (int i = num1; i <= num2; i = i + 2) {
            System.out.print(i + " ");
        }
    }

    // task 8
    public static void multiplyTables() {
        int num1, num2;
        String errorMsg = "Incorrect input! Please enter a number.";

        try (Scanner scanner = new Scanner(System.in)) {
            num1 = getInputInt(scanner, "Enter number 1:", errorMsg);
            num2 = getInputInt(scanner, "Enter number 2:", errorMsg);
        }

        if (num1 > num2) {
            int tmp = num1;
            num1 = num2;
            num2 = tmp;
        }

        for (int i = num1; i <= num2 ; i++) {
            printTable(i);
        }
    }

    private static void printTable(int num) {
        for (int i = 0; i < 11; i++) {
            System.out.println(num + " * " + i + " = " + (num * i));
        }
        System.out.println();
    }

    // task 9
    public static void randomArrayStats(int arraySize, int min, int max) {
        int[] randomArray = generateRandomArray(arraySize, min, max);

        System.out.println("Random array:");
        printArray(randomArray);

        int minValue = max;
        int maxValue = min;
        int amountNegative = 0;
        int amountPositive = 0;
        int amountZero = 0;

        for (int i = 0; i < randomArray.length; i++) {
            if (randomArray[i] < minValue ) minValue = randomArray[i];
            if (randomArray[i] > maxValue ) maxValue = randomArray[i];

            if (randomArray[i] > 0) ++amountPositive;
            else if (randomArray[i] < 0) ++amountNegative;
            else ++amountZero;
        }

        System.out.println("Random array statistics:");
        System.out.println("Min value: ".concat(Integer.toString(minValue)));
        System.out.println("Max value: ".concat(Integer.toString(maxValue)));
        System.out.println("Amount of positive integers: ".concat(Integer.toString(amountPositive)));
        System.out.println("Amount of negative integers: ".concat(Integer.toString(amountNegative)));
        System.out.println("Amount of zeros: ".concat(Integer.toString(amountZero)));
    }

    // task 10
    public static void arraysFromRandomArray(int arraySize, int min, int max) {
        int[] randomArray = generateRandomArray(arraySize, min, max);

        System.out.println("Random array:");
        printArray(randomArray);

        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();
        ArrayList<Integer> odds = new ArrayList<>();
        ArrayList<Integer> evens = new ArrayList<>();

        for (int i = 0; i < randomArray.length; i++) {
            if (randomArray[i] > 0) positive.add(randomArray[i]);
            else if (randomArray[i] < 0) negative.add(randomArray[i]);

            if (randomArray[i] % 2 == 0) evens.add(randomArray[i]);
            else odds.add(randomArray[i]);
        }

        System.out.println("Positive numbers:");
        System.out.println(positive);
        System.out.println("Negative numbers:");
        System.out.println(negative);
        System.out.println("Odd numbers:");
        System.out.println(odds);
        System.out.println("Even numbers:");
        System.out.println(evens);
    }

    // task 11
    public static void drawLineMain() {
        char symbol = 0;
        int isVertical = 0;
        int length = 0;

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter desired symbol:");
            symbol = scanner.nextLine().charAt(0);

            while (true) {
                length = getInputInt(
                        scanner,
                        "Enter desired length:",
                        "Incorrect input, please enter a number.");
                if (length < 1 || length > 10) {
                    System.out.println("Please enter a number between 1 and 10");
                }
                else break;
            }

            while (true) {
                isVertical = getInputInt(
                        scanner,
                        "Enter 1 for vertical line, 0 for horizontal:",
                        "Incorrect input, please enter a number.");
                if (isVertical < 0 || isVertical > 1) {
                    System.out.println("Please enter 0 or 1");
                }
                else break;
            }
        }

        drawLine(symbol, length, isVertical == 1);
    }

    private static void drawLine(char symbol, int length, boolean isVertical) {
        if (isVertical) {
            for (int i = 0; i < length; i++) {
                System.out.println(symbol);
            }
        }
        else {
            for (int i = 0; i < length; i++) {
                System.out.print(symbol);
            }
        }
    }

    // task 12
    public static void sortArrayMain() {
        int[] array = generateRandomArray(10, 1, 23);
        int desc = 0;

        System.out.println("Original array:");
        printArray(array);

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                desc = getInputInt(
                        scanner,
                        "Enter 1 to desc sort, 0 for asc:",
                        "Incorrect input, please enter 0 or 1.");
                if (desc < 0 || desc > 1) {
                    System.out.println("Please enter 0 or 1");
                }
                else break;
            }
        }

        sortArray(array, desc == 1);
        System.out.println("Sorted array:");
        printArray(array);
    }

    private static void sortArray(int[] array, boolean desc) {
        boolean isSwapped;
        int tmp;
        if (desc) {
            for (int i = 0; i < array.length; i++) {
                isSwapped = false;
                for (int j = 0; j < array.length - 1; j++) {
                    if (array[j] < array[j + 1]) {
                        tmp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = tmp;
                        isSwapped = true;
                    }
                }
                if (!isSwapped) break;
            }
        }
        else {
            for (int i = 0; i < array.length; i++) {
                isSwapped = false;
                for (int j = 0; j < array.length - 1; j++) {
                    if (array[j] > array[j + 1]) {
                        tmp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = tmp;
                        isSwapped = true;
                    }
                }
                if (!isSwapped) break;
            }
        }
    }

    // helpers

    private static double getInputDouble(Scanner scanner, String label, String errorMsg) {
        boolean isValid = false;
        double result = 0;
        System.out.println(label);
        while (!isValid) {
            try {
                result = scanner.nextDouble();
                isValid = true;
            }
            catch (InputMismatchException exc) {
                System.out.println(errorMsg);
                scanner.nextLine();
            }
        }
        return result;
    }

    private static int getInputInt(Scanner scanner, String label, String errorMsg) {
        boolean isValid = false;
        int result = 0;
        System.out.println(label);
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

    private static int[] generateRandomArray(int arraySize, int min, int max) {
        int[] randomArray = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            randomArray[i] = (int)((Math.random() * (max - min + 1)) + min);
        }

        return randomArray;
    }

    private static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
