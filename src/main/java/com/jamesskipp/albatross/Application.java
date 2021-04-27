package com.jamesskipp.albatross;

import com.jamesskipp.albatross.service.UserService;
import com.jamesskipp.albatross.util.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Application {

    @Autowired
    UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    public void postConstruct() {
        this.userService.create("app", "user", "user", passwordEncoder.encode("password"), Role.USER);
        this.userService.create("app", "admin", "admin", passwordEncoder.encode("password"), Role.ADMIN);
    }
}
