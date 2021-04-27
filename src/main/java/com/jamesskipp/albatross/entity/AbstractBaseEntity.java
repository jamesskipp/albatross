package com.jamesskipp.albatross.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

@Data
@MappedSuperclass
public abstract class AbstractBaseEntity {

    @Id
    @NotNull
    @GeneratedValue
    private Long id;
}
