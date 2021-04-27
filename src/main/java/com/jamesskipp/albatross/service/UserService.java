package com.jamesskipp.albatross.service;

import com.jamesskipp.albatross.entity.Authority;
import com.jamesskipp.albatross.entity.Credentials;
import com.jamesskipp.albatross.entity.User;
import com.jamesskipp.albatross.exception.NotFoundException;
import com.jamesskipp.albatross.model.UserForm;
import com.jamesskipp.albatross.repository.UserRepository;
import com.jamesskipp.albatross.util.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> query() {
        return userRepository.findAll();
    }

    public User findById(Long id) throws NotFoundException {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException(id, User.class));
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User create(UserForm form) {
        return create(form.getFirstName(), form.getLastName(), form.getUsername(), form.getPassword(), Role.USER);
    }

    public User create(String firstName, String lastName, String username, String password, Role role) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUsername(username);
        user.setCredentials(new Credentials(password));
        user.addAuthority(new Authority(role));
        return userRepository.save(user);
    }

    public User update(Long id, UserForm form) throws NotFoundException {
        User user = findById(id);
        return bindAndSave(user, form);
    }

    private User bindAndSave(User user, UserForm form) {
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        return userRepository.save(user);
    }
}
