package com.jamesskipp.albatross.converter;

import com.jamesskipp.albatross.util.ConverterUtils;
import com.jamesskipp.albatross.util.Role;

import javax.persistence.Converter;

@Converter(autoApply = true)
public class RoleConverter extends DbCharEnumConverter<Role> {

    @Override
    public Role convertToEntityAttribute(Character code) {
        return ConverterUtils.convertToEntityAttribute(Role.values(), code);
    }
}
