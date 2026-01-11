package net.alkeity.homework.homework15;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        task2();
    }

    // Создайте ExecutorService с фиксированным пулом из 3 потоков.
    //
    //	Запустите 10 задач, используя интерфейс Runnable, которые
    //        выводят свой порядковый номер и имя потока.
    //
    //        После отправки всех задач в ExecutorService, вызовите метод
    //        shutdown() и убедитесь, что все задачи выполнены.
    public static void task1() {
        try (ExecutorService executorService = Executors.newFixedThreadPool(3)) {
            for (int i = 0; i < 10; i++) {
                int taskNumber = i;
                Runnable task = () -> {
                    System.out.printf("Task №%d, thread %s\n", taskNumber, Thread.currentThread().getName());
                };
                executorService.submit(task);
            }
            executorService.shutdown();
        }
    }

    // Создайте задачу, которая выводит числа от 1 до 5 с интервалом
    //        0.5 секунды.
    //
    //        Запустите 3 экземпляра этой задачи сначала при помощи SingleThreadExecutor,
    //        а затем при помощи FixedThreadPool с 3 потоками.
    //
    //	Сравните порядок и время выполнения задач.
    public static void task2() {
        Runnable task = () -> {
            for (int i = 1; i < 6; i++) {
                System.out.println(i);
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        // SingleThreadExecutor запускает один поток, который по очереди выполняет переданные задачи
        try (ExecutorService esSingleThread = Executors.newSingleThreadExecutor()) {
            for (int i = 0; i < 3; i++) {
                esSingleThread.submit(task);
            }

            System.out.println("All tasks added to SingleThreadExecutor");
        }

        // FixedThreadPool запускает три параллельных потока с задачами, которые выполняются параллельно друг другу
        try (ExecutorService esFixed = Executors.newFixedThreadPool(3)) {
            for (int i = 0; i < 3; i++) {
                esFixed.submit(task);
            }
            System.out.println("All tasks added to FixedThreadPool");
        }

        // соответственно, реализация на SingleThreadExecutor работает в три раза дольше реализации на FixedThreadPool
        // однако сами задачи выполняются строго по порядку добавления
    }
}
