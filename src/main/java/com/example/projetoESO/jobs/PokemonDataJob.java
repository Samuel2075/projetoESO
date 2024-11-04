package com.example.projetoESO.jobs;

import com.example.projetoESO.dto.*;
import com.example.projetoESO.entities.Color;
import com.example.projetoESO.entities.Habitat;
import com.example.projetoESO.entities.Pokemon;
import com.example.projetoESO.entities.Types;
import com.example.projetoESO.services.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

@Component
public class PokemonDataJob {
    @Autowired
    private ApiHttpService apiHttpService;
    @Autowired
    private PokemonService pokemonService;
    @Autowired
    private HabitatService habitatService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private ColorService colorService;

    @PostConstruct
    @Scheduled(cron = "0 0 0 * * MON")
    public void updateDataStoragePokemon() {
        /*this.populateTypes();
        this.populateColors();
        this.populateHabitat();
        this.populatePokemon();
        this.linkColorPokemon();
        this.linkPokemonHabitat();*/
    }

    private void populateTypes() {
        List<TypeDTO> typesList = apiHttpService.requestApiGetTypes();
        typesList.forEach((type) -> {
            typeService.saveType(type.convertDtoTypeToEntity());
        });
    }

    private void populateHabitat() {
        List<HabitatsDTO> habitatsList = apiHttpService.requestApiGetHabitats();
        habitatsList.forEach((habitat) -> {
            habitatService.saveHabitat(habitat.convertDtoHabitatToEntity());
        });
    }

    private void populateColors() {
        List<ColorDTO> colorsList = apiHttpService.requestApiGetColors();
        colorsList.forEach((color) -> {
            colorService.saveColor(color.convertDtoColorToEntity());
        });
    }

    private void populatePokemon() {
        List<Types> typesPokemon = new ArrayList<>();
        List<PokemonDTO> pokemonsList = apiHttpService.requestApiGetAllPokemons(1303, 0);
        pokemonsList.forEach((pokemon) -> {
            PokemonStatusDTO pokemonStatusDTO = apiHttpService.requestApiGetStatusPokemon(pokemon.getName());

            pokemonStatusDTO.getTypes().forEach((type) -> {
                typesPokemon.add(typeService.getTypeByName(type.getType().getName()));
            });
            pokemonService.savePokemon(pokemon.convertDtoPokemonToEntity(typesPokemon, pokemonStatusDTO.getSprites(), pokemonStatusDTO.getWeight(), pokemonStatusDTO.getBase_experience()));
            typesPokemon.clear();
            System.out.println(pokemonStatusDTO.getName());
        });
    }

    private void linkColorPokemon() {
        List<Color> colorsList = colorService.getAllColors();
        colorsList.forEach((color) -> {
            ColorPokemonsDTO colorPokemonsDTO = apiHttpService.requestApiGetPokemonsColor(color.getName());
            colorPokemonsDTO.getPokemon_species().forEach((pokemon) -> {
                Pokemon pokemonEntity = pokemonService.getPokemonByName(pokemon.getName());
                if(pokemonEntity != null) {
                    Set<Color> colorSet = new HashSet<>();
                    colorSet.add(color);
                    pokemonEntity.setColors(colorSet);
                    pokemonService.updatePokemon(pokemonEntity);
                }
            });
        });
    }

    private void linkPokemonHabitat() {
        List<Habitat> listHabitats = habitatService.getAllHabitats();
        listHabitats.forEach((habitat) -> {
            PokemonsHabitatDTO pokemonsHabitatDTO = apiHttpService.requestApiGetPokemonsHabitats(habitat.getUrl());
            pokemonsHabitatDTO.getPokemon_species().forEach((pokemon) -> {
               Pokemon pokemonEntity = pokemonService.getPokemonByName(pokemon.getName());
               if(pokemonEntity != null) {
                   pokemonEntity.setHabitat(habitat);
                   pokemonService.updatePokemon(pokemonEntity);
               }
            });
        });
    }

}
