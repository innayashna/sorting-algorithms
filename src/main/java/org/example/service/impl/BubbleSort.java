package org.example.service.impl;

import org.example.service.AbstractSorting;

/**
 * BubbleSort works by repeatedly swapping adjacent elements if they are in the wrong order.
 * After each iteration, the largest element is guaranteed to be in its correct position at the end of the array.
 */
public class BubbleSort extends AbstractSorting {

    @Override
    public void sort(int[] array) {
        for(int i = 0; i < array.length; i++) {
            for(int j = 1; j < array.length; j++) {
                if(array[j] < array[j -1]) { // Compare adjacent elements and swap if necessary
                    swap(array, j, j - 1);
                }
            }
        }
    }
}
