package com.jamesskipp.oakseed.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Table(name = "user_credentials")
@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
public class Credentials extends AbstractBaseEntity {

    public Credentials(String password) {
        this.password = password;
        this.isExpired = false;
    }

    private String password;

    private Boolean isExpired;
}
