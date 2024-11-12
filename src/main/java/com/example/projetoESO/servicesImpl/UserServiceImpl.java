package com.example.projetoESO.servicesImpl;

import com.example.projetoESO.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl {
    @Autowired
    private UserRepository userRepository;
}
