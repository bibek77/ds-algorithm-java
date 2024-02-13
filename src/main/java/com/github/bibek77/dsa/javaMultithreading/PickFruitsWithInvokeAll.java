package com.github.bibek77.dsa.javaMultithreading;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ForkJoinPool;

/**
 * @author bibek
 */
public class PickFruitsWithInvokeAll {

    public static void main(String[] args) {
        AppleTree[] appleTrees = AppleTree.newTreeGarden(6);

        Callable<Void> callable1 = createApplePicker(appleTrees, 0, 2, "Alex");
        Callable<Void> callable2 = createApplePicker(appleTrees, 2, 4, "Bob");
        Callable<Void> callable3 = createApplePicker(appleTrees, 4, 6, "Carol");

        ForkJoinPool.commonPool().invokeAll(Arrays.asList(callable1, callable2, callable3));
        //Common Pool returns the best performance.
        //It executes all callable functional interface in parallel.

        System.out.println("All Fruits Collected!");
    }

    public static Callable<Void> createApplePicker(AppleTree[] appleTrees, int fromTree, int toTree, String worker) {

        return () -> {
            for(int i=fromTree; i<toTree; i++) {
                appleTrees[i].pickApples(worker);
            }
            return null;
        };
    }
}
