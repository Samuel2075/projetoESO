package com.example.projetoESO.controllers;

import com.example.projetoESO.form.PokemonFilterForm;
import com.example.projetoESO.services.PokemonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping()
public class PokemonController {
    @Autowired
    private PokemonService pokemonService;

    @PostMapping("/pokemon/filter")
    ResponseEntity<?> getPokemonsFilter(@RequestBody @Valid PokemonFilterForm pokemonFilterRequest) {
        return ResponseEntity.ok(pokemonService.filterPokemons(pokemonFilterRequest));
    }

    @GetMapping("/pokemon")
    ResponseEntity<?> getAllPokemons() {
        return ResponseEntity.ok(pokemonService.getAllPokemons());
    }

}
