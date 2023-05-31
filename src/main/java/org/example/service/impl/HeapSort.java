package org.example.service.impl;

import org.example.service.AbstractSorting;

/**
 * Heap Sort is a comparison-based sorting algorithm that uses a binary heap data structure
 * to perform the sorting by repeatedly extracting the maximum element of the heap.
 */
public class HeapSort extends AbstractSorting {

    @Override
    public void sort(int[] array) {
        int n = array.length;

        // Build the initial heap (rearrange the array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        // Extract elements from the heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move the current root (maximum element) to the end
            swap(array, 0, i);

            // Heapify the reduced heap
            heapify(array, i, 0);
        }
    }

    private void heapify(int[] array, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // Left child
        int right = 2 * i + 2; // Right child

        // If the left child is larger than the root
        if (left < n && array[left] > array[largest]) {
            largest = left;
        }

        // If the right child is larger than the current largest
        if (right < n && array[right] > array[largest]) {
            largest = right;
        }

        // If the largest is not the root
        if (largest != i) {
            swap(array, i, largest);

            // Recursively heapify the affected subtree
            heapify(array, n, largest);
        }
    }
}
