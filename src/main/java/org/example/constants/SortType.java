package org.example.constants;

import org.example.exception.SortTypeNotFoundException;

import static org.example.exception.constants.ErrorMessage.NOT_IMPLEMENTED_SORT_TYPE;

public enum SortType {
    BUBBLE ("bubble"),
    INSERTION ("insertion"),
    SELECTION ("selection"),
    SHELL ("shell"),
    MERGE ("merge"),
    HEAP ("heap"),
    QUICK ("quick");

    private final String name;

    SortType(final String name) {
        this.name = name;
    }

    public static SortType fromString(String type) {
        for (SortType t : SortType.values()) {
            if (t.name.equalsIgnoreCase(type)) {
                return t;
            }
        }
        throw new SortTypeNotFoundException(NOT_IMPLEMENTED_SORT_TYPE);
    }
}
