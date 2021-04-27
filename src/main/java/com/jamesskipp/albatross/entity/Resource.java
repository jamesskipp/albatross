package com.jamesskipp.albatross.entity;

import com.jamesskipp.albatross.util.ResourceType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "resources")
public class Resource extends AbstractAuditedEntity {

    private String name;

    private ResourceType type;

    private Boolean active;

    @ManyToOne
    private Resource parent;

    @OneToMany
    private List<Resource> children;

    @OneToMany
    private List<Connection> connections;
}
