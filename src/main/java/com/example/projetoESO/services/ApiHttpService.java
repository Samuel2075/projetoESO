package com.example.projetoESO.services;

import com.example.projetoESO.dto.*;

import java.util.List;

public interface ApiHttpService {
    List<PokemonDTO> requestApiGetAllPokemons(int limit, int offset);
    List<HabitatsDTO> requestApiGetHabitats();
    PokemonsHabitatDTO requestApiGetPokemonsHabitats(String habitat);
    List<TypeDTO> requestApiGetTypes();
    List<ColorDTO> requestApiGetColors();
    PokemonStatusDTO requestApiGetStatusPokemon(String namePokemon);
}
