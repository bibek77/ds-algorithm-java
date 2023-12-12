package com.github.bibek77.dsa.javaSnippets;

import com.github.bibek77.dsa.javaSnippets.refClass.Task;
import com.github.bibek77.dsa.javaSnippets.refClass.Task2;

/**
 * @author bibek
 */
public class ConcurrencyTest {
    public static void main(String[] args) {
        Task task = new Task(); // Defines a class Task what you want to perform
        Thread thread = new Thread(task); // Thread needs to be created with a new task

//        Task2 task2 = new Task2();
//        Thread thread = new Thread(task2);
        thread.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Inside main ...");
    }
}
