package org.example.service.impl;

import org.example.service.AbstractSorting;

/** SelectionSort works by dividing the array into two parts: the sorted part and the unsorted part.
 * In each iteration of the outer loop, the smallest element from the unsorted part is selected and
 * placed at the correct position in the sorted part.
 */
public class SelectionSort extends AbstractSorting {

    @Override
    public void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i; // Assume the current element is the minimum
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) { // Check if any element is smaller than the assumed minimum
                    minIndex = j; // Update the index of the new minimum element
                }
            }
            swap(array, minIndex, i); // Swap the minimum element with the element at the current position
        }
    }
}
