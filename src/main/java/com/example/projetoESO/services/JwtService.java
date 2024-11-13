package com.example.projetoESO.services;

import io.jsonwebtoken.Claims;

public interface JwtService {
    String generateToken(String username);
    Claims getClaimsFromToken(String token);
    boolean isTokenValid(String token);
    String getUsernameFromToken(String token);

}
