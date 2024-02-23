package com.github.bibek77.dsa.javaMultithreading;

import java.util.concurrent.*;

/**
 * @author bibek
 */
public class FutureCallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        demoFutureWithCallable();
    }

    public static void demoFutureWithCallable() throws InterruptedException, ExecutionException {
        ExecutorService pool = Executors.newCachedThreadPool();

        Callable<Pizza> task = () -> {
            System.out.println("Restaurant is preparing Pizza");
            TimeUnit.MILLISECONDS.sleep(200);
            return new Pizza();
        };

        Future<Pizza> pickOrderedPizza = pool.submit(task);
        System.out.println("Waiting for pizza to be prepared.");
        System.out.println("Talking to a friend on a phone.");
        TimeUnit.MILLISECONDS.sleep(300);
        System.out.println("Booking a flight on phone.");
        Pizza pizza = pickOrderedPizza.get();
        System.out.println("Pizza is ready : " + pizza);

        // A task can be callable or runnable
        // Use callable if you want to return a result.
        // Use runnable if you don't want to return a result.
        // Future task will only start, when invoked with get().

        // CompletableFuture vs Future
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello");
//        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello", pool);
        // If want to use threads from Executor pool instead of ForkJoinPool then we use overloaded version as above
        completableFuture.thenAccept(System.out::println);
        // Completable Future executes asynchronously, without blocking any execution.

        Future<String> future = pool.submit(() -> "Hello");
        String result = future.get(); // Blocking the execution till this operation is done
        System.out.println(result);

        // If return is void we can use runAsync
        CompletableFuture<Void> completableFutureVoid = CompletableFuture.runAsync(() -> System.out.println("Hello"));

        pool.shutdown();
    }

    public static class Pizza {
        Pizza() {

        }
    }
}
