package com.jamesskipp.albatross.entity;

import com.jamesskipp.albatross.util.DataFormat;
import com.jamesskipp.albatross.util.DataType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "resource_connections")
@Data
@EqualsAndHashCode(callSuper = true)
public class Connection extends AbstractAuditedEntity {

    @ManyToOne
    private Resource x;

    @ManyToOne
    private Resource y;

    private Boolean active;

    private DataType dataType;

    private DataFormat dataFormat;
}
