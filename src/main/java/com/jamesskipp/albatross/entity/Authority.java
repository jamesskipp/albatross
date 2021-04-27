package com.jamesskipp.albatross.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jamesskipp.albatross.util.Role;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = true, exclude = "user")
@ToString(exclude = "user")
@NoArgsConstructor
@Entity
@Table(name = "user_authorities")
public class Authority extends AbstractBaseEntity implements GrantedAuthority {

    public Authority(Role role) {
        this.role = role;
    }

    @JsonIgnore
    @ManyToOne
    private User user;

    private Role role;

    @Override
    public String getAuthority() {
        return role.name();
    }
}
