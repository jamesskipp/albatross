package com.jamesskipp.albatross.config;

import com.jamesskipp.albatross.security.AppUserDetailsService;
import com.jamesskipp.albatross.util.Role;
import com.jamesskipp.albatross.util.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AppUserDetailsService appUserDetailsService;

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(appUserDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(URL.API + URL.USER).permitAll()
                .antMatchers(URL.API + URL.ADMIN).hasAuthority(Role.ADMIN.name())
                .antMatchers(URL.API + "/**").hasAnyAuthority(Role.USER.name(),  Role.USER.name())
                .and().httpBasic();

        http.csrf().disable().cors();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}