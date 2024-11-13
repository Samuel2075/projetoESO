package com.example.projetoESO.form;

import com.example.projetoESO.entities.User;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class RegisterForm {
    private String username;
    private String password;
    private String name;

    public User convertDtoUserToEntity(RegisterForm registerForm) {
        User userEntity = new User();
        userEntity.setUserName(registerForm.getUsername());
        userEntity.setName(registerForm.getName());
        userEntity.setPassword(registerForm.getPassword());
        return userEntity;
    }
}
