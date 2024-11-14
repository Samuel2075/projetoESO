package com.example.projetoESO.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CaptureResponseDTO {
    private String message;
    private Boolean error;
    private UserPokemonDTO user;
}
