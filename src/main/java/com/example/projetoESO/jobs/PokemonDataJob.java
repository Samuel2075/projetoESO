package com.example.projetoESO.jobs;

import com.example.projetoESO.dto.*;
import com.example.projetoESO.entities.Types;
import com.example.projetoESO.services.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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
        this.populateTypes();
        this.populateColors();
        this.populateHabitat();
    }

    private void populateTypes() {
        List<TypeDTO> typesList = apiHttpService.requestApiGetTypes();
        typesList.forEach((type) -> {
            typeService.saveType(type.convertDtoTypeToEntity());
        });
    }

    private void populateHabitat() {
        List<HabitatsDTO> habitatsList = apiHttpService.requestApiGetHabitats();
        List<PokemonsHabitatDTO> pokemonsHabitatList = new ArrayList<>();
        habitatsList.forEach((habitat) -> {
            habitatService.saveHabitat(habitat.convertDtoHabitatToEntity());
            pokemonsHabitatList.add(apiHttpService.requestApiGetPokemonsHabitats(habitat.getName()));
        });
        this.populatePokemon(pokemonsHabitatList);
    }

    private void populateColors() {
        List<ColorDTO> colorsList = apiHttpService.requestApiGetColors();
        colorsList.forEach((color) -> {
            colorService.saveColor(color.convertDtoColorToEntity());
        });
    }

    private void populatePokemon(List<PokemonsHabitatDTO> pokemonsHabitatList) {

        List<PokemonDTO> pokemonsList = apiHttpService.requestApiGetAllPokemons(1302, 0);
        List<PokemonStatusDTO> pokemonStatusList = new ArrayList<>();
        pokemonsList.forEach((pokemon) -> {
            pokemonStatusList.add(apiHttpService.requestApiGetStatusPokemon(pokemon.getName()));
            System.out.println(pokemon.getName());
            //pokemonService.savePokemon(pokemon.convertDtoPokemonToEntity());
        });
        String teste = ":D";
    }

}
