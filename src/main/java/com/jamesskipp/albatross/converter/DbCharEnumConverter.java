package com.jamesskipp.albatross.converter;

import com.jamesskipp.albatross.util.ConverterUtils;
import com.jamesskipp.albatross.util.DbCharEnum;

import javax.persistence.AttributeConverter;

abstract class DbCharEnumConverter<T extends DbCharEnum> implements AttributeConverter<T, Character> {

    @Override
    public Character convertToDatabaseColumn(T attribute) {
        return ConverterUtils.convertToDatabaseColumn(attribute);
    }

    @Override
    public abstract T convertToEntityAttribute(Character code);
}
