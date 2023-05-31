package org.example.controller;

import org.example.constants.SortType;
import org.example.service.AbstractSorting;
import org.example.service.FileReader;
import org.example.service.SortFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/sort")
public class SortController {

    private final SortFactory sortFactory;
    private final FileReader fileReader;

    @Autowired
    public SortController(SortFactory sortFactory, FileReader fileReader) {
        this.sortFactory = sortFactory;
        this.fileReader = fileReader;
    }

    @PostMapping("/{sortType}")
    public ResponseEntity<Result> sortArray(@PathVariable String sortType,
                                            @RequestPart MultipartFile file) {
        AbstractSorting sortAlgorithm = sortFactory.createSort(SortType.fromString(sortType));
        int[] array = fileReader.getArray(file);
        double elapsedTime = sortAlgorithm.sortWithElapsedTime(array);
        Result result = Result.builder()
                .sortedArray(array)
                .duration(formatElapsedTime(elapsedTime))
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    private String formatElapsedTime(double time) {
        return String.format("%.6f seconds", time);
    }
}
