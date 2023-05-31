package org.example.controller;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Result {
    private int[] sortedArray;
    private String duration;
}
