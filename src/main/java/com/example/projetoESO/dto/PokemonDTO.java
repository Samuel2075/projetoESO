package com.example.projetoESO.dto;

import com.example.projetoESO.entities.Types;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
public class PokemonDTO {
    private long id;
    private String name;
    private String urlStatus;
    private Set<Types> types = new HashSet<>();
    private UserPokemonDTO user;
    private String front_default;
    private int weight;
}
