package org.example.service.impl;

import org.example.service.AbstractSorting;

/**
 * MergeSort works by dividing the array into smaller subarrays,sorting them recursively,
 * and then merging them back together to produce a sorted array.
 */
public class MergeSort extends AbstractSorting {

    @Override
    public void sort(int[] array) {
        if(array.length <= 1) {
            return; // If the array has 0 or 1 element, it is already sorted
        }

        // Split the array into two halves
        int mid = array.length / 2;
        int[] leftArray = new int[mid];
        int[] rightArray = new int[array.length - mid];

        System.arraycopy(array, 0, leftArray, 0, mid);
        System.arraycopy(array, mid, rightArray, 0, array.length - mid);

        sort(leftArray); // Recursively sort the left subarray
        sort(rightArray); // Recursively sort the right subarray

        merge(leftArray, rightArray, array); // Merge the sorted subarrays
    }

    private void merge(int[] leftArray, int[] rightArray, int[] mergedArray) {
        int leftLength = leftArray.length;
        int rightLength = rightArray.length;
        int i = 0; // Index for the left subarray
        int j = 0; // Index for the right subarray
        int k = 0; // Index for the merged array

        // Compare elements from the left and right subarrays and merge them in sorted order
        while (i < leftLength && j < rightLength) {
            if (leftArray[i] <= rightArray[j]) {
                mergedArray[k] = leftArray[i];
                i++;
            } else {
                mergedArray[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy any remaining elements from the left subarray, if any
        while (i < leftLength) {
            mergedArray[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy any remaining elements from the right subarray, if any
        while (j < rightLength) {
            mergedArray[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
