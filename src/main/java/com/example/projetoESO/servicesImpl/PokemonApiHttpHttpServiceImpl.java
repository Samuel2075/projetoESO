package com.example.projetoESO.servicesImpl;

import com.example.projetoESO.services.PokemonApiHttpService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
@Service
public class PokemonApiHttpHttpServiceImpl implements PokemonApiHttpService {
    @Override
    public String getAllPokemons(int limit, int offset) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://pokeapi.co/api/v2/pokemon?limit=" + limit + "&offset=" + offset))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    @Override
    public JSONPObject convertStringJson(String jsonString) {
        return new JSONPObject(null, jsonString);
    }
}
