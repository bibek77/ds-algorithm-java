package com.github.bibek77.dsa.javaMultithreading;

import java.util.concurrent.*;

/**
 * @author bibek
 */
public class ThreadTest {
    public static void main(String[] args) {

        Runnable testTask =
                () -> System.out.println("Thread Name : " + Thread.currentThread().getName());

//        for (int i=0; i<10; i++) {
//            new Thread(testTask).start();
//        }
//        helper();
        ExecutorService executorService = Executors.newCachedThreadPool();
//        ExecutorService executorService = Executors.newFixedThreadPool(5);
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        for(int i=0; i<10; i++) {
            executorService.submit(testTask);
        }
        executorService.shutdown();

        ScheduledFuture<?> reminder = scheduledExecutorService
                .scheduleAtFixedRate( () -> System.out.println("Unit Time Run"), 0, 2, TimeUnit.SECONDS);
    }

    private static void helper() {
        System.out.println("Thread Name : " + Thread.currentThread().getName());
    }
}
