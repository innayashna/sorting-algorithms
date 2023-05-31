package org.example.exception;

public class SortTypeNotFoundException extends RuntimeException {

    public SortTypeNotFoundException(String message) {
        super(message);
    }
}
