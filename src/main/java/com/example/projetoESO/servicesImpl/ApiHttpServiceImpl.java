package com.example.projetoESO.servicesImpl;

import com.example.projetoESO.dto.*;
import com.example.projetoESO.services.ApiHttpService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApiHttpServiceImpl implements ApiHttpService {

    private <T> ResponseEntity<T> requestApi(String url, Class<T> responseType) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<T> responseEntity = restTemplate.getForEntity(url, responseType);
        return responseEntity;
    }
    @Override
    public List<PokemonDTO> requestApiGetAllPokemons(int limit, int offset) {
        ResponseEntity<RequestDTO> responseEntity = this.requestApi(String.format("https://pokeapi.co/api/v2/pokemon?limit=%d&offset=%d", limit, offset), RequestDTO.class);
        ObjectMapper objectMapper = new ObjectMapper();
        return responseEntity.getBody().getResults().stream()
                .map(item -> objectMapper.convertValue(item, PokemonDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<HabitatsDTO> requestApiGetHabitats() {
        ResponseEntity<RequestDTO> responseEntity = this.requestApi(String.format("https://pokeapi.co/api/v2/pokemon-habitat"), RequestDTO.class);
        ObjectMapper objectMapper = new ObjectMapper();
        return responseEntity.getBody().getResults().stream()
                .map(item -> objectMapper.convertValue(item, HabitatsDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PokemonsHabitatDTO requestApiGetPokemonsHabitats(String habitat) {
        ResponseEntity<PokemonsHabitatDTO> responseEntity = this.requestApi(String.format("https://pokeapi.co/api/v2/pokemon-habitat/%s/", habitat), PokemonsHabitatDTO.class);
        return responseEntity.getBody();
    }

    @Override
    public List<TypeDTO> requestApiGetTypes() {
        ResponseEntity<RequestDTO> responseEntity = this.requestApi(String.format("https://pokeapi.co/api/v2/type?offset=0&limit=21"), RequestDTO.class);
        ObjectMapper objectMapper = new ObjectMapper();
        return responseEntity.getBody().getResults().stream()
                .map(item -> objectMapper.convertValue(item, TypeDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ColorDTO> requestApiGetColors() {
        ResponseEntity<RequestDTO> responseEntity = this.requestApi(String.format("https://pokeapi.co/api/v2/pokemon-color"), RequestDTO.class);
        ObjectMapper objectMapper = new ObjectMapper();
        return responseEntity.getBody().getResults().stream()
                .map(item -> objectMapper.convertValue(item, ColorDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PokemonStatusDTO requestApiGetStatusPokemon(String namePokemon) {
        ResponseEntity<PokemonStatusDTO> responseEntity = this.requestApi(String.format("https://pokeapi.co/api/v2/pokemon/%s/", namePokemon), PokemonStatusDTO.class);
        return responseEntity.getBody();
    }

}
