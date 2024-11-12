package com.example.projetoESO.servicesImpl;

import com.example.projetoESO.services.AuthenticationService;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Override
    public String authenticate() {
        return "token";
    }
}
