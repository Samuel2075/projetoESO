package com.example.projetoESO.controllers;

import com.example.projetoESO.dto.LoginResponseDTO;
import com.example.projetoESO.form.LoginForm;
import com.example.projetoESO.services.JwtService;
import com.example.projetoESO.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserService userService;
    @Autowired
    private JwtService jwtService;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginForm loginForm) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginForm.getUsername(), loginForm.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        loginResponseDTO.setUser(userService.findByUserName(loginForm.getUsername()));
        loginResponseDTO.setToken(jwtService.generateToken(userDetails.getUsername()));
        loginResponseDTO.setMessage("Login efetuado com sucesso!");

        return ResponseEntity.ok(loginResponseDTO);
    }

}
