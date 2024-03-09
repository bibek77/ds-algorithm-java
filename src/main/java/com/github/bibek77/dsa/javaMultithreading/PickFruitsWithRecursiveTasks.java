package com.github.bibek77.dsa.javaMultithreading;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

/**
 * @author bibek
 */
public class PickFruitsWithRecursiveTasks {

    public static void main(String[] args) {
        AppleTree[] appleTrees = AppleTree.newTreeGarden(12);
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        PickFruitTask pickFruitTask = new PickFruitTask(appleTrees, 0, appleTrees.length - 1);

        int result = forkJoinPool.invoke(pickFruitTask);

        System.out.println();
        System.out.println("Apples Picked : "+ result);
    }

    public static class PickFruitTask extends RecursiveTask<Integer> {
        private final AppleTree[] appleTrees;
        private final int startTree;
        private final int endTree;

        private final int taskThreshold = 4;

        public PickFruitTask(AppleTree[] appleTrees, int startTree, int endTree) {
            this.appleTrees = appleTrees;
            this.startTree = startTree;
            this.endTree = endTree;
        }

        @Override
        protected Integer compute() {
            if (endTree - startTree < taskThreshold) {
                return doCompute();
            }
            int midPoint = startTree + (endTree - startTree) / 2;
            PickFruitTask leftSum = new PickFruitTask(appleTrees, startTree, midPoint);
            PickFruitTask rightSum = new PickFruitTask(appleTrees, midPoint + 1, endTree);

            rightSum.fork();
            return leftSum.compute() + rightSum.join();
        }

        protected int doCompute() {
            return IntStream.rangeClosed(startTree, endTree)
                    .map(i -> appleTrees[i].pickApples()).sum();
        }


    }
}
