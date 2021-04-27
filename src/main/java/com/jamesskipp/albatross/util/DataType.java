package com.jamesskipp.albatross.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum DataType implements DbCharEnum {
    AUDIT('A'), METRICS('M'), USER_DATA('U'), OTHER('O');

    @Getter
    private final Character code;

}
