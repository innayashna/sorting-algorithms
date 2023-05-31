package org.example.service;

import org.example.constants.SortType;
import org.example.exception.SortTypeNotFoundException;
import org.example.service.impl.*;
import org.springframework.stereotype.Service;

import static org.example.exception.constants.ErrorMessage.NOT_IMPLEMENTED_SORT_TYPE;

@Service
public class SortFactory {

    public AbstractSorting createSort(SortType sortType) {
        if (sortType == SortType.BUBBLE) {
            return new BubbleSort();
        } else if (sortType == SortType.INSERTION) {
            return new InsertionSort();
        } else if (sortType == SortType.SELECTION) {
            return new SelectionSort();
        } else if (sortType == SortType.SHELL) {
            return new ShellSort();
        } else if (sortType == SortType.MERGE) {
            return new MergeSort();
        } else if (sortType == SortType.QUICK) {
            return new QuickSort();
        } else if (sortType == SortType.HEAP) {
            return new HeapSort();
        }
        throw new SortTypeNotFoundException(NOT_IMPLEMENTED_SORT_TYPE);
    }
}
