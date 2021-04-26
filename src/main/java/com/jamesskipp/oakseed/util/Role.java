package com.jamesskipp.oakseed.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Role {
    ADMIN('A'), USER('U');

    @Getter
    private final Character code;
}
