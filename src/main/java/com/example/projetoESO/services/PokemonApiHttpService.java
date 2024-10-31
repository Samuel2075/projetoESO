package com.example.projetoESO.services;

import com.fasterxml.jackson.databind.util.JSONPObject;

import java.io.IOException;

public interface PokemonApiHttpService {
    public String getAllPokemons(int limit, int offset) throws IOException, InterruptedException;
    public JSONPObject convertStringJson(String json);
}
