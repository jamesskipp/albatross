package com.jamesskipp.albatross.security;

import com.jamesskipp.albatross.entity.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class AppUserDetails implements UserDetails {

    @Setter
    @Getter
    private User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getAuthorities();
    }

    @Override
    public String getPassword() {
        return user.getCredentials().getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !user.getCredentials().getIsExpired();
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public static AppUserDetails fromUser(User user) {
        AppUserDetails appUserDetails = new AppUserDetails();
        appUserDetails.setUser(user);
        return appUserDetails;
    }
}
