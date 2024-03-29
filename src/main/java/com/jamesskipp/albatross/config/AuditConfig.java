package com.jamesskipp.albatross.config;

import com.jamesskipp.albatross.security.AppAuditorAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class AuditConfig {

    @Bean
    public AppAuditorAware auditorProvider() {
        return new AppAuditorAware();
    }
}