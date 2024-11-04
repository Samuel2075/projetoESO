package com.example.projetoESO.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class PokemonStatusDTO {
    private String name;
    private List<TypeStructDTO> types;
    private SpriteDTO sprites;
    private int weight;
    private int base_experience;
}
