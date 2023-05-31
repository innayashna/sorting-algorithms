package org.example.service.impl;

import org.example.service.AbstractSorting;

/** ShellSort is an optimization of the insertion sort algorithm that reduces the number of shifting operations.
 * It works by comparing and swapping elements that are far apart, gradually reducing the gap
 * until it becomes 1 and the array is sorted using a standard insertion sort.
 */
public class ShellSort extends AbstractSorting {

    @Override
    public void sort(int[] array) {
        int length = array.length;
        for (int gap = length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < length; i++) {
                int temp = array[i];
                int j;

                // Compare elements in pairs divided by the gap and shift them if necessary
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                    array[j] = array[j - gap];
                }

                array[j] = temp;
            }
        }
    }
}
