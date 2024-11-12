package com.example.projetoESO.services;

import org.springframework.security.core.Authentication;

public interface JwtService {
    String generateToken(Authentication authentication);
}
