package com.example.projetoESO.services;

import com.example.projetoESO.dto.PokemonDTO;
import com.example.projetoESO.entities.Pokemon;
import com.example.projetoESO.form.PokemonFilterForm;

import java.io.IOException;
import java.util.List;

public interface PokemonService {
    List<PokemonDTO> getAllPokemons(int page, int size);
    void savePokemon(Pokemon pokemon);
    Pokemon getPokemonByName(String name);
    void updatePokemon(Pokemon pokemonEntityUpdate);
    List<PokemonDTO> filterPokemons(PokemonFilterForm pokemonFilterForm);
}
