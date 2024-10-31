package com.example.projetoESO.controllers;

import com.example.projetoESO.entities.Pokemon;
import com.example.projetoESO.services.PokemonApiHttpService;
import com.example.projetoESO.services.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping()
public class PokemonController {
    @Autowired
    private PokemonService pokemonService;
    @Autowired
    private PokemonApiHttpService pokemonApiHttpService;

    @GetMapping("/pokemon")
    List<Pokemon> getAllPokemons() {
        return pokemonService.getAllPokemons();
    }

    @GetMapping("/pokemon/api")
    String getAllPokemonsApi() throws IOException, InterruptedException {
        return pokemonApiHttpService.getAllPokemons(1302, 0);
    }

}
