package org.example.service.impl;

import org.example.service.AbstractSorting;

/** InsertionSort works by dividing the array into two parts: the sorted part and the unsorted part.
 * It iterates through the unsorted part and inserts each element into its correct position in the sorted part,
 * shifting other elements if necessary. This process is repeated until all elements are in their correct positions.
 */
public class InsertionSort extends AbstractSorting {

    @Override
    public void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i]; // Current element to be inserted into its correct position
            int j = i - 1; // Travers the sorted part of the array

            // Shift elements to the right until correct position for current element is found
            while (j >= 0 && array[j] > current) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = current; // Insert the current element into its correct position in the sorted part
        }
    }
}
