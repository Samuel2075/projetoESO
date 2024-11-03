package com.example.projetoESO.servicesImpl;

import com.example.projetoESO.entities.Pokemon;
import com.example.projetoESO.repositories.PokemonRepository;
import com.example.projetoESO.services.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class PokemonServiceImpl implements PokemonService {
    @Autowired
    private PokemonRepository pokemonRepository;
    @Override
    public List<Pokemon> getAllPokemons() {
        return pokemonRepository.findAll();
    }

    @Override
    public void savePokemon(Pokemon pokemon) {
        pokemonRepository.save(pokemon);
    }

}
