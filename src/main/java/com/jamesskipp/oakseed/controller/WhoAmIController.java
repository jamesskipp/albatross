package com.jamesskipp.oakseed.controller;

import com.jamesskipp.oakseed.entity.User;
import com.jamesskipp.oakseed.service.UserService;
import com.jamesskipp.oakseed.util.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping(URL.API + URL.WHO_AM_I)
public class WhoAmIController {

    @Autowired
    UserService userService;

    @GetMapping
    public User whoAmI(Principal principal) {
        if (principal == null) {
            return null;
        }

        return userService.findByUsername(principal.getName()).orElse(null);
    }
}
