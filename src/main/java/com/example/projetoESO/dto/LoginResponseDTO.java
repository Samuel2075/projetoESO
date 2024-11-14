package com.example.projetoESO.dto;

import com.example.projetoESO.entities.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseDTO {
    private String message;
    private String token;
    private long userId;
}
