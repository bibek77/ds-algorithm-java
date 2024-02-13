package com.github.bibek77.dsa.javaMultithreading;

import java.util.concurrent.TimeUnit;

/**
 * @author bibek
 */
public class AppleTree {

    private final String treeLabel;
    private final int numberOfApples;

    public AppleTree(String treeLabel) {
        this.treeLabel = treeLabel;
        numberOfApples = 3;
    }

    public static AppleTree[] newTreeGarden(int size) {
        AppleTree[] appleTrees = new AppleTree[size];
        for (int i = 0; i < size; i++) {
            appleTrees[i] = new AppleTree("#" + i);
        }
        return appleTrees;
    }

    public int pickApples(String workerName) {
        try {
            System.out.printf("Worker : %s started picking apples from : %s\n", workerName, treeLabel);
            TimeUnit.SECONDS.sleep(3);
            System.out.printf("Worker : %s picked : %d from tree : %s\n", workerName, numberOfApples, treeLabel);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return numberOfApples;
    }

    public int pickApples() {
        System.out.printf("Apples : %d picked from tree : %s\n", numberOfApples, treeLabel);
        return numberOfApples;
    }


}
