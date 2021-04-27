package com.jamesskipp.albatross.util;

import java.util.stream.Stream;

public interface ConverterUtils {

    static <T extends DbCharEnum> T convertToEntityAttribute(T[] values, Character code) {
        if (code == null) {
            return null;
        }

        return (T) Stream.of(values)
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    static <T extends DbCharEnum> Character convertToDatabaseColumn(T dbCharEnum) {
        return dbCharEnum != null ? dbCharEnum.getCode() : null;
    }
}
