package org.example.service.impl;

import org.example.service.AbstractSorting;

/**
 * QuickSort works by selecting a pivot element, partitioning the array into
 * two subarrays based on the pivot, and recursively sorting the subarrays.
 */
public class QuickSort extends AbstractSorting {

    @Override
    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high); // Partition the array

            // Recursively sort the subarrays before and after the pivot
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[high]; // Select the pivot element (last element)

        int i = low - 1; // Index of the smaller element

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j); // Swap elements at i and j
            }
        }

        swap(array, i + 1, high); // Place the pivot element in its correct position
        return i + 1; // Return the index of the pivot element
    }
}
