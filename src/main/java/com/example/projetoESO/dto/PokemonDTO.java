package com.example.projetoESO.dto;

import com.example.projetoESO.entities.Habitat;
import com.example.projetoESO.entities.Pokemon;
import com.example.projetoESO.entities.Types;
import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

@Getter
@Setter
public class PokemonDTO {
    private String name;
    private String url;

    public Pokemon convertDtoPokemonToEntity(List<Types> typesPokemon, SpriteDTO spriteDTO, int weight, int base_experience) {
        Pokemon pokemonEntity = new Pokemon();
        pokemonEntity.setName(this.getName());
        pokemonEntity.setUrlStatus(this.getUrl());
        typesPokemon.forEach((type) -> {
            pokemonEntity.setTypes(Collections.singleton(type));
        });
        pokemonEntity.setFront_default(spriteDTO.getFront_default());
        pokemonEntity.setFront_shiny(spriteDTO.getFront_shiny());
        pokemonEntity.setWeight(weight);
        pokemonEntity.setBase_experience(base_experience);
        return pokemonEntity;
    }
}
