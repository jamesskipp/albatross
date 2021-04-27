package com.jamesskipp.albatross.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "users")
@Data
public class User extends AbstractAuditedEntity {

    private String username;

    private String firstName;

    private String lastName;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "credentials_id")
    private Credentials credentials;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Authority> authorities = new HashSet<>();

    @JsonProperty("authorities")
    public Set<String> getAuthorityStrings() {
        return authorities.stream().map(auth -> auth.getRole().name()).collect(Collectors.toSet());
    }

    public void addAuthority(Authority authority) {
        if (authority.getUser() != this) {
            authority.setUser(this);
        }
        authorities.add(authority);
    }
}
