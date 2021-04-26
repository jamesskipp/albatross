package com.jamesskipp.oakseed.security;

import com.jamesskipp.oakseed.entity.User;
import org.springframework.data.domain.AuditorAware;
import org.springframework.lang.NonNull;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class AppAuditorAware implements AuditorAware<User> {

    @NonNull
    @Override
    public Optional<User> getCurrentAuditor() {
        Optional<User> user = Optional.empty();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            Object principal = auth.getPrincipal();
            if (principal instanceof AppUserDetails appUserDetails) {
                user = Optional.of(appUserDetails.getUser());
            }
        }
        return user;
    }
}
