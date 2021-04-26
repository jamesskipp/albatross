package com.jamesskipp.oakseed.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractAuditedEntity extends AbstractBaseEntity {

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @JsonIgnore
    @CreatedBy
    @ManyToOne
    private User createdBy;

    @JsonProperty("createdBy")
    public Long getCreatedById() {
        return createdBy != null ? createdBy.getId() : null;
    }

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

    @JsonIgnore
    @LastModifiedBy
    @ManyToOne
    private User updatedBy;

    @JsonProperty("updatedBy")
    public Long getUpdatedById() {
        return updatedBy != null ? updatedBy.getId() : null;
    }
}
