package com.jamesskipp.albatross.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum DataFormat implements DbCharEnum {
    JSON('J'), XML('X'), BYTE('B'), TEXT('T');

    @Getter
    private final Character code;
}
