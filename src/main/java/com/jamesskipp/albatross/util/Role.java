package com.jamesskipp.albatross.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Role implements DbCharEnum {
    ADMIN('A'), USER('U');

    @Getter
    private final Character code;
}
