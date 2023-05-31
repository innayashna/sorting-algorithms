package org.example.service;

public abstract class AbstractSorting implements SortAlgorithm {

    public double sortWithElapsedTime(int[] array) {
        long start = System.nanoTime();
        sort(array);
        long end = System.nanoTime();

        return (end - start) / 1_000_000_000.0;
    }

    protected void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
