package com.example.projetoESO.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserPokemonDTO {
    private long id;
    private String name;
    public UserPokemonDTO(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
