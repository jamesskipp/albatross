package com.jamesskipp.oakseed.controller;

import com.jamesskipp.oakseed.entity.User;
import com.jamesskipp.oakseed.exception.NotFoundException;
import com.jamesskipp.oakseed.model.UserForm;
import com.jamesskipp.oakseed.service.UserService;
import com.jamesskipp.oakseed.util.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Secured("hasRole(ROLE_ADMIN)")
@RestController
@RequestMapping(URL.API + URL.USER)
public class UserController extends AbstractBaseController<User> {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public List<User> query() {
        return userService.query();
    }

    @GetMapping(URL.ID_PARAM)
    public User findById(@PathVariable Long id) throws NotFoundException {
        return userService.findById(id);
    }

    @PostMapping
    public User create(@RequestBody UserForm form) {
        form.setPassword(passwordEncoder.encode(form.getPassword()));
        return userService.create(form);
    }

    @PutMapping(URL.ID_PARAM)
    public User update(@PathVariable Long id, @RequestBody @Validated UserForm form) throws NotFoundException {
        return userService.update(id, form);
    }
}