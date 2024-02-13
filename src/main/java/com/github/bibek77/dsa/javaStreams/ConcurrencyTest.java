package com.github.bibek77.dsa.javaStreams;

import com.github.bibek77.dsa.javaStreams.refClass.Task;
import com.github.bibek77.dsa.javaStreams.refClass.Task2;

/**
 * @author bibek
 */
public class ConcurrencyTest {
    public static void main(String[] args) {
        Task task = new Task(); // Defines a class Task what you want to perform
        Thread thread = new Thread(task); // Thread needs to be created with a new task

        Task2 task2 = new Task2();
        Thread thread2 = new Thread(task2);
        thread2.setPriority(Thread.MAX_PRIORITY);
        thread.setPriority(Thread.MIN_PRIORITY);
        thread.start();
        thread2.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Inside main ...");
    }
}
