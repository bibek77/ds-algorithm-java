package com.github.bibek77.dsa.dataStructures.sorting;

import java.util.*;

/**
 * @author bibek
 */
public class BucketSort {
    public void bucketSort(int[] arr) {
        int totalBuckets = (int) Math.ceil(Math.sqrt(arr.length));
        int maxVal = Integer.MIN_VALUE;
        // get the max value for bucket size
        for (int val : arr) {
            maxVal = Math.max(val, maxVal);
        }

        // Initializing buckets
        List<Integer>[] totalBucketsList = new ArrayList[totalBuckets];
        for (int i = 0; i < totalBucketsList.length; i++) {
            totalBucketsList[i] = new ArrayList<>();
        }

        // Adding values to buckets
        for (int val : arr) {
            int bucketNum = (int) Math.ceil(((float) val * totalBuckets) / (float) maxVal);
            totalBucketsList[bucketNum - 1].add(val);
        }

        // Sorting buckets
        for (List<Integer> bucket : totalBucketsList) {
            Collections.sort(bucket);
        }

        //Merging the bucket
        int index = 0;
        for (List<Integer> buckets : totalBucketsList) {
            for (int val : buckets) {
                arr[index] = val;
                index++;
            }
        }
    }
}
