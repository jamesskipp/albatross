package com.jamesskipp.albatross.converter;

import com.jamesskipp.albatross.util.ConverterUtils;
import com.jamesskipp.albatross.util.DataType;

import javax.persistence.Converter;

@Converter(autoApply = true)
public class DataTypeConverter extends DbCharEnumConverter<DataType> {

    @Override
    public DataType convertToEntityAttribute(Character code) {
        return ConverterUtils.convertToEntityAttribute(DataType.values(), code);
    }
}
