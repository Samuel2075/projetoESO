package com.example.projetoESO.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ColorPokemonsDTO {
    private String name;
    private List<PokemonApiDTO> pokemon_species;
}
