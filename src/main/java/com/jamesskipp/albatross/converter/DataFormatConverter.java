package com.jamesskipp.albatross.converter;

import com.jamesskipp.albatross.util.ConverterUtils;
import com.jamesskipp.albatross.util.DataFormat;

import javax.persistence.Converter;

@Converter(autoApply = true)
public class DataFormatConverter extends DbCharEnumConverter<DataFormat> {

    @Override
    public DataFormat convertToEntityAttribute(Character code) {
        return ConverterUtils.convertToEntityAttribute(DataFormat.values(), code);
    }
}

