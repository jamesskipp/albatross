package com.jamesskipp.albatross.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserForm {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    public static UserForm create(String firstName, String lastName, String username, String password) {
        UserForm userForm = new UserForm();
        userForm.setFirstName(firstName);
        userForm.setLastName(lastName);
        userForm.setUsername(username);
        userForm.setPassword(password);
        return userForm;
    }
}
