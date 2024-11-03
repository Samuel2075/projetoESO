package com.example.projetoESO.dto;

import com.example.projetoESO.entities.Pokemon;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PokemonDTO {
    private String name;
    private String url;

    public Pokemon convertDtoPokemonToEntity() {
        Pokemon pokemonEntity = new Pokemon();
        pokemonEntity.setName(this.getName());
        pokemonEntity.setUrlStatus(this.getUrl());
        //pokemonEntity.setHabitat("teste");
        return pokemonEntity;
    }
}
