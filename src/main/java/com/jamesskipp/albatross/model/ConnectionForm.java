package com.jamesskipp.albatross.model;

import com.jamesskipp.albatross.util.DataFormat;
import com.jamesskipp.albatross.util.DataType;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
public class ConnectionForm {

    @NotEmpty
    private Long xId;

    @NotEmpty
    private Long yId;

    @NotBlank
    private DataType dataType;

    @NotBlank
    private DataFormat dataFormat;
}
