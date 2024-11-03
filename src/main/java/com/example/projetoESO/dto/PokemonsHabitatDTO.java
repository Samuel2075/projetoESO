package com.example.projetoESO.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PokemonsHabitatDTO {
    private String name;
    private List<PokemonDTO> pokemon_species;
}
