package com.jamesskipp.oakseed.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NotFoundException extends Exception {

    private final Long id;
    private final Class<?> cls;

    @Override
    public String getMessage() {
        return String.format("Id [%s] of class [%s] not found!", id, cls);
    }
}
