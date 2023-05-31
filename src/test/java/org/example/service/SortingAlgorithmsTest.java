package org.example.service;

import org.example.service.impl.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SortingAlgorithmsTest {

    private final int[] unsortedArray = new int[] {1, 4, 3, 2, 5};
    private final int[] sortedArray = new int[] {1, 2, 3, 4, 5};

    @Test
    void bubbleSort() {
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(unsortedArray);
        assertArrayEquals(sortedArray, unsortedArray);
    }

    @Test
    void insertionSort() {
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(unsortedArray);
        assertArrayEquals(sortedArray, unsortedArray);
    }

    @Test
    void shellSort() {
        ShellSort shellSort = new ShellSort();
        shellSort.sort(unsortedArray);
        assertArrayEquals(sortedArray, unsortedArray);
    }

    @Test
    void selectionSort() {
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(unsortedArray);
        assertArrayEquals(sortedArray, unsortedArray);
    }

    @Test
    void mergeSort() {
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(unsortedArray);
        assertArrayEquals(sortedArray, unsortedArray);
    }

    @Test
    void quickSort() {
        QuickSort quickSort = new QuickSort();
        quickSort.sort(unsortedArray);
        assertArrayEquals(sortedArray, unsortedArray);
    }

    @Test
    void heapSort() {
        HeapSort heapSort = new HeapSort();
        heapSort.sort(unsortedArray);
        assertArrayEquals(sortedArray, unsortedArray);
    }
}
