package com.jamesskipp.albatross.model;

import com.jamesskipp.albatross.util.ResourceType;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ResourceForm {

    @NotBlank
    private String name;

    @NotNull
    private ResourceType type;
}
